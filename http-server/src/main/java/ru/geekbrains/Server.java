package ru.geekbrains;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private int port;

    public Server( int port) {
        this.port = port;
    }

    public ServerSocket startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        return serverSocket;
    }
}
