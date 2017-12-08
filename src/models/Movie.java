package models;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;
import static com.google.common.base.MoreObjects.toStringHelper;

public class Movie {
	static Long counter = 0l;

	public Long id;

	public String title;
	public String year;
	public String URL;

	public List<Movie> route = new ArrayList<>();

	public Movie(String title, String year, String URL) {
		this.id = counter++;
		this.title = title;
		this.year = year;
		this.URL = URL;
	}

	@Override
	public String toString() {
		return toStringHelper(this).addValue(id).addValue(title).addValue(year).addValue(URL).addValue(route)
				.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id, this.title, this.year, this.URL);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Movie) {
			final Movie other = (Movie) obj;
			return Objects.equal(title, other.title) && Objects.equal(year, other.year) && Objects.equal(URL, other.URL)
					&& Objects.equal(route, other.route);
		} else {
			return false;
		}
	}

	// getters + setters for Movie
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getYear () {
		return year;
	}
	public void setYear (String year) {
		this.year = year;
	}
	
	public String getURL() {
		return URL;
	}
	public void setURL(String URL) {
		this.URL = URL;
	}
}