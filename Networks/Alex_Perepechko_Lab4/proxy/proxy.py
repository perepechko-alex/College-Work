import sys
import thread
import socket
import argparse

buffer_size = 4096

def proxy(connectionSocket, client_addr):

    # get request from browser
    request = connectionSocket.recv(buffer_size)
    # parse through the first line
    first_line = request.split('\n')[0]
    # gets the url
    url = first_line.split(' ')[1]

    if(first_line[:3] != 'GET'):
        print 'Error 501'

    if(first_line[:3] == 'GET'):
        print(first_line)
    
    # find the webserver, port, and the complete url
    http_position = url.find("://")          
    if (http_position==-1):
        temp = url
    else:
        temp = url[(http_position+3):]
    
    port_position = temp.find(":")           

    # find the end of the web server
    website_position = temp.find("/")
    if website_position == -1:
        website_position = len(temp)

    webserver = ""
    portnum = -1 #initialize port
    if (port_position == -1 or website_position < port_position):
        portnum = 80 # default
        webserver = temp[:website_position]
    else:       # specific port
        portnum = int((temp[(port_position+1):])[:website_position-port_position-1])
        webserver = temp[:port_position]

    try:
        # create a socket to connectionSocketect to the web server
        serverSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  
        serverSocket.connect((webserver, portnum))
        serverSocket.send(request)         # send request to webserver
        
        while 1:
            # receive data from web server
            data = serverSocket.recv(buffer_size)
            
            if (len(data) > 0):
                # send to browser
                connectionSocket.send(data)
                print 'HTTP 200'
            else:
                break
            
        serverSocket.close()
        connectionSocket.close()
    except socket.error, (value, message):
        if serverSocket:
            serverSocket.close()
        if connectionSocket:
            connectionSocket.close()
        print("Error 404")
        sys.exit(1)

def main():

   
    parser = argparse.ArgumentParser()
    parser.add_argument("--port","--port=", help="Specifies port to use",type=int)
    args = parser.parse_args()


    host = ''               
    print "Proxy Server Running on",host,":",args.port

    try:
        serverSocketMain = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        serverSocketMain.bind((host, args.port))
        serverSocketMain.listen(10)
    
    except socket.error, (value, message):
        if serverSocketMain:
            serverSocketMain.close()
        print "Could not open socket:", message
        sys.exit(1)

    while 1:
        connectionSocket, client_addr = serverSocketMain.accept()
        #threads in order to not miss requests
        thread.start_new_thread(proxy, (connectionSocket, client_addr))
        
    serverSocketMain.close()
    
if __name__ == '__main__': #call main
    main()