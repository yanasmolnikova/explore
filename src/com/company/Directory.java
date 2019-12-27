package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Directory implements Manipulatable {

    private Path path;

    public Directory(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public void view() {
        try {
            Files.list(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create() {
        try {
            if (checkExistence(path)) {
                return;
            }
            Files.createDirectory(path);
            System.out.println("Directory created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try {
            Files.delete(path);
            System.out.println("Directory deleted");
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

    public String getRelativePath() {
        return path.toString();
    }
}
