<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="head.jsp" />
<body>
	<div class="container">

		<c:import url="menu.jsp" />

		<h2 class="ui inverted header top attached">
			<i class="users small icon"></i>
			<div class="content">
				S�jour
				<div class="sub header">D�tail du s�jour</div>
			</div>
		</h2>

		<div class="ui segment attached">
			<p><b>Num�ro : </b>${stay.id}</p>
			<p><b>Nom : </b>${stay.client.name}</p>
			<p><b>Date d�but : </b><fmt:formatDate type='date' dateStyle="short" value="${stay.startDate}" /></p>
			<p><b>Date fin : </b><fmt:formatDate type='date' dateStyle="short" value="${stay.endDate}" /></p>
			<p><b>Num�ro emplacement : </b>${stay.location.id}</p>
			<p><b>Nombre de personnes : </b>${stay.numberPersons}</p>
			
			
			<p><b>Prestations sportives :</b></p>			
			<table class="ui table">
				<thead>
					<tr>
						<th>Date</th>
						<th>Nom</th>
						<th>Prix/Unit�</th>
						<th>Nombre unit�</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="activity" items="${activities}">
					<tr>
						<td><fmt:formatDate type='date' dateStyle="short" value="${stay.startDate}" /></td>
						<td>${activity.sport.label}</td>
						<td>${activity.sport.price}</td>
						<td>${activity.amount}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a target="_blank" href="<c:url value='/stays/invoice/${stay.id}'/>" class="ui blue button">Voir facture s�jour</a>
			<a target="_blank" href="<c:url value='/stays/invoiceSports/${stay.id}'/>" class="ui teal button">Voir facture sports</a>
			
		</div>

	</div>
</body>
</html>