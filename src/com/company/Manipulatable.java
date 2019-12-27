package com.company;

import java.nio.file.Files;
import java.nio.file.Path;

public interface Manipulatable {
    void create();
    void view();
    void delete();
    void getInfo();

    default boolean isExist(Path path) {
        return Files.exists(path);
    }
}
