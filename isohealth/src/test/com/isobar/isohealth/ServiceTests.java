package test.com.isobar.isohealth;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ServiceTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(ServiceTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(UserServiceTest.class);
		suite.addTestSuite(SettingsServiceTest.class);
		suite.addTestSuite(ProfileServiceTest.class);
		suite.addTestSuite(FitnessActivityFeedServiceTest.class);
		//$JUnit-END$
		return suite;
	}
}
