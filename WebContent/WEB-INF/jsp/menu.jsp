<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="uri" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<div class="ui menu">		
		<div class="header item">Camping Cerisaie</div>
		<a href="<c:url value='/'/>" class="item<c:if test="${uri == '/Cerisaie_Client/'}"> active</c:if>">Accueil</a>
		<a href="<c:url value='/clients'/>" class="item<c:if test="${fn:contains(uri, 'clients')}"> active</c:if>">Clients</a>
		<a href="<c:url value='/stays'/>" class="item<c:if test="${fn:contains(uri, 'stays')}"> active</c:if>">Séjours</a>
	</div>
	