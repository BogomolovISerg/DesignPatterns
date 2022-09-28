package ru.geekbrains;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CorrectFile {

    private static String WWW = "/Users/sergbogomolov/Documents/idea/index.html";
    public CorrectFile(String[] parts, PrintWriter output) {

        Path path = Paths.get(WWW, parts[1]);
        try {
            if (!Files.exists(path)) {
                output.println("HTTP/1.1 404 NOT_FOUND");
                output.println("Content-Type: text/html; charset=utf-8");
                output.println();
                output.println("<h1>Файл не найден!</h1>");
                output.flush();
                throw new RuntimeException("Файл не найден");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
