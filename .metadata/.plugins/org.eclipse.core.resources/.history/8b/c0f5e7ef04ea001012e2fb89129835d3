package com.isobar.isohealth.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class Stat {
	private String stat_type; // The type of statistic, as one of the following values: "BEST_ACTIVITY", "BEST_WEEK", "LAST_WEEK", "THIS_WEEK", "BEST_MONTH", "LAST_MONTH", "THIS_MONTH", "OVERALL"
	private Double value;     // The record distance value
	private String date;      // The date of the record (e.g., "Sat, 1 Jan 2011 00:00:00"; omitted if not available)
	
	public Stat() {
		super();
	}
	public Stat(String stat_type, Double value, String date) {
		super();
		this.stat_type = stat_type;
		this.value = value;
		this.date = date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((stat_type == null) ? 0 : stat_type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Stat other = (Stat) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (stat_type == null) {
			if (other.stat_type != null)
				return false;
		} else if (!stat_type.equals(other.stat_type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stat [stat_type=" + stat_type + ", value=" + value
				+ ", date=" + date + "]";
	}
	public String getStat_type() {
		return stat_type;
	}
	public void setStat_type(String stat_type) {
		this.stat_type = stat_type;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
