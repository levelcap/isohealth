package com.isobar.isohealth.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class User {
	private Integer userID; 	//The unique ID for the user 	N
	private String profile; // The URI of the user profile resource 	N
	private String settings; //The URI of the sharing and display settings resource 	N
	private String fitness_activities; //The URI of the first page of the fitness activity feed 	N
	private String strength_training_activities;  //The URI of the first page of the strength training activity feed 	N
	private String background_activities; //The URI of the first page of the background activity feed 	N
	private String sleep; //The URI of the first page of the sleep feed 	N
	private String nutrition; //The URI of the first page of the nutrition feed 	N
	private String weight; //The URI of the first page of the weight measurement feed 	N
	private String general_measurements; //The URI of the first page of the general measurements feed 	N
	private String diabetes; //The URI of the first page of the diabetes measurements feed 	N
	private String records; //The URI of the personal records resource 	N
	private String team; //The URI of the street team resource	
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProfile() {
		return profile;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}

	public String getSettings() {
		return settings;
	}

	public void setFitness_activities(String fitness_activities) {
		this.fitness_activities = fitness_activities;
	}

	public String getFitness_activities() {
		return fitness_activities;
	}

	public void setStrength_training_activities(
			String strength_training_activities) {
		this.strength_training_activities = strength_training_activities;
	}

	public String getStrength_training_activities() {
		return strength_training_activities;
	}

	public void setBackground_activities(String background_activities) {
		this.background_activities = background_activities;
	}

	public String getBackground_activities() {
		return background_activities;
	}

	public void setSleep(String sleep) {
		this.sleep = sleep;
	}

	public String getSleep() {
		return sleep;
	}

	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}

	public String getNutrition() {
		return nutrition;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeight() {
		return weight;
	}

	public void setGeneral_measurements(String general_measurements) {
		this.general_measurements = general_measurements;
	}

	public String getGeneral_measurements() {
		return general_measurements;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public String getRecords() {
		return records;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String toString() {
		return "User [_userID=" + userID + ", _profile=" + profile
				+ ", _settings=" + settings + ", _fitness_activities="
				+ fitness_activities + ", _strength_training_activities="
				+ strength_training_activities + ", _background_activities="
				+ background_activities + ", _sleep=" + sleep
				+ ", _nutrition=" + nutrition + ", _weight=" + weight
				+ ", _general_measurements=" + general_measurements
				+ ", _diabetes=" + diabetes + ", _records=" + records
				+ ", _team=" + team + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((background_activities == null) ? 0
						: background_activities.hashCode());
		result = prime * result
				+ ((diabetes == null) ? 0 : diabetes.hashCode());
		result = prime
				* result
				+ ((fitness_activities == null) ? 0 : fitness_activities
						.hashCode());
		result = prime
				* result
				+ ((general_measurements == null) ? 0 : general_measurements
						.hashCode());
		result = prime * result
				+ ((nutrition == null) ? 0 : nutrition.hashCode());
		result = prime * result
				+ ((profile == null) ? 0 : profile.hashCode());
		result = prime * result
				+ ((records == null) ? 0 : records.hashCode());
		result = prime * result
				+ ((settings == null) ? 0 : settings.hashCode());
		result = prime * result + ((sleep == null) ? 0 : sleep.hashCode());
		result = prime
				* result
				+ ((strength_training_activities == null) ? 0
						: strength_training_activities.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
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
		User other = (User) obj;
		if (background_activities == null) {
			if (other.background_activities != null)
				return false;
		} else if (!background_activities.equals(other.background_activities))
			return false;
		if (diabetes == null) {
			if (other.diabetes != null)
				return false;
		} else if (!diabetes.equals(other.diabetes))
			return false;
		if (fitness_activities == null) {
			if (other.fitness_activities != null)
				return false;
		} else if (!fitness_activities.equals(other.fitness_activities))
			return false;
		if (general_measurements == null) {
			if (other.general_measurements != null)
				return false;
		} else if (!general_measurements.equals(other.general_measurements))
			return false;
		if (nutrition == null) {
			if (other.nutrition != null)
				return false;
		} else if (!nutrition.equals(other.nutrition))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (records == null) {
			if (other.records != null)
				return false;
		} else if (!records.equals(other.records))
			return false;
		if (settings == null) {
			if (other.settings != null)
				return false;
		} else if (!settings.equals(other.settings))
			return false;
		if (sleep == null) {
			if (other.sleep != null)
				return false;
		} else if (!sleep.equals(other.sleep))
			return false;
		if (strength_training_activities == null) {
			if (other.strength_training_activities != null)
				return false;
		} else if (!strength_training_activities
				.equals(other.strength_training_activities))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
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
