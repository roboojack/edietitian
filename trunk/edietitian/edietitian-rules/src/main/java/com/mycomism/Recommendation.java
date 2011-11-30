/**
 * This is the superclass from which recommendation object inherit from.
 * 
 * It would be nice if a recommendation had a source attribute (like a URL, book reference) 
 * that a user could refer to for more information. 
 * 
 * @author Robert Jackson
 * 
 */
package com.mycomism;

public class Recommendation {
	public enum Priority {
		HIGH,
		MEDIUM,
		LOW
	}
	
	private String id;
	private String recommendationText;
	private Priority priority;
	private Source source;

	/**
	 * source   = null
	 * id       = null
	 * priority = null
	 * 
	 * @param recommendationText
	 */
	public Recommendation(String recommendationText) {
		this.id = null;
		this.recommendationText = recommendationText;
	}

	/**
	 * priority = null
	 * source   = null
	 * 
	 * @param id
	 * @param recommendationText
	 */
	public Recommendation(String id, String recommendationText) {
		this.priority = Priority.LOW;
		this.id = id;
		this.recommendationText = recommendationText;
		this.source = null;
	}
	
	public Recommendation(String id, Priority priority, String recommendationText, Source source) {
		this.id = id;
		this.priority = priority;
		this.recommendationText = recommendationText;
		this.source = source;
	}

	
	
	public void setRecommendationText(String recommendationText) {
		this.recommendationText = recommendationText;
	}

	public String getRecommendationText() {
		return recommendationText;
	}

	@Override
	public String toString() {
		if(source != null)
			return recommendationText + source.toString();
		else
			return recommendationText;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((recommendationText == null) ? 0 : recommendationText
						.hashCode());
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
		Recommendation other = (Recommendation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (recommendationText == null) {
			if (other.recommendationText != null)
				return false;
		} else if (!recommendationText.equals(other.recommendationText))
			return false;
		return true;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public Source getSource() {
		return source;
	}
	
	

}
