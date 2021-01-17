package resources;

public enum APIResources {

	GetUpcomingMovies("/v2/movies/upcoming");

	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResources() {
		return resource;
	}
}
