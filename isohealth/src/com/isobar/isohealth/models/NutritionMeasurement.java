package com.isobar.isohealth.models;

import java.util.Arrays;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class NutritionMeasurement {
	private String uri; // The URI for this measurement	N
	private Integer userID; // The unique ID for the user	N
	private String timestamp; // The time at which the measurement was taken (e.g., "Sat, 1 Jan 2011 00:00:00")	N

	//One of the following values: calories, carbohydrates, fat, fiber, protein, sodium, water
	private Double calories; // The value of the measured quantity	Y
	private Double carbohydrates; // The value of the measured quantity	Y
	private Double fat; // The value of the measured quantity	Y
	private Double fiber; // The value of the measured quantity	Y
	private Double protein; // The value of the measured quantity	Y
	private Double sodium; // The value of the measured quantity	Y
	private Double water; // The value of the measured quantity	Y

	private String source;
	private String previous; // The URI of the previous nutrition measurement in chronological order for the user (omitted for the first nutrition measurement)	N
	private String next; // The URI of the next nutrition measurement in chronological order for the user (omitted for the most recent nutrition measurement)	N
	private String nearest_fitness_activity; // The URI of the fitness activity closest in time to this activity for the user (omitted if no fitness activities have been recorded)	N
	private String[] nearest_teammate_fitness_activities; // The URIs of the fitness activities closest in time to this activity for each street teammate (empty if no fitness activities have been recorded)	N
	private String nearest_strength_training_activity; // The URI of the strength training activity closest in time to this activity for the user (omitted if no strength training activities have been recorded)	N
	private String[] nearest_teammate_strength_training_activities; // The URIs of the strength training activities closest in time to this activity for each street teammate (empty if no strength training activities have been recorded)	N
	private String nearest_background_activity; // The URI of the background activity closest in time to this activity for the user (omitted if no background activities have been recorded)	N
	private String[] nearest_teammate_background_activities; // The URIs of the background activities closest in time to this activity for each street teammate (empty if no background activities have been recorded)	N
	private String nearest_sleep; // The URI of the sleep measurements closest in time to this activity for the user (omitted if no sleep measurements have been taken)	N
	private String[] nearest_teammate_sleep; // The URIs of the sleep measurements closest in time to this activity for each street teammate (empty if no sleep measurements have been taken)	N
	private String[] nearest_teammate_nutrition; // The URIs of the nutrition measurement closest in time to this activity for each street teammate (empty if no nutrition measurements have been token)	N
	private String nearest_weight; // The URI of the weight measurement closest in time to this activity for the user (omitted if no weight measurements have been token)	N
	private String[] nearest_teammate_weight; // The URIs of the weight measurements closest in time to this activity for each street teammate (empty if no weight measurements have been token)	N
	private String nearest_general_measurement; // The URI of the general measurement measurement closest in time to this activity for the user (omitted if no general measurements have been token)	N
	private String[] nearest_teammate_general_measurements; // The URIs of the general measurements closest in time to this activity for each street teammate (empty if no general measurements have been token)	N
	private String nearest_diabetes; // The URI of the diabetes measurement closest in time to this activity for the user (omitted if no diabetes measurements have been token)	N
	private String[] nearest_teammate_diabetes; // The URIs of the diabetes measurements closest in time to this activity for each street teammate (empty if no diabetes measurements have been token)	N
	
	public NutritionMeasurement() {
		super();
	}
	
	public NutritionMeasurement(String uri, Integer userID, String timestamp,
			Double calories, Double carbohydrates, Double fat, Double fiber,
			Double protein, Double sodium, Double water, String source, String previous,
			String next, String nearest_fitness_activity,
			String[] nearest_teammate_fitness_activities,
			String nearest_strength_training_activity,
			String[] nearest_teammate_strength_training_activities,
			String nearest_background_activity,
			String[] nearest_teammate_background_activities,
			String nearest_sleep, String[] nearest_teammate_sleep,
			String[] nearest_teammate_nutrition, String nearest_weight,
			String[] nearest_teammate_weight,
			String nearest_general_measurement,
			String[] nearest_teammate_general_measurements,
			String nearest_diabetes, String[] nearest_teammate_diabetes) {
		super();
		this.uri = uri;
		this.userID = userID;
		this.timestamp = timestamp;
		this.calories = calories;
		this.carbohydrates = carbohydrates;
		this.fat = fat;
		this.fiber = fiber;
		this.protein = protein;
		this.sodium = sodium;
		this.water = water;
		this.source = source;
		this.previous = previous;
		this.next = next;
		this.nearest_fitness_activity = nearest_fitness_activity;
		this.nearest_teammate_fitness_activities = nearest_teammate_fitness_activities;
		this.nearest_strength_training_activity = nearest_strength_training_activity;
		this.nearest_teammate_strength_training_activities = nearest_teammate_strength_training_activities;
		this.nearest_background_activity = nearest_background_activity;
		this.nearest_teammate_background_activities = nearest_teammate_background_activities;
		this.nearest_sleep = nearest_sleep;
		this.nearest_teammate_sleep = nearest_teammate_sleep;
		this.nearest_teammate_nutrition = nearest_teammate_nutrition;
		this.nearest_weight = nearest_weight;
		this.nearest_teammate_weight = nearest_teammate_weight;
		this.nearest_general_measurement = nearest_general_measurement;
		this.nearest_teammate_general_measurements = nearest_teammate_general_measurements;
		this.nearest_diabetes = nearest_diabetes;
		this.nearest_teammate_diabetes = nearest_teammate_diabetes;
	}

	@Override
	public String toString() {
		return "NutritionMeasurement [uri="
				+ uri
				+ ", userID="
				+ userID
				+ ", timestamp="
				+ timestamp
				+ ", calories="
				+ calories
				+ ", carbohydrates="
				+ carbohydrates
				+ ", fat="
				+ fat
				+ ", fiber="
				+ fiber
				+ ", protein="
				+ protein
				+ ", sodium="
				+ sodium
				+ ", water="
				+ water
				+ ", source="
				+ source				
				+ ", previous="
				+ previous
				+ ", next="
				+ next
				+ ", nearest_fitness_activity="
				+ nearest_fitness_activity
				+ ", nearest_teammate_fitness_activities="
				+ Arrays.toString(nearest_teammate_fitness_activities)
				+ ", nearest_strength_training_activity="
				+ nearest_strength_training_activity
				+ ", nearest_teammate_strength_training_activities="
				+ Arrays.toString(nearest_teammate_strength_training_activities)
				+ ", nearest_background_activity="
				+ nearest_background_activity
				+ ", nearest_teammate_background_activities="
				+ Arrays.toString(nearest_teammate_background_activities)
				+ ", nearest_sleep=" + nearest_sleep
				+ ", nearest_teammate_sleep="
				+ Arrays.toString(nearest_teammate_sleep)
				+ ", nearest_teammate_nutrition="
				+ Arrays.toString(nearest_teammate_nutrition)
				+ ", nearest_weight=" + nearest_weight
				+ ", nearest_teammate_weight="
				+ Arrays.toString(nearest_teammate_weight)
				+ ", nearest_general_measurement="
				+ nearest_general_measurement
				+ ", nearest_teammate_general_measurements="
				+ Arrays.toString(nearest_teammate_general_measurements)
				+ ", nearest_diabetes=" + nearest_diabetes
				+ ", nearest_teammate_diabetes="
				+ Arrays.toString(nearest_teammate_diabetes) + "]";
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
				+ ((nearest_background_activity == null) ? 0
						: nearest_background_activity.hashCode());
		result = prime
				* result
				+ ((nearest_diabetes == null) ? 0 : nearest_diabetes.hashCode());
		result = prime
				* result
				+ ((nearest_fitness_activity == null) ? 0
						: nearest_fitness_activity.hashCode());
		result = prime
				* result
				+ ((nearest_general_measurement == null) ? 0
						: nearest_general_measurement.hashCode());
		result = prime * result
				+ ((nearest_sleep == null) ? 0 : nearest_sleep.hashCode());
		result = prime
				* result
				+ ((nearest_strength_training_activity == null) ? 0
						: nearest_strength_training_activity.hashCode());
		result = prime * result
				+ Arrays.hashCode(nearest_teammate_background_activities);
		result = prime * result + Arrays.hashCode(nearest_teammate_diabetes);
		result = prime * result
				+ Arrays.hashCode(nearest_teammate_fitness_activities);
		result = prime * result
				+ Arrays.hashCode(nearest_teammate_general_measurements);
		result = prime * result + Arrays.hashCode(nearest_teammate_nutrition);
		result = prime * result + Arrays.hashCode(nearest_teammate_sleep);
		result = prime
				* result
				+ Arrays.hashCode(nearest_teammate_strength_training_activities);
		result = prime * result + Arrays.hashCode(nearest_teammate_weight);
		result = prime * result
				+ ((nearest_weight == null) ? 0 : nearest_weight.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
		result = prime * result + ((protein == null) ? 0 : protein.hashCode());
		result = prime * result + ((sodium == null) ? 0 : sodium.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		NutritionMeasurement other = (NutritionMeasurement) obj;
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
		if (nearest_background_activity == null) {
			if (other.nearest_background_activity != null)
				return false;
		} else if (!nearest_background_activity
				.equals(other.nearest_background_activity))
			return false;
		if (nearest_diabetes == null) {
			if (other.nearest_diabetes != null)
				return false;
		} else if (!nearest_diabetes.equals(other.nearest_diabetes))
			return false;
		if (nearest_fitness_activity == null) {
			if (other.nearest_fitness_activity != null)
				return false;
		} else if (!nearest_fitness_activity
				.equals(other.nearest_fitness_activity))
			return false;
		if (nearest_general_measurement == null) {
			if (other.nearest_general_measurement != null)
				return false;
		} else if (!nearest_general_measurement
				.equals(other.nearest_general_measurement))
			return false;
		if (nearest_sleep == null) {
			if (other.nearest_sleep != null)
				return false;
		} else if (!nearest_sleep.equals(other.nearest_sleep))
			return false;
		if (nearest_strength_training_activity == null) {
			if (other.nearest_strength_training_activity != null)
				return false;
		} else if (!nearest_strength_training_activity
				.equals(other.nearest_strength_training_activity))
			return false;
		if (!Arrays.equals(nearest_teammate_background_activities,
				other.nearest_teammate_background_activities))
			return false;
		if (!Arrays.equals(nearest_teammate_diabetes,
				other.nearest_teammate_diabetes))
			return false;
		if (!Arrays.equals(nearest_teammate_fitness_activities,
				other.nearest_teammate_fitness_activities))
			return false;
		if (!Arrays.equals(nearest_teammate_general_measurements,
				other.nearest_teammate_general_measurements))
			return false;
		if (!Arrays.equals(nearest_teammate_nutrition,
				other.nearest_teammate_nutrition))
			return false;
		if (!Arrays
				.equals(nearest_teammate_sleep, other.nearest_teammate_sleep))
			return false;
		if (!Arrays.equals(nearest_teammate_strength_training_activities,
				other.nearest_teammate_strength_training_activities))
			return false;
		if (!Arrays.equals(nearest_teammate_weight,
				other.nearest_teammate_weight))
			return false;
		if (nearest_weight == null) {
			if (other.nearest_weight != null)
				return false;
		} else if (!nearest_weight.equals(other.nearest_weight))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (previous == null) {
			if (other.previous != null)
				return false;
		} else if (!previous.equals(other.previous))
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
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		if (water == null) {
			if (other.water != null)
				return false;
		} else if (!water.equals(other.water))
			return false;
		return true;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
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
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getNearest_fitness_activity() {
		return nearest_fitness_activity;
	}
	public void setNearest_fitness_activity(String nearest_fitness_activity) {
		this.nearest_fitness_activity = nearest_fitness_activity;
	}
	public String[] getNearest_teammate_fitness_activities() {
		return nearest_teammate_fitness_activities;
	}
	public void setNearest_teammate_fitness_activities(
			String[] nearest_teammate_fitness_activities) {
		this.nearest_teammate_fitness_activities = nearest_teammate_fitness_activities;
	}
	public String getNearest_strength_training_activity() {
		return nearest_strength_training_activity;
	}
	public void setNearest_strength_training_activity(
			String nearest_strength_training_activity) {
		this.nearest_strength_training_activity = nearest_strength_training_activity;
	}
	public String[] getNearest_teammate_strength_training_activities() {
		return nearest_teammate_strength_training_activities;
	}
	public void setNearest_teammate_strength_training_activities(
			String[] nearest_teammate_strength_training_activities) {
		this.nearest_teammate_strength_training_activities = nearest_teammate_strength_training_activities;
	}
	public String getNearest_background_activity() {
		return nearest_background_activity;
	}
	public void setNearest_background_activity(String nearest_background_activity) {
		this.nearest_background_activity = nearest_background_activity;
	}
	public String[] getNearest_teammate_background_activities() {
		return nearest_teammate_background_activities;
	}
	public void setNearest_teammate_background_activities(
			String[] nearest_teammate_background_activities) {
		this.nearest_teammate_background_activities = nearest_teammate_background_activities;
	}
	public String getNearest_sleep() {
		return nearest_sleep;
	}
	public void setNearest_sleep(String nearest_sleep) {
		this.nearest_sleep = nearest_sleep;
	}
	public String[] getNearest_teammate_sleep() {
		return nearest_teammate_sleep;
	}
	public void setNearest_teammate_sleep(String[] nearest_teammate_sleep) {
		this.nearest_teammate_sleep = nearest_teammate_sleep;
	}
	public String[] getNearest_teammate_nutrition() {
		return nearest_teammate_nutrition;
	}
	public void setNearest_teammate_nutrition(String[] nearest_teammate_nutrition) {
		this.nearest_teammate_nutrition = nearest_teammate_nutrition;
	}
	public String getNearest_weight() {
		return nearest_weight;
	}
	public void setNearest_weight(String nearest_weight) {
		this.nearest_weight = nearest_weight;
	}
	public String[] getNearest_teammate_weight() {
		return nearest_teammate_weight;
	}
	public void setNearest_teammate_weight(String[] nearest_teammate_weight) {
		this.nearest_teammate_weight = nearest_teammate_weight;
	}
	public String getNearest_general_measurement() {
		return nearest_general_measurement;
	}
	public void setNearest_general_measurement(String nearest_general_measurement) {
		this.nearest_general_measurement = nearest_general_measurement;
	}
	public String[] getNearest_teammate_general_measurements() {
		return nearest_teammate_general_measurements;
	}
	public void setNearest_teammate_general_measurements(
			String[] nearest_teammate_general_measurements) {
		this.nearest_teammate_general_measurements = nearest_teammate_general_measurements;
	}
	public String getNearest_diabetes() {
		return nearest_diabetes;
	}
	public void setNearest_diabetes(String nearest_diabetes) {
		this.nearest_diabetes = nearest_diabetes;
	}
	public String[] getNearest_teammate_diabetes() {
		return nearest_teammate_diabetes;
	}
	public void setNearest_teammate_diabetes(String[] nearest_teammate_diabetes) {
		this.nearest_teammate_diabetes = nearest_teammate_diabetes;
	}
}
