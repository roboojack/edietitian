package com.mycomism.drools;

import org.drools.event.rule.DefaultWorkingMemoryEventListener;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;

import com.mycomism.Recommendation;
import com.mycomism.SFact;





public class MyWorkingMemoryEventListener extends DefaultWorkingMemoryEventListener{

	public final static boolean SHOW_ALL_MEMORY_OBJECTS_IN_LOG = true;
	
	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		if(!isObjectOfInterest(event.getObject())) return;
		logToConsole("*** OBJECT INSERTED : " + event.getObject().toString());
		super.objectInserted(event);
	}
	@Override
	public void objectRetracted(ObjectRetractedEvent event) {
		if(!isObjectOfInterest(event.getOldObject())) return;
		logToConsole("*** OBJECT RETRACTED: " + event.getOldObject().toString());
		super.objectRetracted(event);
	}
	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {
		if(!isObjectOfInterest(event.getObject())) return;
		logToConsole("*** OBJECT UPDATED  : \n" + 
					 "	         OLD STATE: " + event.getOldObject().toString() + "\n" + 
			         "	         NEW STATE: " + event.getObject().toString() 
		);
		super.objectUpdated(event);
	}

	private void logToConsole(String output){
		System.err.println(output);
	}

	/**
	 * this is used if we're only interested in the SFact objects in the log 
	 */
	private boolean isObjectOfInterest(Object object) {
		// check if verbose logging is active
		if(SHOW_ALL_MEMORY_OBJECTS_IN_LOG == true)
			return true;
		
		if(object instanceof SFact)
			return true;
		else if(object instanceof Recommendation)
			return true;
		return false;
	}

}
