package com.isobar.isohealth.models;

public class Settings {
	private Boolean _facebook_connected; //true if the user has connected to his/her Facebook account, false otherwise
	private Boolean _twitter_connected; //true if the user has connected to his/her Twitter account, false otherwise
	private Boolean _foursquare_connected; //true if the user has connected to his/her Foursquare account, false otherwise
	private String _share_fitness_activities; //The visibility of the user's fitness activities to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private String _share_map; //The visibility of the user's activity routes to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean _post_fitness_activity_facebook; //true if fitness activities are automatically posted to Facebook, false otherwise
	private Boolean _post_fitness_activity_twitter; //if fitness activities are automatically posted to Twitter, false otherwise
	private Boolean _post_live_fitness_activity_facebook; //true if live activities are automatically posted to Facebook, false otherwise
	private Boolean _post_live_fitness_activity_twitter; //true if live activities are automatically posted to Twitter, false otherwise
	private String _share_background_activities; //The visibility of the user's background activities to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean _post_background_activity_facebook; //true if background activities are automatically posted to Facebook, false otherwise
	private Boolean _post_background_activity_twitter; //true if fitness activities are automatically posted to Twitter, false otherwise
	private String _share_sleep; //The visibility of the user's sleep measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean _post_sleep_facebook; //true if sleep measurements are automatically posted to Facebook, false otherwise
	private Boolean _post_sleep_twitter; //true if sleep measurements are automatically posted to Twitter, false otherwise
	private String _share_nutrition; //The visibility of the user's nutrition measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean _post_nutrition_facebook; //true if nutrition measurements are automatically posted to Facebook, false otherwise
	private Boolean _post_nutrition_twitter; //true if nutrition measurements are automatically posted to Twitter, false otherwise
	private String _share_weight; //The visibility of the user's weight measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean _post_weight_facebook; //true if weight measurements are automatically posted to Facebook, false otherwise
	private Boolean _post_weight_twitter; //true if weight measurements are automatically posted to Twitter, false otherwise
	private String _share_general_measurements; //The visibility of the user's general measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean _post_general_measurements_facebook; //true if general measurements are automatically posted to Facebook, false otherwise
	private Boolean _post_general_measurements_twitter; //true if general measurements are automatically posted to Twitter, false otherwise
	private String _share_diabetes; //The visibility of the user's diabetes measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean _post_diabetes_facebook; //true if diabetes measurements are automatically posted to Facebook, false otherwise
	private Boolean _post_diabetes_twitter; //true if diabetes measurements are automatically posted to Twitter, false otherwise
	private String _distance_units; //The units of distance used on the RunKeeper website, as one of the following values: "mi", "km"
	private String _weight_units; //The units of weight used on the RunKeeper website, as one of the following values: "lbs", "kg"
	private String _first_day_of_week; //The first day of the calendar week used on the RunKeeper website, as one of the following values: "Sunday", "Monday"
	
	public Settings() {
		
	}

	public Boolean getFacebook_connected() {
		return _facebook_connected;
	}

	public void setFacebook_connected(Boolean facebook_connected) {
		this._facebook_connected = facebook_connected;
	}

	public Boolean getTwitter_connected() {
		return _twitter_connected;
	}

	public void setTwitter_connected(Boolean twitter_connected) {
		this._twitter_connected = twitter_connected;
	}

	public Boolean getFoursquare_connected() {
		return _foursquare_connected;
	}

	public void setFoursquare_connected(Boolean foursquare_connected) {
		this._foursquare_connected = foursquare_connected;
	}

	public String getShare_fitness_activities() {
		return _share_fitness_activities;
	}

	public void setShare_fitness_activities(String share_fitness_activities) {
		this._share_fitness_activities = share_fitness_activities;
	}

	public String getShare_map() {
		return _share_map;
	}

	public void setShare_map(String share_map) {
		this._share_map = share_map;
	}

	public Boolean getPost_fitness_activity_facebook() {
		return _post_fitness_activity_facebook;
	}

	public void setPost_fitness_activity_facebook(
			Boolean post_fitness_activity_facebook) {
		this._post_fitness_activity_facebook = post_fitness_activity_facebook;
	}

	public Boolean getPost_fitness_activity_twitter() {
		return _post_fitness_activity_twitter;
	}

