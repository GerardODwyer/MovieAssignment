package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import models.Movie;
import models.Rateings;
import models.User;
import utils.FileLogger;
import utils.Serializer;

import com.google.common.base.Optional;

public class MovieAPI
{
  private Serializer serializer;
  private Map<Long,   User>   userIndex       = new HashMap<>();
  private Map<String, User>   firstNameIndex      = new HashMap<>();
  private Map<Long, Movie> movieIndex = new HashMap<>();
  private Map<Long, Rateings> rateIndex = new HashMap<>();
  
  public Optional<User> currentUser;
  

  public MovieAPI()
  {
  }
  
  public MovieAPI(Serializer serializer)
  {
    this.serializer = serializer;
  }

  public Collection<User> getUsers ()
  {
    return userIndex.values();
  }

  public  void deleteUsers() 
  {
    userIndex.clear();
    firstNameIndex.clear();
  }

  public void createUser(String firstName, String lastName, int age, String occupation, String gender) 
  {
    User user = new User (firstName, lastName, age, occupation, gender);
    userIndex.put(user.id, user);
    
  }
  
  public void createAdminUser(String firstName, String lastName, int age, String occupation, String gender, String role) 
  {
    User user = new User (firstName, lastName, age, occupation, gender, role);
    userIndex.put(user.id, user);
    
  }

  public User getUserByFirstName(String firstName) 
  {
    return firstNameIndex.get(firstName);
  }

  public User getUser(Long id) 
  {
    return userIndex.get(id);
  }

  public void deleteUser(Long id) 
  {
    User user = userIndex.remove(id);
    firstNameIndex.remove(user.firstName);
  }

  public void createMovie(String title, String year, String URL)
  {
    Movie movie = new Movie(title, year, URL);
      movieIndex.put(movie.id, movie);
 
  }
 
  
  public Movie getMovie(Long id)
  {
    return movieIndex.get(id);
  }
 
	public void addRatings(Long userID, Long movieID, int rating) {
		Rateings ratings;
		Optional<User> user = Optional.fromNullable(userIndex.get(userID));
		Optional<Movie> movie = Optional.fromNullable(movieIndex.get(movieID));
		if (movie.isPresent() && user.isPresent()) {
			ratings = new Rateings(userID, movieID, rating); // add new rating
			user.get().movietitle.put(ratings.id, ratings); // attach user to a rating
			movie.get().route.put(ratings.id, ratings); // attach a movie to a rating
			rateIndex.put(ratings.id, ratings); // add rating to a collection
			
			

		}
	}
 
  
  @SuppressWarnings("unchecked")
  public void load() throws Exception
  {
    serializer.read();
    userIndex  = (Map<Long, User>)  serializer.pop();
    movieIndex = (Map<Long, Movie>) serializer.pop();
    rateIndex = (Map<Long, Rateings>) serializer.pop();
  }

  void store() throws Exception
  {
	  serializer.push(rateIndex);
	  serializer.push(movieIndex);
    serializer.push(userIndex);
    
    serializer.write(); 
  }
 
  
  public void initalLoad() throws IOException {
		String delims = "[|]";
		Scanner scanner = new Scanner(new File("./lib/users5.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 7) {
				createUser(userTokens[1], userTokens[2], Integer.parseInt(userTokens[3]), userTokens[5], userTokens[4]);
			} else {
				scanner.close();
				throw new IOException("Invalid member length: " + userTokens.length);
			}
			
			
			}
		
		scanner = new Scanner(new File("./lib/items5.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 23) {
				createMovie(userTokens[1], userTokens[2], (userTokens[3]));
			} else {
				scanner.close();
				throw new IOException("Invalid member length: " + userTokens.length);
			}
		}
		
		scanner = new Scanner(new File("./lib/ratings5.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 4) {
				addRatings(Long.valueOf(userTokens[1]), Long.valueOf(userTokens[2]), Integer.valueOf(userTokens[3]));
			} else {
				scanner.close();
				throw new IOException("Invalid member length: " + userTokens.length);
			}
		}
		
		
		scanner.close();
	}
  
  //simplified login method
  public boolean login(long id, String password) {
    Optional<User> user = Optional.fromNullable(userIndex.get(id));
    if (user.isPresent() && user.get().lastName.equals(password)) {
      currentUser = user;
      return true;
    }
    return false;
  }
  
//simplified and generalized version of my logout method
 public void logout() {
   Optional<User> user = currentUser;
   if (user.isPresent()) {
     currentUser = Optional.absent();
   }
 }
}