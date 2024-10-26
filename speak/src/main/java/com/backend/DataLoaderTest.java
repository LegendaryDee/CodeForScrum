/**
 * 
 */
package com.backend;

import java.util.List;

/**
 * 
 */
public class DataLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 // Load existing data from JSON files using DataLoader
        System.out.println("Loading users...");
        List<User> users  = UserList.getInstance().getUsers();
        System.out.println("List of Users: " + users);


        System.out.println("Loading courses...");
        List<Course> courses = CourseList.getInstance().getAllCourses();
        System.out.println("List of Courses: " + courses);

	}

}
