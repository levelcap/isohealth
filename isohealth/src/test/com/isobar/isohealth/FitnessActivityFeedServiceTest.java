package test.com.isobar.isohealth;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.FitnessActivityFeed;
import com.isobar.isohealth.services.FitnessActivityFeedService;

public class FitnessActivityFeedServiceTest extends TestCase {

	public void testGetFitnessActivityFeed() {
		try {
			FitnessActivityFeed fitnessActivityFeed = FitnessActivityFeedService.getFitnessActivityFeed(GraphConstants.AUTH_CODE);
			System.out.println("FitnessActivityFeed: " + fitnessActivityFeed.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
