var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "12786",
        "ok": "4182",
        "ko": "8604"
    },
    "minResponseTime": {
        "total": "51",
        "ok": "81",
        "ko": "51"
    },
    "maxResponseTime": {
        "total": "60024",
        "ok": "59228",
        "ko": "60024"
    },
    "meanResponseTime": {
        "total": "33157",
        "ok": "1283",
        "ko": "48650"
    },
    "standardDeviation": {
        "total": "26630",
        "ok": "6697",
        "ko": "17268"
    },
    "percentiles1": {
        "total": "41167",
        "ok": "92",
        "ko": "60001"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "118",
        "ko": "60002"
    },
    "percentiles3": {
        "total": "60003",
        "ok": "281",
        "ko": "60003"
    },
    "percentiles4": {
        "total": "60003",
        "ok": "43203",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 4022,
    "percentage": 31
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 3,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 157,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 8604,
    "percentage": 67
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7.849",
        "ok": "2.567",
        "ko": "5.282"
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
        "total": "12786",
        "ok": "4182",
        "ko": "8604"
    },
    "minResponseTime": {
        "total": "51",
        "ok": "81",
        "ko": "51"
    },
    "maxResponseTime": {
        "total": "60024",
        "ok": "59228",
        "ko": "60024"
    },
    "meanResponseTime": {
        "total": "33157",
        "ok": "1283",
        "ko": "48650"
    },
    "standardDeviation": {
        "total": "26630",
        "ok": "6697",
        "ko": "17268"
    },
    "percentiles1": {
        "total": "41167",
        "ok": "92",
        "ko": "60001"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "118",
        "ko": "60002"
    },
    "percentiles3": {
        "total": "60003",
        "ok": "281",
        "ko": "60003"
    },
    "percentiles4": {
        "total": "60003",
        "ok": "43203",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 4022,
    "percentage": 31
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 3,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 157,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 8604,
    "percentage": 67
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7.849",
        "ok": "2.567",
        "ko": "5.282"
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