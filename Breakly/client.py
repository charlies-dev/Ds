import socket
import time
from datetime import datetime


def get_time():
    return time.time()


def main():
    host = "0.0.0.0"
    port = 5000
    my_socket = socket.socket()

    my_socket.connect((host , port))

    print("Connected to server")

    local_time = get_time()

    print(f"Local time {datetime.fromtimestamp(local_time)}")

    my_socket.send(str(local_time).encode())

    adjustment_time = float(my_socket.recv(1024).decode())

    print(f"recieved Adjustment time of {datetime.fromtimestamp(adjustment_time)}")

    new_time = local_time + adjustment_time

    print(f"After adjustment New time {datetime.fromtimestamp(new_time)}")


    my_socket.close()



if __name__== "__main__":
    main()