	public void setPost_fitness_activity_twitter(
			Boolean post_fitness_activity_twitter) {
		this._post_fitness_activity_twitter = post_fitness_activity_twitter;
	}

	public Boolean getPost_live_fitness_activity_facebook() {
		return _post_live_fitness_activity_facebook;
	}

	public void setPost_live_fitness_activity_facebook(
			Boolean post_live_fitness_activity_facebook) {
		this._post_live_fitness_activity_facebook = post_live_fitness_activity_facebook;
	}

	public Boolean getPost_live_fitness_activity_twitter() {
		return _post_live_fitness_activity_twitter;
	}

	public void setPost_live_fitness_activity_twitter(
			Boolean post_live_fitness_activity_twitter) {
		this._post_live_fitness_activity_twitter = post_live_fitness_activity_twitter;
	}

	public String getShare_background_activities() {
		return _share_background_activities;
	}

	public void setShare_background_activities(String share_background_activities) {
		this._share_background_activities = share_background_activities;
	}

	public Boolean getPost_background_activity_facebook() {
		return _post_background_activity_facebook;
	}

	public void setPost_background_activity_facebook(
			Boolean post_background_activity_facebook) {
		this._post_background_activity_facebook = post_background_activity_facebook;
	}

	public Boolean getPost_background_activity_twitter() {
		return _post_background_activity_twitter;
	}

	public void setPost_background_activity_twitter(
			Boolean post_background_activity_twitter) {
		this._post_background_activity_twitter = post_background_activity_twitter;
	}

	public String getShare_sleep() {
		return _share_sleep;
	}

	public void setShare_sleep(String share_sleep) {
		this._share_sleep = share_sleep;
	}

	public Boolean getPost_sleep_facebook() {
		return _post_sleep_facebook;
	}

	public void setPost_sleep_facebook(Boolean post_sleep_facebook) {
		this._post_sleep_facebook = post_sleep_facebook;
	}

	public Boolean getPost_sleep_twitter() {
		return _post_sleep_twitter;
	}

	public void setPost_sleep_twitter(Boolean post_sleep_twitter) {
		this._post_sleep_twitter = post_sleep_twitter;
	}

	public String getShare_nutrition() {
		return _share_nutrition;
	}

	public void setShare_nutrition(String share_nutrition) {
		this._share_nutrition = share_nutrition;
	}

	public Boolean getPost_nutrition_facebook() {
		return _post_nutrition_facebook;
	}

	public void setPost_nutrition_facebook(Boolean post_nutrition_facebook) {
		this._post_nutrition_facebook = post_nutrition_facebook;
	}

	public Boolean getPost_nutrition_twitter() {
		return _post_nutrition_twitter;
	}

	public void setPost_nutrition_twitter(Boolean post_nutrition_twitter) {
		this._post_nutrition_twitter = post_nutrition_twitter;
	}

	public String getShare_weight() {
		return _share_weight;
	}

	public void setShare_weight(String share_weight) {
		this._share_weight = share_weight;
	}

	public Boolean getPost_weight_facebook() {
		return _post_weight_facebook;
	}

	public void setPost_weight_facebook(Boolean post_weight_facebook) {
		this._post_weight_facebook = post_weight_facebook;
	}

	public Boolean getPost_weight_twitter() {
		return _post_weight_twitter;
	}

	public void setPost_weight_twitter(Boolean post_weight_twitter) {
		this._post_weight_twitter = post_weight_twitter;
	}

	public String getShare_general_measurements() {
		return _share_general_measurements;
	}

	public void setShare_general_measurements(String share_general_measurements) {
		this._share_general_measurements = share_general_measurements;
	}

	public Boolean getPost_general_measurements_facebook() {
		return _post_general_measurements_facebook;
	}

	public void setPost_general_measurements_facebook(
			Boolean post_general_measurements_facebook) {
		this._post_general_measurements_facebook = post_general_measurements_facebook;
	}

	public Boolean getPost_general_measurements_twitter() {
		return _post_general_measurements_twitter;
	}

	public void setPost_general_measurements_twitter(
			Boolean post_general_measurements_twitter) {
		this._post_general_measurements_twitter = post_general_measurements_twitter;
	}

	public String getShare_diabetes() {
		return _share_diabetes;
	}

