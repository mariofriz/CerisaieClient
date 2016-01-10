<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<p><b>Numéro :</b></p>
			<p><b>Nom :</b></p>
			<p><b>Adresse :</b></p>
			<p><b>Code Postal / Ville:</b></p>
			<p><b>Type Piece :</b></p>
			<p><b>Numéro Piece :</b></p>
			
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
					<tr>
						<td>September 10, 2013</td>
						<td>September 14, 2013</td>
						<td>3</td>
						<td>15</td>
						<td><a href="<c:url value='/stays/view/1'/>" class="ui blue basic button">Voir</a></td>
					</tr>
				</tbody>
			</table>
			
		</div>

	</div>
</body>
</html>