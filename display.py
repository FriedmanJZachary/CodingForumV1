import subprocess
import time

file = open('commands.txt', 'r')

for line in file:
	print("\n\nCalling Command: " + line)
	output = subprocess.call([line], shell=True)
	#print(output)
	time.sleep(5)

file.close()