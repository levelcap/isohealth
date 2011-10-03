package com.isobar.isohealth.services;

import com.isobar.isohealth.wrappers.BackgroundActivityWrapper;
import com.isobar.isohealth.wrappers.FitnessActivityWrapper;
import com.isobar.isohealth.wrappers.ProfileWrapper;
import com.isobar.isohealth.wrappers.SettingsWrapper;
import com.isobar.isohealth.wrappers.StrengthTrainingActivityWrapper;
import com.isobar.isohealth.wrappers.UserWrapper;

public class RunkeeperService {
	public BackgroundActivityWrapper backgroundActivityWrapper;
	public FitnessActivityWrapper fitnessActivityWrapper;
	public ProfileWrapper profileWrapper;
	public SettingsWrapper settingsWrapper;
	public StrengthTrainingActivityWrapper strengthTrainingActivityWrapper;
	public UserWrapper userWrapper;
	
	@SuppressWarnings("unused")
	private String authToken;
	
	public RunkeeperService(String authToken) {
		this.authToken = authToken;
		backgroundActivityWrapper = new BackgroundActivityWrapper(authToken);
		fitnessActivityWrapper = new FitnessActivityWrapper(authToken);
		profileWrapper = new ProfileWrapper(authToken);
		settingsWrapper = new SettingsWrapper(authToken);
		strengthTrainingActivityWrapper = new StrengthTrainingActivityWrapper(authToken);
		userWrapper = new UserWrapper(authToken);
	}
}
