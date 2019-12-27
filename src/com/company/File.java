package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File implements Manipulatable {

    private Path path;

    public File(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public void view() {
        System.out.println(this.readStrings());
    }

    @Override
    public void create() {
        try {
            if (this.checkExistence(path)) {
                return;
            }
            Files.createFile(path);
            System.out.println("File created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try {
            Files.delete(path);
            System.out.println("File deleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getInfo() {
        try {
            String owner = Files.getOwner(path).getName();
            String lastModifiedTime = Files.getLastModifiedTime(path).toString();

            String info = String.format("Owner: %s\nLastModifiedTime: %s", owner, lastModifiedTime);

            System.out.println(info);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(String text) {
        try {
            String current = this.readStrings();
            Files.write(path, (current + text).getBytes());
            System.out.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readStrings() {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}