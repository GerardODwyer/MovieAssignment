package models;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;



public class UserTest
{
  User bob = new User ("Bob", "Bobby", "52", "clerk", "male");

  @Test
  public void testCreate()
  {
    assertEquals ("Bob",                bob.firstName);
    assertEquals ("Bobby",             bob.lastName);
    assertEquals ("52",                          bob.age);
    assertEquals ("clerk",           bob.occupation);   
    assertEquals ("gender",               bob.gender);   
  }

 
  @Test
  public void testToString()
  {
    assertEquals ("User{" + bob.id + ", Bob, Bobby,52, clerk,male}", bob.toString());
  }
  @Test
  public void testEquals()
  {
    User Bob2 = new User ("Bob", "Bobby","52", "clerk",  "male"); 
    User Beth   = new User ("Beth", "Smith","52", "maid",  "female"); 

    assertEquals(bob, bob);
    assertEquals(bob, Bob2);
    assertNotEquals(bob, Beth);
  } 
}