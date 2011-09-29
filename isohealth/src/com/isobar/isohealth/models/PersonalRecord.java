package com.isobar.isohealth.models;

import java.util.Arrays;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class PersonalRecord {
	private Stat[] stats;         // The statistics for the activity type (empty if no records are available)
	private String activity_type; // The type of activity, as one of the following values: "Run", "Bike", "Mountain Bike", "Walk", "Hike", "Downhill Ski", "Cross-Country Ski", "Snowboard", "Skate", "Swimming", "Wheelchair", "Rowing", "Elliptical", "Other"
	
	public PersonalRecord() {
		super();
	}
	public PersonalRecord(String activity_type, Stat[] stats) {
		super();
		this.activity_type = activity_type;
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "PersonalRecords [activity_type=" + activity_type + ", stats="
				+ Arrays.toString(stats) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activity_type == null) ? 0 : activity_type.hashCode());
		result = prime * result + Arrays.hashCode(stats);
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
		PersonalRecord other = (PersonalRecord) obj;
		if (activity_type == null) {
			if (other.activity_type != null)
				return false;
		} else if (!activity_type.equals(other.activity_type))
			return false;
		if (!Arrays.equals(stats, other.stats))
			return false;
		return true;
	}

	public String getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}
	public Stat[] getStats() {
		return stats;
	}
	public void setStats(Stat[] stats) {
		this.stats = stats;
	}
}