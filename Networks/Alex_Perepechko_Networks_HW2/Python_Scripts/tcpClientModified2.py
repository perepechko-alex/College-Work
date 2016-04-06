#!/usr/bin/python

from socket import *

serverName = "www.google.com"
serverPort = 80

clientSocket = socket(AF_INET, SOCK_STREAM) 
clientSocket.connect((serverName, serverPort))

#message = raw_input("Input lowercase sentence:") 
message = None
with open("get.txt", "r") as f:
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
    chunk = clientSocket.recv(8000000)
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