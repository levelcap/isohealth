package com.isobar.isohealth.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class NewBackgroundActivity {
	private String timestamp; //The timestamp (e.g., "Sat, 1 Jan 2011 00:00:00")
	private Double calories_burned;
	private Double steps;
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Double getCalories_burned() {
		return calories_burned;
	}
	public void setCalories_burned(Double calories_burned) {
		this.calories_burned = calories_burned;
	}
	public Double getSteps() {
		return steps;
	}
	public void setSteps(Double steps) {
		this.steps = steps;
	}
	
	@Override
	public String toString() {
		return "NewBackgroundActivity [timestamp=" + timestamp
				+ ", calories_burned=" + calories_burned + ", steps=" + steps
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((calories_burned == null) ? 0 : calories_burned.hashCode());
		result = prime * result + ((steps == null) ? 0 : steps.hashCode());
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
		NewBackgroundActivity other = (NewBackgroundActivity) obj;
		if (calories_burned == null) {
			if (other.calories_burned != null)
				return false;
		} else if (!calories_burned.equals(other.calories_burned))
			return false;
		if (steps == null) {
			if (other.steps != null)
				return false;
		} else if (!steps.equals(other.steps))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}
}
