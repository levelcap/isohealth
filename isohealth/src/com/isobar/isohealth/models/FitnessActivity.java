package com.isobar.isohealth.models;

import java.util.Arrays;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class FitnessActivity {
	public static class Distance {
		private Double timestamp; //The number of seconds since the start of the activity
		private Double distance; //The total distance traveled since the start of the activity, in meters
		public Double getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Double timestamp) {
			this.timestamp = timestamp;
		}
		public Double getDistance() {
			return distance;
		}
		public void setDistance(Double distance) {
			this.distance = distance;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((distance == null) ? 0 : distance.hashCode());
			result = prime * result
					+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
			Distance other = (Distance) obj;
			if (distance == null) {
				if (other.distance != null)
					return false;
			} else if (!distance.equals(other.distance))
				return false;
			if (timestamp == null) {
				if (other.timestamp != null)
					return false;
			} else if (!timestamp.equals(other.timestamp))
				return false;
			return true;
		}
	}
	
	public static class Calories {
		private Double timestamp; //The number of seconds since the start of the activity
		private Double calories; //The total calories burned since the start of the activity
		public Double getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Double timestamp) {
			this.timestamp = timestamp;
		}
		public Double getCalories() {
			return calories;
		}
		public void setCalories(Double calories) {
			this.calories = calories;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((calories == null) ? 0 : calories.hashCode());
			result = prime * result
					+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
			Calories other = (Calories) obj;
			if (calories == null) {
				if (other.calories != null)
					return false;
			} else if (!calories.equals(other.calories))
				return false;
			if (timestamp == null) {
				if (other.timestamp != null)
					return false;
			} else if (!timestamp.equals(other.timestamp))
				return false;
			return true;
		}
	}
	
	public static class Image {
		private Double timestamp; //The number of seconds since the start of the activity
		private Double latitude; //The latitude, in degrees (values increase northward and decrease southward)
		private Double longitude; //The longitude, in degrees (values increase eastward and decrease westward)
		private String uri; //The URI of the image
		private String thumbnail_uri; //The URI of the thumbnail version of the image		
		public Double getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Double timestamp) {
			this.timestamp = timestamp;
		}
		public Double getLatitude() {
			return latitude;
		}
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}
		public Double getLongitude() {
			return longitude;
		}
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		public String getThumbnail_uri() {
			return thumbnail_uri;
		}
		public void setThumbnail_uri(String thumbnail_uri) {
			this.thumbnail_uri = thumbnail_uri;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((latitude == null) ? 0 : latitude.hashCode());
			result = prime * result
					+ ((longitude == null) ? 0 : longitude.hashCode());
			result = prime * result
					+ ((thumbnail_uri == null) ? 0 : thumbnail_uri.hashCode());
			result = prime * result
					+ ((timestamp == null) ? 0 : timestamp.hashCode());
			result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
			Image other = (Image) obj;
			if (latitude == null) {
				if (other.latitude != null)
					return false;
			} else if (!latitude.equals(other.latitude))
				return false;
			if (longitude == null) {
				if (other.longitude != null)
					return false;
			} else if (!longitude.equals(other.longitude))
				return false;
			if (thumbnail_uri == null) {
				if (other.thumbnail_uri != null)
					return false;
			} else if (!thumbnail_uri.equals(other.thumbnail_uri))
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
			return true;
		}
	}
	
	private String uri; //The URI for this activity
	private Integer userID; //The unique ID of the user for the activity
	private String type; //The type of activity, as one of the following values: "Running", "Cycling", "Mountain Biking", "Walking", "Hiking", "Downhill Skiing", "Cross-Country Skiing", "Snowboarding", "Skating", "Swimming", "Wheelchair", "Rowing", "Elliptical", "Other"
	private String equipment; //The equipment used to complete this activity, as one of the following values: None, Treadmill, Stationary Bike, Elliptical, Row Machine. (Optional; if not specified, None is assumed.) 
	private String start_time; //The starting time for the activity (e.g., "Sat, 1 Jan 2011 00:00:00")
	private Double total_distance; //The total distance traveled, in meters
	private Distance[] distance; //The sequence of time-stamped distance measurements (empty if not available)
	private Double duration; //The duration of the activity, in seconds
	private Integer average_heart_rate; //The user's average heart rate, in beats per minute (omitted if not available)
	private HeartRate[] heart_rate; //The sequence of time-stamped heart rate measurements (empty if not available)
	private Double total_calories; //The total calories burned
	private Calories[] calories; //The sequence of time-stamped caloric burn measurements (empty if not available)
	private Double climb; //The total elevation climbed over the course of the activity, in meters
	private String notes; //Any notes that the user has associated with the activity
	private WGS84[] path; //The sequence of geographical points along the route (empty for stationary activities)
	private Image[] images; //The sequence of images along the route (empty if not available)
	private String source; //The name of the application that last modified this activity
	private String activity; //The URL of the user's public, human-readable page for this activity
	private String previous; //The URI of the previous activity in the user's fitness feed (omitted for the oldest activity)
	private String next; //The URI of the next activity in the user's fitness feed (omitted for the most-recent activity)
	private String[] nearest_teammate_fitness_activities; //The URIs of the fitness activities closest in time to this activity for each street teammate (empty if no fitness activities have been recorded)
	private String nearest_strength_training_activity; //The URI of the strength training activity closest in time to this activity for the user (omitted if no strength training activities have been recorded)
	private String[] nearest_teammate_strength_training_activities; //The URIs of the strength training activities closest in time to this activity for each street teammate (empty if no strength training activities have been recorded)
	private String nearest_background_activity; //The URI of the background activity closest in time to this activity for the user (omitted if no background activities have been recorded)
	private String[] nearest_teammate_background_activities; //The URIs of the background activities closest in time to this activity for each street teammate (empty if no background activities have been recorded)
	private String nearest_sleep; //The URI of the sleep measurements closest in time to this activity for the user (omitted if no sleep measurements have been taken)
	private String[] nearest_teammate_sleep; //The URIs of the sleep measurements closest in time to this activity for each street teammate (empty if no sleep measurements have been taken)
	private String nearest_nutrition; //The URI of the nutrition measurement closest in time to this activity for the user (omitted if no nutrition measurements have been token)
	private String[] nearest_teammate_nutrition; //The URIs of the nutrition measurement closest in time to this activity for each street teammate (empty if no nutrition measurements have been token)
	private String  nearest_weight; //The URI of the weight measurement closest in time to this activity for the user (omitted if no weight measurements have been token)
	private String[] nearest_teammate_weight; //The URIs of the weight measurements closest in time to this activity for each street teammate (empty if no weight measurements have been token)
	private String nearest_general_measurement; //The URI of the general measurement measurement closest in time to this activity for the user (omitted if no general measurements have been token)
	private String[] nearest_teammate_general_measurements; //The URIs of the general measurements closest in time to this activity for each street teammate (empty if no general measurements have been token)
	private String nearest_diabetes; //The URI of the diabetes measurement closest in time to this activity for the user (omitted if no diabetes measurements have been token)
	private String[] nearest_teammate_diabetes; //The URIs of the diabetes measurements closest in time to this activity for each street teammate (empty if no diabetes measurements have been token)
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public Double getTotal_distance() {
		return total_distance;
	}
	public void setTotal_distance(Double total_distance) {
		this.total_distance = total_distance;
	}
	public Distance[] getDistance() {
		return distance;
	}
	public void setDistance(Distance[] distance) {
		this.distance = distance;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Integer getAverage_heart_rate() {
		return average_heart_rate;
	}
	public void setAverage_heart_rate(Integer average_heart_rate) {
		this.average_heart_rate = average_heart_rate;
	}
	public HeartRate[] getHeart_rate() {
		return heart_rate;
	}
	public void setHeart_rate(HeartRate[] heart_rate) {
		this.heart_rate = heart_rate;
	}
	public Double getTotal_calories() {
		return total_calories;
	}
	public void setTotal_calories(Double total_calories) {
		this.total_calories = total_calories;
	}
	public Calories[] getCalories() {
		return calories;
	}
	public void setCalories(Calories[] calories) {
		this.calories = calories;
	}
	public Double getClimb() {
		return climb;
	}
	public void setClimb(Double climb) {
		this.climb = climb;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public WGS84[] getPath() {
		return path;
	}
	public void setPath(WGS84[] path) {
		this.path = path;
	}
	public Image[] getImages() {
		return images;
	}
	public void setImages(Image[] images) {
		this.images = images;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
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
		return "FitnessActivity [uri="
				+ uri
				+ ", userID="
				+ userID
				+ ", type="
				+ type
				+ ", equipment="
				+ equipment
				+ ", start_time="
				+ start_time
				+ ", total_distance="
				+ total_distance
				+ ", distance="
				+ Arrays.toString(distance)
				+ ", duration="
				+ duration
				+ ", average_heart_rate="
				+ average_heart_rate
				+ ", heart_rate="
				+ Arrays.toString(heart_rate)
				+ ", total_calories="
				+ total_calories
				+ ", calories="
				+ Arrays.toString(calories)
				+ ", climb="
				+ climb
				+ ", notes="
				+ notes
				+ ", path="
				+ Arrays.toString(path)
				+ ", images="
				+ Arrays.toString(images)
				+ ", activity="
				+ activity
				+ ", source="
				+ source
				+ ", previous="
				+ previous
				+ ", next="
				+ next
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
				+ ((activity == null) ? 0 : activity.hashCode());
		result = prime
				* result
				+ ((average_heart_rate == null) ? 0 : average_heart_rate
						.hashCode());
		result = prime * result + Arrays.hashCode(calories);
		result = prime * result + ((climb == null) ? 0 : climb.hashCode());
		result = prime * result + Arrays.hashCode(distance);
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + Arrays.hashCode(heart_rate);
		result = prime * result + Arrays.hashCode(images);
		result = prime
				* result
				+ ((nearest_background_activity == null) ? 0
						: nearest_background_activity.hashCode());
		result = prime
				* result
				+ ((nearest_diabetes == null) ? 0 : nearest_diabetes.hashCode());
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
		result = prime * result
				+ ((nearest_weight == null) ? 0 : nearest_weight.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + Arrays.hashCode(path);
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
		result = prime * result
				+ ((start_time == null) ? 0 : start_time.hashCode());
		result = prime * result
				+ ((total_calories == null) ? 0 : total_calories.hashCode());
		result = prime * result
				+ ((total_distance == null) ? 0 : total_distance.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		FitnessActivity other = (FitnessActivity) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (average_heart_rate == null) {
			if (other.average_heart_rate != null)
				return false;
		} else if (!average_heart_rate.equals(other.average_heart_rate))
			return false;
		if (!Arrays.equals(calories, other.calories))
			return false;
		if (climb == null) {
			if (other.climb != null)
				return false;
		} else if (!climb.equals(other.climb))
			return false;
		if (!Arrays.equals(distance, other.distance))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (!Arrays.equals(heart_rate, other.heart_rate))
			return false;
		if (!Arrays.equals(images, other.images))
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
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (!Arrays.equals(path, other.path))
			return false;
		if (previous == null) {
			if (other.previous != null)
				return false;
		} else if (!previous.equals(other.previous))
			return false;
		if (start_time == null) {
			if (other.start_time != null)
				return false;
		} else if (!start_time.equals(other.start_time))
			return false;
		if (total_calories == null) {
			if (other.total_calories != null)
				return false;
		} else if (!total_calories.equals(other.total_calories))
			return false;
		if (total_distance == null) {
			if (other.total_distance != null)
				return false;
		} else if (!total_distance.equals(other.total_distance))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
