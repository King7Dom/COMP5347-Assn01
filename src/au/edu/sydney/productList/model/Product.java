package au.edu.sydney.productList.model;

public class Product {
	String name;
	String imageURL;
	float price;
	int year;
	float height;
	float width;
	float depth;
	float averageRating;
	int numberOfRatings;
	int[] ratings;
	
	public Product(String name, String imageURL, float price, float width, float height, float depth) {
		this.name = name;
		this.imageURL = imageURL;
		this.price = price;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.ratings = new int[5];
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getDepth() {
		return depth;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	public float getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
	public int getNumberOfRatings() {
		return numberOfRatings;
	}
	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	public int[] getRatings() {
		return ratings;
	}

	public void setRatings(int[] ratings) {
		this.ratings = ratings;
	}
}
