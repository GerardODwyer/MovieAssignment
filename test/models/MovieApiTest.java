package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.MovieAPI;


public class MovieApiTest {

		  private MovieAPI movie;

		  @Before
		  public void setup()
		  {
		    movie = new MovieAPI();
		    for (User user : users)
		    {
		      Movie.createUser(user.firstName, user.lastName,user.age, user.occupation, user.gender);
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
		    assertEquals (User.length, Movie.getUser().size());
		    Movie.createUser("Ger", "O Dywer",52, "student", "m");
		    assertEquals (user.length+1, Movie.getUser().size());
		    assertEquals (user[0], Movie.getUserByfirstName(user[0].firstName));
		  }  

		  @Test
		  public void testUsers()
		  {
		    assertEquals (user.length, Movie.getUser().size());
		    for (User user: user)
		    {
		      User eachUser = Movie.getUserByfirstName(user.firstName);
		      assertEquals (user, eachUser);
		      assertNotSame(user, eachUser);
		    }
		  }

		  @Test
		  public void testDeleteUsers()
		  {
		    assertEquals (user.length, Movie.getUser().size());
		    User Ger = Movie.getUserByfirstName("Ger");
		    Movie.deleteUser(Ross.id);
		    assertEquals (user.length-1, movie.getUser().size());    
		  }  
		  
		  @Test
		  public void testAddActivity()
		  {
		    User Ger = Movie.getUserByfirstName("Beth");
		    Rateing activity = M.createActivity(Beth.id, activities[0].type, activities[0].Rateings, activities[0].distance);
		    Activity returnedActivity = movie.getActivity(activity.id);
		    assertEquals(activities[0],  returnedActivity);
		    assertNotSame(activities[0], returnedActivity);
		  }
		  
		  @Test
		  public void testAddActivityWithSingleRateings()
		  {
		    User marge = movie.getUserByfirstName("Beth");
		    Long activityId = movie.createActivity(.id, movie[0].type, movie[0].location, movie[0].distance).id;

		    movie.addLocation(activityId, Rateings[0].latitude, Rateings[0].longitude);

		    Movie movie = movie.getMovie(movieId);
		    assertEquals (1, movie.route.size());
		    assertEquals(0.0001, rateings[0].userid,  movie.route.get(0).userid);
		    assertEquals(0.0001, rateings[0].movieid, movie.route.get(0).movieid);   
		  }
		  
		  @Test
		  public void testAddActivityWithMultipleRateings()
		  {
		    User marge = movie.getUserByfirstName("marge@simpson.com");
		    Long activityId = movie.createActivity(marge.id, rateings[0].type, rateings[0].location, rateings[0].distance).id;

		    for (Rateings rateings : rateings)
		    {
		    	movie.addMovie(activityId, rateings.latitude, rateings.longitude);      
		    }

		    Movie activity = movie.getmovie(activityId);
		    assertEquals (Rateings.length, activity.route.size());
		    int i = 0;
		    for (Rateings rateings : activity.route)
		    {
		      assertEquals(rateings, rateings[i]);
		      i++;
		    }
		  } 
		}
	