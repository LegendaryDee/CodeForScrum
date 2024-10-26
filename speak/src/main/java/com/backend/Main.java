package com.backend;
package com.narration;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Main class serves as the driver for the language learning application.
 * It demonstrates how to load data, perform various operations, and save changes.
 */
public class Main {
    public static void main(String[] args) {
        // Initialize the scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Load existing data from JSON files using DataLoader
        System.out.println("Loading users...");
        List<User> users  = UserList.getInstance().getUsers();
        System.out.println("List of Users: " + users);


        System.out.println("Loading courses...");
        List<Course> courses = CourseList.getInstance().getAllCourses();
        System.out.println("List of Courses: " + courses);
        
        
        //Scenario for Tim and Tammy Tomacka
        handleTimScenario();
        handleTammyScenario();

        // Display menu and interact with the user
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== El Chicos Language Learning Application ===");
            System.out.println("1. Register new user");
            System.out.println("2. Login as user");
            System.out.println("3. View all courses");
            System.out.println("4. Assign course to user");
            System.out.println("5. View all users");
            System.out.println("6. Save data");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    registerNewUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    displayAllCourses();
                    break;
                case 4:
                    assignCourseToUser(scanner);
                    break;
                case 5:
                    displayAllUsers();
                    break;
                case 6:
                    saveData(users, courses);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }

        scanner.close();
    }
 private static void handleTimScenario()
 {
    System.out.println("\n=== Tim Tomacka's Scenario ===");
    User timUser = UserList.getInstance().getUser("ttomacka");
    if(timUser == null)
    {
        System.out.println("Tim Tomacka is not in the users.json file.");
    }

    User tammyUser = UserList.getInstance().getUser("ttomacka");
    if (tammyUser != null)
    {
        System.out.println("Tammy Tomacka is in the users.json file.");
    }

    // Tim changes his username and successfully creates an account
    System.out.println("Tim changes his username to 'ttom' and creates an account.");
    timUser = new User(UUID.randomUUID(), "ttom", "password123", "tim@example.com", LanguagePreference.ENGLISH, new ProgressData(UUID.randomUUID().toString()), 0);
    UserList.getInstance().addUser(timUser);
    System.out.println("Account created successfully for Tim Tomacka.");

    // Tim logs out
    timUser.logout();

    // Save the updated users.json and show Tim's entry
    saveData(UserList.getInstance().getUsers(), CourseList.getInstance().getAllCourses());
    System.out.println("Users.json updated to include Tim. Checking users.json...");
    displayAllUsers();

    // Tim logs in successfully
    System.out.println("Tim logs into the system with the username 'ttom'.");
    User timLogin = UserList.getInstance().getUser("ttom");
    if (timLogin != null && timLogin.login("ttom", "password123")) {
        System.out.println("Tim successfully logged in.");
    }

    // Tim proceeds through the course (hardcoded scenario)
    proceedThroughCourse(timLogin);

    // Tim logs out
    timLogin.logout();
    System.out.println("Tim has logged out.");

    }

    private static void handleTammyScenario()
    {
        System.out.println("\n=== Tanny Tomacka's Scenraio ===");
        
        User tammyUser = UserList.getInstance().getUser("ttomacka");
        if (tammyUser != null)
        {
            System.out.println("Tammy Tomacka's entry found in users.json");
            System.out.println("User ID: " +tammyUser.getId());
            System.out.println("Usernname: " + tammyUser.getUserName());
            System.out.println("Email: " + tammyUser.getEmail());
        }

        // Tammy logs in
        System.out.println("Tammy logs into her account.");
        if (tammyUser.login("ttomacka", "tammyPassword")) {
            System.out.println("Tammy successfully logged in.");
        }

        // Tammy checks her progress
        System.out.println("Checking Tammy's progress...");
        showUserProgress(tammyUser);

        // Tammy reviews her struggling content
        System.out.println("Tammy reviews her struggling words and phrases...");
        reviewStrugglingContent(tammyUser);

        // Tammy logs out
        tammyUser.logout();
        System.out.println("Tammy has logged out.");

        // Show updates to Tammy's user.json entry
        saveData(UserList.getInstance().getUsers(), CourseList.getInstance().getAllCourses());
        System.out.println("Users.json updated to reflect Tammy's progress. Checking users.json...");
        displayAllUsers();
    }

  /**
 * Displays the progress of a user, including current course, lesson, struggling words, and course percentage.
 */
