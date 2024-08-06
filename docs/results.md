# Results

## ToC

- [Short results](#short-results)
- [Issues loading task](#issues-loading)
- [Load Testing](#load-testing)

## Short results

- 100k issues could be loaded with aproximate 4 hours.

## Issues loading

### First iteration

- With given limits maximum speed of loading issues could be defined at 20 rps.
- Accordindly to the [Gatling report](/youtrack/runsresults/issuegenerationtest-20240802141143532) the last load level with response times that satisfy the SLA was at `16:12:35`:
![pic.1](https://github.com/user-attachments/assets/cafc88b5-ad15-49be-a152-172d0b6771f1)

- At this time the load was around 20-22 rps:
![pic.2](https://github.com/user-attachments/assets/26ab5e90-fef3-4977-bb47-8674c58df0ac)

- Resources utilizaion
![pic.3](https://github.com/user-attachments/assets/f5911ba2-b773-4261-9322-fb1cc511b1df)


- With this rate we can load 100k issues for aproximatly 1 hour and 25 minutes.

Than a number of load test with a flat load was taken, but none of then proved that results described above. Main problems were with CPU. Application starts to use 100% CPU at some point and stops serve.

Next step was to change methodology to use stepped MaxPerf to find actual point of degradation.

### Second Iteration

Stepped test approved the thesis that an actual degradation point is lower and lies aroung ~ 6-7 rps: [Gatling Report](/youtrack/runsresults/issuegenerationtestmaxperf-20240802171440667/)

This allows us to calculate new minimum load time:

```text
100000 / 7 / 60 / 60 ~= 3.96 hours 
```

The next [load test](/youtrack/runsresults/issuegenerationteststab-20240805110054151/) showed the ability of system to endure that load with long time.

However [an attmpt](/youtrack/runsresults/issuegenerationteststab-20240805141220619/) to use this level of load still causes an application crash after some time:
![pic.4](https://github.com/user-attachments/assets/f0b34f56-857a-4302-bf3b-04999eec295d)

**Hypothesis**: more and more issues creation causes more CPU pressure while reindexing, GC adds spikes. At some time the lack of CPU resources causes too long response time. An open load model on the other side still spawns more and more requests and finally system fails to serve them.

Potential solutions:

- add more CPU resources
- change tools to closed load model
- use less load
- fine tuning (Application, GC, DB)
  
### Third iteration

Firtsly I've decided to test the system with more reources to check that adding more CPU (t2.2xlarge AWS-instance: 8 CPU, 32 RAM) could help the system to endure the load.
[Test](/youtrack/runsresults/issuegenerationtestmaxperf-20240806083340560/) showed that adding more CPU cores add some capacity to the system but this is not the key factor:
![pic.5](https://github.com/user-attachments/assets/1964d290-aad2-4e01-b523-8f9dbbeced1e)
![pic.6](https://github.com/user-attachments/assets/9709486c-185f-4e83-9e15-bd4df7e8c233)

System is still crashing after reaching 20 rps but now do not utilize even 80% of CPU. That shows us that something else causes crashes.
But the way how the CPU utilization increases (kind of exponential) indicates that problem with reindexing is present.
One of the solutions could be turn off the indexing for the time of issue loading.

### Fourth iteration

We could also use standart YouTrack instruments to import issues.
I wrote a simple csv [generator](/youtrack-issue-csv-generator/), and the load this csv to YouTrack via google sheet

## Load testing

1. Load

2. Profile and requests:
	- we should include to profile all requests from SLA, because wee need them to measure success of our tests; they, obviously,  are also requests which generate main load by the users accordigly to the task.

	- we could include also:
		- `/values` - as it runs for every loaded issue
		- `/search/assist` - as requests previuous to search it self
		- `/hub/api/rest/users/me` - it requests on every page loading (infor about current user)
		- `/api/config` - return info about application settings
		- `/draftComment` - as request previous to adding comment

	- we can ignore requests for resources (scripts, images etc.) as they are static reources and requests for them not generating a load on API and DB

	- we can definitly ignore requests:
		- `/folders` - we dont expect any messages
		- `/fields` - we need not to ask API about them, we know them directly; we also dont use any custom fields (?)
		- `activities` - we dont expect any