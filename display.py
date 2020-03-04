import subprocess
import time

file = open('commands.txt', 'r')

for line in file:
	print("\n\nCalling Command: " + line)
	output = subprocess.call([line], shell=True)
	#print(output)
	bullshit = input()

file.close()