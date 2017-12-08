package models;

import static models.Fixtures.users;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.MovieAPI;
import models.User;


public class MovieApiTest {

		  private MovieAPI movie;

		  @Before
		  public void setup()
		  {
		    movie = new MovieAPI();
		    for (User user : users)
		    {
		     movie.createUser(user.firstName, user.lastName,user.age, user.occupation, user.gender);
		    }
		  }

		  @After
		  public void tearDown()
		  {
		    movie = null;
		  }

		  @Test
		  public void testUser()
		  {
		    assertEquals (users.length, movie.getUsers().size());
		    movie.createUser("Ger", "O Dywer", 52, "student", "m");
		    assertEquals (users.length+1, movie.getUsers().size());
		    assertEquals (users[0], movie.getUserByFirstName(users[0].firstName));
		  }  

		  @Test
		  public void testUsers()
		  {
		    assertEquals (users.length, movie.getUsers().size());
		    for (User user: users)
		    {
		      User eachUser = movie.getUserByFirstName(user.firstName);
		      assertEquals (user, eachUser);
		      assertNotSame(user, eachUser);
		    }
		  }

		  @Test
		  public void testDeleteUsers()
		  {
		    assertEquals (users.length, movie.getUsers().size());
		    User Ger = movie.getUserByFirstName("Ger");
		    movie.deleteUser(Ger.id);
		    assertEquals (users.length-1, movie.getUsers().size());    
		  }  
		  
		  
		}
	