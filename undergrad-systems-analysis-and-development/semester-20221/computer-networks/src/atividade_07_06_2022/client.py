import socket

from pip._vendor.distlib.compat import raw_input

from chacha20 import chacha20

HOST = '127.0.0.1'   
PORT = 5000          
tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
dest = (HOST, PORT)
tcp.connect(dest)
cripto = chacha20()
print (cripto.get.encript('Para sair use CTRL+X'))
msg = raw_input()
while msg != '\x18':
  tcp.send (msg)
  msg = raw_input()
tcp.close()

