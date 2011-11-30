<%@page import="java.math.BigDecimal"%>
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

<script src="jquery-1.6.2.min.js"></script>
<script src="jquery-ui-1.8.16.custom.min.js"></script>
<script>
$(document).ready(function() {
	$("#accordion").accordion();
	$("#recommendationTypeAccordion").accordion();
	
});
</script>
<link rel="stylesheet" type="text/css" href="jquery-ui-1.8.16.custom.css" />




<title>eDietitian :: Recommendations</title>
</head>
<body>

<%
	out.println(PageConstants.HEADER_HTML);
	out.println(PageConstants.MENU_ITEMS);
	//pageContext.include("/content.jspf");
	
	
	// put recommendation object into similar colelctions
	Vector<EatingRecommendation> eatingRecommendations = (Vector<EatingRecommendation>)request.getAttribute("eatingRecommendations");
	Vector<OtherRecommendation> otherRecommendations = (Vector<OtherRecommendation>)request.getAttribute("otherRecommendations");
	Vector<ExerciseRecommendation> exerciseRecommendations = (Vector<ExerciseRecommendation>)request.getAttribute("exerciseRecommendations");
%>

<div class="feedback">
	<br>
	<h2>Results</h2>

	<div id="accordion"> <%--START OUTER-MOST ACCORDION --%>
	
		<h3>Recommendations that you should try to follow</h3>
		<div>
			<div id="recommendationTypeAccordion"> <%--START RECOMMENDATION TYPE ACCORDION --%>

				<h3>EXERCISE RECOMMENDATIONS</h3>
				<div>
					<ul>
						<%
						if (exerciseRecommendations.size() == 0){
							out.println( 
									"<li>" + "No recommendations were found in this category." + "</li>");
						}
						%>
						
						<%
						for (ExerciseRecommendation recommendation : exerciseRecommendations) {
							out.println( 
									"<li>" + recommendation.toString() + "</li>");
						}
						%>
					</ul>
				</div>

				<h3>EATING RECOMMENDATIONS</h3>
				<div>
					<ul>
						<%
						if (eatingRecommendations.size() == 0){
							out.println( 
									"<li>" + "No recommendations were found in this category." + "</li>");
						}
						%>
						<%
						for (EatingRecommendation recommendation : eatingRecommendations) {
							out.println( 
									"<li>" + recommendation.toString() + "</li>");
						}
						%>
					</ul>
				</div>

				<h3>OTHER RECOMMENDATIONS</h3>
				<div>
					<ul>
						<%
						if (otherRecommendations.size() == 0){
							out.println( 
									"<li>" + "No recommendations were found in this category." + "</li>");
						}
						%>
						<%
						for (OtherRecommendation recommendation : otherRecommendations) {
							out.println( 
									"<li>" + recommendation.toString() + "</li>");
						}
						%>
					</ul>
				</div>
			</div> <%--END RECOMMENDATION TYPE ACCORDION --%>
		</div> <%--END RECOMMENDATION ACCORDION --%>





		<h3>FACTS</h3>
		<div>
		<table>
			<tr>
				<th>Question</th>
				<th>Response</th>
			</tr>
			<%
				Map<String, Object> answers = (Map<String, Object>)request.getAttribute("answers");
				for (Map.Entry<String, Object> entry : answers.entrySet()) {
					// instead of printing true/false => yes/no
					if(entry.getValue() instanceof Boolean) {
						Boolean bool = (Boolean)entry.getValue();
						out.println(
							"<tr>" + 
							"<th>" + entry.getKey() + "</th>" + 
							"<td>" + ((bool==true) ? "yes" : "no") + "</td>" + 
							"</tr>");
						
					} 
					// if it's a BigDecimal => round to nearest 10th place
					else if(entry.getValue() instanceof BigDecimal) {
						BigDecimal bd = (BigDecimal)entry.getValue();
						out.println(
							"<tr>" + 
							"<th>" + entry.getKey() + "</th>" + 
							"<td>" + (Math.round(Double.parseDouble(bd.toString()) * 10.0) / 10.0) + "</td>" + 
							"</tr>");
						
					} 
					else {
					out.println(
							"<tr>" + 
							"<th>" + entry.getKey() + "</th>" + 
							"<td>" + entry.getValue().toString() + "</td>" + 
							"</tr>");
					}
				}
			%>
		</table>
		</div>





		<h3>INFERRED FACTS</h3>
		<div>
			<table>
			<tr>
				<th>Inferred Fact Name</th>
				<th>Value</th>
			</tr>
			<%
				Vector<SFact> sfacts = (Vector<SFact>)request.getAttribute("sfacts");
				for (SFact sfact : sfacts) {
					// instead of printing true/false => yes/no
					if(sfact.getAnswerType() == SFact.TYPE_BOOLEAN) {
						out.println(
							"<tr>" + 
							"<th>" + sfact.getId() + "</th>" + 
							"<td>" + ((sfact.getBooleanAnswer()==true) ? "yes" : "no") + "</td>" + 
							"</tr>");
						
					} 
					// if it's a BigDecimal => round to nearest 10th place
					else if(sfact.getAnswerType() == SFact.TYPE_DECIMAL) {
						out.println(
							"<tr>" + 
							"<th>" + sfact.getId() + "</th>" + 
							"<td>" + Math.round(sfact.getDecimalAnswer().doubleValue() * 10.0) / 10.0 + "</td>" + 
							"</tr>");
						
					} 

					else {
						out.println(
							"<tr>" + 
							"<th>" + sfact.getId() + "</th>" + 
							"<td>" + sfact.getAnswer().toString() + "</td>" + 
							"</tr>");
					}
				}

			%>
			</table>
		</div>
	</div> <%--END OUTER-MOST ACCORDION--%>
</div> <%--END FEEDBACK DIV--%>
	<%
		pageContext.include("/feedbackFragment.jspf");
		out.println(PageConstants.FOOTER_HTML);		
	 %>
</body>
</html>
