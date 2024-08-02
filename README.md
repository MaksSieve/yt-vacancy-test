# Test task for JB YouTrak vacancy

QA Performance Engineer

## ToC

- [Methodology of testing](/docs/methodology.md)
- [Structure](#structure)
- [Results](#results)

## Structure

- [youtrack](/youtrack/) Performance tests written with Gatling
- [youtrack-prometheus-exporter](/youtrack-prometheus-exporter/) YouTrack metrics exporter for prometheus

## Results

### Issues loading

With given limits maximum speed of loading issues could be defined at 20 rps.

Accordindly to the [Gatling report](/youtrack/runsresults/issuegenerationtest-20240802141143532) the last load level with response times that satisfy the SLA was at `16:12:35`:
![pic.1](https://github.com/user-attachments/assets/cafc88b5-ad15-49be-a152-172d0b6771f1)

At this time the load was around 20-22 rps:
![pic.2](https://github.com/user-attachments/assets/26ab5e90-fef3-4977-bb47-8674c58df0ac)

**With this rate we can load 100k issues for aproximatly 1 hour and 25 minutes.**
