package com.isobar.isohealth.models;

import java.util.Arrays;

public class SleepMeasurement {
	private String uri; // The URI for this measurement	private N
	private Integer userID;// The unique ID for the user	private N
	private String timestamp; // The time at which the measurement was taken (e.g., "Sat, 1 Jan 2011 00:00:00")	N

	//	One of the following values: total_sleep, rem, deep, light, times_woken, awake	
	private Double total_sleep; // The value of the measured quantity (durational measurements are given in minutes)	Y
	private Double rem; // The value of the measured quantity (durational measurements are given in minutes)	Y
	private Double deep; // The value of the measured quantity (durational measurements are given in minutes)	Y
	private Double light; // The value of the measured quantity (durational measurements are given in minutes)	Y
	private Double times_woken; // The value of the measured quantity (durational measurements are given in minutes)	Y
	private Double awake; // The value of the measured quantity (durational measurements are given in minutes)	Y
	
	private String previous; // The URI of the previous sleep measurement in chronological order for the user (omitted for the first sleep measurement)	N
	private String next; // The URI of the next sleep measurement in chronological order for the user (omitted for the most recent sleep measurement)	N
	private String nearest_fitness_activity; // The URI of the fitness activity closest in time to this activity for the user (omitted if no fitness activities have been recorded)	N
	private String[] nearest_teammate_fitness_activities; // The URIs of the fitness activities closest in time to this activity for each street teammate (empty if no fitness activities have been recorded)	N
	private String nearest_background_activity; // The URI of the background activity closest in time to this activity for the user (omitted if no background activities have been recorded)	N
	private String[] nearest_teammate_background_activities; // The URIs of the background activities closest in time to this activity for each street teammate (empty if no background activities have been recorded)	N
	private String[] nearest_teammate_sleep; // The URIs of the sleep measurements closest in time to this activity for each street teammate (empty if no sleep measurements have been taken)	N
	private String nearest_nutrition; // The URI of the nutrition measurement closest in time to this activity for the user (omitted if no nutrition measurements have been token)	N
	private String[] nearest_teammate_nutrition; // The URIs of the nutrition measurement closest in time to this activity for each street teammate (empty if no nutrition measurements have been token)	N
	private String nearest_weight; // The URI of the weight measurement closest in time to this activity for the user (omitted if no weight measurements have been token)	N
	private String[] nearest_teammate_weight; // The URIs of the weight measurements closest in time to this activity for each street teammate (empty if no weight measurements have been token)	N
	private String nearest_general_measurement; // The URI of the general measurement measurement closest in time to this activity for the user (omitted if no general measurements have been token)	N
	private String[] nearest_teammate_general_measurements; // The URIs of the general measurements closest in time to this activity for each street teammate (empty if no general measurements have been token)	N
	private String nearest_diabetes; // The URI of the diabetes measurement closest in time to this activity for the user (omitted if no diabetes measurements have been token)	N
	private String[] nearest_teammate_diabetes; // The URIs of the diabetes measurements closest in time to this activity for each street teammate (empty if no diabetes measurements have been token)	N
	
