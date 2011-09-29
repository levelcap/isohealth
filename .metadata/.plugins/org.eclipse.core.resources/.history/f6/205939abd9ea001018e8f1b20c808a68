package com.isobar.isohealth.models;

import java.util.Arrays;

public class NutritionMeasurementFeed {
	private Integer size; // The total number of nutrition measurements across all pages
	private Item[] items; // The user's nutrition measurements, in reverse chronological order
	private String previous; // The URI of the previous page of nutrition measurements for the user (omitted for the earliest page)
	private String next; // The URI of the next page of nutrition measurements for the user (omitted for the most recent page)
	
	public static class Item {
		private String timestamp; // The time at which the measurement was taken (e.g., "Sat, 1 Jan 2011 00:00:00")
		
		//One of the following values: calories, carbohydrates, fat, fiber, protein, sodium, water
		private Double calories; // The value of the measured quantity
		private Double carbohydrates; // The value of the measured quantity
		private Double fat; // The value of the measured quantity
		private Double fiber; // The value of the measured quantity
		private Double protein; // The value of the measured quantity
		private Double sodium; // The value of the measured quantity
		private Double water; // The value of the measured quantity
		
		private String uri; // The URI of detailed information for the nutrition measurement

		public Item(String timestamp, Double calories, Double carbohydrates,
				Double fat, Double fiber, Double protein, Double sodium,
				Double water, String uri) {
			super();
			this.timestamp = timestamp;
			this.calories = calories;
			this.carbohydrates = carbohydrates;
			this.fat = fat;
			this.fiber = fiber;
			this.protein = protein;
			this.sodium = sodium;
			this.water = water;
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
		public Double getCalories() {
			return calories;
		}
		public void setCalories(Double calories) {
			this.calories = calories;
		}
		public Double getCarbohydrates() {
			return carbohydrates;
		}
		public void setCarbohydrates(Double carbohydrates) {
			this.carbohydrates = carbohydrates;
		}
		public Double getFat() {
			return fat;
		}
		public void setFat(Double fat) {
			this.fat = fat;
		}
		public Double getFiber() {
			return fiber;
		}
		public void setFiber(Double fiber) {
			this.fiber = fiber;
		}
		public Double getProtein() {
			return protein;
		}
		public void setProtein(Double protein) {
			this.protein = protein;
		}
		public Double getSodium() {
			return sodium;
		}
		public void setSodium(Double sodium) {
			this.sodium = sodium;
		}
		public Double getWater() {
			return water;
		}
		public void setWater(Double water) {
			this.water = water;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		@Override
		public String toString() {
			return "Item [timestamp=" + timestamp + ", calories=" + calories
					+ ", carbohydrates=" + carbohydrates + ", fat=" + fat
					+ ", fiber=" + fiber + ", protein=" + protein + ", sodium="
					+ sodium + ", water=" + water + ", uri=" + uri + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((calories == null) ? 0 : calories.hashCode());
			result = prime * result
					+ ((carbohydrates == null) ? 0 : carbohydrates.hashCode());
			result = prime * result + ((fat == null) ? 0 : fat.hashCode());
			result = prime * result + ((fiber == null) ? 0 : fiber.hashCode());
			result = prime * result
					+ ((protein == null) ? 0 : protein.hashCode());
			result = prime * result
					+ ((sodium == null) ? 0 : sodium.hashCode());
			result = prime * result
					+ ((timestamp == null) ? 0 : timestamp.hashCode());
			result = prime * result + ((uri == null) ? 0 : uri.hashCode());
			result = prime * result + ((water == null) ? 0 : water.hashCode());
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
			if (calories == null) {
				if (other.calories != null)
					return false;
			} else if (!calories.equals(other.calories))
				return false;
			if (carbohydrates == null) {
				if (other.carbohydrates != null)
					return false;
			} else if (!carbohydrates.equals(other.carbohydrates))
				return false;
			if (fat == null) {
				if (other.fat != null)
					return false;
			} else if (!fat.equals(other.fat))
				return false;
			if (fiber == null) {
				if (other.fiber != null)
					return false;
			} else if (!fiber.equals(other.fiber))
				return false;
			if (protein == null) {
				if (other.protein != null)
					return false;
			} else if (!protein.equals(other.protein))
				return false;
			if (sodium == null) {
				if (other.sodium != null)
					return false;
			} else if (!sodium.equals(other.sodium))
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
			if (water == null) {
				if (other.water != null)
					return false;
			} else if (!water.equals(other.water))
				return false;
			return true;
		}
	}

	public NutritionMeasurementFeed(Integer size, Item[] items,
			String previous, String next) {
		super();
		this.size = size;
		this.items = items;
		this.previous = previous;
		this.next = next;
	}
	public NutritionMeasurementFeed() {
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
	public String toString() {
		return "NutritionMeasurementFeed [size=" + size + ", items="
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
		NutritionMeasurementFeed other = (NutritionMeasurementFeed) obj;
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
