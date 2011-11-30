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

<title>Feedback</title>
</head>
<body>
<%
	out.println(PageConstants.HEADER_HTML);
	pageContext.include("/feedbackFragment.jspf");
	out.println(PageConstants.FOOTER_HTML);
%>

</body>

</html>
