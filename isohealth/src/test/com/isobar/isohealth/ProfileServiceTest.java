package test.com.isobar.isohealth;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.Profile;
import com.isobar.isohealth.wrappers.ProfileWrapper;
import com.isobar.isohealth.wrappers.RunkeeperService;

public class ProfileServiceTest extends TestCase {

	ProfileWrapper profileWrapper;

	protected void setUp() {
    	RunkeeperService runkeeperService = new RunkeeperService(GraphConstants.AUTH_CODE);
    	profileWrapper = runkeeperService.profileWrapper;
    }
	public void testGetProfile() {
		try {
			Profile profile = profileWrapper.getProfile();
			System.out.println("Profile: " + profile.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUpdateProfile() {
		try {
			Profile profile = profileWrapper.getProfile();
			System.out.println("Profile: " + profile.toString());
			profile.setAthlete_type("Runner");
			profile.setGoal("Be awesomer");
			profile = profileWrapper.updateProfile(profile);
			System.out.println("Updated Profile: " + profile.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
