<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="head.jsp" />
<body>
	<div class="container">

		<c:import url="menu.jsp" />

		<h2 class="ui inverted header top attached">
			<i class="users small icon"></i>
			<div class="content">
				Séjours
				<div class="sub header">Gestion des séjours</div>
			</div>
		</h2>

		<div class="ui segment attached">			
			<a href="<c:url value='/stays/create'/>" class="ui small primary labeled icon button">
				<i class="user icon"></i>Nouveau séjour
       		</a>

			<table class="ui table">
				<thead>
					<tr>
						<th>#</th>
						<th>Nom client</th>
						<th>Date début</th>
						<th>Date fin</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stay" items="${stays}">
					<tr>
						<td>${stay.id}</td>
						<td>${stay.client.name}</td>
						<td><fmt:formatDate type='date' dateStyle="short" value="${stay.startDate}" />
						<td><fmt:formatDate type='date' dateStyle="short" value="${stay.endDate}" />
						<td class="right aligned">
							<div class="ui tiny buttons">
								<a href="<c:url value='/stays/view/${stay.id}'/>" class="ui green button">Voir</a>
								<a href="<c:url value='/stays'/>" class="ui blue button">Modifier</a>
								<a href="<c:url value='/stays/delete/${stay.id}'/>" onclick="return confirm('Etes vous sûr ?')" class="ui red button">Supprimer</a>
							</div>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

	</div>
</body>
</html>