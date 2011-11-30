/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * 
 * This is a simple servlet that will dump the facts and recommendations to a simple HTML document
 * 
 * @author Robert Jackson
 */

package com.mycomism;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.drools.common.InternalFactHandle;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.tohu.util.QueryHelper;

import drools.rex.ExecutionServerHelper;

/**
 * Servlet that extracts the results of the questions, facts, and answers from
 * the knowledge session, then outputs to objects into a jsp.
 * 
 * @author Robert Jackson
 */
public class RecommendationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Vector<EatingRecommendation> eatingRecommendations;
	private Vector<ExerciseRecommendation> exerciseRecommendations;
	private Vector<OtherRecommendation> otherRecommendations;


	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// output log data to terminal
		logToStdOut(request);

		// get the drools knowledge session from the request
		StatefulKnowledgeSession knowledgeSession = new ExecutionServerHelper(
				request.getSession()).getKnowledgeSession();

		// get the answer, recommendation, and sfact objects
		Map<String, Object> answers = new QueryHelper(knowledgeSession)
				.getAnswers();

		// put objects into similar collections
		getRecommendationObjects(knowledgeSession);
		Vector<SFact> sfacts = getSFactObjects(knowledgeSession);

		// put the collections into the request object
		request.setAttribute("eatingRecommendations", eatingRecommendations);
		request.setAttribute("exerciseRecommendations", exerciseRecommendations);
		request.setAttribute("otherRecommendations", otherRecommendations);
		request.setAttribute("sfacts", sfacts);
		request.setAttribute("answers", answers);

		// forward the request with the data objectd into the view jsp
		RequestDispatcher view = request
				.getRequestDispatcher("recommendations.jsp");
		view.forward(request, response);
	}

	/**
	 * This just outputs some logging data to STDOUT 
	 * 	 	What time that submitted the data
	 * 		their ip address
	 *  
	 * @param request
	 */
	private void logToStdOut(HttpServletRequest request) {
		System.out.println("*** NEW RECOMMENDATION BEING SERVED ***");		
		System.out.println("\tTime          : " + new Date());
		System.out.println("\tRemote address: " + request.getRemoteAddr());
		System.out.println(request.toString());
		System.out.println("*** END NEW RECOMMENDATION BEING SERVED ***");				
	}

	/**
	 * Returns a collection of recommendation objects from the edietitian
	 * knowledge session *
	 * 
	 * @param knowledgeSession
	 * @return
	 */
	private void getRecommendationObjects(
			StatefulKnowledgeSession knowledgeSession) {
		// clear the recommendation collections
		eatingRecommendations = new Vector<EatingRecommendation>();
		exerciseRecommendations = new Vector<ExerciseRecommendation>();
		otherRecommendations = new Vector<OtherRecommendation>();

		for (FactHandle factHandle : knowledgeSession.getFactHandles()) {
			InternalFactHandle internalFactHandle = (InternalFactHandle) factHandle;
			Object object = internalFactHandle.getObject();

//			if (object instanceof ExerciseRecommendation) {
//				ExerciseRecommendation rec = (ExerciseRecommendation) object;
//				exerciseRecommendations.add(new ExerciseRecommendation(rec.getRecommendationText()));
//			}
//			else if (object instanceof EatingRecommendation) {
//				EatingRecommendation rec = (EatingRecommendation) object;
//				eatingRecommendations.add(new EatingRecommendation(rec.getRecommendationText()));
//			}
//			else if (object instanceof OtherRecommendation) {
//				OtherRecommendation rec = (OtherRecommendation) object;
//				otherRecommendations.add(new OtherRecommendation(rec.getRecommendationText()));
//			}

			if (object instanceof ExerciseRecommendation) {
				ExerciseRecommendation rec = (ExerciseRecommendation) object;
				exerciseRecommendations.add(rec);
			}
			else if (object instanceof EatingRecommendation) {
				EatingRecommendation rec = (EatingRecommendation) object;
				eatingRecommendations.add(rec);
			}
			else if (object instanceof OtherRecommendation) {
				OtherRecommendation rec = (OtherRecommendation) object;
				otherRecommendations.add(rec);
			}
		}
	}

	/**
	 * Returns a collection of Simple Fact objects from the edietitian knowledge
	 * session *
	 * 
	 * @param knowledgeSession
	 * @return
	 */
	private Vector<SFact> getSFactObjects(
			StatefulKnowledgeSession knowledgeSession) {
		Vector<SFact> objects = new Vector<SFact>();
		Vector<String> recommendationObjects = new Vector<String>(); 

		for (FactHandle factHandle : knowledgeSession.getFactHandles()) {
			InternalFactHandle internalFactHandle = (InternalFactHandle) factHandle;
			Object object = internalFactHandle.getObject();
			recommendationObjects.add(object.toString());
//			System.out.println(object.toString());
			if (object instanceof SFact) {
				SFact rec = (SFact) object;
				//if(!objects.contains(rec)) // only insert the fact once
					objects.add(new SFact(rec));
			}
		}
		
		Collections.sort(recommendationObjects);
		for (String string : recommendationObjects) {
			System.out.println(string);			
		}


		return objects;
	}

}
