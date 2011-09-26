package test.com.isobar.isohealth;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.Settings;
import com.isobar.isohealth.services.SettingsService;

public class SettingsServiceTest extends TestCase {

	public void testGetSettings() {
		try {
			Settings settings = SettingsService.getSettings(GraphConstants.AUTH_CODE);
			System.out.println("Settings: " + settings.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
