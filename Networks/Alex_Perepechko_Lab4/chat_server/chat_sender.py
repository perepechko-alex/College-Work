#!/usr/bin/python

from socket import *
import socket
import sys
import argparse

parser = argparse.ArgumentParser()
parser.add_argument("--port","--port=", help="Specifies port to use",type=int)
#parser.add_argument("--base","--base=", help="Specifies the base directory of where the website is stored", action='store')

args = parser.parse_args()


# Create UDP socket
try:
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)
except socket.error as msg:
    print("Error: could not create socket")
    print("Description: " + str(msg))
    sys.exit()
    

while 1:  
    message = raw_input("Input lowercase sentence:")
    
    s.sendto(message,("255.255.255.255",args.port))
    
    message, serverAddress = s.recvfrom(2048)
    if (message == 'quit'):
        break
    #print message
s.close()