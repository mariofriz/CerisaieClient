<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="head.jsp" />
<body>
	<div class="container">

		<c:import url="menu.jsp" />

		<h2 class="ui inverted header top attached">
			<i class="users small icon"></i>
			<div class="content">
				Clients
				<div class="sub header">Détail du client</div>
			</div>
		</h2>

		<div class="ui segment attached">
			<p><b>Numéro : </b>${client.id}</p>
			<p><b>Nom : </b>${client.name}</p>
			<p><b>Adresse : </b>${client.address}</p>
			<p><b>Code Postal / Ville : </b>${client.zipCode} ${client.city}</p>
			<p><b>Type Piece : </b>${client.typeIdentity}</p>
			<p><b>Numéro Piece : </b>${client.numIdentity}</p>
			
			<p><b>Séjours :</b></p>			
			<table class="ui table">
				<thead>
					<tr>
						<th>Date Début</th>
						<th>Date Fin</th>
						<th>Nombre Personne</th>
						<th>Prix/Jour/Personne</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stay" items="${stays}">
					<tr>
						<td><fmt:formatDate type='date' dateStyle="short" value="${stay.startDate}" /></td>
						<td><fmt:formatDate type='date' dateStyle="short" value="${stay.endDate}" /></td>
						<td>${stay.numberPersons}</td>
						<td>${stay.location.typeLocation.price}</td>
						<td><a href="<c:url value='/stays/view/${stay.id}'/>" class="ui blue basic button">Voir</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>

	</div>
</body>
</html>