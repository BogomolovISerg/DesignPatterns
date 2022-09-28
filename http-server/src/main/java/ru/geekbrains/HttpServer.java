package ru.geekbrains;

import java.io.*;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpServer {

       private static Logger log = Logger.getLogger(HttpServer.class.getName());

    public static void main(String[] args) {

        Server server = new Server(8080);

        try (ServerSocket serverSocket = server.startServer()) {
            log.info("Server started!");

            new Client(serverSocket);

        } catch (IOException e) {
            log.log(Level.SEVERE,"Exception: ", e);
        }
    }
}
