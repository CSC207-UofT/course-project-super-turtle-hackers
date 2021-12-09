package com.amigo.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amigo.course.CourseSetFactory;
import com.amigo.user.ProfileFactory;
import com.amigo.user.User;
import com.amigo.user.UserFactory;

public class DemoMatching {
    /**
     * Performs the matching algorthm and returns the matches
     */
    public static Map<String, List<Match>> doMatching(User user) {
        Matcher matcher = new Matcher();
        List<User> users = createDemoUsers();
        users.add(user);
        return matcher.match(users);
    }
    /**
     * Creates the demo users
     */
    private static List<User> createDemoUsers() {
        ArrayList<User> users = new ArrayList<>();
        ProfileFactory profileFactory = new ProfileFactory();
        CourseSetFactory courseSetFactory = new CourseSetFactory();
        UserFactory userFactory = new UserFactory();
        var p1 = profileFactory.createProfile("Toni", 2, "Linguistics", courseSetFactory.createCourseSet("CSC207,LIN102,LIN101"),
                                              "", "Chess", "Ice Skating", "Taylor Swift", "Eat Manpuku");
        var p2 = profileFactory.createProfile("Ikshat", 2, "Computer Science", courseSetFactory.createCourseSet("CSC207,CSC301,CSC209"),
                                              "", "Sleep", "Rock Climbing", "Zachary Knowles", "Play Video Games");
        var p3 = profileFactory.createProfile("Rue", 2, "Computer Science", courseSetFactory.createCourseSet("CSC207,CSC236,CSC209"),
                                              "", "Poetry", "Ew Sports", "BTS", "Read");
        var p4 = profileFactory.createProfile("Adrian", 2, "Gender Studies", courseSetFactory.createCourseSet("ECO101,CSC207,MAT237"),
                                              "", "Economics", "Ski", "Illenium", "Breathe");
        var p5 = profileFactory.createProfile("Dien", 2, "Computational Biology and Bioinformatics", courseSetFactory.createCourseSet("CSC207,CSC236,BIO101"),
                                              "", "Makeup", "Dance", "Blackpink", "Makeup Even More");
        var p6 = profileFactory.createProfile("Lawrence", 2, "Chemistry", courseSetFactory.createCourseSet("CHM101,CHM102,CSC207,MAT237"),
                                              "", "Crypto", "Run", "Pop", "Lift Weights");

        users.add(userFactory.createUser(p1));
        users.add(userFactory.createUser(p2));
        users.add(userFactory.createUser(p3));
        users.add(userFactory.createUser(p4));
        users.add(userFactory.createUser(p5));
        users.add(userFactory.createUser(p6));

        return users;
    }
}