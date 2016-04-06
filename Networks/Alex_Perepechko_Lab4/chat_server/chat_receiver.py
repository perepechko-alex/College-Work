#!/usr/bin/python

from socket import *
import socket
import sys
import argparse

parser = argparse.ArgumentParser()

parser.add_argument("--port","--port=", help="Specifies port to use",type=int)
args = parser.parse_args()

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)


host=''  # Bind to all interfaces
s.bind((host,args.port))
 
print("Listening socket bound to port %d" % args.port)

while 1:
    message, clientAddress = s.recvfrom(2048)
    print message
    #print clientAddress
    s.sendto(message, clientAddress)
    if(message == 'quit'):
        print "Quitting the chat, thank you for using it!"
        break
