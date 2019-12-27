package com.company;

public class Main {
	public static void main(String[] args) {
		Main.directorySnippet();
		Main.fileSnippet();
	}

	private static void directorySnippet() {
		Directory directory = new Directory("Documents");
		directory.create();
		directory.delete();
		directory = new Directory("NewDocuments");
		directory.create();
		Directory subDirectory = new Directory(directory.getRelativePath() + "/sub");
		subDirectory.create();
		subDirectory.getInfo();
		directory.view();
	}

	private static void fileSnippet() {
		File file = new File("temp.txt");
		file.create();
		file.write("Lol\n");
		file.write("Kek");
		file.view();
		file.delete();

		file = new File("temp2.txt");
		file.create();
		file.getInfo();
		file.write("Kek");
		file.view();
	}
}
