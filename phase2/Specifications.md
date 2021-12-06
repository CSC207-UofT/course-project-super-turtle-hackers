# Amigo Specifications

Below is the roadmap, or phases of implementation, we have planned for our project. Note that these phases correspond to the course project phases.

## Phase 0

Each user creates a profile that includes their name, year of study, courses they’re taking and 5 interests. Every year users must update their year of study and courses and can update their interests. Every term, they will also have the option of updating their courses until the second week of the term. The system will match them with other student(s) in the same course (will take lecture and tutorial timings into consideration later) with similar interests.

*Note: We match only on one interest and give two matches per user. The users who consent to chatting will be provided with each other's contact information.*

## Phase 1

An existing user can sign into their account using their existing login credentials. A new user can create an account by entering their personal information, course details, and personal interests. After signing in, user will be able to view their profile on the "Home" tab of the page; "Match Pool" shows the matches and profile alongside for the user to select a match; "Socials" let the user to add their social contact for the match; finally, "View Match" shows the profile of the chosen match; "Sign out" brings the user back to the log-in page. When the matching algorithm runs "Match Pool" will be updated. User credentials are stored and retrieved from a database. The database is extended to allow user enter up to 2 courses with tutorial section, lecture section, and course code.

## Phase 2

Each user can start a conversation with 2 other matched users and conversation starter prompts will be provided based on course and interest. At the end of the day, each user can choose whether they want to continue the conversation. If both users choose “yes”, the app will automatically exchange their social media/contact information with their conversation partner. If only one of them says yes, both will be asked whether they want to have the chance to match again with the same person. Only if both say yes, they will be potentially matched again in the future. If neither user consents to continue the conversation, they can still send a message request at a later point. Users will be able to see their match history.

Each chat has a distress and harassment report feature enabled. Once a report is filed, the chat is immediately closed and sent for review. Both the users involved will no longer participate in matches until the review is completed. If the distress feature is enabled, hotline numbers will be displayed and the users are given the option to continue chatting.

If time permits, users can add a friend that they met from outside the app using an ID code. Their friend will be invited to the app and will be given a choice to be matched with other users or to build a timetable only with you. The app will show the lecture/tutorial section both users can attend. If the users wanted to hangout/study together, the app will show you the time slots where both users are free.
