/**
 * This class is a type of recommendation that has to do with improving a
 * person's exercise habits.
 * 
 * @author Robert Jackson
 * 
 */

package com.mycomism;

 

public class ExerciseRecommendation extends Recommendation {

	/**
	 * @param recommendationText
	 */
	public ExerciseRecommendation(String recommendationText) {
		super(recommendationText);
		// TODO Auto-generated constructor stub
	}
	
	public ExerciseRecommendation(String id, String recommendationText) {
		super(id, recommendationText);
	}
	public ExerciseRecommendation(String id, Priority priority, String recommendationText, Source source) {
		super(id, priority, recommendationText, source);
	}

	
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


}
