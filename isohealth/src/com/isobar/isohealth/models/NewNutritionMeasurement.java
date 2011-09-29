package com.isobar.isohealth.models;

public class NewNutritionMeasurement {
	private String timestamp; // The time at which the measurement was taken (e.g., "Sat, 1 Jan 2011 00:00:00")
	
	// One of the following values: calories, carbohydrates (grams), fat (grams), fiber (grams), protein (grams), sodium (milligrams), water (fluid ounces)
	private Double calories; // The value of the measured quantity
	private Double carbohydrates; // The value of the measured quantity in grams
	private Double fat; // The value of the measured quantity in grams
	private Double fiber; // The value of the measured quantity in grams
	private Double protein; // The value of the measured quantity in grams
	private Double sodium; // The value of the measured quantity in milligrams
	private Double water; // The value of the measured quantity in fluid ounces
	
	private Boolean post_to_twitter; // Whether to post this measurement to Twitter (optional; if omitted, the user's default setting will be used)
	private Boolean post_to_facebook; // Whether to post this measurement to Facebook (optional; if omitted, the user's default setting will be used)
	
	
	public NewNutritionMeasurement() {
		super();
	}
	public NewNutritionMeasurement(String timestamp, Double calories,
			Double carbohydrates, Double fat, Double fiber, Double protein,
			Double sodium, Double water, Boolean post_to_twitter,
			Boolean post_to_facebook) {
		super();
		this.timestamp = timestamp;
		this.calories = calories;
		this.carbohydrates = carbohydrates;
		this.fat = fat;
		this.fiber = fiber;
		this.protein = protein;
		this.sodium = sodium;
		this.water = water;
		this.post_to_twitter = post_to_twitter;
		this.post_to_facebook = post_to_facebook;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Double getCalories() {
		return calories;
	}
	public void setCalories(Double calories) {
		this.calories = calories;
	}
	public Double getCarbohydrates() {
		return carbohydrates;
	}
	public void setCarbohydrates(Double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	public Double getFat() {
		return fat;
	}
	public void setFat(Double fat) {
		this.fat = fat;
	}
	public Double getFiber() {
		return fiber;
	}
	public void setFiber(Double fiber) {
		this.fiber = fiber;
	}
	public Double getProtein() {
		return protein;
	}
	public void setProtein(Double protein) {
		this.protein = protein;
	}
	public Double getSodium() {
		return sodium;
	}
	public void setSodium(Double sodium) {
		this.sodium = sodium;
	}
	public Double getWater() {
		return water;
	}
	public void setWater(Double water) {
		this.water = water;
	}
	public Boolean getPost_to_twitter() {
		return post_to_twitter;
	}
	public void setPost_to_twitter(Boolean post_to_twitter) {
		this.post_to_twitter = post_to_twitter;
	}
	public Boolean getPost_to_facebook() {
		return post_to_facebook;
	}
	public void setPost_to_facebook(Boolean post_to_facebook) {
		this.post_to_facebook = post_to_facebook;
	}
	@Override
	public String toString() {
		return "NewNutritionMeasurement [timestamp=" + timestamp
				+ ", calories=" + calories + ", carbohydrates=" + carbohydrates
				+ ", fat=" + fat + ", fiber=" + fiber + ", protein=" + protein
				+ ", sodium=" + sodium + ", water=" + water
				+ ", post_to_twitter=" + post_to_twitter
				+ ", post_to_facebook=" + post_to_facebook + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((calories == null) ? 0 : calories.hashCode());
		result = prime * result
				+ ((carbohydrates == null) ? 0 : carbohydrates.hashCode());
		result = prime * result + ((fat == null) ? 0 : fat.hashCode());
		result = prime * result + ((fiber == null) ? 0 : fiber.hashCode());
		result = prime
				* result
				+ ((post_to_facebook == null) ? 0 : post_to_facebook.hashCode());
		result = prime * result
				+ ((post_to_twitter == null) ? 0 : post_to_twitter.hashCode());
		result = prime * result + ((protein == null) ? 0 : protein.hashCode());
		result = prime * result + ((sodium == null) ? 0 : sodium.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((water == null) ? 0 : water.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewNutritionMeasurement other = (NewNutritionMeasurement) obj;
		if (calories == null) {
			if (other.calories != null)
				return false;
		} else if (!calories.equals(other.calories))
			return false;
		if (carbohydrates == null) {
			if (other.carbohydrates != null)
				return false;
		} else if (!carbohydrates.equals(other.carbohydrates))
			return false;
		if (fat == null) {
			if (other.fat != null)
				return false;
		} else if (!fat.equals(other.fat))
			return false;
		if (fiber == null) {
			if (other.fiber != null)
				return false;
		} else if (!fiber.equals(other.fiber))
			return false;
		if (post_to_facebook == null) {
			if (other.post_to_facebook != null)
				return false;
		} else if (!post_to_facebook.equals(other.post_to_facebook))
			return false;
		if (post_to_twitter == null) {
			if (other.post_to_twitter != null)
				return false;
		} else if (!post_to_twitter.equals(other.post_to_twitter))
			return false;
		if (protein == null) {
			if (other.protein != null)
				return false;
		} else if (!protein.equals(other.protein))
			return false;
		if (sodium == null) {
			if (other.sodium != null)
				return false;
		} else if (!sodium.equals(other.sodium))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (water == null) {
			if (other.water != null)
				return false;
		} else if (!water.equals(other.water))
			return false;
		return true;
	}
}
