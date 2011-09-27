package com.isobar.isohealth.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class Settings {
	private Boolean facebook_connected; //true if the user has connected to his/her Facebook account, false otherwise
	private Boolean twitter_connected; //true if the user has connected to his/her Twitter account, false otherwise
	private Boolean foursquare_connected; //true if the user has connected to his/her Foursquare account, false otherwise
	private String share_fitness_activities; //The visibility of the user's fitness activities to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private String share_map; //The visibility of the user's activity routes to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean post_fitness_activity_facebook; //true if fitness activities are automatically posted to Facebook, false otherwise
	private Boolean post_fitness_activity_twitter; //if fitness activities are automatically posted to Twitter, false otherwise
	private Boolean post_live_fitness_activity_facebook; //true if live activities are automatically posted to Facebook, false otherwise
	private Boolean post_live_fitness_activity_twitter; //true if live activities are automatically posted to Twitter, false otherwise
	private String share_background_activities; //The visibility of the user's background activities to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean post_background_activity_facebook; //true if background activities are automatically posted to Facebook, false otherwise
	private Boolean post_background_activity_twitter; //true if fitness activities are automatically posted to Twitter, false otherwise
	private String share_sleep; //The visibility of the user's sleep measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean post_sleep_facebook; //true if sleep measurements are automatically posted to Facebook, false otherwise
	private Boolean post_sleep_twitter; //true if sleep measurements are automatically posted to Twitter, false otherwise
	private String share_nutrition; //The visibility of the user's nutrition measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean post_nutrition_facebook; //true if nutrition measurements are automatically posted to Facebook, false otherwise
	private Boolean post_nutrition_twitter; //true if nutrition measurements are automatically posted to Twitter, false otherwise
	private String share_weight; //The visibility of the user's weight measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean post_weight_facebook; //true if weight measurements are automatically posted to Facebook, false otherwise
	private Boolean post_weight_twitter; //true if weight measurements are automatically posted to Twitter, false otherwise
	private String share_general_measurements; //The visibility of the user's general measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean post_general_measurements_facebook; //true if general measurements are automatically posted to Facebook, false otherwise
	private Boolean post_general_measurements_twitter; //true if general measurements are automatically posted to Twitter, false otherwise
	private String share_diabetes; //The visibility of the user's diabetes measurements to others, as one of the following values: "Just Me", "Street Team", "Everyone"
	private Boolean post_diabetes_facebook; //true if diabetes measurements are automatically posted to Facebook, false otherwise
	private Boolean post_diabetes_twitter; //true if diabetes measurements are automatically posted to Twitter, false otherwise
	private String distance_units; //The units of distance used on the RunKeeper website, as one of the following values: "mi", "km"
	private String weight_units; //The units of weight used on the RunKeeper website, as one of the following values: "lbs", "kg"
	private String first_day_of_week; //The first day of the calendar week used on the RunKeeper website, as one of the following values: "Sunday", "Monday"
	
	public Boolean getFacebook_connected() {
		return facebook_connected;
	}

	public void setFacebook_connected(Boolean facebook_connected) {
		this.facebook_connected = facebook_connected;
	}

	public Boolean getTwitter_connected() {
		return twitter_connected;
	}

	public void setTwitter_connected(Boolean twitter_connected) {
		this.twitter_connected = twitter_connected;
	}

	public Boolean getFoursquare_connected() {
		return foursquare_connected;
	}

	public void setFoursquare_connected(Boolean foursquare_connected) {
		this.foursquare_connected = foursquare_connected;
	}

	public String getShare_fitness_activities() {
		return share_fitness_activities;
	}

	public void setShare_fitness_activities(String share_fitness_activities) {
		this.share_fitness_activities = share_fitness_activities;
	}

	public String getShare_map() {
		return share_map;
	}

	public void setShare_map(String share_map) {
		this.share_map = share_map;
	}

	public Boolean getPost_fitness_activity_facebook() {
		return post_fitness_activity_facebook;
	}

	public void setPost_fitness_activity_facebook(
			Boolean post_fitness_activity_facebook) {
		this.post_fitness_activity_facebook = post_fitness_activity_facebook;
	}

	public Boolean getPost_fitness_activity_twitter() {
		return post_fitness_activity_twitter;
	}

	public void setPost_fitness_activity_twitter(
			Boolean post_fitness_activity_twitter) {
		this.post_fitness_activity_twitter = post_fitness_activity_twitter;
	}

	public Boolean getPost_live_fitness_activity_facebook() {
		return post_live_fitness_activity_facebook;
	}

	public void setPost_live_fitness_activity_facebook(
			Boolean post_live_fitness_activity_facebook) {
		this.post_live_fitness_activity_facebook = post_live_fitness_activity_facebook;
	}

	public Boolean getPost_live_fitness_activity_twitter() {
		return post_live_fitness_activity_twitter;
	}

	public void setPost_live_fitness_activity_twitter(
			Boolean post_live_fitness_activity_twitter) {
		this.post_live_fitness_activity_twitter = post_live_fitness_activity_twitter;
	}

	public String getShare_background_activities() {
		return share_background_activities;
	}

	public void setShare_background_activities(String share_background_activities) {
		this.share_background_activities = share_background_activities;
	}

	public Boolean getPost_background_activity_facebook() {
		return post_background_activity_facebook;
	}

	public void setPost_background_activity_facebook(
			Boolean post_background_activity_facebook) {
		this.post_background_activity_facebook = post_background_activity_facebook;
	}

	public Boolean getPost_background_activity_twitter() {
		return post_background_activity_twitter;
	}

	public void setPost_background_activity_twitter(
			Boolean post_background_activity_twitter) {
		this.post_background_activity_twitter = post_background_activity_twitter;
	}

	public String getShare_sleep() {
		return share_sleep;
	}

	public void setShare_sleep(String share_sleep) {
		this.share_sleep = share_sleep;
	}

	public Boolean getPost_sleep_facebook() {
		return post_sleep_facebook;
	}

	public void setPost_sleep_facebook(Boolean post_sleep_facebook) {
		this.post_sleep_facebook = post_sleep_facebook;
	}

	public Boolean getPost_sleep_twitter() {
		return post_sleep_twitter;
	}

	public void setPost_sleep_twitter(Boolean post_sleep_twitter) {
		this.post_sleep_twitter = post_sleep_twitter;
	}

	public String getShare_nutrition() {
		return share_nutrition;
	}

	public void setShare_nutrition(String share_nutrition) {
		this.share_nutrition = share_nutrition;
	}

	public Boolean getPost_nutrition_facebook() {
		return post_nutrition_facebook;
	}

	public void setPost_nutrition_facebook(Boolean post_nutrition_facebook) {
		this.post_nutrition_facebook = post_nutrition_facebook;
	}

	public Boolean getPost_nutrition_twitter() {
		return post_nutrition_twitter;
	}

	public void setPost_nutrition_twitter(Boolean post_nutrition_twitter) {
		this.post_nutrition_twitter = post_nutrition_twitter;
	}

	public String getShare_weight() {
		return share_weight;
	}

	public void setShare_weight(String share_weight) {
		this.share_weight = share_weight;
	}

	public Boolean getPost_weight_facebook() {
		return post_weight_facebook;
	}

	public void setPost_weight_facebook(Boolean post_weight_facebook) {
		this.post_weight_facebook = post_weight_facebook;
	}

	public Boolean getPost_weight_twitter() {
		return post_weight_twitter;
	}

	public void setPost_weight_twitter(Boolean post_weight_twitter) {
		this.post_weight_twitter = post_weight_twitter;
	}

	public String getShare_general_measurements() {
		return share_general_measurements;
	}

	public void setShare_general_measurements(String share_general_measurements) {
		this.share_general_measurements = share_general_measurements;
	}

	public Boolean getPost_general_measurements_facebook() {
		return post_general_measurements_facebook;
	}

	public void setPost_general_measurements_facebook(
			Boolean post_general_measurements_facebook) {
		this.post_general_measurements_facebook = post_general_measurements_facebook;
	}

	public Boolean getPost_general_measurements_twitter() {
		return post_general_measurements_twitter;
	}

	public void setPost_general_measurements_twitter(
			Boolean post_general_measurements_twitter) {
		this.post_general_measurements_twitter = post_general_measurements_twitter;
	}

	public String getShare_diabetes() {
		return share_diabetes;
	}

	public void setShare_diabetes(String share_diabetes) {
		this.share_diabetes = share_diabetes;
	}

	public Boolean getPost_diabetes_facebook() {
		return post_diabetes_facebook;
	}

	public void setPost_diabetes_facebook(Boolean post_diabetes_facebook) {
		this.post_diabetes_facebook = post_diabetes_facebook;
	}

	public Boolean getPost_diabetes_twitter() {
		return post_diabetes_twitter;
	}

	public void setPost_diabetes_twitter(Boolean post_diabetes_twitter) {
		this.post_diabetes_twitter = post_diabetes_twitter;
	}

	public String getDistance_units() {
		return distance_units;
	}

	public void setDistance_units(String distance_units) {
		this.distance_units = distance_units;
	}

	public String getWeight_units() {
		return weight_units;
	}

	public void setWeight_units(String weight_units) {
		this.weight_units = weight_units;
	}

	public String getFirst_day_of_week() {
		return first_day_of_week;
	}

	public void setFirst_day_of_week(String first_day_of_week) {
		this.first_day_of_week = first_day_of_week;
	}

	@Override
	public String toString() {
		return "Settings [_facebook_connected=" + facebook_connected
				+ ", _twitter_connected=" + twitter_connected
				+ ", _foursquare_connected=" + foursquare_connected
				+ ", _share_fitness_activities=" + share_fitness_activities
				+ ", _share_map=" + share_map
				+ ", _post_fitness_activity_facebook="
				+ post_fitness_activity_facebook
				+ ", _post_fitness_activity_twitter="
				+ post_fitness_activity_twitter
				+ ", _post_live_fitness_activity_facebook="
				+ post_live_fitness_activity_facebook
				+ ", _post_live_fitness_activity_twitter="
				+ post_live_fitness_activity_twitter
				+ ", _share_background_activities="
				+ share_background_activities
				+ ", _post_background_activity_facebook="
				+ post_background_activity_facebook
				+ ", _post_background_activity_twitter="
				+ post_background_activity_twitter + ", _share_sleep="
				+ share_sleep + ", _post_sleep_facebook="
				+ post_sleep_facebook + ", _post_sleep_twitter="
				+ post_sleep_twitter + ", _share_nutrition="
				+ share_nutrition + ", _post_nutrition_facebook="
				+ post_nutrition_facebook + ", _post_nutrition_twitter="
				+ post_nutrition_twitter + ", _share_weight=" + share_weight
				+ ", _post_weight_facebook=" + post_weight_facebook
				+ ", _post_weight_twitter=" + post_weight_twitter
				+ ", _share_general_measurements="
				+ share_general_measurements
				+ ", _post_general_measurements_facebook="
				+ post_general_measurements_facebook
				+ ", _post_general_measurements_twitter="
				+ post_general_measurements_twitter + ", _share_diabetes="
				+ share_diabetes + ", _post_diabetes_facebook="
				+ post_diabetes_facebook + ", _post_diabetes_twitter="
				+ post_diabetes_twitter + ", _distance_units="
				+ distance_units + ", _weight_units=" + weight_units
				+ ", _first_day_of_week=" + first_day_of_week + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distance_units == null) ? 0 : distance_units.hashCode());
		result = prime
				* result
				+ ((facebook_connected == null) ? 0 : facebook_connected
						.hashCode());
		result = prime
				* result
				+ ((first_day_of_week == null) ? 0 : first_day_of_week
						.hashCode());
		result = prime
				* result
				+ ((foursquare_connected == null) ? 0 : foursquare_connected
						.hashCode());
		result = prime
				* result
				+ ((post_background_activity_facebook == null) ? 0
						: post_background_activity_facebook.hashCode());
		result = prime
				* result
				+ ((post_background_activity_twitter == null) ? 0
						: post_background_activity_twitter.hashCode());
		result = prime
				* result
				+ ((post_diabetes_facebook == null) ? 0
						: post_diabetes_facebook.hashCode());
		result = prime
				* result
				+ ((post_diabetes_twitter == null) ? 0
						: post_diabetes_twitter.hashCode());
		result = prime
				* result
				+ ((post_fitness_activity_facebook == null) ? 0
						: post_fitness_activity_facebook.hashCode());
		result = prime
				* result
				+ ((post_fitness_activity_twitter == null) ? 0
						: post_fitness_activity_twitter.hashCode());
		result = prime
				* result
				+ ((post_general_measurements_facebook == null) ? 0
						: post_general_measurements_facebook.hashCode());
		result = prime
				* result
				+ ((post_general_measurements_twitter == null) ? 0
						: post_general_measurements_twitter.hashCode());
		result = prime
				* result
				+ ((post_live_fitness_activity_facebook == null) ? 0
						: post_live_fitness_activity_facebook.hashCode());
		result = prime
				* result
				+ ((post_live_fitness_activity_twitter == null) ? 0
						: post_live_fitness_activity_twitter.hashCode());
		result = prime
				* result
				+ ((post_nutrition_facebook == null) ? 0
						: post_nutrition_facebook.hashCode());
		result = prime
				* result
				+ ((post_nutrition_twitter == null) ? 0
						: post_nutrition_twitter.hashCode());
		result = prime
				* result
				+ ((post_sleep_facebook == null) ? 0 : post_sleep_facebook
						.hashCode());
		result = prime
				* result
				+ ((post_sleep_twitter == null) ? 0 : post_sleep_twitter
						.hashCode());
		result = prime
				* result
				+ ((post_weight_facebook == null) ? 0 : post_weight_facebook
						.hashCode());
		result = prime
				* result
				+ ((post_weight_twitter == null) ? 0 : post_weight_twitter
						.hashCode());
		result = prime
				* result
				+ ((share_background_activities == null) ? 0
						: share_background_activities.hashCode());
		result = prime * result
				+ ((share_diabetes == null) ? 0 : share_diabetes.hashCode());
		result = prime
				* result
				+ ((share_fitness_activities == null) ? 0
						: share_fitness_activities.hashCode());
		result = prime
				* result
				+ ((share_general_measurements == null) ? 0
						: share_general_measurements.hashCode());
		result = prime * result
				+ ((share_map == null) ? 0 : share_map.hashCode());
		result = prime
				* result
				+ ((share_nutrition == null) ? 0 : share_nutrition.hashCode());
		result = prime * result
				+ ((share_sleep == null) ? 0 : share_sleep.hashCode());
		result = prime * result
				+ ((share_weight == null) ? 0 : share_weight.hashCode());
		result = prime
				* result
				+ ((twitter_connected == null) ? 0 : twitter_connected
						.hashCode());
		result = prime * result
				+ ((weight_units == null) ? 0 : weight_units.hashCode());
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
		if (distance_units == null) {
			if (other.distance_units != null)
				return false;
		} else if (!distance_units.equals(other.distance_units))
			return false;
		if (facebook_connected == null) {
			if (other.facebook_connected != null)
				return false;
		} else if (!facebook_connected.equals(other.facebook_connected))
			return false;
		if (first_day_of_week == null) {
			if (other.first_day_of_week != null)
				return false;
		} else if (!first_day_of_week.equals(other.first_day_of_week))
			return false;
		if (foursquare_connected == null) {
			if (other.foursquare_connected != null)
				return false;
		} else if (!foursquare_connected.equals(other.foursquare_connected))
			return false;
		if (post_background_activity_facebook == null) {
			if (other.post_background_activity_facebook != null)
				return false;
		} else if (!post_background_activity_facebook
				.equals(other.post_background_activity_facebook))
			return false;
		if (post_background_activity_twitter == null) {
			if (other.post_background_activity_twitter != null)
				return false;
		} else if (!post_background_activity_twitter
				.equals(other.post_background_activity_twitter))
			return false;
		if (post_diabetes_facebook == null) {
			if (other.post_diabetes_facebook != null)
				return false;
		} else if (!post_diabetes_facebook
				.equals(other.post_diabetes_facebook))
			return false;
		if (post_diabetes_twitter == null) {
			if (other.post_diabetes_twitter != null)
				return false;
		} else if (!post_diabetes_twitter.equals(other.post_diabetes_twitter))
			return false;
		if (post_fitness_activity_facebook == null) {
			if (other.post_fitness_activity_facebook != null)
				return false;
		} else if (!post_fitness_activity_facebook
				.equals(other.post_fitness_activity_facebook))
			return false;
		if (post_fitness_activity_twitter == null) {
			if (other.post_fitness_activity_twitter != null)
				return false;
		} else if (!post_fitness_activity_twitter
				.equals(other.post_fitness_activity_twitter))
			return false;
		if (post_general_measurements_facebook == null) {
			if (other.post_general_measurements_facebook != null)
				return false;
		} else if (!post_general_measurements_facebook
				.equals(other.post_general_measurements_facebook))
			return false;
		if (post_general_measurements_twitter == null) {
			if (other.post_general_measurements_twitter != null)
				return false;
		} else if (!post_general_measurements_twitter
				.equals(other.post_general_measurements_twitter))
			return false;
		if (post_live_fitness_activity_facebook == null) {
			if (other.post_live_fitness_activity_facebook != null)
				return false;
		} else if (!post_live_fitness_activity_facebook
				.equals(other.post_live_fitness_activity_facebook))
			return false;
		if (post_live_fitness_activity_twitter == null) {
			if (other.post_live_fitness_activity_twitter != null)
				return false;
		} else if (!post_live_fitness_activity_twitter
				.equals(other.post_live_fitness_activity_twitter))
			return false;
		if (post_nutrition_facebook == null) {
			if (other.post_nutrition_facebook != null)
				return false;
		} else if (!post_nutrition_facebook
				.equals(other.post_nutrition_facebook))
			return false;
		if (post_nutrition_twitter == null) {
			if (other.post_nutrition_twitter != null)
				return false;
		} else if (!post_nutrition_twitter
				.equals(other.post_nutrition_twitter))
			return false;
		if (post_sleep_facebook == null) {
			if (other.post_sleep_facebook != null)
				return false;
		} else if (!post_sleep_facebook.equals(other.post_sleep_facebook))
			return false;
		if (post_sleep_twitter == null) {
			if (other.post_sleep_twitter != null)
				return false;
		} else if (!post_sleep_twitter.equals(other.post_sleep_twitter))
			return false;
		if (post_weight_facebook == null) {
			if (other.post_weight_facebook != null)
				return false;
		} else if (!post_weight_facebook.equals(other.post_weight_facebook))
			return false;
		if (post_weight_twitter == null) {
			if (other.post_weight_twitter != null)
				return false;
		} else if (!post_weight_twitter.equals(other.post_weight_twitter))
			return false;
		if (share_background_activities == null) {
			if (other.share_background_activities != null)
				return false;
		} else if (!share_background_activities
				.equals(other.share_background_activities))
			return false;
		if (share_diabetes == null) {
			if (other.share_diabetes != null)
				return false;
		} else if (!share_diabetes.equals(other.share_diabetes))
			return false;
		if (share_fitness_activities == null) {
			if (other.share_fitness_activities != null)
				return false;
		} else if (!share_fitness_activities
				.equals(other.share_fitness_activities))
			return false;
		if (share_general_measurements == null) {
			if (other.share_general_measurements != null)
				return false;
		} else if (!share_general_measurements
				.equals(other.share_general_measurements))
			return false;
		if (share_map == null) {
			if (other.share_map != null)
				return false;
		} else if (!share_map.equals(other.share_map))
			return false;
		if (share_nutrition == null) {
			if (other.share_nutrition != null)
				return false;
		} else if (!share_nutrition.equals(other.share_nutrition))
			return false;
		if (share_sleep == null) {
			if (other.share_sleep != null)
				return false;
		} else if (!share_sleep.equals(other.share_sleep))
			return false;
		if (share_weight == null) {
			if (other.share_weight != null)
				return false;
		} else if (!share_weight.equals(other.share_weight))
			return false;
		if (twitter_connected == null) {
			if (other.twitter_connected != null)
				return false;
		} else if (!twitter_connected.equals(other.twitter_connected))
			return false;
		if (weight_units == null) {
			if (other.weight_units != null)
				return false;
		} else if (!weight_units.equals(other.weight_units))
			return false;
		return true;
	}
}
