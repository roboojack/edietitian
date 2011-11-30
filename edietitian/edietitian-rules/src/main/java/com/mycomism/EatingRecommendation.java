/**
 * This class is a type of recommendation that has to do with improving a
 * person's eating habits.
 * 
 * @author Robert Jackson
 * 
 */
package com.mycomism;


public class EatingRecommendation extends Recommendation {

	@Override
	public String toString() {
		return super.toString();
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}


	/**
	 * @param recommendationText
	 */
	public EatingRecommendation(String recommendationText) {
		super(recommendationText);
		// TODO Auto-generated constructor stub
	}

	public EatingRecommendation(String id, String recommendationText) {
		super(id, recommendationText);
	}

	public EatingRecommendation(String id, Priority priority, String recommendationText, Source source) {
		super(id, priority, recommendationText, source);
	}

	
}
