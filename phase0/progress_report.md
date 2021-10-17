### Specification Summary:

Amigo has 3 phases of product development. In phase 0, Users can create a profile which includes their name, year of study, courses and personal interests. They will be matched with 2 other users taking the same course. They will choose one person to chat with and if both users consent, they will be provided with each other’s contact information. In phase 1, users will be matched with 4 other users. They will choose 2 users to chat with and if both parties consent, they can  access a chat feature which allows them to chat if both users want to. Each chat has a distress feature and report feature for the users’ comfort and safety. The matches not chosen to chat with are considered rejected matches, in which case they can choose whether they would have the chance of being matched again in the future.  Lastly in phase 2, the app will allow friends to be invited and can generate a timetable where a user can meet their friends based on their schedules. 

### CRC Model Summary:
[Note all the classes have been bolded to emphasize the difference between the class name and actual noun.]

The usecase UserManager collaborates with the entities User and Profile to create users and modify them. The interface adapter UserDatabase collaborates with the UserManager to create and update the text file storing information.

The use case Matcher receives users from the controller ControlSystem and creates matches. These matches are then sent back to the ControlSystem. Then, they are sent to the UserManager who modifies the User to store the current matches. This process is repeated with the MatchHistory entity too.

The Chat entity is a collection of messages stored in the Message entity. The Report entity (also an abstract class) temporarily stores the information filled in a report before sending it to the interface adaptor ReportDatabase. If it’s a harassment report, we use the HarrasmentReport (child of Report class) entity and if it’s a distress report, we use the DistressReport (child of Report class) entity. The Admin entity, a child of the User class, access the ReportDatabase and can resolve reports.

### Scenario-Walk Through Summary:

Our scenario walk-through shows how a typical user would be using our app by referencing the CRC model. First, the ControlSystem receives input and runs the program and requests the UserManager to make a new User and Profile object. Then, the UserManager stores the Profile object in User. UserManager will communicate with UserDatabase so that the new User is logged. Next, ControlSystem will request a list of User objects and send it to Matcher, once a day. The Matcher will generate a dictionary of matches, called match dictionary based on each User’s courses and interests, and return it back to ControlSystem.The match dictionary has a key of a User object and the value would be that user’s list of matches. This match dictionary is then forward to UserManager by the Controller. Lastly, UserManager takes the match dictionary and allocates the list of matches to each User.

In the future we want to implement, a chat with reports as a safety feature and admins with permissions to review these reports.

### Skeleton program Summary:

  The user interacts with the app through the IDE terminal. The main method is in Driver Class. An instance of ControlSystem (referred to as the control system) is created and its run method runs to prompt the user to input their information. After the user inputs their information to create a new profile, an instance of UserManager (referred to as the user manager) is created by the control system. The user manager creates the profile and user objects and adds it to the database. The control system calls on the matching method in Matcher to match the users, which returns a hashmap with users and their matches. The control system then prints out a list of users and their matches.

### Open-ended questions:

We are still figuring out how to implement a server and database. We are also working through maintaining interactions between the front and back end. We are also unsure about implementing the chat feature because we need to store chat data in a server and create a corresponding UI to make interaction effortless.

### What has worked well for the team so far?

In terms of collaboration, ideation, and communication, our group has been able to allocate time efficiently and work well together. So far, our designs have a good foundation in how each entity interacts with other classes and follows SOLID and clean architecture principles. There are many sophisticated layers but we established a good structure to improve on for phase 1 and 2.

### Summary of what each group member has worked:
Lawrence, Adrian, and Rue are on design and designed the screens, methodology, planning, UI/UX, and are planning to extend more GUI functionalities. Lawrence and Adrian are on frontend and will code the UI to replace the command line interface. Tony, Dien, and Akshat are working on the backend which includes the skeleton code and collaborating with the frontend. The backend team along with Rue will continue with coding the algorithm for the matching while the frontend will implement the screens created and work on the interactions. 
