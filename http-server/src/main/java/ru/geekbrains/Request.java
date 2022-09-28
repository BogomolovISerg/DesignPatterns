package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Request {

    private static Logger log = Logger.getLogger(HttpServer.class.getName());

    public Request(Socket socket) throws Exception{
        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter output = new PrintWriter(socket.getOutputStream())
        )
        {
            Info info = new Info(input);
            String[] parts = info.print();
            new CorrectFile(parts, output);
            new Result(parts, output);
            log.info("Client disconnected!");
        } catch (IOException e) {
            log.log(Level.SEVERE,"Exception: ", e);
        }
    }
}
