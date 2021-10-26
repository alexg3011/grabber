package ru.job4j.cache;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        AbstractCache<String, String> abstractCache = null;
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        System.out.println("Enter your directory: ");
        String dir = scanner.nextLine();

        if (Files.exists(Path.of(dir))) {
            abstractCache = new DirFileCache(dir);
        } else {
            System.out.println("It's not a directory!");
        }
        while (run) {
            System.out.println("Take one: "
                    + "1. Load file to cache"
                    + "2. Download file from cache"
                    + "3. Exit");
            int choice = scanner.nextInt();
            if (choice == 3) {
                run = false;
                System.out.println("Good bye");
            }
            if (choice == 1) {
                System.out.println("Enter filename at current directory: ");
                String fileName = scanner.nextLine();
                abstractCache.put(fileName, abstractCache.load(fileName));
                System.out.println("File load.");
            }
            if (choice == 2) {
                System.out.println("Enter file in cache: ");
                String fileName = scanner.nextLine();
                String cacheFile = abstractCache.get(fileName);
                if (cacheFile == null) {
                    System.out.println("File not found in cache. Downloading file from directory...");
                    abstractCache.put(fileName, abstractCache.load(fileName));
                    System.out.println("Done!");
                }
            }
        }
    }
}
