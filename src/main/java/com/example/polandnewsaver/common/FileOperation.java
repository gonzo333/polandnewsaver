package com.example.polandnewsaver.common;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOperation {
    public boolean createFileIfNotExist(String path) {
        try {
            File textFile = new File(path);
            return textFile.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public void writeLineToFile(String filePath, String line) {
        try {
            Path path = Paths.get(filePath);
            Files.writeString(path, line, StandardOpenOption.APPEND);
            Files.writeString(path, "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
