# Results

## Issues loading

### First iteration

- With given limits maximum speed of loading issues could be defined at 20 rps.
- Accordindly to the [Gatling report](/youtrack/runsresults/issuegenerationtest-20240802141143532) the last load level with response times that satisfy the SLA was at `16:12:35`:
![pic.1](https://github.com/user-attachments/assets/cafc88b5-ad15-49be-a152-172d0b6771f1)

- At this time the load was around 20-22 rps:
![pic.2](https://github.com/user-attachments/assets/26ab5e90-fef3-4977-bb47-8674c58df0ac)

- [Node exporter dashboard for test time](http://ec2-35-181-160-56.eu-west-3.compute.amazonaws.com:3000/d/rYdddlPWk/node-exporter-full?orgId=1&from=1722607906000&to=1722608220000)

- With this rate we can load 100k issues for aproximatly 1 hour and 25 minutes.

Than a number of load test with a flat load was taken, but none of then proved that results described above. Main problems were with CPU. Application starts to use 100% CPU at some point and stops serve.

Next step was to change methodology to use stepped MaxPerf to find actual point of degradation.

### Second Iteration

Stepped test approved the thesis that an actual degradation point is lower and lies aroung ~ 6-7 rps: [Gatling Report](/youtrack/runsresults/issuegenerationtestmaxperf-20240802171440667/)

This allows us to calculate new minimum load time:

```text
100000 / 7 / 60 / 60 ~= 3.96 hours 
```

However an attmpt to use this level of load still causes an application crash after some time:
![image](https://github.com/user-attachments/assets/f0b34f56-857a-4302-bf3b-04999eec295d)
