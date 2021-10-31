# Scenario Walkthrough

This scenario walk-through will show how each of the CRC cards are useful in the structure of our program. The program begins by taking the keyboard input and forwards it to ControlSystem. Control System will request UserManager to create a new User object, which takes the user’s crucial information such as courses, interests, name and so on. The UserManger also creates a Profile for the User and ensures that the Profile Object is stored in the User’s attributes. Then, UserManager will forward the User object to UserDatabase. It’s important to note that UserManger will retrieve all existing Users from UserDatabase each time the program is run. Then, ControlSystem will request UserManger to receive a list of all user from the UserDatabase and send it to Matcher; it will generate a dictionary of key values {User: [matches]} and send it back to UserManager. The UserManager loops over the dictionary and associates each User object with their corresponding matches. 

In later development of the program, we intend to add more features. Admin is a User that has special privileges and has access to the ReportDatabase. ReportDatabase stores all user reports, such as DistressReport and HarassementReport. A Report is an entity that has information about the user that filed the report, date of report, and so on. Based on the reports, an Admin will be able to read them and has access to other Users to modify their BlockedUser attribute when necessary. We also intend to implement entities such as MatchHistory, Course, Message, and Chat to store them in the User’s attribute. This enables the User to interact with other users, such that a collection of Message will be stored in a Chat entity. MatchHistory will contain the User’s previous matches, and Course contains the user’s current courses and course details.