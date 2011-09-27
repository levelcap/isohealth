package com.isobar.isohealth.models;

public class StrengthTrainingActivity {
	public static class Exercise {
		private String primary_type; //The primary exercise type, as one of the following values: "Barbell Curl", "Dumbbell Curl", "Barbell Tricep Press", "Dumbbell Tricep Press", "Overhead Press", "Wrist Curl", "Tricep Kickback", "Bench Press", "Cable Crossover", "Dumbbell Fly", "Incline Bench", "Dips", "Pushup", "Pullup", "Back Raise", "Bent-Over Row", "Seated Row", "Chinup", "Lat Pulldown", "Seated Reverse Fly", "Military Press", "Upgright Row", "Front Raise", "Side Lateral Raise", "Snatch", "Push Press", "Shrug", "Crunch Machine", "Crunch", "Ab Twist", "Bicycle Kick", "Hanging Leg Raise", "Hanging Knee Raise", "Reverse Crunch", "V Up", "Situp", "Squat", "Lunge", "Dead Lift", "Hamstring Curl", "Good Morning", "Clean", "Leg Press", "Leg Extension", "Other",
		private String secondary_type; //The secondary exercise type (optional; provides greater detail as free-form text if supplied)
		private String primary_muscle_group; //The primary muscle group, as one of the following values: "Arms", "Chest", "Back", "Shoulders", "Abs", "Legs"
		private String secondary_muscle_group; //The secondary muscle group, as one of the following values: "Arms", "Chest", "Back", "Shoulders", "Abs", "Legs" (optional)
		private String routine; //Free-form tag for the routine of which this exercise is a part (max. 32 characters; optional)
		private String gnotes; //Any notes for this exercise (max. 1024 characters; optional)
		private Set[] sets; //The sets performed during this exercise
	}


	public static class Set {
		private Double weight; //The weight for the set, in kg
		private Integer repetitions; //The number of repetitions in this set
		private String notes; //Any notes for this set (max. 1024 characters; optional)
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
}
