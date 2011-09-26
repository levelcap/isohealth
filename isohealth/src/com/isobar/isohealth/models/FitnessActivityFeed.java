package com.isobar.isohealth.models;

import java.util.Arrays;

public class FitnessActivityFeed {
	public static class Item {
		private String _type; //The type of activity, as one of the following values: "Running", "Cycling", "Mountain Biking", "Walking", "Hiking", "Downhill Skiing", "Cross-Country Skiing", "Snowboarding", "Skating", "Swimming", "Wheelchair", "Rowing", "Elliptical", "Other"
		private String _start_time; //The starting time for the activity (e.g., "Sat, 1 Jan 2011 00:00:00")
		private Double _total_distance; //The total distance for the activity, in meters
		private Double _duration; //The duration of the activity, in seconds
		private String _uri; //The URI of the detailed information for the past activity
		
		public String getType() {
			return _type;
		}
		public void setType(String type) {
			this._type = type;
		}
		public String getStart_time() {
			return _start_time;
		}
		public void setStart_time(String start_time) {
			this._start_time = start_time;
		}
		public Double getTotal_distance() {
			return _total_distance;
		}
		public void setTotal_distance(Double total_distance) {
			this._total_distance = total_distance;
		}
		public Double getDuration() {
			return _duration;
		}
		public void setDuration(Double duration) {
			this._duration = duration;
		}
		public String getUri() {
			return _uri;
		}
		public void setUri(String uri) {
			this._uri = uri;
		}
		
		@Override
		public String toString() {
			return "Item [_type=" + _type + ", _start_time=" + _start_time
					+ ", _total_distance=" + _total_distance + ", _duration="
					+ _duration + ", _uri=" + _uri + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((_duration == null) ? 0 : _duration.hashCode());
			result = prime * result
					+ ((_start_time == null) ? 0 : _start_time.hashCode());
			result = prime
					* result
					+ ((_total_distance == null) ? 0 : _total_distance
							.hashCode());
			result = prime * result + ((_type == null) ? 0 : _type.hashCode());
			result = prime * result + ((_uri == null) ? 0 : _uri.hashCode());
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
			if (_duration == null) {
				if (other._duration != null)
					return false;
			} else if (!_duration.equals(other._duration))
				return false;
			if (_start_time == null) {
				if (other._start_time != null)
					return false;
			} else if (!_start_time.equals(other._start_time))
				return false;
			if (_total_distance == null) {
				if (other._total_distance != null)
					return false;
			} else if (!_total_distance.equals(other._total_distance))
				return false;
			if (_type == null) {
				if (other._type != null)
					return false;
			} else if (!_type.equals(other._type))
				return false;
			if (_uri == null) {
				if (other._uri != null)
					return false;
			} else if (!_uri.equals(other._uri))
				return false;
			return true;
		}
	}
	
	private Integer _size; //The total number of fitness activities across all pages;
	private Item[] _items; //The user's activities, from newest to oldest
	private String _previous; //The URI of the previous page in the user's feed (omitted for the oldest page)
	private String _next; 	//The URI of the next page in the user's feed (omitted for the newest page)
	
	public FitnessActivityFeed() {
		
	}
	
	public Integer getSize() {
		return _size;
	}
	public void setSize(Integer size) {
		this._size = size;
	}
	public Item[] getItems() {
		return _items;
	}
	public void setItems(Item[] items) {
		this._items = items;
	}
	public String getPrevious() {
		return _previous;
	}
	public void setPrevious(String previous) {
		this._previous = previous;
	}
	public String getNext() {
		return _next;
	}
	public void setNext(String next) {
		this._next = next;
	}

	@Override
	public String toString() {
		return "FitnessActivityFeed [_size=" + _size + ", _items="
				+ Arrays.toString(_items) + ", _previous=" + _previous
				+ ", _next=" + _next + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(_items);
		result = prime * result + ((_next == null) ? 0 : _next.hashCode());
		result = prime * result
				+ ((_previous == null) ? 0 : _previous.hashCode());
		result = prime * result + ((_size == null) ? 0 : _size.hashCode());
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
		FitnessActivityFeed other = (FitnessActivityFeed) obj;
		if (!Arrays.equals(_items, other._items))
			return false;
		if (_next == null) {
			if (other._next != null)
				return false;
		} else if (!_next.equals(other._next))
			return false;
		if (_previous == null) {
			if (other._previous != null)
				return false;
		} else if (!_previous.equals(other._previous))
			return false;
		if (_size == null) {
			if (other._size != null)
				return false;
		} else if (!_size.equals(other._size))
			return false;
		return true;
	}
}
