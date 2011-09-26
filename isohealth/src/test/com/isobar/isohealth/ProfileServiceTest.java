package test.com.isobar.isohealth;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.Profile;
import com.isobar.isohealth.services.ProfileService;

public class ProfileServiceTest extends TestCase {

	public void testGetProfile() {
		try {
			Profile profile = ProfileService.getProfile(GraphConstants.AUTH_CODE);
			System.out.println("Profile: " + profile.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
