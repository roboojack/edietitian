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


</head>
<body>
<%
	out.println(PageConstants.HEADER_HTML);
	out.println(PageConstants.MENU_ITEMS);
	String pageId = (String)request.getParameter("pageId");

	// do some error/security checking 
	if (pageId == null ||
		pageId.length() > 20) {
		pageContext.include("/pages/home.jspf");
		out.println(PageConstants.FOOTER_HTML);
		return; 
	}
	
	// for testing, peek at string
	System.out.println("pageId=" + pageId);
	
	// DYNAMICALLY ENTER INCLUDE THE JSP FRAGMENT HERE
	pageId = pageId.intern(); // store string for comparison 
	if(pageId == "feedback") pageContext.include("/pages/feedbackFragment.jspf");
	else if(pageId == "privacyStatement") pageContext.include("/pages/privacyStatement.jspf");
	else pageContext.include("/pages/error.jspf");
	
	
	out.println(PageConstants.FOOTER_HTML);
%>

</body>

</html>
