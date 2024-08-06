import csv
from faker import Faker

fake = Faker()

with open('issues.csv', 'w') as issues_csv:
	writer = csv.DictWriter(issues_csv, fieldnames=['Summary', 'Description'])
	writer.writeheader()

	for i in range(100000):
		writer.writerow({
			'Summary': fake.sentence(),
			'Description': fake.text().replace('\n', ' ')
		})
		
	



