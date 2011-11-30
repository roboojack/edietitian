<%@page import="drools.rex.ExecutionServerHelper"%>
<%@page import="drools.rex.management.REXMonitor"%>
<%@ page 
import=
"java.util.*, 
com.mycomism.*,
com.mycomism.edietitian.web.*,
org.drools.logger.KnowledgeRuntimeLogger,
org.drools.logger.KnowledgeRuntimeLoggerFactory;"
%>
<%
	//new drools.rex.ExecutionServerHelper(request.getSession()).removeKnowledgeSession();


	ExecutionServerHelper helper = new drools.rex.ExecutionServerHelper(request.getSession());
	helper.removeKnowledgeSession();
	//helper.newKnowledgeSession("edietitian");
	
	//KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(helper.getKnowledgeSession(), "edietitian_logFile");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% pageContext.include("/jsps/include.jspf"); %>
<%--	This is the menu, probably not needed during the knowledge session 
	<% pageContext.include("/includes.jspf"); %> 
--%>

<link rel="stylesheet" type="text/css" media="screen" href="css/oldStyle.css" />
<script type="text/javascript" src="script/oldExtras.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    onQuestionnaireLoad("bodyContent");
  });
</script>


<title>eDietitian</title>
</head>
	<body>
	<%
		out.println(PageConstants.HEADER_HTML);
	%>
 
 <table border=0 width="750px">
  <tr>
    <td valign="top">
        <div id="progressindicator" class="clearfix">
    	<a href="http://www.uwf.edu"><img src="images/uwfLogo.jpg" width="150" id="uwf"></a>
        	<h3><font color="white">Your Progress:</font></h3>
          	<div id="progressbar">
            	<p>&nbsp;</p>
          	</div>
        </div>
    </td>
	<td valign="top">
       <div id="bodyContent"></div>
    </td>
  </tr>
</table>
	<%
		out.println(PageConstants.FOOTER_HTML);
	%>

</body>
</html>
