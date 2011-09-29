package com.isobar.isohealth.models;

import java.util.Arrays;

public class WeightMeasurement {
	private String uri; // The URI for this measurement	N
	private Integer userID; // The unique ID for the user	N
	private String timestamp; // The time at which the measurement was taken (e.g., "Sat, 1 Jan 2011 00:00:00")	N
	
	//One of the following values: weight, free_mass, mass_weight, fat_percent, bmi
	private Double weight; // The value of the measured quantity (mass/weight is measured in kilograms)	Y
	private Double free_mass; // The value of the measured quantity (mass/weight is measured in kilograms)	Y
	private Double mass_weight; // The value of the measured quantity (mass/weight is measured in kilograms)	Y
	private Double fat_percent; // The value of the measured quantity (mass/weight is measured in kilograms)	Y
	private Double bmi; // The value of the measured quantity (mass/weight is measured in kilograms)	Y
	
	private String previous; // The URI of the previous weight measurement in chronological order for the user (omitted for the first weight measurement)	N
	private String next; // The URI of the next weight measurement in chronological order for the user (omitted for the most recent weight measurement)	N
	private String nearest_fitness_activity; // The URI of the fitness activity closest in time to this activity for the user (omitted if no fitness activities have been recorded)	N
	private String[] nearest_teammate_fitness_activities; // The URIs of the fitness activities closest in time to this activity for each street teammate (empty if no fitness activities have been recorded)	N
	private String nearest_strength_training_activity; // The URI of the strength training activity closest in time to this activity for the user (omitted if no strength training activities have been recorded)	N
	private String[] nearest_teammate_strength_training_activities; // The URIs of the strength training activities closest in time to this activity for each street teammate (empty if no strength training activities have been recorded)	N
	private String nearest_background_activity; // The URI of the background activity closest in time to this activity for the user (omitted if no background activities have been recorded)	N
	private String[] nearest_teammate_background_activities; // The URIs of the background activities closest in time to this activity for each street teammate (empty if no background activities have been recorded)	N
	private String nearest_sleep; // The URI of the sleep measurements closest in time to this activity for the user (omitted if no sleep measurements have been taken)	N
	private String[] nearest_teammate_sleep; // The URIs of the sleep measurements closest in time to this activity for each street teammate (empty if no sleep measurements have been taken)	N
	private String nearest_nutrition; // The URI of the nutrition measurement closest in time to this activity for the user (omitted if no nutrition measurements have been token)	N
	private String[] nearest_teammate_nutrition; // The URIs of the nutrition measurement closest in time to this activity for each street teammate (empty if no nutrition measurements have been token)	N
	private String[] nearest_teammate_weight; // The URIs of the weight measurements closest in time to this activity for each street teammate (empty if no weight measurements have been token)	N
	private String nearest_general_measurement; // The URI of the general measurement measurement closest in time to this activity for the user (omitted if no general measurements have been token)	N
	private String[] nearest_teammate_general_measurements; // The URIs of the general measurements closest in time to this activity for each street teammate (empty if no general measurements have been token)	N
	private String nearest_diabetes; // The URI of the diabetes measurement closest in time to this activity for the user (omitted if no diabetes measurements have been token)	N
	private String[] nearest_teammate_diabetes; // The URIs of the diabetes measurements closest in time to this activity for each street teammate (empty if no diabetes measurements have been token)	N
	
