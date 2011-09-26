package com.isobar.isohealth.models;

public class User {
	
	private Integer _userID; 	//The unique ID for the user 	N
	private String _profile; // The URI of the user profile resource 	N
	private String _settings; //The URI of the sharing and display settings resource 	N
	private String _fitness_activities; //The URI of the first page of the fitness activity feed 	N
	private String _strength_training_activities;  //The URI of the first page of the strength training activity feed 	N
	private String _background_activities; //The URI of the first page of the background activity feed 	N
	private String _sleep; //The URI of the first page of the sleep feed 	N
	private String _nutrition; //The URI of the first page of the nutrition feed 	N
	private String _weight; //The URI of the first page of the weight measurement feed 	N
	private String _general_measurements; //The URI of the first page of the general measurements feed 	N
	private String _diabetes; //The URI of the first page of the diabetes measurements feed 	N
	private String _records; //The URI of the personal records resource 	N
	private String _team; //The URI of the street team resource	
	
	public User() {
		
	}

	public void setUserID(Integer userID) {
		this._userID = userID;
	}

	public Integer getUserID() {
		return _userID;
	}

	public void setProfile(String profile) {
		this._profile = profile;
	}

	public String getProfile() {
		return _profile;
	}

	public void setSettings(String settings) {
		this._settings = settings;
	}

	public String getSettings() {
		return _settings;
	}

	public void setFitness_activities(String fitness_activities) {
		this._fitness_activities = fitness_activities;
	}

	public String getFitness_activities() {
		return _fitness_activities;
	}

	public void setStrength_training_activities(
			String strength_training_activities) {
		this._strength_training_activities = strength_training_activities;
	}

	public String getStrength_training_activities() {
		return _strength_training_activities;
	}

	public void setBackground_activities(String background_activities) {
		this._background_activities = background_activities;
	}

	public String getBackground_activities() {
		return _background_activities;
	}

	public void setSleep(String sleep) {
		this._sleep = sleep;
	}

	public String getSleep() {
		return _sleep;
	}

	public void setNutrition(String nutrition) {
		this._nutrition = nutrition;
	}

	public String getNutrition() {
		return _nutrition;
	}

	public void setWeight(String weight) {
		this._weight = weight;
	}

	public String getWeight() {
		return _weight;
	}

	public void setGeneral_measurements(String general_measurements) {
		this._general_measurements = general_measurements;
	}

	public String getGeneral_measurements() {
		return _general_measurements;
	}

	public void setDiabetes(String diabetes) {
		this._diabetes = diabetes;
	}

	public String getDiabetes() {
		return _diabetes;
	}

	public void setRecords(String records) {
		this._records = records;
	}

	public String getRecords() {
		return _records;
	}

	public void setTeam(String team) {
		this._team = team;
	}

	public String getTeam() {
		return _team;
	}
}
