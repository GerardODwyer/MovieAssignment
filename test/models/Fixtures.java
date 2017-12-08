package models;

public class Fixtures
{
  public static User[] users =
  {
    new User ("Bob", "Bobby", 52,"clerk",  "male"),
    new User ("Beth", "Smith", 34, "maid", "female"),
    new User ("Ross", "Kurt", 21, " cleaner", "male"),
    
  };


  public static Movie[] movies =
	  {
			new Movie("John Wick", "2014", "http://www.imdb.com/title/tt2911666/"),
			new Movie("Twilight", "2008", "Twilight.com"), 
			new Movie("Shrek", "2001", "Shrek.org"),
			new Movie("Robocop", "1992", "Robocop.net")
	  };


	public static Rateings[] rateing =
		{ 
			new Rateings(1L, 2L, 3),
			new Rateings(2L, 3L, 4), 
			new Rateings(3L, 4L, 5),
			new Rateings(4L, 5L, 6)
	  };
	}
