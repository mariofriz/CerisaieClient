<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="head.jsp" />
<body>
	<div class="container">

		<c:import url="menu.jsp" />

		<h2 class="ui inverted header top attached">
			<i class="users small icon"></i>
			<div class="content">
				Clients
				<div class="sub header">Gestion des clients</div>
			</div>
		</h2>

		<div class="ui segment attached">
		
			<a href="<c:url value='/clients/create'/>" class="ui small primary labeled icon button">
				<i class="user icon"></i>Nouveau client
       		</a>

			<table class="ui table">
				<thead>
					<tr>
						<th>#</th>
						<th>Nom</th>
						<th>Ville</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="client" items="${clients}">
					<tr>
						<td>${client.id}</td>
						<td>${client.name}</td>
						<td>${client.city}</td>
						<td class="right aligned">
							<div class="ui tiny buttons">
								<a href="<c:url value='/clients/view/${client.id}'/>" class="ui green button">Voir</a>
								<a href="<c:url value='/clients'/>" class="ui blue button">Modifier</a>
								<a href="<c:url value='/clients/delete/${client.id}'/>" onclick="return confirm('Etes vous sûr ?')" class="ui red button">Supprimer</a>
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