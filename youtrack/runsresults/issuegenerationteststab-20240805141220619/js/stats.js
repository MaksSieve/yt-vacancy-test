var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "26292",
        "ok": "24234",
        "ko": "2058"
    },
    "minResponseTime": {
        "total": "88",
        "ok": "88",
        "ko": "88"
    },
    "maxResponseTime": {
        "total": "60069",
        "ok": "44082",
        "ko": "60069"
    },
    "meanResponseTime": {
        "total": "3486",
        "ok": "151",
        "ko": "42748"
    },
    "standardDeviation": {
        "total": "12765",
        "ok": "357",
        "ko": "20191"
    },
    "percentiles1": {
        "total": "119",
        "ok": "116",
        "ko": "55565"
    },
    "percentiles2": {
        "total": "161",
        "ok": "142",
        "ko": "60002"
    },
    "percentiles3": {
        "total": "35781",
        "ok": "291",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "759",
        "ko": "60005"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 24009,
    "percentage": 91
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 164,
    "percentage": 1
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 61,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 2058,
    "percentage": 8
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.683",
        "ok": "6.16",
        "ko": "0.523"
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
        "total": "26292",
        "ok": "24234",
        "ko": "2058"
    },
    "minResponseTime": {
        "total": "88",
        "ok": "88",
        "ko": "88"
    },
    "maxResponseTime": {
        "total": "60069",
        "ok": "44082",
        "ko": "60069"
    },
    "meanResponseTime": {
        "total": "3486",
        "ok": "151",
        "ko": "42748"
    },
    "standardDeviation": {
        "total": "12765",
        "ok": "357",
        "ko": "20191"
    },
    "percentiles1": {
        "total": "119",
        "ok": "116",
        "ko": "55565"
    },
    "percentiles2": {
        "total": "161",
        "ok": "142",
        "ko": "60002"
    },
    "percentiles3": {
        "total": "35519",
        "ok": "291",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "759",
        "ko": "60005"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 24009,
    "percentage": 91
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 164,
    "percentage": 1
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 61,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 2058,
    "percentage": 8
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.683",
        "ok": "6.16",
        "ko": "0.523"
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
