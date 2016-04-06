#!/usr/bin/python

from socket import *

serverPort = 12000

serverSocket = socket(AF_INET, SOCK_STREAM) 
serverSocket.bind(('', serverPort))
serverSocket.listen(1)

print "The server is ready to receive"

while 1:
    connectionSocket, addr = serverSocket.accept()
    message = connectionSocket.recv(4096)
    #print message
    modifiedMessage = message.upper() 
    print modifiedMessage
    connectionSocket.send(modifiedMessage)
    
    connectionSocket.close()