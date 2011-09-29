package com.isobar.isohealth.models;

public class NewDiabetesMeasurement {
	private String timestamp; // The time at which the measurement was taken (e.g., "Sat, 1 Jan 2011 00:00:00")
	// One of the following values: fasting_plasma_glucose_test, random_plasma_glucose_test, oral_glucose_tolerance_test, hemoglobin_a1c, insulin, c_peptide, triglyceride.
	private Double fasting_plasma_glucose_test; // The value of the measured quantity
	private Double random_plasma_glucose_test; // The value of the measured quantity
	private Double oral_glucose_tolerance_test; // The value of the measured quantity
	private Double hemoglobin_a1c; // The value of the measured quantity
	private Double insulin; // The value of the measured quantity
	private Double c_peptide; // The value of the measured quantity
	private Double triglyceride; // The value of the measured quantity
	private Boolean post_to_twitter; // Whether to post this measurement to Twitter (optional; if omitted, the user's default setting will be used)
	private Boolean	post_to_facebook; // Whether to post this measurement to Facebook (optional; if omitted, the user's default setting will be used)
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Boolean getPost_to_twitter() {
		return post_to_twitter;
	}
	public void setPost_to_twitter(Boolean post_to_twitter) {
		this.post_to_twitter = post_to_twitter;
	}
	public Boolean getPost_to_facebook() {
		return post_to_facebook;
	}
	public void setPost_to_facebook(Boolean post_to_facebook) {
		this.post_to_facebook = post_to_facebook;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((c_peptide == null) ? 0 : c_peptide.hashCode());
		result = prime
				* result
				+ ((fasting_plasma_glucose_test == null) ? 0
						: fasting_plasma_glucose_test.hashCode());
		result = prime * result
				+ ((hemoglobin_a1c == null) ? 0 : hemoglobin_a1c.hashCode());
		result = prime * result + ((insulin == null) ? 0 : insulin.hashCode());
		result = prime
				* result
				+ ((oral_glucose_tolerance_test == null) ? 0
						: oral_glucose_tolerance_test.hashCode());
		result = prime
				* result
				+ ((post_to_facebook == null) ? 0 : post_to_facebook.hashCode());
		result = prime * result
				+ ((post_to_twitter == null) ? 0 : post_to_twitter.hashCode());
		result = prime
				* result
				+ ((random_plasma_glucose_test == null) ? 0
						: random_plasma_glucose_test.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result
				+ ((triglyceride == null) ? 0 : triglyceride.hashCode());
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
		NewDiabetesMeasurement other = (NewDiabetesMeasurement) obj;
		if (c_peptide == null) {
			if (other.c_peptide != null)
				return false;
		} else if (!c_peptide.equals(other.c_peptide))
			return false;
		if (fasting_plasma_glucose_test == null) {
			if (other.fasting_plasma_glucose_test != null)
				return false;
		} else if (!fasting_plasma_glucose_test
				.equals(other.fasting_plasma_glucose_test))
			return false;
		if (hemoglobin_a1c == null) {
			if (other.hemoglobin_a1c != null)
				return false;
		} else if (!hemoglobin_a1c.equals(other.hemoglobin_a1c))
			return false;
		if (insulin == null) {
			if (other.insulin != null)
				return false;
		} else if (!insulin.equals(other.insulin))
			return false;
		if (oral_glucose_tolerance_test == null) {
			if (other.oral_glucose_tolerance_test != null)
				return false;
		} else if (!oral_glucose_tolerance_test
				.equals(other.oral_glucose_tolerance_test))
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
		if (random_plasma_glucose_test == null) {
			if (other.random_plasma_glucose_test != null)
				return false;
		} else if (!random_plasma_glucose_test
				.equals(other.random_plasma_glucose_test))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (triglyceride == null) {
			if (other.triglyceride != null)
				return false;
		} else if (!triglyceride.equals(other.triglyceride))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NewDiabetesMeasurement [timestamp=" + timestamp
				+ ", fasting_plasma_glucose_test="
				+ fasting_plasma_glucose_test + ", random_plasma_glucose_test="
				+ random_plasma_glucose_test + ", oral_glucose_tolerance_test="
				+ oral_glucose_tolerance_test + ", hemoglobin_a1c="
				+ hemoglobin_a1c + ", insulin=" + insulin + ", c_peptide="
				+ c_peptide + ", triglyceride=" + triglyceride
				+ ", post_to_twitter=" + post_to_twitter
				+ ", post_to_facebook=" + post_to_facebook + "]";
	}
	public Double getFasting_plasma_glucose_test() {
		return fasting_plasma_glucose_test;
	}
	public void setFasting_plasma_glucose_test(Double fasting_plasma_glucose_test) {
		this.fasting_plasma_glucose_test = fasting_plasma_glucose_test;
	}
	public Double getRandom_plasma_glucose_test() {
		return random_plasma_glucose_test;
	}
	public void setRandom_plasma_glucose_test(Double random_plasma_glucose_test) {
		this.random_plasma_glucose_test = random_plasma_glucose_test;
	}
	public Double getOral_glucose_tolerance_test() {
		return oral_glucose_tolerance_test;
	}
	public void setOral_glucose_tolerance_test(Double oral_glucose_tolerance_test) {
		this.oral_glucose_tolerance_test = oral_glucose_tolerance_test;
	}
	public Double getHemoglobin_a1c() {
		return hemoglobin_a1c;
	}
	public void setHemoglobin_a1c(Double hemoglobin_a1c) {
		this.hemoglobin_a1c = hemoglobin_a1c;
	}
	public Double getInsulin() {
		return insulin;
	}
	public void setInsulin(Double insulin) {
		this.insulin = insulin;
	}
	public Double getC_peptide() {
		return c_peptide;
	}
	public void setC_peptide(Double c_peptide) {
		this.c_peptide = c_peptide;
	}
	public Double getTriglyceride() {
		return triglyceride;
	}
	public void setTriglyceride(Double triglyceride) {
		this.triglyceride = triglyceride;
	}
	public NewDiabetesMeasurement(String timestamp,
			Double fasting_plasma_glucose_test,
			Double random_plasma_glucose_test,
			Double oral_glucose_tolerance_test, Double hemoglobin_a1c,
			Double insulin, Double c_peptide, Double triglyceride,
			Boolean post_to_twitter, Boolean post_to_facebook) {
		super();
		this.timestamp = timestamp;
		this.fasting_plasma_glucose_test = fasting_plasma_glucose_test;
		this.random_plasma_glucose_test = random_plasma_glucose_test;
		this.oral_glucose_tolerance_test = oral_glucose_tolerance_test;
		this.hemoglobin_a1c = hemoglobin_a1c;
		this.insulin = insulin;
		this.c_peptide = c_peptide;
		this.triglyceride = triglyceride;
		this.post_to_twitter = post_to_twitter;
		this.post_to_facebook = post_to_facebook;
	}
	public NewDiabetesMeasurement() {
		super();
	}
	
}
