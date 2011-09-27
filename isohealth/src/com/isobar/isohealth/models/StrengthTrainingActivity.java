package com.isobar.isohealth.models;

import java.util.Arrays;

public class StrengthTrainingActivity {
	public static class Exercise {
		private String primary_type; //The primary exercise type, as one of the following values: "Barbell Curl", "Dumbbell Curl", "Barbell Tricep Press", "Dumbbell Tricep Press", "Overhead Press", "Wrist Curl", "Tricep Kickback", "Bench Press", "Cable Crossover", "Dumbbell Fly", "Incline Bench", "Dips", "Pushup", "Pullup", "Back Raise", "Bent-Over Row", "Seated Row", "Chinup", "Lat Pulldown", "Seated Reverse Fly", "Military Press", "Upgright Row", "Front Raise", "Side Lateral Raise", "Snatch", "Push Press", "Shrug", "Crunch Machine", "Crunch", "Ab Twist", "Bicycle Kick", "Hanging Leg Raise", "Hanging Knee Raise", "Reverse Crunch", "V Up", "Situp", "Squat", "Lunge", "Dead Lift", "Hamstring Curl", "Good Morning", "Clean", "Leg Press", "Leg Extension", "Other",
		private String secondary_type; //The secondary exercise type (optional; provides greater detail as free-form text if supplied)
		private String primary_muscle_group; //The primary muscle group, as one of the following values: "Arms", "Chest", "Back", "Shoulders", "Abs", "Legs"
		private String secondary_muscle_group; //The secondary muscle group, as one of the following values: "Arms", "Chest", "Back", "Shoulders", "Abs", "Legs" (optional)
		private String routine; //Free-form tag for the routine of which this exercise is a part (max. 32 characters; optional)
		private String gnotes; //Any notes for this exercise (max. 1024 characters; optional)
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
		public String getGnotes() {
			return gnotes;
		}
		public void setGnotes(String gnotes) {
			this.gnotes = gnotes;
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
					+ ", routine=" + routine + ", gnotes=" + gnotes + ", sets="
					+ Arrays.toString(sets) + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((gnotes == null) ? 0 : gnotes.hashCode());
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
			if (gnotes == null) {
				if (other.gnotes != null)
					return false;
			} else if (!gnotes.equals(other.gnotes))
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
	
	private String uri; //The URI for this activity
	private Integer userID; //The unique ID of the user for the activity
	private String start_time; //The starting time for the activity (e.g., "Sat, 1 Jan 2011 00:00:00")
	private String notes; //Any notes that the user has associated with the activity (max. 1024 characters; optional)
	private Exercise[] exercises; //Exercise[] 	The exercises performed during this strength training activity
	private String previous; //The URI of the previous activity in the user's fitness feed (omitted for the oldest activity)
	private String next; //The URI of the next activity in the user's fitness feed (omitted for the most-recent activity)
	private String nearest_fitness_activity; //The URI of the fitness activity closest in time to this activity for the user (omitted if no fitness activities have been recorded)
	private String[] nearest_teammate_fitness_activities; //The URIs of the fitness activities closest in time to this activity for each street teammate (empty if no fitness activities have been recorded)
	private String[] nearest_teammate_strength_training_activities; //The URIs of the strength training activities closest in time to this activity for each street teammate (empty if no strength training activities have been recorded)
	private String nearest_background_activity; //The URI of the background activity closest in time to this activity for the user (omitted if no background activities have been recorded)
	private String[] nearest_teammate_background_activities; //The URIs of the background activities closest in time to this activity for each street teammate (empty if no background activities have been recorded)
	private String nearest_sleep; //The URI of the sleep measurements closest in time to this activity for the user (omitted if no sleep measurements have been taken)
	private String[] nearest_teammate_sleep; //The URIs of the sleep measurements closest in time to this activity for each street teammate (empty if no sleep measurements have been taken)
	private String nearest_nutrition; //The URI of the nutrition measurement closest in time to this activity for the user (omitted if no nutrition measurements have been token)
	private String[] nearest_teammate_nutrition; //The URIs of the nutrition measurement closest in time to this activity for each street teammate (empty if no nutrition measurements have been token)
	private String nearest_weight; //The URI of the weight measurement closest in time to this activity for the user (omitted if no weight measurements have been token)
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
	public String getNearest_fitness_activity() {
		return nearest_fitness_activity;
	}
	public void setNearest_fitness_activity(String nearest_fitness_activity) {
		this.nearest_fitness_activity = nearest_fitness_activity;
	}
	public String[] getNearest_teammate_fitness_activities() {
		return nearest_teammate_fitness_activities;
	}
	public void setNearest_teammate_fitness_activities(
			String[] nearest_teammate_fitness_activities) {
		this.nearest_teammate_fitness_activities = nearest_teammate_fitness_activities;
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
		return "StrengthTrainingActivity [uri="
				+ uri
				+ ", userID="
				+ userID
				+ ", start_time="
				+ start_time
				+ ", notes="
				+ notes
				+ ", exercises="
				+ Arrays.toString(exercises)
				+ ", previous="
				+ previous
				+ ", next="
				+ next
				+ ", nearest_fitness_activity="
				+ nearest_fitness_activity
				+ ", nearest_teammate_fitness_activities="
				+ Arrays.toString(nearest_teammate_fitness_activities)
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
		result = prime * result + Arrays.hashCode(exercises);
		result = prime
				* result
				+ ((nearest_background_activity == null) ? 0
						: nearest_background_activity.hashCode());
		result = prime
				* result
				+ ((nearest_diabetes == null) ? 0 : nearest_diabetes.hashCode());
		result = prime
				* result
				+ ((nearest_fitness_activity == null) ? 0
						: nearest_fitness_activity.hashCode());
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
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
		result = prime * result
				+ ((start_time == null) ? 0 : start_time.hashCode());
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
		StrengthTrainingActivity other = (StrengthTrainingActivity) obj;
		if (!Arrays.equals(exercises, other.exercises))
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
		if (nearest_fitness_activity == null) {
			if (other.nearest_fitness_activity != null)
				return false;
		} else if (!nearest_fitness_activity
				.equals(other.nearest_fitness_activity))
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
