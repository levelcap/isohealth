package test.com.isobar.isohealth;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.FitnessActivity;
import com.isobar.isohealth.models.FitnessActivityFeed;
import com.isobar.isohealth.models.FitnessActivityFeed.Item;
import com.isobar.isohealth.services.FitnessActivityService;

public class FitnessActivityServiceTest extends TestCase {

	public void testGetFitnessActivityFeed() {
		try {
			FitnessActivityFeed fitnessActivityFeed = FitnessActivityService.getFitnessActivityFeed(GraphConstants.AUTH_CODE);
			System.out.println("FitnessActivityFeed: " + fitnessActivityFeed.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testGetFitnessActivity() {
		try {
			FitnessActivityFeed fitnessActivityFeed = FitnessActivityService.getFitnessActivityFeed(GraphConstants.AUTH_CODE);
			List<FitnessActivity> fitnessActivities =  new ArrayList<FitnessActivity>();
			for (Item item : fitnessActivityFeed.getItems()) {
				FitnessActivity activity = FitnessActivityService.getFitnessActivity(item.getUri(),GraphConstants.AUTH_CODE);
				System.out.println("FitnessActivity: " + activity.toString());
				fitnessActivities.add(activity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
