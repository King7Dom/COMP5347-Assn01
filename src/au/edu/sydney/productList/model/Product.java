package au.edu.sydney.productList.model;

public class Product {
	String name;
	String imageURL;
	float price;
	float averageRating;
	int numberOfRatings;
	
	public Product(String name, String imageURL, float price, float rating, int numberOfRatings) {
		this.name = name;
		this.imageURL = imageURL;
		this.price = price;
		this.averageRating = rating;
		this.numberOfRatings = numberOfRatings;
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
}
