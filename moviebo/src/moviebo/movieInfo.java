package moviebo;

public class movieInfo {

	private String director;
	private String movie;
	private String actor;
	private String category;
	private String year;
	
	public movieInfo(String director,String movie,String actor,String category, String year) {
		
		this.director=director;
		this.movie=movie;
		this.actor=actor;
		this.category=category;
		this.year=year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
