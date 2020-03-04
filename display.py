import subprocess
import time

file = open('unixcommands.txt', 'r')

for line in file:
	print("\nCalling Command: " + line)
	output = subprocess.call([line], shell=True)
	#print(output)
	bullshit = input()

file.close()