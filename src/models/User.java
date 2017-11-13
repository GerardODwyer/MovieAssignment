package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class User 
{
	  public Long id;
	public static long counter =(long)01;
  public String firstName;
  public String lastName;
  public String age;
  public String occupation;
  public String gender;

  
  public Map<Long, Movie> movietitle = new HashMap<>();

  public User(String firstName, String lastName, String age, String occupation, String gender)
  {
	  this.id =counter++;;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.occupation = occupation;
    this.gender = gender;
    
  }
  @Override
  public String toString()
  {

    return toStringHelper(this).addValue(id)
    	                       .addValue(firstName)
                               .addValue(lastName)
                               .addValue(age)
                               .addValue(occupation) 
                               .addValue(gender) 
                               .toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.lastName, this.firstName, this.age, this.occupation, this.gender);  
  }
  
  
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof User)
    {
      final User other = (User) obj;
      return Objects.equal(firstName, other.firstName) 
          && Objects.equal(lastName,  other.lastName)
          && Objects.equal(age,     other.age)
          && Objects.equal(occupation,  other.occupation)
          &&  Objects.equal(gender,  other.gender);
     }
    else
    {
      return false;
    }
  }
}