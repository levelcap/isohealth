package com.isobar.isohealth.wrappers;

import com.isobar.isohealth.wrappers.BackgroundActivityWrapper;
import com.isobar.isohealth.wrappers.FitnessActivityWrapper;
import com.isobar.isohealth.wrappers.ProfileWrapper;
import com.isobar.isohealth.wrappers.SettingsWrapper;
import com.isobar.isohealth.wrappers.StrengthTrainingActivityWrapper;
import com.isobar.isohealth.wrappers.UserWrapper;

public class RunkeeperService {
	public BackgroundActivityWrapper backgroundActivityWrapper;
	public DiabetesMeasurementWrapper diabetesMeasurementWrapper;
	public FitnessActivityWrapper fitnessActivityWrapper;
	public GeneralMeasurementWrapper generalMeasurementWrapper;
	public NutritionMeasurementWrapper nutritionMeasurementWrapper;
	public PersonalRecordWrapper personalRecordWrapper;
	public ProfileWrapper profileWrapper;
	public SettingsWrapper settingsWrapper;
	public SleepMeasurementWrapper sleepMeasurementWrapper;
	public StreetTeamMembershipWrapper streetTeamMembershipWrapper;
	public StrengthTrainingActivityWrapper strengthTrainingActivityWrapper;
	public UserWrapper userWrapper;
	public WeightManagementWrapper weightManagementWrapper;
	
	@SuppressWarnings("unused")
	private String authToken;
	
	public RunkeeperService(String authToken) {
		this.authToken = authToken;
		backgroundActivityWrapper = new BackgroundActivityWrapper(authToken);
		diabetesMeasurementWrapper = new DiabetesMeasurementWrapper(authToken);
		fitnessActivityWrapper = new FitnessActivityWrapper(authToken);
		generalMeasurementWrapper = new GeneralMeasurementWrapper(authToken);
		nutritionMeasurementWrapper = new NutritionMeasurementWrapper(authToken);
		personalRecordWrapper = new PersonalRecordWrapper(authToken);
		profileWrapper = new ProfileWrapper(authToken);
		settingsWrapper = new SettingsWrapper(authToken);
		sleepMeasurementWrapper = new SleepMeasurementWrapper(authToken);
		streetTeamMembershipWrapper = new StreetTeamMembershipWrapper(authToken);
		strengthTrainingActivityWrapper = new StrengthTrainingActivityWrapper(authToken);
		userWrapper = new UserWrapper(authToken);
		weightManagementWrapper = new WeightManagementWrapper(authToken);
	}
}
