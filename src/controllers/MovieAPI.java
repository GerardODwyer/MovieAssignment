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
  
  Optional<User> currentUser;

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

  public User createUser(String firstName, String lastName, int age, String occupation, String gender) 
  {
    User user = new User (firstName, lastName,age,occupation, gender);
    userIndex.put(user.id, user);
    firstNameIndex.put(firstName, user);
    return user;
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

  public void createMovie(Long id, String title, String year, String URL)
  {
    Movie movie = new Movie(title, year, URL);
    Optional<User> user = Optional.fromNullable(userIndex.get(id));
    if (user.isPresent())
    {
      user.get().movietitle.put(movie.id, movie);
      movieIndex.put(movie.id, movie);
    }
  }

  public Movie getMovie(Long id)
  {
    return movieIndex.get(id);
  }

  public void addRateing (Long id, Long userid, Long movieid, int rateing)
  {
    Optional<Movie> activity = Optional.fromNullable(movieIndex.get(id));
    if (activity.isPresent())
    {
      //activity.get().route.add(new Rateings(userid, movieid, rateing));
    }
  }
  
 
  
  @SuppressWarnings("unchecked")
  public void load() throws Exception
  {
    serializer.read();
    userIndex       = (Map<Long, User>)     serializer.pop();
    firstNameIndex      = (Map<String, User>)   serializer.pop();
    movieIndex = (Map<Long, Movie>) serializer.pop();
    
    
  }

  void store() throws Exception
  {
    serializer.push(userIndex);
    serializer.push(firstNameIndex);
    serializer.push(movieIndex);
    serializer.write(); 
  }
  
  public void addMovies(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
		movieIndex.put(movie.id, movie);
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
				addMovies(userTokens[1], userTokens[2], (userTokens[3]));
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
      FileLogger.getLogger().log(currentUser.get().firstName + " logged in...");
      return true;
    }
    return false;
  }
  
//simplified and generalized version of my logout method
 public void logout() {
   Optional<User> user = currentUser;
   if (user.isPresent()) {
     FileLogger.getLogger().log(currentUser.get().firstName + " logged out...");
     currentUser = Optional.absent();
   }
 }
}