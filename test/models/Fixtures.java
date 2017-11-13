package models;

public class Fixtures
{
  public static User[] users =
  {
    new User ("Bob", "Bobby",52,"clerk",  "male"),
    new User ("Beth", "Smith",34, "maid", "femail"),
    new User ("Ross", "Kurt",21, " cleaner", "male"),
    
  };


  public static Activity[] activities =
	  {
	    new Activity ("walk",  "fridge", 0.001),
	    new Activity ("walk",  "bar",    1.0),
	    new Activity ("run",   "work",   2.2),
	    new Activity ("walk",  "shop",   2.5),
	    new Activity ("cycle", "school", 4.5)
	  };

	  public static Location[]locations =
	  {
	    new Location(23.3f, 33.3f),
	    new Location(34.4f, 45.2f),  
	    new Location(25.3f, 34.3f),
	    new Location(44.4f, 23.3f)       
	  };
	}



}