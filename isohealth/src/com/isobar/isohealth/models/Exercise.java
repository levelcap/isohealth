package com.isobar.isohealth.models;

import java.util.Arrays;

public class Exercise {
	public static class Set {
		private Double weight; //The weight for the set, in kg
		private Integer repetitions; //The number of repetitions in this set
		private String notes; //Any notes for this set (max. 1024 characters; optional)
		public Double getWeight() {
			return weight;
		}
		public void setWeight(Double weight) {
			this.weight = weight;
		}
		public Integer getRepetitions() {
			return repetitions;
		}
		public void setRepetitions(Integer repetitions) {
			this.repetitions = repetitions;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		@Override
		public String toString() {
			return "Set [weight=" + weight + ", repetitions=" + repetitions
					+ ", notes=" + notes + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((notes == null) ? 0 : notes.hashCode());
			result = prime * result
					+ ((repetitions == null) ? 0 : repetitions.hashCode());
			result = prime * result
					+ ((weight == null) ? 0 : weight.hashCode());
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
			Set other = (Set) obj;
			if (notes == null) {
				if (other.notes != null)
					return false;
			} else if (!notes.equals(other.notes))
				return false;
			if (repetitions == null) {
				if (other.repetitions != null)
					return false;
			} else if (!repetitions.equals(other.repetitions))
				return false;
			if (weight == null) {
				if (other.weight != null)
					return false;
			} else if (!weight.equals(other.weight))
				return false;
			return true;
		}		
	}
	private String primary_type; //The primary exercise type, as one of the following values: "Barbell Curl", "Dumbbell Curl", "Barbell Tricep Press", "Dumbbell Tricep Press", "Overhead Press", "Wrist Curl", "Tricep Kickback", "Bench Press", "Cable Crossover", "Dumbbell Fly", "Incline Bench", "Dips", "Pushup", "Pullup", "Back Raise", "Bent-Over Row", "Seated Row", "Chinup", "Lat Pulldown", "Seated Reverse Fly", "Military Press", "Upgright Row", "Front Raise", "Side Lateral Raise", "Snatch", "Push Press", "Shrug", "Crunch Machine", "Crunch", "Ab Twist", "Bicycle Kick", "Hanging Leg Raise", "Hanging Knee Raise", "Reverse Crunch", "V Up", "Situp", "Squat", "Lunge", "Dead Lift", "Hamstring Curl", "Good Morning", "Clean", "Leg Press", "Leg Extension", "Other",
	private String secondary_type; //The secondary exercise type (optional; provides greater detail as free-form text if supplied)
	private String primary_muscle_group; //The primary muscle group, as one of the following values: "Arms", "Chest", "Back", "Shoulders", "Abs", "Legs"
	private String secondary_muscle_group; //The secondary muscle group, as one of the following values: "Arms", "Chest", "Back", "Shoulders", "Abs", "Legs" (optional)
	private String routine; //Free-form tag for the routine of which this exercise is a part (max. 32 characters; optional)
	private String notes; //Any notes for this exercise (max. 1024 characters; optional)
	private Set[] sets; //The sets performed during this exercise
	public String getPrimary_type() {
		return primary_type;
	}
	public void setPrimary_type(String primary_type) {
		this.primary_type = primary_type;
	}
	public String getSecondary_type() {
		return secondary_type;
	}
	public void setSecondary_type(String secondary_type) {
		this.secondary_type = secondary_type;
	}
	public String getPrimary_muscle_group() {
		return primary_muscle_group;
	}
	public void setPrimary_muscle_group(String primary_muscle_group) {
		this.primary_muscle_group = primary_muscle_group;
	}
	public String getSecondary_muscle_group() {
		return secondary_muscle_group;
	}
	public void setSecondary_muscle_group(String secondary_muscle_group) {
		this.secondary_muscle_group = secondary_muscle_group;
	}
	public String getRoutine() {
		return routine;
	}
	public void setRoutine(String routine) {
		this.routine = routine;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Set[] getSets() {
		return sets;
	}
	public void setSets(Set[] sets) {
		this.sets = sets;
	}
	@Override
	public String toString() {
		return "Exercise [primary_type=" + primary_type
				+ ", secondary_type=" + secondary_type
				+ ", primary_muscle_group=" + primary_muscle_group
				+ ", secondary_muscle_group=" + secondary_muscle_group
				+ ", routine=" + routine + ", notes=" + notes + ", sets="
				+ Arrays.toString(sets) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((notes == null) ? 0 : notes.hashCode());
		result = prime
				* result
				+ ((primary_muscle_group == null) ? 0
						: primary_muscle_group.hashCode());
		result = prime * result
				+ ((primary_type == null) ? 0 : primary_type.hashCode());
		result = prime * result
				+ ((routine == null) ? 0 : routine.hashCode());
		result = prime
				* result
				+ ((secondary_muscle_group == null) ? 0
						: secondary_muscle_group.hashCode());
		result = prime
				* result
				+ ((secondary_type == null) ? 0 : secondary_type.hashCode());
		result = prime * result + Arrays.hashCode(sets);
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
		Exercise other = (Exercise) obj;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (primary_muscle_group == null) {
			if (other.primary_muscle_group != null)
				return false;
		} else if (!primary_muscle_group.equals(other.primary_muscle_group))
			return false;
		if (primary_type == null) {
			if (other.primary_type != null)
				return false;
		} else if (!primary_type.equals(other.primary_type))
			return false;
		if (routine == null) {
			if (other.routine != null)
				return false;
		} else if (!routine.equals(other.routine))
			return false;
		if (secondary_muscle_group == null) {
			if (other.secondary_muscle_group != null)
				return false;
		} else if (!secondary_muscle_group
				.equals(other.secondary_muscle_group))
			return false;
		if (secondary_type == null) {
			if (other.secondary_type != null)
				return false;
		} else if (!secondary_type.equals(other.secondary_type))
			return false;
		if (!Arrays.equals(sets, other.sets))
			return false;
		return true;
	}	
}
