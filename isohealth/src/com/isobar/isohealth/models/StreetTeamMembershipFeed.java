package com.isobar.isohealth.models;

import java.util.Arrays;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class StreetTeamMembershipFeed {
	private Integer size; // The total number of members on the Street Team (i.e., across all pages)
	private Item[] items; // An array of up to 25 elements, with one element per member
	private String next;  // The URI for the next page of members (omitted from the last page)
	
	public StreetTeamMembershipFeed() {
		super();
	}
	public StreetTeamMembershipFeed(Integer size, Item[] items, String next) {
		super();
		this.size = size;
		this.items = items;
		this.next = next;
	}
	
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(items);
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		StreetTeamMembershipFeed other = (StreetTeamMembershipFeed) obj;
		if (!Arrays.equals(items, other.items))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StreetTeamMembershipFeed [size=" + size + ", items="
				+ Arrays.toString(items) + ", next=" + next + "]";
	}


	public static class Item {
		private String name;    // The member's full name
		private String profile; // The URL of the member's public, human-readable profile on the RunKeeper website
		private String url;     // A URI for detailed information about the member, including membership status
		
		public Item() {
			super();
		}
		public Item(String name, String profile, String url) {
			super();
			this.name = name;
			this.profile = profile;
			this.url = url;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getProfile() {
			return profile;
		}
		public void setProfile(String profile) {
			this.profile = profile;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result
					+ ((profile == null) ? 0 : profile.hashCode());
			result = prime * result + ((url == null) ? 0 : url.hashCode());
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
			Item other = (Item) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (profile == null) {
				if (other.profile != null)
					return false;
			} else if (!profile.equals(other.profile))
				return false;
			if (url == null) {
				if (other.url != null)
					return false;
			} else if (!url.equals(other.url))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Item [name=" + name + ", profile=" + profile + ", uri="
					+ url + "]";
		}
	}
}
