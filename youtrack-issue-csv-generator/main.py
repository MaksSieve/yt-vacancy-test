import csv
import random

from faker import Faker

fake = Faker()

userFilePath = '/Users/sitnikovma/dev/yt-vacancy-test/youtrack/src/test/resources/feeders/users.csv'


with open(userFilePath, 'r') as users_csv:

	users = list(csv.DictReader(users_csv))

	with open('issues.csv', 'w') as issues_csv:
		writer = csv.DictWriter(issues_csv, fieldnames=['Summary','author', 'Description', ])
		writer.writeheader()

		for i in range(100000):
			writer.writerow({
				'Summary': fake.sentence(),
				'author': users[random.randint(0, len(users) - 1)]['name'],
				'Description': fake.text().replace('\n', ' ')
				
			})
		
	



