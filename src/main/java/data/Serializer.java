package data;

import model.Manager;
import model.Movie;
import model.User;

import java.io.*;
import java.util.HashMap;
import java.util.UUID;

public class Serializer {
    public static final int MOVIES = 0;
    public static final int USERS = 1;

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
