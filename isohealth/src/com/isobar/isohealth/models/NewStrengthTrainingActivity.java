package com.isobar.isohealth.models;

import java.util.Arrays;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class NewStrengthTrainingActivity {
	private String start_time; //The starting time for the activity (e.g., "Sat, 1 Jan 2011 00:00:00")
	private String notes; //Any notes that the user has associated with the activity (max. 1024 characters; optional)
	private Exercise[] exercises; //The exercises performed during this strength training activity
	private Boolean post_to_facebook; //True to post this activity to Facebook, false to prevent posting (optional; if not specified, the user's default preference is used)
	private Boolean post_to_twitter; //True to post this activity to Twitter, false to prevent posting (optional; if not specified, the user's default preference is used)
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Exercise[] getExercises() {
		return exercises;
	}
	public void setExercises(Exercise[] exercises) {
		this.exercises = exercises;
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
	@Override
	public String toString() {
		return "NewStrenghtTrainingActivity [start_time=" + start_time
				+ ", notes=" + notes + ", exercises="
				+ Arrays.toString(exercises) + ", post_to_facebook="
				+ post_to_facebook + ", post_to_twitter=" + post_to_twitter
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(exercises);
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime
				* result
				+ ((post_to_facebook == null) ? 0 : post_to_facebook.hashCode());
		result = prime * result
				+ ((post_to_twitter == null) ? 0 : post_to_twitter.hashCode());
		result = prime * result
				+ ((start_time == null) ? 0 : start_time.hashCode());
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
		NewStrengthTrainingActivity other = (NewStrengthTrainingActivity) obj;
		if (!Arrays.equals(exercises, other.exercises))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
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
		return true;
	}	
}
