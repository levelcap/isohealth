package com.isobar.isohealth.models;

import java.util.Arrays;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class BackgroundActivityFeed {
	public static class Item {
		private String timestamp; //The timestamp for the activity (e.g., "Sat, 1 Jan 2011 00:00:00")
		private Double calories_burned;  //Either this or steps will exist
		private Double steps;
		private String uri; //The URI of detailed information for the activity
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public Double getCalories_burned() {
			return calories_burned;
		}
		public void setCalories_burned(Double calories_burned) {
			this.calories_burned = calories_burned;
		}
		public Double getSteps() {
			return steps;
		}
		public void setSteps(Double steps) {
			this.steps = steps;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		
		@Override
		public String toString() {
			return "Item [timestamp=" + timestamp + ", calories_burned="
					+ calories_burned + ", steps=" + steps + ", uri=" + uri
					+ "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((calories_burned == null) ? 0 : calories_burned
							.hashCode());
			result = prime * result + ((steps == null) ? 0 : steps.hashCode());
			result = prime * result
					+ ((timestamp == null) ? 0 : timestamp.hashCode());
			result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
			if (calories_burned == null) {
				if (other.calories_burned != null)
					return false;
			} else if (!calories_burned.equals(other.calories_burned))
				return false;
			if (steps == null) {
				if (other.steps != null)
					return false;
			} else if (!steps.equals(other.steps))
				return false;
			if (timestamp == null) {
				if (other.timestamp != null)
					return false;
			} else if (!timestamp.equals(other.timestamp))
				return false;
			if (uri == null) {
				if (other.uri != null)
					return false;
			} else if (!uri.equals(other.uri))
				return false;
			return true;
		}
	}
	private Integer size; //The total number of fitness activities across all pages
	private Item[] items; //The user's activities, from newest to oldest
	private String previous; //The URI of the previous page in the user's history (omitted for the oldest page)
	private String next; //The URI of the next page in the user's history (omitted for the newest page)
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
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "BackgroundActivity [size=" + size + ", items="
				+ Arrays.toString(items) + ", previous=" + previous + ", next="
				+ next + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(items);
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
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
		BackgroundActivityFeed other = (BackgroundActivityFeed) obj;
		if (!Arrays.equals(items, other.items))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (previous == null) {
			if (other.previous != null)
				return false;
		} else if (!previous.equals(other.previous))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
}
