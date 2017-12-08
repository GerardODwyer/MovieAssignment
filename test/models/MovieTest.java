package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {
	  Movie test = new Movie ("thor",  "2017", "https://en.wikipedia.org/wiki/Thor_(film)");

	  @Test
	  public void testCreate()
	  {
	    assertEquals ("thor",          test.title);
	    assertEquals ("2017",        test.year);
	    assertEquals ("https://en.wikipedia.org/wiki/Thor_(film)",   test.URL);    
	  }

	  @Test
	  public void testToString()
	  {
	    assertEquals ("Movie{" + test.id + ", thor, 2017, https://en.wikipedia.org/wiki/Thor_(film), []}", test.toString());
	  }
	}