package com.isobar.isohealth.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class StreetTeamInvite {
	private Integer userID; // The ID of the user to invite

	public StreetTeamInvite() {
		super();
	}
	public StreetTeamInvite(Integer userID) {
		super();
		this.userID = userID;
	}
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StreetTeamInvite other = (StreetTeamInvite) obj;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StreetTeamInvite [userID=" + userID + "]";
	}
}
