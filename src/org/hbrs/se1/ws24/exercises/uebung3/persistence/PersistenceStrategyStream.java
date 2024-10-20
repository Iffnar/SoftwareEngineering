package org.hbrs.se1.ws24.exercises.uebung3.persistence;

import java.io.*;
import java.util.List;

import org.hbrs.se1.ws24.exercises.uebung2.Member;

public class PersistenceStrategyStream implements PersistenceStrategy<Member> {

    // URL of the file in which the objects are stored
    private String location = "objects.ser";

    // Constructor to allow specifying a custom file location
    public PersistenceStrategyStream(String filename) {
        this.location = filename;
    }

    public PersistenceStrategyStream() {
    }

    // Method for testing purposes to change location dynamically
    public void setLocation(String location) {
        this.location = location;
    }

    private boolean isValidLocation(String location) {
        if (location == null || location.isEmpty()) {
            return false;
        }

        File file = new File(location);

        // If the file is in the current working directory
        if (file.getParentFile() == null) {
            return true; // Current working directory is valid
        }

        // Check if the parent directory exists
        return file.getParentFile().exists();
    }

    @Override
    public void save(List<Member> members) throws PersistenceException {
        if(!isValidLocation(location)) {
            throw new PersistenceException(PersistenceException.ExceptionType.locationNotValid, "Invalid location");
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(location))) {
            oos.writeObject(members);  // Serialize and save
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.SaveError, "Error while saving");
        }
    }

    @Override
    public List<Member> load() throws PersistenceException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(location))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Member>) obj;
            } else {
                throw new PersistenceException(PersistenceException.ExceptionType.LoadError, "Invalid data format");
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.LoadError, "Error while loading");
        }
    }
}
