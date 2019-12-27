package com.company;

import java.nio.file.Files;
import java.nio.file.Path;

public interface Manipulatable {
    void create();
    void view();
    void delete();
    void getInfo();


    default boolean checkExistence(Path path) {
        boolean alreadyExist = Files.exists(path);
        if (alreadyExist) {
            String errorMessage = String.format("%s already exist", path);
            System.err.println(errorMessage);
        }
        return alreadyExist;
    }

}
