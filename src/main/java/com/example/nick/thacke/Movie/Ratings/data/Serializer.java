package com.example.nick.thacke.Movie.Ratings.data;

import com.example.nick.thacke.Movie.Ratings.model.Manager;

import java.io.*;

public class Serializer {

    /**
     * The directory which is used to store data.
     */
    private static final String directory = "src/data";
    /**
     * The file which is used to store the data.
     */
    private static final String file = "data.txt";

    public static void save(Manager manager) throws IOException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(directory + File.separator + file));
            oos.writeObject(manager);
            oos.close();
        } catch (IOException ioexcept) {
            System.out.println(ioexcept);
        }
    }

    public static Manager load() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream( new FileInputStream(directory + File.separator + file));
        Manager manager = (Manager) ois.readObject();
        ois.close();
        if(manager == null) {
            throw new IOException();
        }
        return manager;
    }
}
