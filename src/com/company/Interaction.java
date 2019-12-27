package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Interaction {
    Path path;

    public Interaction(String path) {
        this.path = Paths.get(path);
    }

    public abstract void view();

    public abstract void create();

    public abstract void delete();

    public abstract void getInfo();

    public void isExist() {
        if (Files.exists(path)) {
            String errorMessage = String.format("%s already exist", this.path.toString());
            System.err.println(errorMessage);
        };
    }
}
