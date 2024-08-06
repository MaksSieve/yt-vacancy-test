var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "55337",
        "ok": "42468",
        "ko": "12869"
    },
    "minResponseTime": {
        "total": "74",
        "ok": "74",
        "ko": "5461"
    },
    "maxResponseTime": {
        "total": "60014",
        "ok": "59730",
        "ko": "60014"
    },
    "meanResponseTime": {
        "total": "12928",
        "ok": "720",
        "ko": "53214"
    },
    "standardDeviation": {
        "total": "24077",
        "ok": "4725",
        "ko": "17443"
    },
    "percentiles1": {
        "total": "112",
        "ok": "102",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "954",
        "ok": "122",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "441",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "30643",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 41386,
    "percentage": 75
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 201,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 881,
    "percentage": 2
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 12869,
    "percentage": 23
},
    "meanNumberOfRequestsPerSecond": {
        "total": "11.608",
        "ok": "8.909",
        "ko": "2.7"
    }
},
contents: {
"req_addissue--1256162120": {
        type: "REQUEST",
        name: "addIssue",
path: "addIssue",
pathFormatted: "req_addissue--1256162120",
stats: {
    "name": "addIssue",
    "numberOfRequests": {
        "total": "55337",
        "ok": "42468",
        "ko": "12869"
    },
    "minResponseTime": {
        "total": "74",
        "ok": "74",
        "ko": "5461"
    },
    "maxResponseTime": {
        "total": "60014",
        "ok": "59730",
        "ko": "60014"
    },
    "meanResponseTime": {
        "total": "12928",
        "ok": "720",
        "ko": "53214"
    },
    "standardDeviation": {
        "total": "24077",
        "ok": "4725",
        "ko": "17443"
    },
    "percentiles1": {
        "total": "112",
        "ok": "102",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "954",
        "ok": "122",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "441",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "30643",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 41386,
    "percentage": 75
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 201,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 881,
    "percentage": 2
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 12869,
    "percentage": 23
},
    "meanNumberOfRequestsPerSecond": {
        "total": "11.608",
        "ok": "8.909",
        "ko": "2.7"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
