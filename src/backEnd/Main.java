package backEnd;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner (System.in);

       System.out.println("Loading users...");
       ArrayList<User> users = DataLoader.getUsers();
       UserList userList = UserList.getInstance();
       userList.setUsers(users);

       System.out.println("Loading courses...");
       ArrayList<Course> courses = DataLoader.getCourses();
    CourseList courseList = CourseList.getInstance();
    courseList.setCourses(courses); 

    boolean exit = false;
    while (!exit)
    {
        System.out.println("\n=== El Chicos Language Learning Application ===");
        System.out.println("1. Register new user");
        System.out.println("2. Login as user");
        System.out.println("3. View all courses");
        System.out.println("4. Assign course to user");
        System.out.println("5. Save data");
        System.out.println("6. Exit");
        System.out.println("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                registerNewUser(scanner, userList);
                break;
            case 2:
                loginUser(scanner, userList);
                break;
            case 3:
                displayallCourses(courseList);
                break;
            case 4:
                assignCourseToUser(scanner, userList, courseList);
                break;
            case 5:
                saveData(userList, courseList);
            case 6:
            exit = true;
            System.out.println("Exiting application...");
            break;
        default:
            System.out.println("Invalid choice. Please select again.");
        }
    }
    scanner.close();
    }

    private static void registerNewUser(Scanner scanner, UserList userList)
    {
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter language prefernce (ENGLISH/SPANISH/FRENCH/GERMAN): ");
        String languagePreferenceString = scanner.nextLine();

        LanguagePreference languagePreference = LanguagePreference.valueOf(languagePreferenceString.toUpperCase());
        UUID userId = UUID.randomUUID();
        User newUser = new User(userId, userName, password, email, languagePreference, new ProgressData(userId.toString()), 0);

        userList.addUser(newUser);
        System.out.println("User registered successfully: " + userName);
    }

    private static void loginUser(Scanner scanner, UserList userList)
    {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = userList.getUserByUsername(username);

        if (user == null)
        {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Enter user ID to assign: ");
        String courseId = scanner.nextLine();
        Course course = courseList.getCourseByID(courseId);

        if (course == null)
        {
            System.out.println("Course not found.")
            return;
        }
        user.getProgessData().setCurrentCourseID(coures.getCourseByID());
        System.out.println("Course " + course.getTitle() + " assigned to user " + user.getUserName());
    }

    private static void saveData(UserList userList, CourseList courseList)
    {
        System.out.println("Saving users...");
        DataWriter.saveUsers(userList.getUsers());

        System.out.println("Saving courses...");
        DataWriter.saveCourses(courseList.getCouses());

        System.out.println("Data saved successfully.");
    }

}