	public SleepMeasurement(String uri, Integer userID, String timestamp,
			Double total_sleep, Double rem, Double deep, Double light,
			Double times_woken, Double awake, String previous, String next,
			String nearest_fitness_activity,
			String[] nearest_teammate_fitness_activities,
			String nearest_background_activity,
			String[] nearest_teammate_background_activities,
			String[] nearest_teammate_sleep, String nearest_nutrition,
			String[] nearest_teammate_nutrition, String nearest_weight,
			String[] nearest_teammate_weight,
			String nearest_general_measurement,
			String[] nearest_teammate_general_measurements,
			String nearest_diabetes, String[] nearest_teammate_diabetes) {
		super();
		this.uri = uri;
		this.userID = userID;
		this.timestamp = timestamp;
		this.total_sleep = total_sleep;
		this.rem = rem;
		this.deep = deep;
		this.light = light;
		this.times_woken = times_woken;
		this.awake = awake;
		this.previous = previous;
		this.next = next;
		this.nearest_fitness_activity = nearest_fitness_activity;
		this.nearest_teammate_fitness_activities = nearest_teammate_fitness_activities;
		this.nearest_background_activity = nearest_background_activity;
		this.nearest_teammate_background_activities = nearest_teammate_background_activities;
		this.nearest_teammate_sleep = nearest_teammate_sleep;
		this.nearest_nutrition = nearest_nutrition;
		this.nearest_teammate_nutrition = nearest_teammate_nutrition;
		this.nearest_weight = nearest_weight;
		this.nearest_teammate_weight = nearest_teammate_weight;
		this.nearest_general_measurement = nearest_general_measurement;
		this.nearest_teammate_general_measurements = nearest_teammate_general_measurements;
		this.nearest_diabetes = nearest_diabetes;
		this.nearest_teammate_diabetes = nearest_teammate_diabetes;
	}
	public SleepMeasurement() {
		super();
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
	public Double getTotal_sleep() {
		return total_sleep;
	}
	public void setTotal_sleep(Double total_sleep) {
		this.total_sleep = total_sleep;
	}
	public Double getRem() {
		return rem;
	}
	public void setRem(Double rem) {
		this.rem = rem;
	}
	public Double getDeep() {
		return deep;
	}
	public void setDeep(Double deep) {
		this.deep = deep;
	}
	public Double getLight() {
		return light;
	}
	public void setLight(Double light) {
		this.light = light;
	}
	public Double getTimes_woken() {
		return times_woken;
	}
	public void setTimes_woken(Double times_woken) {
		this.times_woken = times_woken;
	}
	public Double getAwake() {
		return awake;
	}
	public void setAwake(Double awake) {
		this.awake = awake;
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
	@Override
	public String toString() {
		return "SleepMeasurement [uri=" + uri + ", userID=" + userID
				+ ", timestamp=" + timestamp + ", total_sleep=" + total_sleep
				+ ", rem=" + rem + ", deep=" + deep + ", light=" + light
				+ ", times_woken=" + times_woken + ", awake=" + awake
				+ ", previous=" + previous + ", next=" + next
				+ ", nearest_fitness_activity=" + nearest_fitness_activity
				+ ", nearest_teammate_fitness_activities="
				+ Arrays.toString(nearest_teammate_fitness_activities)
				+ ", nearest_background_activity="
				+ nearest_background_activity
				+ ", nearest_teammate_background_activities="
				+ Arrays.toString(nearest_teammate_background_activities)
				+ ", nearest_teammate_sleep="
				+ Arrays.toString(nearest_teammate_sleep)
				+ ", nearest_nutrition=" + nearest_nutrition
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
		result = prime * result + ((awake == null) ? 0 : awake.hashCode());
		result = prime * result + ((deep == null) ? 0 : deep.hashCode());
		result = prime * result + ((light == null) ? 0 : light.hashCode());
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
				+ Arrays.hashCode(nearest_teammate_background_activities);
		result = prime * result + Arrays.hashCode(nearest_teammate_diabetes);
		result = prime * result
				+ Arrays.hashCode(nearest_teammate_fitness_activities);
		result = prime * result
				+ Arrays.hashCode(nearest_teammate_general_measurements);
		result = prime * result + Arrays.hashCode(nearest_teammate_nutrition);
		result = prime * result + Arrays.hashCode(nearest_teammate_sleep);
		result = prime * result + Arrays.hashCode(nearest_teammate_weight);
		result = prime * result
				+ ((nearest_weight == null) ? 0 : nearest_weight.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
		result = prime * result + ((rem == null) ? 0 : rem.hashCode());
		result = prime * result
				+ ((times_woken == null) ? 0 : times_woken.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result
				+ ((total_sleep == null) ? 0 : total_sleep.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		SleepMeasurement other = (SleepMeasurement) obj;
		if (awake == null) {
			if (other.awake != null)
				return false;
		} else if (!awake.equals(other.awake))
			return false;
		if (deep == null) {
			if (other.deep != null)
				return false;
		} else if (!deep.equals(other.deep))
			return false;
		if (light == null) {
			if (other.light != null)
				return false;
		} else if (!light.equals(other.light))
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
		if (rem == null) {
			if (other.rem != null)
				return false;
		} else if (!rem.equals(other.rem))
			return false;
		if (times_woken == null) {
			if (other.times_woken != null)
				return false;
		} else if (!times_woken.equals(other.times_woken))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (total_sleep == null) {
			if (other.total_sleep != null)
				return false;
		} else if (!total_sleep.equals(other.total_sleep))
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
		return true;
	}
}
