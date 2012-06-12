package test.com.isobar.isohealth;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.BackgroundActivity;
import com.isobar.isohealth.models.BackgroundActivityFeed;
import com.isobar.isohealth.models.BackgroundActivityFeed.Item;
import com.isobar.isohealth.models.NewBackgroundActivity;
import com.isobar.isohealth.wrappers.BackgroundActivityWrapper;
import com.isobar.isohealth.wrappers.RunkeeperService;

public class BackgroundActivityServiceTest extends TestCase {
	BackgroundActivityWrapper backgroundActivityWrapper;
	BackgroundActivityFeed backgroundActivityFeed;

	@Override
	protected void setUp() {
    	RunkeeperService runkeeperService = new RunkeeperService(GraphConstants.AUTH_CODE);
    	backgroundActivityWrapper = runkeeperService.backgroundActivityWrapper;
    	try {
    		backgroundActivityFeed = backgroundActivityWrapper.getBackgroundActivityFeed();
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    }

	public void testGetBackgroundActivityFeed() {
		try {
//			BackgroundActivityFeed backgroundActivityFeed = backgroundActivityWrapper.getBackgroundActivityFeed();
			System.out.println("BackgroundActivityFeed: " + backgroundActivityFeed.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testGetBackgroundActivity() {
		try {
			List<BackgroundActivity> backgroundActivities =  new ArrayList<BackgroundActivity>();
			//for (Item item : backgroundActivityFeed.getItems()) {
				Item[] items = backgroundActivityFeed.getItems();
				Item item = items[items.length-1]; 
				BackgroundActivity activity = backgroundActivityWrapper.getBackgroundActivity(item.getUri());
				System.out.println("BackgroundActivity: " + activity.toString());
				backgroundActivities.add(activity);
			//}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testCreateNewBackgroundActivity() {
		try {
		  NewBackgroundActivity activity = new NewBackgroundActivity();
		  activity.setSteps(1000d);
		  activity.setTimestamp("Wed, 5 Jan 2011 07:03:00");  
		  
		  backgroundActivityWrapper.createBackgroundActivity(activity);
		  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testUpdateBackgroundActivity() {
		try {
//			BackgroundActivityFeed backgroundActivityFeed = backgroundActivityWrapper.getBackgroundActivityFeed();
			for (Item item : backgroundActivityFeed.getItems()) {
				BackgroundActivity activity = backgroundActivityWrapper.getBackgroundActivity(item.getUri());
				System.out.println("Activity: " + activity);
				activity.setSteps(1200d);
				activity = backgroundActivityWrapper.updateBackgroundActivity(activity);
				System.out.println("Updated activity: " + activity);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
}
