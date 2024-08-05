var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "20304",
        "ok": "17846",
        "ko": "2458"
    },
    "minResponseTime": {
        "total": "102",
        "ok": "102",
        "ko": "459"
    },
    "maxResponseTime": {
        "total": "60008",
        "ok": "59694",
        "ko": "60008"
    },
    "meanResponseTime": {
        "total": "6862",
        "ok": "402",
        "ko": "53760"
    },
    "standardDeviation": {
        "total": "18154",
        "ok": "1352",
        "ko": "14374"
    },
    "percentiles1": {
        "total": "180",
        "ok": "152",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "731",
        "ok": "350",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "1439",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "2097",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 15386,
    "percentage": 76
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 973,
    "percentage": 5
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 1487,
    "percentage": 7
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 2458,
    "percentage": 12
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4.289",
        "ok": "3.77",
        "ko": "0.519"
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
        "total": "20304",
        "ok": "17846",
        "ko": "2458"
    },
    "minResponseTime": {
        "total": "102",
        "ok": "102",
        "ko": "459"
    },
    "maxResponseTime": {
        "total": "60008",
        "ok": "59694",
        "ko": "60008"
    },
    "meanResponseTime": {
        "total": "6862",
        "ok": "402",
        "ko": "53760"
    },
    "standardDeviation": {
        "total": "18154",
        "ok": "1352",
        "ko": "14374"
    },
    "percentiles1": {
        "total": "180",
        "ok": "152",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "731",
        "ok": "350",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "1439",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "2097",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 15386,
    "percentage": 76
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 973,
    "percentage": 5
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 1487,
    "percentage": 7
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 2458,
    "percentage": 12
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4.289",
        "ok": "3.77",
        "ko": "0.519"
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