	public void setShare_diabetes(String share_diabetes) {
		this._share_diabetes = share_diabetes;
	}

	public Boolean getPost_diabetes_facebook() {
		return _post_diabetes_facebook;
	}

	public void setPost_diabetes_facebook(Boolean post_diabetes_facebook) {
		this._post_diabetes_facebook = post_diabetes_facebook;
	}

	public Boolean getPost_diabetes_twitter() {
		return _post_diabetes_twitter;
	}

	public void setPost_diabetes_twitter(Boolean post_diabetes_twitter) {
		this._post_diabetes_twitter = post_diabetes_twitter;
	}

	public String getDistance_units() {
		return _distance_units;
	}

	public void setDistance_units(String distance_units) {
		this._distance_units = distance_units;
	}

	public String getWeight_units() {
		return _weight_units;
	}

	public void setWeight_units(String weight_units) {
		this._weight_units = weight_units;
	}

	public String getFirst_day_of_week() {
		return _first_day_of_week;
	}

	public void setFirst_day_of_week(String first_day_of_week) {
		this._first_day_of_week = first_day_of_week;
	}

	@Override
	public String toString() {
		return "Settings [_facebook_connected=" + _facebook_connected
				+ ", _twitter_connected=" + _twitter_connected
				+ ", _foursquare_connected=" + _foursquare_connected
				+ ", _share_fitness_activities=" + _share_fitness_activities
				+ ", _share_map=" + _share_map
				+ ", _post_fitness_activity_facebook="
				+ _post_fitness_activity_facebook
				+ ", _post_fitness_activity_twitter="
				+ _post_fitness_activity_twitter
				+ ", _post_live_fitness_activity_facebook="
				+ _post_live_fitness_activity_facebook
				+ ", _post_live_fitness_activity_twitter="
				+ _post_live_fitness_activity_twitter
				+ ", _share_background_activities="
				+ _share_background_activities
				+ ", _post_background_activity_facebook="
				+ _post_background_activity_facebook
				+ ", _post_background_activity_twitter="
				+ _post_background_activity_twitter + ", _share_sleep="
				+ _share_sleep + ", _post_sleep_facebook="
				+ _post_sleep_facebook + ", _post_sleep_twitter="
				+ _post_sleep_twitter + ", _share_nutrition="
				+ _share_nutrition + ", _post_nutrition_facebook="
				+ _post_nutrition_facebook + ", _post_nutrition_twitter="
				+ _post_nutrition_twitter + ", _share_weight=" + _share_weight
				+ ", _post_weight_facebook=" + _post_weight_facebook
				+ ", _post_weight_twitter=" + _post_weight_twitter
				+ ", _share_general_measurements="
				+ _share_general_measurements
				+ ", _post_general_measurements_facebook="
				+ _post_general_measurements_facebook
				+ ", _post_general_measurements_twitter="
				+ _post_general_measurements_twitter + ", _share_diabetes="
				+ _share_diabetes + ", _post_diabetes_facebook="
				+ _post_diabetes_facebook + ", _post_diabetes_twitter="
				+ _post_diabetes_twitter + ", _distance_units="
				+ _distance_units + ", _weight_units=" + _weight_units
				+ ", _first_day_of_week=" + _first_day_of_week + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_distance_units == null) ? 0 : _distance_units.hashCode());
		result = prime
				* result
				+ ((_facebook_connected == null) ? 0 : _facebook_connected
						.hashCode());
		result = prime
				* result
				+ ((_first_day_of_week == null) ? 0 : _first_day_of_week
						.hashCode());
		result = prime
				* result
				+ ((_foursquare_connected == null) ? 0 : _foursquare_connected
						.hashCode());
		result = prime
				* result
				+ ((_post_background_activity_facebook == null) ? 0
						: _post_background_activity_facebook.hashCode());
		result = prime
				* result
				+ ((_post_background_activity_twitter == null) ? 0
						: _post_background_activity_twitter.hashCode());
		result = prime
				* result
				+ ((_post_diabetes_facebook == null) ? 0
						: _post_diabetes_facebook.hashCode());
		result = prime
				* result
				+ ((_post_diabetes_twitter == null) ? 0
						: _post_diabetes_twitter.hashCode());
		result = prime
				* result
				+ ((_post_fitness_activity_facebook == null) ? 0
						: _post_fitness_activity_facebook.hashCode());
		result = prime
				* result
				+ ((_post_fitness_activity_twitter == null) ? 0
						: _post_fitness_activity_twitter.hashCode());
		result = prime
				* result
				+ ((_post_general_measurements_facebook == null) ? 0
						: _post_general_measurements_facebook.hashCode());
		result = prime
				* result
				+ ((_post_general_measurements_twitter == null) ? 0
						: _post_general_measurements_twitter.hashCode());
		result = prime
				* result
				+ ((_post_live_fitness_activity_facebook == null) ? 0
						: _post_live_fitness_activity_facebook.hashCode());
		result = prime
				* result
				+ ((_post_live_fitness_activity_twitter == null) ? 0
						: _post_live_fitness_activity_twitter.hashCode());
		result = prime
				* result
				+ ((_post_nutrition_facebook == null) ? 0
						: _post_nutrition_facebook.hashCode());
		result = prime
				* result
				+ ((_post_nutrition_twitter == null) ? 0
						: _post_nutrition_twitter.hashCode());
		result = prime
				* result
				+ ((_post_sleep_facebook == null) ? 0 : _post_sleep_facebook
						.hashCode());
		result = prime
				* result
				+ ((_post_sleep_twitter == null) ? 0 : _post_sleep_twitter
						.hashCode());
		result = prime
				* result
				+ ((_post_weight_facebook == null) ? 0 : _post_weight_facebook
						.hashCode());
		result = prime
				* result
				+ ((_post_weight_twitter == null) ? 0 : _post_weight_twitter
						.hashCode());
		result = prime
				* result
				+ ((_share_background_activities == null) ? 0
						: _share_background_activities.hashCode());
		result = prime * result
				+ ((_share_diabetes == null) ? 0 : _share_diabetes.hashCode());
		result = prime
				* result
				+ ((_share_fitness_activities == null) ? 0
						: _share_fitness_activities.hashCode());
		result = prime
				* result
				+ ((_share_general_measurements == null) ? 0
						: _share_general_measurements.hashCode());
		result = prime * result
				+ ((_share_map == null) ? 0 : _share_map.hashCode());
		result = prime
				* result
				+ ((_share_nutrition == null) ? 0 : _share_nutrition.hashCode());
		result = prime * result
				+ ((_share_sleep == null) ? 0 : _share_sleep.hashCode());
		result = prime * result
				+ ((_share_weight == null) ? 0 : _share_weight.hashCode());
		result = prime
				* result
				+ ((_twitter_connected == null) ? 0 : _twitter_connected
						.hashCode());
		result = prime * result
				+ ((_weight_units == null) ? 0 : _weight_units.hashCode());
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
		Settings other = (Settings) obj;
		if (_distance_units == null) {
			if (other._distance_units != null)
				return false;
		} else if (!_distance_units.equals(other._distance_units))
			return false;
		if (_facebook_connected == null) {
			if (other._facebook_connected != null)
				return false;
		} else if (!_facebook_connected.equals(other._facebook_connected))
			return false;
		if (_first_day_of_week == null) {
			if (other._first_day_of_week != null)
				return false;
		} else if (!_first_day_of_week.equals(other._first_day_of_week))
			return false;
		if (_foursquare_connected == null) {
			if (other._foursquare_connected != null)
				return false;
		} else if (!_foursquare_connected.equals(other._foursquare_connected))
			return false;
		if (_post_background_activity_facebook == null) {
			if (other._post_background_activity_facebook != null)
				return false;
		} else if (!_post_background_activity_facebook
				.equals(other._post_background_activity_facebook))
			return false;
		if (_post_background_activity_twitter == null) {
			if (other._post_background_activity_twitter != null)
				return false;
		} else if (!_post_background_activity_twitter
				.equals(other._post_background_activity_twitter))
			return false;
		if (_post_diabetes_facebook == null) {
			if (other._post_diabetes_facebook != null)
				return false;
		} else if (!_post_diabetes_facebook
				.equals(other._post_diabetes_facebook))
			return false;
		if (_post_diabetes_twitter == null) {
			if (other._post_diabetes_twitter != null)
				return false;
		} else if (!_post_diabetes_twitter.equals(other._post_diabetes_twitter))
			return false;
		if (_post_fitness_activity_facebook == null) {
			if (other._post_fitness_activity_facebook != null)
				return false;
		} else if (!_post_fitness_activity_facebook
				.equals(other._post_fitness_activity_facebook))
			return false;
		if (_post_fitness_activity_twitter == null) {
			if (other._post_fitness_activity_twitter != null)
				return false;
		} else if (!_post_fitness_activity_twitter
				.equals(other._post_fitness_activity_twitter))
			return false;
		if (_post_general_measurements_facebook == null) {
			if (other._post_general_measurements_facebook != null)
				return false;
		} else if (!_post_general_measurements_facebook
				.equals(other._post_general_measurements_facebook))
			return false;
		if (_post_general_measurements_twitter == null) {
			if (other._post_general_measurements_twitter != null)
				return false;
		} else if (!_post_general_measurements_twitter
				.equals(other._post_general_measurements_twitter))
			return false;
		if (_post_live_fitness_activity_facebook == null) {
			if (other._post_live_fitness_activity_facebook != null)
				return false;
		} else if (!_post_live_fitness_activity_facebook
				.equals(other._post_live_fitness_activity_facebook))
			return false;
		if (_post_live_fitness_activity_twitter == null) {
			if (other._post_live_fitness_activity_twitter != null)
				return false;
		} else if (!_post_live_fitness_activity_twitter
				.equals(other._post_live_fitness_activity_twitter))
			return false;
		if (_post_nutrition_facebook == null) {
			if (other._post_nutrition_facebook != null)
				return false;
		} else if (!_post_nutrition_facebook
				.equals(other._post_nutrition_facebook))
			return false;
		if (_post_nutrition_twitter == null) {
			if (other._post_nutrition_twitter != null)
				return false;
		} else if (!_post_nutrition_twitter
				.equals(other._post_nutrition_twitter))
			return false;
		if (_post_sleep_facebook == null) {
			if (other._post_sleep_facebook != null)
				return false;
		} else if (!_post_sleep_facebook.equals(other._post_sleep_facebook))
			return false;
		if (_post_sleep_twitter == null) {
			if (other._post_sleep_twitter != null)
				return false;
		} else if (!_post_sleep_twitter.equals(other._post_sleep_twitter))
			return false;
		if (_post_weight_facebook == null) {
			if (other._post_weight_facebook != null)
				return false;
		} else if (!_post_weight_facebook.equals(other._post_weight_facebook))
			return false;
		if (_post_weight_twitter == null) {
			if (other._post_weight_twitter != null)
				return false;
		} else if (!_post_weight_twitter.equals(other._post_weight_twitter))
			return false;
		if (_share_background_activities == null) {
			if (other._share_background_activities != null)
				return false;
		} else if (!_share_background_activities
				.equals(other._share_background_activities))
			return false;
		if (_share_diabetes == null) {
			if (other._share_diabetes != null)
				return false;
		} else if (!_share_diabetes.equals(other._share_diabetes))
			return false;
		if (_share_fitness_activities == null) {
			if (other._share_fitness_activities != null)
				return false;
		} else if (!_share_fitness_activities
				.equals(other._share_fitness_activities))
			return false;
		if (_share_general_measurements == null) {
			if (other._share_general_measurements != null)
				return false;
		} else if (!_share_general_measurements
				.equals(other._share_general_measurements))
			return false;
		if (_share_map == null) {
			if (other._share_map != null)
				return false;
		} else if (!_share_map.equals(other._share_map))
			return false;
		if (_share_nutrition == null) {
			if (other._share_nutrition != null)
				return false;
		} else if (!_share_nutrition.equals(other._share_nutrition))
			return false;
		if (_share_sleep == null) {
			if (other._share_sleep != null)
				return false;
		} else if (!_share_sleep.equals(other._share_sleep))
			return false;
		if (_share_weight == null) {
			if (other._share_weight != null)
				return false;
		} else if (!_share_weight.equals(other._share_weight))
			return false;
		if (_twitter_connected == null) {
			if (other._twitter_connected != null)
				return false;
		} else if (!_twitter_connected.equals(other._twitter_connected))
			return false;
		if (_weight_units == null) {
			if (other._weight_units != null)
				return false;
		} else if (!_weight_units.equals(other._weight_units))
			return false;
		return true;
	}
}