	public WeightMeasurement() {
		super();
	}
	public WeightMeasurement(String uri, Integer userID, String timestamp,
			Double weight, Double free_mass, Double mass_weight,
			Double fat_percent, Double bmi, String previous, String next,
			String nearest_fitness_activity,
			String[] nearest_teammate_fitness_activities,
			String nearest_strength_training_activity,
			String[] nearest_teammate_strength_training_activities,
			String nearest_background_activity,
			String[] nearest_teammate_background_activities,
			String nearest_sleep, String[] nearest_teammate_sleep,
			String nearest_nutrition, String[] nearest_teammate_nutrition,
			String[] nearest_teammate_weight,
			String nearest_general_measurement,
			String[] nearest_teammate_general_measurements,
			String nearest_diabetes, String[] nearest_teammate_diabetes) {
		super();
		this.uri = uri;
		this.userID = userID;
		this.timestamp = timestamp;
		this.weight = weight;
		this.free_mass = free_mass;
		this.mass_weight = mass_weight;
		this.fat_percent = fat_percent;
		this.bmi = bmi;
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
		this.nearest_nutrition = nearest_nutrition;
		this.nearest_teammate_nutrition = nearest_teammate_nutrition;
		this.nearest_teammate_weight = nearest_teammate_weight;
		this.nearest_general_measurement = nearest_general_measurement;
		this.nearest_teammate_general_measurements = nearest_teammate_general_measurements;
		this.nearest_diabetes = nearest_diabetes;
		this.nearest_teammate_diabetes = nearest_teammate_diabetes;
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
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getFree_mass() {
		return free_mass;
	}
	public void setFree_mass(Double free_mass) {
		this.free_mass = free_mass;
	}
	public Double getMass_weight() {
		return mass_weight;
	}
	public void setMass_weight(Double mass_weight) {
		this.mass_weight = mass_weight;
	}
	public Double getFat_percent() {
		return fat_percent;
	}
	public void setFat_percent(Double fat_percent) {
		this.fat_percent = fat_percent;
	}
	public Double getBmi() {
		return bmi;
	}
	public void setBmi(Double bmi) {
		this.bmi = bmi;
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
	public String getNearest_nutrition() {
		return nearest_nutrition;
	}
	public void setNearest_nutrition(String nearest_nutrition) {
		this.nearest_nutrition = nearest_nutrition;
	}
	public String[] getNearest_teammate_nutrition() {
		return nearest_teammate_nutrition;
	}
	public void setNearest_teammate_nutrition(String[] nearest_teammate_nutrition) {
		this.nearest_teammate_nutrition = nearest_teammate_nutrition;
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
	@Override
	public String toString() {
		return "WeightMeasurement [uri="
				+ uri
				+ ", userID="
				+ userID
				+ ", timestamp="
				+ timestamp
				+ ", weight="
				+ weight
				+ ", free_mass="
				+ free_mass
				+ ", mass_weight="
				+ mass_weight
				+ ", fat_percent="
				+ fat_percent
				+ ", bmi="
				+ bmi
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
				+ ", nearest_nutrition=" + nearest_nutrition
				+ ", nearest_teammate_nutrition="
				+ Arrays.toString(nearest_teammate_nutrition)
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
		result = prime * result + ((bmi == null) ? 0 : bmi.hashCode());
		result = prime * result
				+ ((fat_percent == null) ? 0 : fat_percent.hashCode());
		result = prime * result
				+ ((free_mass == null) ? 0 : free_mass.hashCode());
		result = prime * result
				+ ((mass_weight == null) ? 0 : mass_weight.hashCode());
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
		result = prime
				* result
				+ ((nearest_nutrition == null) ? 0 : nearest_nutrition
						.hashCode());
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
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		WeightMeasurement other = (WeightMeasurement) obj;
		if (bmi == null) {
			if (other.bmi != null)
				return false;
		} else if (!bmi.equals(other.bmi))
			return false;
		if (fat_percent == null) {
			if (other.fat_percent != null)
				return false;
		} else if (!fat_percent.equals(other.fat_percent))
			return false;
		if (free_mass == null) {
			if (other.free_mass != null)
				return false;
		} else if (!free_mass.equals(other.free_mass))
			return false;
		if (mass_weight == null) {
			if (other.mass_weight != null)
				return false;
		} else if (!mass_weight.equals(other.mass_weight))
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
		if (nearest_nutrition == null) {
			if (other.nearest_nutrition != null)
				return false;
		} else if (!nearest_nutrition.equals(other.nearest_nutrition))
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
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}
