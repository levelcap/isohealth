package test.com.isobar.isohealth;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.User;
import com.isobar.isohealth.wrappers.RunkeeperService;
import com.isobar.isohealth.wrappers.UserWrapper;

public class UserServiceTest extends TestCase {
	UserWrapper userWrapper;
	
	protected void setUp() {
    	RunkeeperService runkeeperService = new RunkeeperService(GraphConstants.AUTH_CODE);
    	userWrapper = runkeeperService.userWrapper;
    }
	
	public void testGetUser() {
		try {
			User user = userWrapper.getUser();
			System.out.println("User: " + user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
