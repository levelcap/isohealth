package com.isobar.isohealth.models;

import java.util.Arrays;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class NewFitnessActivity {
	private String type; //The type of activity, as one of the following values: "Running", "Cycling", "Mountain Biking", "Walking", "Hiking", "Downhill Skiing", "Cross-Country Skiing", "Snowboarding", "Skating", "Swimming", "Wheelchair", "Rowing", "Elliptical", "Other"
	private String start_time; //The starting time for the activity (e.g., "Sat, 1 Jan 2011 00:00:00")
	private Double total_distance; //The total distance traveled, in meters (optional)
	private Double duration; //The duration of the activity, in seconds
	private Integer average_heart_rate; //The user's average heart rate, in beats per minute (optional)
	private HeartRate[] heart_rate; //The sequence of time-stamped heart rate measurements (optional)
	private Double total_calories; //The total calories burned (optional)
	private String notes; //Any notes that the user has associated with the activity
	private WGS84[] path; //The sequence of geographical points along the route (optional)
	private Boolean post_to_facebook; //True to post this activity to Facebook, false to prevent posting (optional; if not specified, the user's default preference is used)
	private Boolean post_to_twitter; //True to post this activity to Twitter, false to prevent posting (optional; if not specified, the user's default preference is used)
	private Boolean detect_pauses; //True to automatically detect and insert pause points into the supplied path, false otherwise (optional; if not specified, no pause detection is performed)
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Boolean getPost_to_facebook() {
		return post_to_facebook;
	}
	public void setPost_to_facebook(Boolean post_to_facebook) {
		this.post_to_facebook = post_to_facebook;
	}
	public Boolean getPost_to_twitter() {
		return post_to_twitter;
	}
	public void setPost_to_twitter(Boolean post_to_twitter) {
		this.post_to_twitter = post_to_twitter;
	}
//	public Boolean getDetect_pauses() {
//		return detect_pauses;
//	}
//	public void setDetect_pauses(Boolean detect_pauses) {
//		this.detect_pauses = detect_pauses;
//	}
	@Override
	public String toString() {
		return "NewFitnessActivity [type=" + type + ", start_time="
				+ start_time + ", total_distance=" + total_distance
				+ ", duration=" + duration + ", average_heart_rate="
				+ average_heart_rate + ", heart_rate="
				+ Arrays.toString(heart_rate) + ", total_calories="
				+ total_calories + ", notes=" + notes + ", path="
				+ Arrays.toString(path) + ", post_to_facebook="
				+ post_to_facebook + ", post_to_twitter=" + post_to_twitter
				+ ", detect_pauses=" + detect_pauses + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((average_heart_rate == null) ? 0 : average_heart_rate
						.hashCode());
		result = prime * result
				+ ((detect_pauses == null) ? 0 : detect_pauses.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + Arrays.hashCode(heart_rate);
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + Arrays.hashCode(path);
		result = prime
				* result
				+ ((post_to_facebook == null) ? 0 : post_to_facebook.hashCode());
		result = prime * result
				+ ((post_to_twitter == null) ? 0 : post_to_twitter.hashCode());
		result = prime * result
				+ ((start_time == null) ? 0 : start_time.hashCode());
		result = prime * result
				+ ((total_calories == null) ? 0 : total_calories.hashCode());
		result = prime * result
				+ ((total_distance == null) ? 0 : total_distance.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		NewFitnessActivity other = (NewFitnessActivity) obj;
		if (average_heart_rate == null) {
			if (other.average_heart_rate != null)
				return false;
		} else if (!average_heart_rate.equals(other.average_heart_rate))
			return false;
		if (detect_pauses == null) {
			if (other.detect_pauses != null)
				return false;
		} else if (!detect_pauses.equals(other.detect_pauses))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (!Arrays.equals(heart_rate, other.heart_rate))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (!Arrays.equals(path, other.path))
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
		return true;
	}
}
