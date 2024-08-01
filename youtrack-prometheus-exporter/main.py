import argparse
import time
from typing import Dict
import requests
from datetime import datetime, UTC

from prometheus_client import Gauge, start_wsgi_server, Info, Counter

# APIKEY = "perm:YWRtaW4=.NDktMw==.Mz2iat4KCnuhZ13BJAHCOlpBQp1hWE"

argparser = argparse.ArgumentParser(prog='yt_exporter', description='Prometheus YouTrack metrics exporter')
argparser.add_argument('--addr', default='0.0.0.0', help="The address to listen by exporter")
argparser.add_argument('--port', type=int, default=7070, help="The port to listen by exporter")
argparser.add_argument('--scrape_interval', type=int, default=15, help="Time in seconds between scrapes")
argparser.add_argument('--api', type=str, default="", help="YouTrack API address")
argparser.add_argument('--api_key', type=str, default="", help="YouTrack API perm-key")


def get_telemetry(api: str, key: str) -> Dict[str,str]:
	response = requests.get(
				api + "/api/admin/telemetry",
				params= {
						"fields": "installationFolder,databaseLocation,logsLocation,availableProcessors,availableMemory,allocatedMemory,usedMemory,uptime,startedTime,databaseBackgroundThreads,pendingAsyncJobs,cachedResultsCountInDBQueriesCache,databaseQueriesCacheHitRate,blobStringsCacheHitRate,totalTransactions,transactionsPerSecond,requestsPerSecond,databaseSize,fullDatabaseSize,textIndexSize,onlineUsers,reportCalculatorThreads,notificationAnalyzerThreads"
				},
				headers = {
						"Authorization": "Bearer " + key
				}
	)
	return response.json()

if __name__ == '__main__':

		args = argparser.parse_args()
	
		start_wsgi_server(args.port, args.addr)

		print("Process Exporter started at", f"{ args.addr }:{ args.port }")
		print(f"Scrape intervel set to { args.scrape_interval }s")

		uptime = Gauge("uptime", "Uptime of instance")

		telemetry = get_telemetry(args.api, args.api_key)
		print(telemetry)

		while True:
			telemetry = get_telemetry(args.api, args.api_key)

			uptime.set(int(datetime.now(UTC).timestamp()- int(telemetry['startedTime']/1000)))

			time.sleep(args.scrape_interval)
			
		