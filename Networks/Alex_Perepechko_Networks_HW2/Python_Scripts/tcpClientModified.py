#!/usr/bin/python

from socket import *

serverName = "localhost"
serverPort = 12000

clientSocket = socket(AF_INET, SOCK_STREAM) 
clientSocket.connect((serverName, serverPort))

#message = raw_input("Input lowercase sentence:") 
message = None
with open("3.txt", "r") as f:
    message = f.read()

MSGLEN = len(message)

totalsent = 0
while totalsent < MSGLEN:
    sent = clientSocket.send(message[totalsent:])
    if sent == 0:
        raise RuntimeError("socket connection broken")
    totalsent = totalsent + sent
    
print MSGLEN
#def myreceive():
chunks = []
chunk = ''
bytes_recd = 0
whole_file = ''
#chunk = clientSocket.recv(4096)

#print(chunk)
while bytes_recd < MSGLEN:
    chunk = clientSocket.recv(min(MSGLEN - bytes_recd, 2048))
    '''if chunk == '':
        raise RuntimeError("socket connection broken")'''
    chunks.append(chunk)
    bytes_recd = bytes_recd + len(chunk)
    whole_file = ''.join(chunks)
   
#clientSocket.send(whole_file) 
#print len(whole_file)
print whole_file

#modifiedMessage = clientSocket.recv(4096) 

#print modifiedMessage



clientSocket.close()