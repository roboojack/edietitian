/*
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
 */

package org.tohu.examples.branching.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.drools.common.InternalFactHandle;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.tohu.util.QueryHelper;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mycomism.Recommendation;
import com.mycomism.SFact;

import drools.rex.ExecutionServerHelper;

/**
 * Example of how you could extract the questions and their answers out. This calls the execution server and uses the output to
 * generate a simple PDF.
 *
 * @author Damon Horrell
 */
public class PdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StatefulKnowledgeSession knowledgeSession = new ExecutionServerHelper(request.getSession()).getKnowledgeSession();
		// get the answer, recommendation, and sfact objects
		Map<String, Object> answers = new QueryHelper(knowledgeSession).getAnswers();
		Collection<Object> persistObjects = new QueryHelper(knowledgeSession).getPersistentObjects();
		
		Vector<Recommendation> recommendations = getRecommendationObjects(knowledgeSession);//new Vector<Recommendation>(); 
		
		Vector<SFact> sfacts = new Vector<SFact>(); 
		// put objects into similar collections
		for (Object object : persistObjects) {
			if(object instanceof Recommendation)
				recommendations.add((Recommendation) object);
			if(object instanceof SFact)
				sfacts.add((SFact) object);
		}
		
		try {
			Document document = new Document();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			document.open();
			Paragraph title = new Paragraph("eDietitian Session Data");
			title.setAlignment("center");
			document.add(title);
			
			// insert answer data table
			document.add(new Paragraph(" "));
			PdfPTable table = new PdfPTable(2);
			for (Map.Entry<String, Object> entry : answers.entrySet()) {
				table.addCell(entry.getKey());
				table.addCell(entry.getValue().toString());
			}
			document.add(table);
			
			// insert sfacts table
			document.add(new Paragraph(" "));
			table = new PdfPTable(2);
			for (SFact sfact : sfacts) {
				table.addCell(sfact.getId());
				table.addCell(sfact.toString());
			}
			document.add(table);
			
			// insert recommendation table
			document.add(new Paragraph(" "));
			table = new PdfPTable(1);
			for (Recommendation recommendation : recommendations) {
				table.addCell(recommendation.toString());
			}
			document.add(table);

			// insert timestamp
			document.add(new Paragraph(" "));
			document.add(new Paragraph(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime())));
			document.close();
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			ServletOutputStream out = response.getOutputStream();
			baos.writeTo(out);
			out.flush();
		} catch (DocumentException e) {
			throw new ServletException(e);
		}
	}
	
	

	/**
	 * Returns a collection of recommendation objects from the edietitian knowledge session
	 *	 *
	 * @param knowledgeSession 
	 * @return
	 */
	private Vector<Recommendation> getRecommendationObjects(StatefulKnowledgeSession knowledgeSession) {
		Vector<Recommendation> objects = new Vector<Recommendation>();
		for (FactHandle factHandle : knowledgeSession.getFactHandles()) {
			InternalFactHandle internalFactHandle = (InternalFactHandle) factHandle;
			Object object = internalFactHandle.getObject();
			System.out.println(object.toString());
			if (object instanceof Recommendation) {
				Recommendation rec = (Recommendation)object;
				objects.add(new Recommendation(
						rec.getRecommendationText()
				));
			}
		}
		return objects;
	}

}
