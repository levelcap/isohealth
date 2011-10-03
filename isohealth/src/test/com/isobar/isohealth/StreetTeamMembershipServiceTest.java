package test.com.isobar.isohealth;

import junit.framework.TestCase;

import com.isobar.isohealth.GraphConstants;
import com.isobar.isohealth.models.StreetTeamInvite;
import com.isobar.isohealth.models.StreetTeamInviteReply;
import com.isobar.isohealth.models.StreetTeamMember;
import com.isobar.isohealth.models.StreetTeamMembershipFeed;
import com.isobar.isohealth.wrappers.RunkeeperService;
import com.isobar.isohealth.wrappers.StreetTeamMembershipWrapper;

public class StreetTeamMembershipServiceTest extends TestCase {

	StreetTeamMembershipWrapper streetTeamMembershipWrapper;
	StreetTeamMembershipFeed streetTeamMembershipFeed;
	
	protected void setUp() {
    	RunkeeperService runkeeperService = new RunkeeperService(GraphConstants.AUTH_CODE);
    	streetTeamMembershipWrapper = runkeeperService.streetTeamMembershipWrapper;
    	try {
    		streetTeamMembershipFeed = streetTeamMembershipWrapper.getStreetTeamMembershipFeed();
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    }
	
	public void testGetStreetTeamMembershipFeed() {
		try {
			System.out.println("StreetTeamMembershipFeed: " + streetTeamMembershipFeed);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testInviteUser() {
		try {
			StreetTeamInvite invitation = new StreetTeamInvite(4558292);

			streetTeamMembershipWrapper.inviteUser(invitation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testReplyToInvite() {
		try {
			String teamId = "0987654321";
			StreetTeamInviteReply streetTeamInviteReply = new StreetTeamInviteReply("accepted");
			StreetTeamMember streetTeamMember = streetTeamMembershipWrapper.replyToInvite(teamId, streetTeamInviteReply);
			System.out.println("ReplyToInvite: "+ streetTeamMember);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testRemoveUser() {
		try {
			String teamId = "0987654321";
			boolean response = streetTeamMembershipWrapper.removeUser(teamId);
			System.out.println("RemoveUser: "+ response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
