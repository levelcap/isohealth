package com.isobar.isohealth.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class StreetTeamInviteReply {
	private String reply; // One of the following values: "accepted", "declined", "ignored"

	public StreetTeamInviteReply() {
		super();
	}
	public StreetTeamInviteReply(String reply) {
		super();
		this.reply = reply;
	}

	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	@Override
	public String toString() {
		return "StreetTeamInviteReply [reply=" + reply + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reply == null) ? 0 : reply.hashCode());
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
		StreetTeamInviteReply other = (StreetTeamInviteReply) obj;
		if (reply == null) {
			if (other.reply != null)
				return false;
		} else if (!reply.equals(other.reply))
			return false;
		return true;
	}
}
