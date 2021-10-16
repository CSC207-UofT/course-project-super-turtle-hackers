package com.amigo.logic.ui;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Terminal User Interface - for phase 0 only
 */
public class TUI {
    public void run() {
        runWelcome();
    }

    public String runWelcome() {
        System.out.println("Welcome to Amigo (beta)!");
        System.out.println("Are you already registered? (y/n)");

        return input("y", "n");
    }

    public String runLogin() {
        System.out.print("Enter your user id: ");
        // this regex string could technically be supplied by the ControlSystem class
        // but we will keep it as hardcoded for now

        return inputRegex("\\w+");
    }

    public String[] runRegister() {
        String[] inputs = new String[5];
        System.out.print("Enter your name: ");
        // input regex taken from source
        // https://stackoverflow.com/a/40056630
        inputs[0] = inputRegex("^([a-zA-Z]{2,}\\\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\\\s?([a-zA-Z]{1,})?)");
        System.out.print("Enter your year of study: ");
        inputs[1] = inputRegex("1-4");
        System.out.print("Enter your program of study: ");
        inputs[2] = inputRegex("(?:[a-zA-Z]+ *)+");
        System.out.print("Enter your courses, separated by a comma: ");
        inputs[3] = inputRegex("(?:[A-Z]{3}[0-9]{3}(?:(?: *, *)| *$))+");
        System.out.print("Enter your contact information: ");
        inputs[4] = inputRegex(".+");

        return inputs;
    }

    public void runRegisterSuccess(String id) {
        System.out.println("Hi! You have successfully registered.");
        System.out.println("Your new user id is " + id);
    }

    /**
     * Accepts input based on the regular expression given by {@code regex}.
     *
     * @param regex the regular expression to filter input with
     * @return the first input that {@code regex} matches
     */
    private String inputRegex(String regex) {
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile(regex);

        String response = in.nextLine();
        while (!p.matcher(response).matches()) {
            System.out.print("Invalid input, try again: ");
            response = in.nextLine();
        }

//        in.close();
        return response;
    }

    /**
     * Repeatedly asks for user input until it matches one of the Strings in {@code accepted}.
     *
     * @param accepted the list of accepted inputs
     * @return the first input that matches a String in {@code accepted}
     */
    private String input(String... accepted) {
        Scanner in = new Scanner(System.in);
        Set<String> acceptedSet = new HashSet<String>(Arrays.asList(accepted));

        String response = in.nextLine();
        while (!acceptedSet.contains(response)) {
            System.out.print("Invalid input, try again: ");
            response = in.nextLine();
        }

//        in.close();
        return response;
    }
}
