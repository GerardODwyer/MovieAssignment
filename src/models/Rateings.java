package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

import utils.ToJsonString;
//call variables
public class Rateings
{
  static Long   counter = 0l;

  public Long  id;
  public int rateing;
  public Long userid;
  public Long movieid;
  
  public Rateings (Long userid, Long movieid, int rateing)
  {
    this.id        = counter++;
    this.userid  = userid;
    this.movieid = movieid;
    this.rateing = rateing;
  }

	@Override
	public String toString() {
		return toStringHelper(this).addValue(id)
				.addValue(id)
				.addValue(userid)
				.addValue(rateing +"\n").toString() ;
	}


  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.id, this.userid, this.movieid, this.rateing);  
  } 
}