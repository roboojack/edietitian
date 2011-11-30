/**
 * This class is a type of recommendation that has to do with improving a
 * person's habits that are not eating or exercise related, ie stop smoking,
 * cut back on drinking, etc.
 * 
 * @author Robert Jackson
 * 
 */
package com.mycomism;


public class OtherRecommendation extends Recommendation {

	/**
	 * @param recommendationText
	 */
	public OtherRecommendation(String recommendationText) {
		super(recommendationText);
		// TODO Auto-generated constructor stub
	}

	public OtherRecommendation(String id, String recommendationText) {
		super(id, recommendationText);
	}

	public OtherRecommendation(String id, Priority priority, String recommendationText, Source source) {
		super(id, priority, recommendationText, source);
	}

//	@Override
//	public String toString() {
//		return super.toString();
//	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
