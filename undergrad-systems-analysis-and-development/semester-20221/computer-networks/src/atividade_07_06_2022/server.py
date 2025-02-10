import socket

IP = socket.gethostbyname(socket.gethostname())
PORT = 4455
ADDR = (IP, PORT)
SIZE = 1024
FORMAT = "utf-8"

def main():
    print("[Iniciando] Server esta iniciando.")
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind(ADDR)
    server.listen()
    while True:
        conn, addr = server.accept()
        print(f"[Nova conexao] {addr} conectado.")
        filename = conn.recv(SIZE).decode(FORMAT)
        print(f"[RECV] Recebendo o arquivo.")
        file = open(filename, "w")
        conn.send("Arquivo recebidos.".encode(FORMAT))
        data = conn.recv(SIZE).decode(FORMAT)
        print(f"[RECV] Recebendo dados do arquivo.")
        file.write(data)
        conn.send("Dados recebidos".encode(FORMAT))
        file.close()
        conn.close()
        print(f"[Desconectado] {addr} desconectado.")
        
if __name__ == "__main__":
    main()
