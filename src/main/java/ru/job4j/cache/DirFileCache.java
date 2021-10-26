package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String pathToFile = cachingDir + "/" + key;
        String fullPath = null;
        try {
            fullPath = Files.readString(Path.of(pathToFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fullPath;
    }
}