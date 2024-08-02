var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "17441",
        "ok": "1626",
        "ko": "15815"
    },
    "minResponseTime": {
        "total": "93",
        "ok": "93",
        "ko": "184"
    },
    "maxResponseTime": {
        "total": "60032",
        "ok": "59893",
        "ko": "60032"
    },
    "meanResponseTime": {
        "total": "36848",
        "ok": "21232",
        "ko": "38454"
    },
    "standardDeviation": {
        "total": "20174",
        "ok": "19571",
        "ko": "19539"
    },
    "percentiles1": {
        "total": "37416",
        "ok": "18219",
        "ko": "39155"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "39523",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60002",
        "ok": "56039",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60004",
        "ok": "58349",
        "ko": "60005"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 446,
    "percentage": 3
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 40,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 1140,
    "percentage": 7
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 15815,
    "percentage": 91
},
    "meanNumberOfRequestsPerSecond": {
        "total": "52.219",
        "ok": "4.868",
        "ko": "47.35"
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
        "total": "17441",
        "ok": "1626",
        "ko": "15815"
    },
    "minResponseTime": {
        "total": "93",
        "ok": "93",
        "ko": "184"
    },
    "maxResponseTime": {
        "total": "60032",
        "ok": "59893",
        "ko": "60032"
    },
    "meanResponseTime": {
        "total": "36848",
        "ok": "21232",
        "ko": "38454"
    },
    "standardDeviation": {
        "total": "20174",
        "ok": "19571",
        "ko": "19539"
    },
    "percentiles1": {
        "total": "37416",
        "ok": "18219",
        "ko": "39155"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "39523",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60002",
        "ok": "56039",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60004",
        "ok": "58349",
        "ko": "60005"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 446,
    "percentage": 3
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 40,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 1140,
    "percentage": 7
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 15815,
    "percentage": 91
},
    "meanNumberOfRequestsPerSecond": {
        "total": "52.219",
        "ok": "4.868",
        "ko": "47.35"
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
