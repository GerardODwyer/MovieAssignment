package controllers;



import java.io.File;
import java.io.IOException;


import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;

import models.User;
import controllers.MovieAPI;
import utils.Serializer;
import utils.XMLSerializer;

public class Main implements ShellDependent
{
	public MovieAPI movieApi = new MovieAPI();
	
	public static final String ADMIN = "admin";
	private Shell theShell;
	
	public Main()throws Exception {
		File movie = new File("deatils6.xml");
		Serializer serial = new XMLSerializer(movie);
		movieApi = new MovieAPI(serial);
		if (movie.isFile()) {
			movieApi.load();
	}
	}
	
	
	@Override
	public void cliSetShell(Shell shell) {
		this.theShell =shell;
	}
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.movieApi.initalLoad();
		main.movieApi.createAdminUser("ger", "odwyer", 20, "Student", "Male", "admin");
		Shell shell = ShellFactory.createConsoleShell("lm", "Welcome to my movie api", main);
		shell.commandLoop();
		main.movieApi.store();
	}

	
	@Command(description = "load data")
	public void loadData() throws IOException {
		movieApi.initalLoad();
	}

	@Command(description = "Log In")
	public void login(@Param(name="id") long id, 
					  @Param(name="last name")String password) throws IOException {
		 if (movieApi.login(id, password) && movieApi.currentUser.isPresent()) {
			 
		      User user = movieApi.currentUser.get();
		      System.out.println("You are logged in as " + user.firstName);
		      if (user.role!=null && user.role.equals(ADMIN)) {
		        AdminMenu adminMenu = new AdminMenu(movieApi, user.firstName);
		        ShellFactory.createSubshell(user.firstName, theShell, "Admin", adminMenu).commandLoop();
		      } else {
		        DefaultMenu defaultMenu = new DefaultMenu(movieApi, user);
		        ShellFactory.createSubshell(user.firstName, theShell, "Default", defaultMenu).commandLoop();
		      }
		    } else
		      System.out.println("Unknown userName and or password.");
		  }

	
	
	

	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
}











