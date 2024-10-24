package com.backend;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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
        
        
        //courseList.setCourses(courses);

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
    @SuppressWarnings("static-access")
    private static void saveData(List<User> users, List<Course> courses) {
        System.out.println("Saving users...");
        DataWriter writer = new DataWriter();
        //Saving the Users
        writer.saveUsers(users);
        
        System.out.println("Saving courses...");
        writer.saveCourses(courses);

        System.out.println("Data saved successfully.");
    }
}
