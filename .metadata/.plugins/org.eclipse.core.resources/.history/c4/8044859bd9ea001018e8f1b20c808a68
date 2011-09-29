package com.isobar.isohealth.models;

import java.util.Arrays;

public class SleepMeasurementFeed {
	private Integer size; // The total number of sleep measurements across all pages
	private Item[] items; // The user's sleep measurements, in reverse chronological order
	private String previous; // The URI of the previous page of sleep measurements for the user (omitted for the earliest page)
	private String next; // The URI of the next page of sleep measurements for the user (omitted for the most recent page)
	
	public SleepMeasurementFeed(Integer size, Item[] items, String previous,
			String next) {
		super();
		this.size = size;
		this.items = items;
		this.previous = previous;
		this.next = next;
	}
	public SleepMeasurementFeed() {
		super();
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
		SleepMeasurementFeed other = (SleepMeasurementFeed) obj;
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
	@Override
	public String toString() {
		return "SleepMeasurementFeed [size=" + size + ", items="
				+ Arrays.toString(items) + ", previous=" + previous + ", next="
				+ next + "]";
	}

	public static class Item {
		private String timestamp; // The time at which the measurement was taken (e.g., "Sat, 1 Jan 2011 00:00:00")
		
		//One of the following values: total_sleep, rem, deep, light, times_woken, awake
		private Double total_sleep; // The value of the measured quantity (durational measurements are given in minutes)
		private Double rem; // The value of the measured quantity (durational measurements are given in minutes)
		private Double deep; // The value of the measured quantity (durational measurements are given in minutes)
		private Double light; // The value of the measured quantity (durational measurements are given in minutes)
		private Double times_woken; // The value of the measured quantity (durational measurements are given in minutes)
		private Double awake; // The value of the measured quantity (durational measurements are given in minutes)
		
		private String uri; // The URI of detailed information for the sleep measurement

		public Item(String timestamp, Double total_sleep, Double rem,
				Double deep, Double light, Double times_woken, Double awake,
				String uri) {
			super();
			this.timestamp = timestamp;
			this.total_sleep = total_sleep;
			this.rem = rem;
			this.deep = deep;
			this.light = light;
			this.times_woken = times_woken;
			this.awake = awake;
			this.uri = uri;
		}
		public Item() {
			super();
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public Double getTotal_sleep() {
			return total_sleep;
		}
		public void setTotal_sleep(Double total_sleep) {
			this.total_sleep = total_sleep;
		}
		public Double getRem() {
			return rem;
		}
		public void setRem(Double rem) {
			this.rem = rem;
		}
		public Double getDeep() {
			return deep;
		}
		public void setDeep(Double deep) {
			this.deep = deep;
		}
		public Double getLight() {
			return light;
		}
		public void setLight(Double light) {
			this.light = light;
		}
		public Double getTimes_woken() {
			return times_woken;
		}
		public void setTimes_woken(Double times_woken) {
			this.times_woken = times_woken;
		}
		public Double getAwake() {
			return awake;
		}
		public void setAwake(Double awake) {
			this.awake = awake;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		@Override
		public String toString() {
			return "Item [timestamp=" + timestamp + ", total_sleep="
					+ total_sleep + ", rem=" + rem + ", deep=" + deep
					+ ", light=" + light + ", times_woken=" + times_woken
					+ ", awake=" + awake + ", uri=" + uri + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((awake == null) ? 0 : awake.hashCode());
			result = prime * result + ((deep == null) ? 0 : deep.hashCode());
			result = prime * result + ((light == null) ? 0 : light.hashCode());
			result = prime * result + ((rem == null) ? 0 : rem.hashCode());
			result = prime * result
					+ ((times_woken == null) ? 0 : times_woken.hashCode());
			result = prime * result
					+ ((timestamp == null) ? 0 : timestamp.hashCode());
			result = prime * result
					+ ((total_sleep == null) ? 0 : total_sleep.hashCode());
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
			if (awake == null) {
				if (other.awake != null)
					return false;
			} else if (!awake.equals(other.awake))
				return false;
			if (deep == null) {
				if (other.deep != null)
					return false;
			} else if (!deep.equals(other.deep))
				return false;
			if (light == null) {
				if (other.light != null)
					return false;
			} else if (!light.equals(other.light))
				return false;
			if (rem == null) {
				if (other.rem != null)
					return false;
			} else if (!rem.equals(other.rem))
				return false;
			if (times_woken == null) {
				if (other.times_woken != null)
					return false;
			} else if (!times_woken.equals(other.times_woken))
				return false;
			if (timestamp == null) {
				if (other.timestamp != null)
					return false;
			} else if (!timestamp.equals(other.timestamp))
				return false;
			if (total_sleep == null) {
				if (other.total_sleep != null)
					return false;
			} else if (!total_sleep.equals(other.total_sleep))
				return false;
			if (uri == null) {
				if (other.uri != null)
					return false;
			} else if (!uri.equals(other.uri))
				return false;
			return true;
		}
	}
}
