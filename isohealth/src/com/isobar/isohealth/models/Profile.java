package com.isobar.isohealth.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class Profile {
	private String name;  //The user's full name (omitted if not yet specified)
	private String location;  //The user's geographical location (omitted if not yet specified)
	private String athlete_type;  //One of the following values: "Athlete", "Runner", "Marathoner", "Ultra Marathoner", "Cyclist", "Tri-Athlete", "Walker", "Hiker", "Skier", "Snowboarder", "Skater", "Swimmer", "Rower" (omitted if not yet specified)
	private String goal;  //The user's current fitness goal
	private String gender;  //One of the following values: "M", "F" (omitted if not yet specified)
	private String birthday;  //The user's birthday (e.g., "Sat, 1 Jan 2011 00:00:00") (omitted if not yet specified)
	private Boolean elite;  //true if the user subscribes to RunKeeper Elite, false otherwise
	private String profile;  //The URL of the user's public, human-readable profile on the RunKeeper Web site
	private String small_picture;  //The URI of the small (50x50) version of the user's profile picture on the RunKeeper Web site (omitted if the user has no such picture) 	
	private String normal_picture;  //The URI of the small (100x100) version of the user's profile picture on the RunKeeper Web site (omitted if the user has no such picture)
	private String medium_picture;  //The URI of the small (200x600) version of the user's profile picture on the RunKeeper Web site (omitted if the user has no such picture)
	private String large_picture;  //The URI of the small (600x1800) version of the user's profile picture on the RunKeeper Web site (omitted if the user has no such picture)	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return location;
	}
	public void setAthlete_type(String athlete_type) {
		this.athlete_type = athlete_type;
	}
	public String getAthlete_type() {
		return athlete_type;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getGoal() {
		return goal;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setElite(Boolean elite) {
		this.elite = elite;
	}
	public Boolean getElite() {
		return elite;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getProfile() {
		return profile;
	}
	public void setSmall_picture(String small_picture) {
		this.small_picture = small_picture;
	}
	public String getSmall_picture() {
		return small_picture;
	}
	public void setNormal_picture(String normal_picture) {
		this.normal_picture = normal_picture;
	}
	public String getNormal_picture() {
		return normal_picture;
	}
	public void setMedium_picture(String medium_picture) {
		this.medium_picture = medium_picture;
	}
	public String getMedium_picture() {
		return medium_picture;
	}
	public void setLarge_picture(String large_picture) {
		this.large_picture = large_picture;
	}
	public String getLarge_picture() {
		return large_picture;
	}
	@Override
	public String toString() {
		return "Profile [_name=" + name + ", _location=" + location
				+ ", _athlete_type=" + athlete_type + ", _goal=" + goal
				+ ", _gender=" + gender + ", _birthday=" + birthday
				+ ", _elite=" + elite + ", _profile=" + profile
				+ ", _small_picture=" + small_picture + ", _normal_picture="
				+ normal_picture + ", _medium_picture=" + medium_picture
				+ ", _large_picture=" + large_picture + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((athlete_type == null) ? 0 : athlete_type.hashCode());
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((elite == null) ? 0 : elite.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((goal == null) ? 0 : goal.hashCode());
		result = prime * result
				+ ((large_picture == null) ? 0 : large_picture.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((medium_picture == null) ? 0 : medium_picture.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((normal_picture == null) ? 0 : normal_picture.hashCode());
		result = prime * result
				+ ((profile == null) ? 0 : profile.hashCode());
		result = prime * result
				+ ((small_picture == null) ? 0 : small_picture.hashCode());
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
		Profile other = (Profile) obj;
		if (athlete_type == null) {
			if (other.athlete_type != null)
				return false;
		} else if (!athlete_type.equals(other.athlete_type))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (elite == null) {
			if (other.elite != null)
				return false;
		} else if (!elite.equals(other.elite))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (goal == null) {
			if (other.goal != null)
				return false;
		} else if (!goal.equals(other.goal))
			return false;
		if (large_picture == null) {
			if (other.large_picture != null)
				return false;
		} else if (!large_picture.equals(other.large_picture))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (medium_picture == null) {
			if (other.medium_picture != null)
				return false;
		} else if (!medium_picture.equals(other.medium_picture))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (normal_picture == null) {
			if (other.normal_picture != null)
				return false;
		} else if (!normal_picture.equals(other.normal_picture))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (small_picture == null) {
			if (other.small_picture != null)
				return false;
		} else if (!small_picture.equals(other.small_picture))
			return false;
		return true;
	}	
}
