<%@ page 
import=
"java.util.*, 
com.mycomism.*,
com.mycomism.edietitian.web.*;"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% pageContext.include("/jsps/include.jspf"); %>
<% pageContext.include("/includes.jspf"); %>
<link rel="stylesheet" type="text/css" media="screen" href="/edietitian-web/css/oldStyle.css" />
<script type="text/javascript" src="/edietitian-web/script/oldExtras.js"></script>

<title>eDietitian :: SubmitSuggestion</title>
</head>
<body> 
<%
	out.println(PageConstants.HEADER_HTML);
	out.println(PageConstants.MENU_ITEMS);
	//pageContext.include("/content.jspf");

	String name = (String)request.getParameter("name");
	String email = (String)request.getParameter("email");
	String suggestion = (String)request.getParameter("suggestion");
	SuggestionSender sender = new SuggestionSender();
	boolean pass=sender.sendSuggestion(name, email, suggestion);
	
%>
<br>
<div class="feedback">
	<h2>Sending Suggestion</h2>
	Sending suggestion...
	<% 
		if (pass) 
			out.print("<font color=\"green\">SUCCESS</font>."); 
		else
			out.print("<font color=\"red\">FAILED</font>.");
	%>
	<p>
	<% 

		//out.print(
		//		name + "<br>" +
		//		email + "<br>" +
		//		suggestion + "<br>"
		//); 
	%>
	
</div>
<br>
	<%
		out.println(PageConstants.FOOTER_HTML);		
	 %>
</body>
</html>
