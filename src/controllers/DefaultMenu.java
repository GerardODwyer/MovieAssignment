package controllers;

import java.util.Optional;

import asg.cliche.Command;
import asg.cliche.Param;
import models.User;

public class DefaultMenu {

	private String name;
	private User user;
	private MovieAPI movieApi;

	public DefaultMenu(MovieAPI paceApi, User user) {
		this.movieApi = paceApi;
		this.setName(user.firstName);
		this.user = user;
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
	public void addMovie(@Param(name = "title") String title, 
						 @Param(name = "year") String year,
						 @Param(name = "url") String url)
	{
		movieApi.createMovie(title, year, url);
	}

}