package test.com.isobar.isohealth;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.User;
import com.isobar.isohealth.services.UserService;

public class UserServiceTest extends TestCase {

	public void testGetUser() {
		try {
			User user = UserService.getUser(GraphConstants.AUTH_CODE);
			System.out.println("User: " + user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
