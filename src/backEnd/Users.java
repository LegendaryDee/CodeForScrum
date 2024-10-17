package backEnd;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a collection of useres with methods for account management.
 * Uses the singleton pattern to ensure only one instane of Users exists.
 */
public class Users extends User
{
    private static Users usersInstance;
    private ArrayList<User> userList;

    /**
     * Private constructor 
     * Initializes the user list from a database or as a new ArrayList.
     */
    private Users()
    {
        userList = new ArrayList<>();
    }

    public static Users getInstance()
    {
        if (usersInstance == null)
        {
            usersInstance = new Users();
        }
        return usersInstance;
    }

    public boolean haveUser(String userName)
    {
        for (User user : userList)
        {
            if (user.getUserName().equalsIgnoreCase(userName))
            {
                return true;
            }
        }
        return false;
    }

    public User getUser (String userName)
    {
        if (!haveUser(userName))
        {
            return null;
        }

        for (User user : userList)
        {
            if (user.getUserName().equalsIgnoreCase(userName))
            {
                return user;
            }
        }
        return null;
    }

    public User createAccount (String userName, String password, String email, String languagePreference)
    {
        if (haveUser(userName)) 
        {
            System.out.println("Username already exists. PLease choose another. ");
            return null;
        }
        User newUser = new Users (UUID.randomUUID(), userName, password, email, languagePreference);
        userList.add(newUser);
        System.out.println("User account created successfully.");
        return newUser;
    }

    public User signIn(String userName, String password)
    {
        User user = getUser(userName);
        if (user != null && user.getPassword().equals(password))
        {
            System.out.println("User signed in successFully.");
            return user;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    public User sigInAsGuest()
    {
        String guestName = "Guest_" + UUID.randomUUID().toString().substring(0, 5);
        User guestUser = new User(UUID.randomUUID(), guestName, "", "", "English");
        userList.add(guestUser);
        System.out.println ("Guest user signed in as " +guestName);
        return guestUser;
    }
}
