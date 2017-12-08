package controllers;

import java.io.File;
import java.io.IOException;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import utils.Serializer;
import utils.XMLSerializer;







public class Main implements ShellDependent
{
	public MovieAPI movies;
	public static final String ADMIN = "admin";
	private Shell theShell;
	
	public Main()throws Exception {
		File movie = new File("deatils.xml");
		Serializer serial = new XMLSerializer(movie);
		movies = new MovieAPI(serial);
		if (movie.isFile()) {
			movies.load();
		}
		
		
		
		
		
	}
	
	@Override
	public void cliSetShell(Shell shell) {
		this.theShell =shell;
	}
	
	
	
	
	
	
	@Command(description = "Log In")
	public void login(@Param(name="id") long id, @Param(name="last name")String last) {
		 if (MovieAPI.login(userName, pass) && MovieAPI.currentUser.isPresent()) {
			 
		      User user = MovieAPI.currentUser.get();
		      System.out.println("You are logged in as " + user.email);
		      if (user.role!=null && user.role.equals(ADMIN)) {
		        AdminMenu adminMenu = new AdminMenu(MovieAPI, user.firstName);
		        ShellFactory.createSubshell(user.firstName, theShell, "Admin", adminMenu).commandLoop();
		      } else {
		        DefaultMenu defaultMenu = new DefaultMenu(MovieAPI, user);
		        ShellFactory.createSubshell(user.firstName, theShell, "Default", defaultMenu).commandLoop();
		      }
		    } else
		      System.out.println("Unknown username and or password.");
		  }
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		//main.movies.initalLoad();
		Shell shell = ShellFactory.createConsoleShell("lm", "Welcome to my movie api", main);
		shell.commandLoop();
		main.movies.store();
	}
}











