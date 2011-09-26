package com.isobar.isohealth.models;

public class Profile {
	private String _name;  //The user's full name (omitted if not yet specified)
	private String _location;  //The user's geographical location (omitted if not yet specified)
	private String _athlete_type;  //One of the following values: "Athlete", "Runner", "Marathoner", "Ultra Marathoner", "Cyclist", "Tri-Athlete", "Walker", "Hiker", "Skier", "Snowboarder", "Skater", "Swimmer", "Rower" (omitted if not yet specified)
	private String _goal;  //The user's current fitness goal
	private String _gender;  //One of the following values: "M", "F" (omitted if not yet specified)
	private String _birthday;  //The user's birthday (e.g., "Sat, 1 Jan 2011 00:00:00") (omitted if not yet specified)
	private Boolean _elite;  //true if the user subscribes to RunKeeper Elite, false otherwise
	private String _profile;  //The URL of the user's public, human-readable profile on the RunKeeper Web site
	private String _small_picture;  //The URI of the small (50x50) version of the user's profile picture on the RunKeeper Web site (omitted if the user has no such picture) 	
	private String _normal_picture;  //The URI of the small (100x100) version of the user's profile picture on the RunKeeper Web site (omitted if the user has no such picture)
	private String _medium_picture;  //The URI of the small (200x600) version of the user's profile picture on the RunKeeper Web site (omitted if the user has no such picture)
	private String _large_picture;  //The URI of the small (600x1800) version of the user's profile picture on the RunKeeper Web site (omitted if the user has no such picture)	
	
	public Profile() {
	
	}
	public void setName(String name) {
		this._name = name;
	}
	public String getName() {
		return _name;
	}
	public void setLocation(String location) {
		this._location = location;
	}
	public String getLocation() {
		return _location;
	}
	public void setAthlete_type(String athlete_type) {
		this._athlete_type = athlete_type;
	}
	public String getAthlete_type() {
		return _athlete_type;
	}
	public void setGoal(String goal) {
		this._goal = goal;
	}
	public String getGoal() {
		return _goal;
	}
	public void setGender(String gender) {
		this._gender = gender;
	}
	public String getGender() {
		return _gender;
	}
	public void setBirthday(String birthday) {
		this._birthday = birthday;
	}
	public String getBirthday() {
		return _birthday;
	}
	public void setElite(Boolean elite) {
		this._elite = elite;
	}
	public Boolean getElite() {
		return _elite;
	}
	public void setProfile(String profile) {
		this._profile = profile;
	}
	public String getProfile() {
		return _profile;
	}
	public void setSmall_picture(String small_picture) {
		this._small_picture = small_picture;
	}
	public String getSmall_picture() {
		return _small_picture;
	}
	public void setNormal_picture(String normal_picture) {
		this._normal_picture = normal_picture;
	}
	public String getNormal_picture() {
		return _normal_picture;
	}
	public void setMedium_picture(String medium_picture) {
		this._medium_picture = medium_picture;
	}
	public String getMedium_picture() {
		return _medium_picture;
	}
	public void setLarge_picture(String large_picture) {
		this._large_picture = large_picture;
	}
	public String getLarge_picture() {
		return _large_picture;
	}
	@Override
	public String toString() {
		return "Profile [_name=" + _name + ", _location=" + _location
				+ ", _athlete_type=" + _athlete_type + ", _goal=" + _goal
				+ ", _gender=" + _gender + ", _birthday=" + _birthday
				+ ", _elite=" + _elite + ", _profile=" + _profile
				+ ", _small_picture=" + _small_picture + ", _normal_picture="
				+ _normal_picture + ", _medium_picture=" + _medium_picture
				+ ", _large_picture=" + _large_picture + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_athlete_type == null) ? 0 : _athlete_type.hashCode());
		result = prime * result
				+ ((_birthday == null) ? 0 : _birthday.hashCode());
		result = prime * result + ((_elite == null) ? 0 : _elite.hashCode());
		result = prime * result + ((_gender == null) ? 0 : _gender.hashCode());
		result = prime * result + ((_goal == null) ? 0 : _goal.hashCode());
		result = prime * result
				+ ((_large_picture == null) ? 0 : _large_picture.hashCode());
		result = prime * result
				+ ((_location == null) ? 0 : _location.hashCode());
		result = prime * result
				+ ((_medium_picture == null) ? 0 : _medium_picture.hashCode());
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		result = prime * result
				+ ((_normal_picture == null) ? 0 : _normal_picture.hashCode());
		result = prime * result
				+ ((_profile == null) ? 0 : _profile.hashCode());
		result = prime * result
				+ ((_small_picture == null) ? 0 : _small_picture.hashCode());
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
		if (_athlete_type == null) {
			if (other._athlete_type != null)
				return false;
		} else if (!_athlete_type.equals(other._athlete_type))
			return false;
		if (_birthday == null) {
			if (other._birthday != null)
				return false;
		} else if (!_birthday.equals(other._birthday))
			return false;
		if (_elite == null) {
			if (other._elite != null)
				return false;
		} else if (!_elite.equals(other._elite))
			return false;
		if (_gender == null) {
			if (other._gender != null)
				return false;
		} else if (!_gender.equals(other._gender))
			return false;
		if (_goal == null) {
			if (other._goal != null)
				return false;
		} else if (!_goal.equals(other._goal))
			return false;
		if (_large_picture == null) {
			if (other._large_picture != null)
				return false;
		} else if (!_large_picture.equals(other._large_picture))
			return false;
		if (_location == null) {
			if (other._location != null)
				return false;
		} else if (!_location.equals(other._location))
			return false;
		if (_medium_picture == null) {
			if (other._medium_picture != null)
				return false;
		} else if (!_medium_picture.equals(other._medium_picture))
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		if (_normal_picture == null) {
			if (other._normal_picture != null)
				return false;
		} else if (!_normal_picture.equals(other._normal_picture))
			return false;
		if (_profile == null) {
			if (other._profile != null)
				return false;
		} else if (!_profile.equals(other._profile))
			return false;
		if (_small_picture == null) {
			if (other._small_picture != null)
				return false;
		} else if (!_small_picture.equals(other._small_picture))
			return false;
		return true;
	}	
}