private static void showUserProgress(User user) {
    ProgressData progressData = user.getProgressData();
    UUID currentCourseId = progressData.getCurrentCourseID();   // Retrieve the current course ID
    UUID currentLessonId = progressData.getCurrentLessonID();   // Retrieve the current lesson ID
    int courseProgress = progressData.getCourseCompletionPercentage();  // Retrieve course completion percentage
    List<String> strugglingWords = progressData.getStrugglingWords();  // Retrieve struggling words
    List<String> strugglingPhrases = progressData.getStrugglingPhrases();  // Retrieve struggling phrases

    System.out.println("\n=== User Progress for " + user.getUserName() + " ===");

    // Display the current course information
    if (currentCourseId != null) {
        System.out.println("Current Course ID: " + currentCourseId);
    } else {
        System.out.println("No course currently assigned.");
    }

    // Display the current lesson
    if (currentLessonId != null) {
        System.out.println("Current Lesson ID: " + currentLessonId);
    } else {
        System.out.println("No lesson in progress.");
    }

    // Display course completion percentage
    System.out.println("Course Completion: " + courseProgress + "%");

    // Display struggling words
    if (!strugglingWords.isEmpty()) {
        System.out.println("Struggling Words: " + strugglingWords);
    } else {
        System.out.println("No struggling words.");
    }

    // Display struggling phrases
    if (!strugglingPhrases.isEmpty()) {
        System.out.println("Struggling Phrases: " + strugglingPhrases);
    } else {
        System.out.println("No struggling phrases.");
    }
}

    /**
     * Dummy method to simulate Tim proceeding through the course.
     */
    private static void proceedThroughCourse(User user) {
        System.out.println("Tim is proceeding through the course...");

        // Simulate learning activities
        System.out.println("Tim is reading a story and reviewing flashcards.");

        // Answer a series of 5 questions
        System.out.println("Tim is answering 5 questions:");
        Question q1 = new Question(UUID.randomUUID(), "Translate 'Hola'", List.of("Hello", "Goodbye", "Please"), 0); // Multiple-choice
        Question q2 = new Question(UUID.randomUUID(), "What does 'Gracias' mean?", List.of("Thank you", "Sorry", "Hello"), 0);
        Question q3 = new Question(UUID.randomUUID(), "Fill in the blank: 'Buenos ___'", List.of("Noches", "Dias", "Tardes"), 1); // Fill-in-the-blank
        Question q4 = new Question(UUID.randomUUID(), "Translate the phrase 'See you later'", List.of("Hasta luego", "Buenos dias", "Gracias"), 0);
        Question q5 = new Question(UUID.randomUUID(), "Choose the correct pronunciation", List.of("Pronunciation A", "Pronunciation B", "Pronunciation C"), 2); // Pronunciation question

        // Tim's answers (4 correct, 1 incorrect)
        int correctAnswers = 0;
        if (q1.checkAnswer("Hello")) correctAnswers++;
        if (q2.checkAnswer("Thank you")) correctAnswers++;
        if (q3.checkAnswer("Dias")) correctAnswers++;
        if (!q4.checkAnswer("Buenos dias")) correctAnswers++;
        if (!q5.checkAnswer("Pronunciation A")) // Incorrect answer

        System.out.println("Tim answered " + correctAnswers + " questions correctly out of 5.");
        System.out.println("Tim's progress updated.");
    }

    /**
     * Simulates Tammy reviewing her struggling content and printing a study sheet.
     */
    private static void reviewStrugglingContent(User tammyUser) {
        // Assume Tammy has 10 words and 8 phrases she's struggling with
        List<String> strugglingWords = List.of("Hola", "Gracias", "Por favor", "Perro", "Gato", "Casa", "Comida", "Familia", "Agua", "Escuela");
        List<String> strugglingPhrases = List.of("Buenos dias", "Buenas noches", "Hasta luego", "Lo siento", "¿Cómo estás?", "Estoy bien", "Perdón", "Muchas gracias");

        // Print study sheet to a text file
        try (FileWriter writer = new FileWriter("tammy_study_sheet.txt")) {
            writer.write("Study Sheet for Tammy Tomacka\n");
            writer.write("=============================\n\n");
            writer.write("Words:\n");
            for (String word : strugglingWords) {
                writer.write("- " + word + "\n");
            }
            writer.write("\nPhrases:\n");
            for (String phrase : strugglingPhrases) {
                writer.write("- " + phrase + "\n");
            }
            System.out.println("Study sheet printed to tammy_study_sheet.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Registers a new user and adds them to the UserList.
     */
    private static void registerNewUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter language preference (ENGLISH/SPANISH/FRENCH/GERMAN): ");
        String languagePreferenceString = scanner.nextLine();

        LanguagePreference languagePreference = LanguagePreference.valueOf(languagePreferenceString.toUpperCase());
        UUID userId = UUID.randomUUID();
        User newUser = new User(userId, userName, password, email, languagePreference, new ProgressData(userId.toString()), 0);

        //userList.addUser(newUser);
        UserList.getInstance().addUser(newUser);
        System.out.println("User registered successfully: " + userName);
        System.out.println("User ID: " + userId);
        System.out.println("Email: " + email);
    }

    /**
     * Simulates user login.
     */
    private static void loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = UserList.getInstance().getUser(username);
        if (user != null && user.login(username, password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            System.out.println("User ID: " + user.getId());
            System.out.println("Email: " + user.getEmail());
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    /**
     * Displays all available courses.
     */
    private static void displayAllCourses() {
        System.out.println("\nAvailable Courses:");
        List<Course> courseList = CourseList.getInstance().getAllCourses();
        for (Course course :  courseList) {
            System.out.println("Course ID: " + course.getCourseID() + " - " + course.getTitle());
        }
    }

    /**
     * Assigns a course to a user.
     */
    private static void assignCourseToUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        User user = UserList.getInstance().getUser(username);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter Course ID to assign: ");
        UUID courseId = UUID.fromString(scanner.nextLine());
        Course course = CourseList.getInstance().findCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        user.getProgressData().setCurrentCourseID(course.getCourseID());
        System.out.println("Course " + course.getTitle() + " assigned to user " + user.getUserName());
    }

    /**
     * Displays all users with their IDs, usernames, and emails.
     */
    private static void displayAllUsers() {
        System.out.println("\nRegistered Users:");
        List<User> userList =  UserList.getInstance().getUsers();
        for (User user : userList) {
            System.out.println("User ID: " + user.getId());
            System.out.println("Username: " + user.getUserName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("----------------------------");
        }
    }

    /**
     * Saves user and course data back to JSON files using DataWriter.
     */
    private static void saveData(List<User> users, List<Course> courses) {
        System.out.println("Saving users...");
        
        //Saving the Users
        DataWriter.saveUsers(users);
        
        System.out.println("Saving courses...");
        DataWriter.saveCourses(courses);

        System.out.println("Data saved successfully.");
    }
}

