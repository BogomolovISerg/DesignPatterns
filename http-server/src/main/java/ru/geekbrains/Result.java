package ru.geekbrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Result {

    private static String WWW = "/Users/sergbogomolov/Documents/idea/index.html";
    public Result(String[] parts, PrintWriter output) throws IOException {
        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();
        Path path = Paths.get(WWW, parts[1]);

        Files.newBufferedReader(path).transferTo(output);

    }
}
