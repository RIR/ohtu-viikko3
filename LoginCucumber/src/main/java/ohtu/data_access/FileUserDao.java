package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

/**
 *
 * @author Raine Rantanen
 */
public class FileUserDao implements UserDao {

    private String filename;
    private Scanner scanner;
    private FileWriter filewriter;

    public FileUserDao(String fileName) {
        this.filename = fileName;
    }

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        try {
            scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String attr[] = scanner.nextLine().split(" ");
                User user = new User(attr[0], attr[1]);
                users.add(user);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return users;
    }

    @Override
    public User findByName(String name) {
        List<User> users = listAll();
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        try {
            filewriter = new FileWriter(new File(filename));
            filewriter.write(user.getUsername() + " " + user.getPassword() + "\n");
            filewriter.close();
        } catch (IOException ex) {
            System.out.println("virhe kirjoittaessa tiedostoon");
        }
    }
}
