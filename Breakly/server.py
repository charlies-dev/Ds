import socket
import time
from datetime import datetime


def get_time():
    return time.time()


def main():
    host = "0.0.0.0"
    port = 5000
    server_socket = socket.socket()
    server_socket.bind((host , port))
    server_socket.listen(5)


    print("waiting for connection")

    number_of_clients = 4
    clients = []
    clients_times = []

    for i in range(4):
        conn , addr = server_socket.accept()
        print('Client from' , addr , "connected")


        clients_time = float(conn.recv(1024).decode())

        clients.append(conn)
        clients_times.append(clients_time)

    server_time = get_time()
    clients_times.append(server_time)
    average_time = sum(clients_times) / len(clients_times)

    print(f"Server Local Time {datetime.fromtimestamp(server_time)}")
    print(f"recieved Client time {datetime.fromtimestamp(clients_times[0])}")

    print(f"Calculated Average TIme: {datetime.fromtimestamp(average_time)}")


    # send adjustment to clients 

    for conn , client_time in zip(clients, clients_times):
        adjustment_time = average_time - client_time

        conn.send(str(adjustment_time).encode())
        conn.close()


    print("adjustment sent server done")
    server_socket.close()



if __name__== "__main__":
    main()



