package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import asg.cliche.Command;
import asg.cliche.Param;
import models.User;

public class AdminMenu {

	private String name;
	private MovieAPI movieApi;

	public AdminMenu(MovieAPI movieApi, String userName) {

		this.movieApi = movieApi;
		this.setName(userName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Command(description = "Get all Users detail")
	public void getUsers() {

		System.out.println(movieApi.getUsers());
	}

	@Command(description = "Get a Users detail by id")
	public void getUser(@Param(name = "id") Long id) {
		User user = movieApi.getUser(id);
		System.out.println(user);
	}

	// @Command(description = "Add a rateing")
	// public void addRateing(@Param(name= "type") Long userid, @Param(name =
	// "year") Long movieid,
	// @Param(name = "distance") int rateing) {
	// movieApi.createRateing(user.id, userid, name, movieid);
	// }

	@Command(description = "Add Movie")
	public void addMovie(@Param(name = "title") String title, @Param(name = "year") String year,
			@Param(name = "url") String url) {
		movieApi.createMovie(title, year, url);
	}

	@Command(description = "Create a new User")
	public void createUser(@Param(name = "first name") String firstName, @Param(name = "last name") String lastName,
			@Param(name = "email") int age, @Param(name = "password") String occupation,
			@Param(name = "password") String gender) {
		movieApi.createUser(firstName, lastName, age, occupation, gender);

	}

	@Command(description = "Delete a User")
	public void deleteUser(@Param(name = "email") Long id) {

		movieApi.deleteUser(id);

	}

	@Command(description = "Get all users sorted by there Name")
	public void getAllUser() {
		TreeSet<User> sortedUsers = new TreeSet<User>();
		sortedUsers.addAll(movieApi.getUsers());
		Iterator<User> iter = sortedUsers.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			System.out.println(u.firstName + " " + u.lastName);
		}
	}

	@Command(description = "search a user by name")
	public void getUserByName(String name) {
		ArrayList<User> users = new ArrayList<User>();
		users.addAll(movieApi.getUsers());
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).firstName.toLowerCase().contains(name.toLowerCase())) {
				System.out.println(users.get(i));
			}
		}
	}

}
