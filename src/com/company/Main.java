package com.company;

public class Main {

    public static void main(String[] args) {
	    Directory directory = new Directory("temp");
	    directory.create();
	    Directory innerDirectory = new Directory("temp/innerTemp");
	    innerDirectory.create();
	    directory.view();
    }
}
