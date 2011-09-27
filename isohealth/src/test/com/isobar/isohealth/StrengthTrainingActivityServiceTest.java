package test.com.isobar.isohealth;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.FitnessActivity;
import com.isobar.isohealth.models.StrengthTrainingActivityFeed.Item;
import com.isobar.isohealth.models.StrengthTrainingActivity;
import com.isobar.isohealth.models.StrengthTrainingActivityFeed;
import com.isobar.isohealth.services.FitnessActivityService;
import com.isobar.isohealth.services.StrengthTrainingActivityService;

public class StrengthTrainingActivityServiceTest extends TestCase {

	public void testGetStrengthTrainingActivityFeed() {
		try {
			StrengthTrainingActivityFeed strengthTrainingActivityFeed = StrengthTrainingActivityService.getStrengthTrainingActivityFeed(GraphConstants.AUTH_CODE);
			System.out.println("StrengthTrainingActivityFeed: " + strengthTrainingActivityFeed.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testGetStrengthTrainingActivity() {
		try {
			StrengthTrainingActivityFeed strengthTrainingActivityFeed = StrengthTrainingActivityService.getStrengthTrainingActivityFeed(GraphConstants.AUTH_CODE);
			List<StrengthTrainingActivity> strengthTrainingActivities =  new ArrayList<StrengthTrainingActivity>();
			for (Item item : strengthTrainingActivityFeed.getItems()) {
				StrengthTrainingActivity activity = StrengthTrainingActivityService.getStrengthTrainingActivity(item.getUri(),GraphConstants.AUTH_CODE);
				System.out.println("StrengthTrainingActivity: " + activity.toString());
				strengthTrainingActivities.add(activity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
