/**
 * This file just contains some constants for the edietitian website, eg menu buttons and header and 
 * footer templates.
 */
package com.mycomism.edietitian.web;


/**
 * $Date: 2011-10-24 14:55:09 -0500 (Mon, 24 Oct 2011) $
 * $Revision: 174 $
 * $Author: robjackAdmin $
 * $Id: PageConstants.java 174 2011-10-24 19:55:09Z robjackAdmin $
 * 
 * @author Robert Jackson
 *
 */
public final class PageConstants {
	
	public static final double VERSION_NUMBER = 1.07;
	
	
	public static final String EDIETITIAN_ROOT = "/edietitian-web";
	public static final String HOME_URL = EDIETITIAN_ROOT + "/index.jsp";
	public static final String FEEDBACK_URL = EDIETITIAN_ROOT + "/index.jsp?pageId=feedback";
	public static final String PRIVACY_STATEMENT_URL = EDIETITIAN_ROOT + "/index.jsp?pageId=privacyStatement";
	
	
	public static final String MENU_ITEMS = 
		"<div id=\"menu\">" +
			"<ul>" +
				"<li><a href=\"" + HOME_URL + "\">Home</a></li>" +
			"</ul>" +
			"<ul>" +
				"<li><a href=\"/edietitian-web/questionnaire.jsp?knowledgebase=edietitian\">Start eDietitian!</a></li>" +
			"</ul>" +
			"<ul>" +
				"<li><a href=\"" + FEEDBACK_URL + "\">Send Feedback!</a></li>" +
			"</ul>" +
		
		"</div>";

	public static final String HEADER_HTML = 
		"<div class=\"header\">" +
			"<a href=\"/edietitian-web/index.jsp\"><img style=\"width: 350px;\" alt=\"edietitianHeaderImage -- Things to Think About\"" +
			"src=\"/edietitian-web/images/edietitianHeader.other.jpg\"></a>" +
		"</div>";
		
	public static final String FOOTER_HTML = 
		"<div class=\"footer\">" +

		"<a href=\"" + HOME_URL + "\">Home</a>  |  " +
		"<a href=\"/edietitian-web/questionnaire.jsp?knowledgebase=edietitian\">Start eDietitian!</a>  |  " +
		"<a href=\"" + FEEDBACK_URL + "\">Send Feedback</a>  |  " +
		"<a href=\"" + PRIVACY_STATEMENT_URL + "\">Privacy Statement</a>  |  " + 
		"© 2011 Robert Jackson" +
		"</div>";
	

}

	

