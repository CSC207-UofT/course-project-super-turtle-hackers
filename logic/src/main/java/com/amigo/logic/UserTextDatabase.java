package com.amigo.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserTextDatabase implements UserDatabase {

    private static class InputFormatException extends RuntimeException {

        InputFormatException(String message) {
            super(message);
        }
    }

    private static final String SOURCE = "users.txt";

    private File sourceFile;

    public UserTextDatabase() {
        sourceFile = new File(SOURCE);
    }

    /**
     * Reads and constructs user objects from file.
     *
     * @return a list of constructed Users
     */
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        // try with resources
        try (Scanner fromFile = new Scanner(sourceFile)){
            while (fromFile.hasNextLine())
                users.add(readNextUser(fromFile, users));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return users;
    }

    @Override
    public boolean addUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sourceFile, true))) {
            Profile p = user.getProfile();
            writer.append(p.getName()).append('\n');
            writer.append(Integer.toString(p.getYearOfStudy())).append('\n');
            writer.append(p.getProgramOfStudy()).append('\n');

            String courses = p
                    .getCourses()
                    .stream()
                    .map(Course::getCourseCode)
                    .collect(Collectors.joining(", "));
            writer.append(p.getContactInfo()).append('\n');
            writer.append("----");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return true;
    }


    private User readNextUser(Scanner fromFile, List<User> users) {
        String name = fromFile.nextLine();
        int year = Integer.parseInt(fromFile.nextLine());
        String prog = fromFile.nextLine();
        HashSet<Course> courses = createCourseSet(fromFile.nextLine());
        String contact = fromFile.nextLine();

        Profile prof = new Profile(name, year, prog, courses, contact);
        // generate a random ID, this behaviour will be changed later
        String id = name + (int) (Math.random() * 100);
        User user = new User(prof, id);
        // check delimiter
        if (!fromFile.nextLine().equals("----")) {
            throw new InputFormatException("Received invalid input from source");
        }
        return user;
    }

    /**
     * Creates a course set from input source
     *
     * @param source
     * @return
     */
    private HashSet<Course> createCourseSet(String source) {
        String[] courseStrings = source.split(",");
        HashSet<Course> courseSet = new HashSet<Course>();
        for (var str : courseStrings) {
            Course c = new Course(str.strip());
            courseSet.add(c);
        }

        return courseSet;
    }
}
