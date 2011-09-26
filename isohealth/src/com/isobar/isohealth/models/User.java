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

	@Override
	public String toString() {
		return "User [_userID=" + _userID + ", _profile=" + _profile
				+ ", _settings=" + _settings + ", _fitness_activities="
				+ _fitness_activities + ", _strength_training_activities="
				+ _strength_training_activities + ", _background_activities="
				+ _background_activities + ", _sleep=" + _sleep
				+ ", _nutrition=" + _nutrition + ", _weight=" + _weight
				+ ", _general_measurements=" + _general_measurements
				+ ", _diabetes=" + _diabetes + ", _records=" + _records
				+ ", _team=" + _team + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((_background_activities == null) ? 0
						: _background_activities.hashCode());
		result = prime * result
				+ ((_diabetes == null) ? 0 : _diabetes.hashCode());
		result = prime
				* result
				+ ((_fitness_activities == null) ? 0 : _fitness_activities
						.hashCode());
		result = prime
				* result
				+ ((_general_measurements == null) ? 0 : _general_measurements
						.hashCode());
		result = prime * result
				+ ((_nutrition == null) ? 0 : _nutrition.hashCode());
		result = prime * result
				+ ((_profile == null) ? 0 : _profile.hashCode());
		result = prime * result
				+ ((_records == null) ? 0 : _records.hashCode());
		result = prime * result
				+ ((_settings == null) ? 0 : _settings.hashCode());
		result = prime * result + ((_sleep == null) ? 0 : _sleep.hashCode());
		result = prime
				* result
				+ ((_strength_training_activities == null) ? 0
						: _strength_training_activities.hashCode());
		result = prime * result + ((_team == null) ? 0 : _team.hashCode());
		result = prime * result + ((_userID == null) ? 0 : _userID.hashCode());
		result = prime * result + ((_weight == null) ? 0 : _weight.hashCode());
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
		if (_background_activities == null) {
			if (other._background_activities != null)
				return false;
		} else if (!_background_activities.equals(other._background_activities))
			return false;
		if (_diabetes == null) {
			if (other._diabetes != null)
				return false;
		} else if (!_diabetes.equals(other._diabetes))
			return false;
		if (_fitness_activities == null) {
			if (other._fitness_activities != null)
				return false;
		} else if (!_fitness_activities.equals(other._fitness_activities))
			return false;
		if (_general_measurements == null) {
			if (other._general_measurements != null)
				return false;
		} else if (!_general_measurements.equals(other._general_measurements))
			return false;
		if (_nutrition == null) {
			if (other._nutrition != null)
				return false;
		} else if (!_nutrition.equals(other._nutrition))
			return false;
		if (_profile == null) {
			if (other._profile != null)
				return false;
		} else if (!_profile.equals(other._profile))
			return false;
		if (_records == null) {
			if (other._records != null)
				return false;
		} else if (!_records.equals(other._records))
			return false;
		if (_settings == null) {
			if (other._settings != null)
				return false;
		} else if (!_settings.equals(other._settings))
			return false;
		if (_sleep == null) {
			if (other._sleep != null)
				return false;
		} else if (!_sleep.equals(other._sleep))
			return false;
		if (_strength_training_activities == null) {
			if (other._strength_training_activities != null)
				return false;
		} else if (!_strength_training_activities
				.equals(other._strength_training_activities))
			return false;
		if (_team == null) {
			if (other._team != null)
				return false;
		} else if (!_team.equals(other._team))
			return false;
		if (_userID == null) {
			if (other._userID != null)
				return false;
		} else if (!_userID.equals(other._userID))
			return false;
		if (_weight == null) {
			if (other._weight != null)
				return false;
		} else if (!_weight.equals(other._weight))
			return false;
		return true;
	}
}
