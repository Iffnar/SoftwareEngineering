package org.hbrs.se1.ws24.exercises.uebung2.test;

import java.io.File;
import java.io.IOException;

public class PathVerifier {

    public static boolean isPathValid(String filePath) {
        // Create a File object
        File file = new File(filePath);

        // Check if the parent directory exists
        if (file.getParentFile() == null || !file.getParentFile().exists()) {
            System.out.println("Parent directory does not exist: " + file.getParent());
            return false;
        }

        // Check if we can write to the directory
        if (!file.getParentFile().canWrite()) {
            System.out.println("Cannot write to the directory: " + file.getParent());
            return false;
        }

        // Optionally, check if the file can be created
        try {
            // Attempt to create the file (if it doesn't exist)
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
                // Delete it afterward as it's just for testing purposes
                file.delete();
            } else {
                System.out.println("File already exists: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String path = "invalid";
        if (isPathValid(path)) {
            System.out.println("The path is valid and writable.");
        } else {
            System.out.println("The path is invalid or not writable.");
        }
    }
}