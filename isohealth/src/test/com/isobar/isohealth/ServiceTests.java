package test.com.isobar.isohealth;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ServiceTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(ServiceTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(BackgroundActivityServiceTest.class);
		suite.addTestSuite(DiabetesMeasurementServiceTest.class);
		suite.addTestSuite(FitnessActivityServiceTest.class);
		suite.addTestSuite(GeneralMeasurementServiceTest.class);
		suite.addTestSuite(NutritionMeasurementServiceTest.class);
		suite.addTestSuite(PersonalRecordServiceTest.class);
		suite.addTestSuite(ProfileServiceTest.class);
		suite.addTestSuite(SettingsServiceTest.class);
		suite.addTestSuite(SleepMeasurementServiceTest.class);
		suite.addTestSuite(StreetTeamMembershipServiceTest.class);
		suite.addTestSuite(StrengthTrainingActivityServiceTest.class);
		suite.addTestSuite(UserServiceTest.class);
		suite.addTestSuite(WeightMeasurementServiceTest.class);

		//$JUnit-END$
		return suite;
	}
}
