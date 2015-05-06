package com.example.junior.volleyapp.model;

public class Movie {
	private String title; //, thumbnailUrl;
	private String year;
	private String rating;
	private String genre;
	private String tag;

	public Movie() {
	}

	public Movie(String name, String year, String rating,
			String genre, String tag) {
		// setado entre name e year /, String thumbnailUrl/
		this.title = name;
		//this.thumbnailUrl = thumbnailUrl;
		this.year = year;
		this.rating = rating;
		this.genre = genre;
		this.setTag(tag);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	//public String getThumbnailUrl() {
	//	return thumbnailUrl;
	//}

	//public void setThumbnailUrl(String thumbnailUrl) {
	//	this.thumbnailUrl = thumbnailUrl;
	//}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
