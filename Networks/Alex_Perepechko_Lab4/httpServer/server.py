#!/usr/bin/python

from socket import *

import mimetypes
import os
import argparse

parser = argparse.ArgumentParser()
parser.add_argument("--port","--port=", help="Specifies port to use",type=int)
parser.add_argument("--base","--base=", help="Specifies the base directory of where the website is stored", action='store')

args = parser.parse_args()
serverPort = args.port
filePath = args.base

os.chdir(filePath)
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))
serverSocket.listen(10)

http_ok="HTTP/1.1 200 OK"
contentType=""
contentLength=""
requestedFile=""
image = http_ok + "\nContent-Type: image/jpeg\nContent-Length: "

print "The server is ready to receive information on port %s" %serverPort
while 1:
    connectionSocket, addr = serverSocket.accept()
    request = connectionSocket.recv(4096)
    endValue=request.find("HTTP/")
    response = None
    requestedFile = request[5:endValue-1]

    contentType= mimetypes.guess_type(requestedFile)
    if (contentType[0] == None):
         print "Error 404"
         break
    contentType="\nContent-Type: " +contentType[0]

    #if there isnt a get request, print out error 501
    if(request[:3]!='GET'):
        response="Error 501"
        connectionSocket.sendall(response)
        connectionSocket.close()

    try:
            with open(request[5:endValue-1], 'rb') as f:
                response = f.read()
    except:
         print "Error 404"

    length= os.stat(request[5:endValue-1])
    length=length.st_size
    contentLength="\n"+str(length)
    response= http_ok+ contentType+ contentLength +'\n\n'+ response
    print(http_ok)

    connectionSocket.sendall(response)


    connectionSocket.close()