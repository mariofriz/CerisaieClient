<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="head.jsp" />
<body>
	<div class="container">

		<c:import url="menu.jsp" />

		<h2 class="ui inverted header top attached">
			<i class="users small icon"></i>
			<div class="content">
				Séjour
				<div class="sub header">Détail du séjour</div>
			</div>
		</h2>

		<div class="ui segment attached">
			<p><b>Numéro :</b></p>
			<p><b>Nom :</b></p>
			<p><b>Date début :</b></p>
			<p><b>Date fin :</b></p>
			<p><b>Numéro emplacement :</b></p>
			<p><b>Nombre de personnes :</b></p>
			
			
			<p><b>Prestations sportives :</b></p>			
			<table class="ui table">
				<thead>
					<tr>
						<th>Date</th>
						<th>Nom</th>
						<th>Prix/Unité</th>
						<th>Nombre unité</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>September 10, 2013</td>
						<td>Volley</td>
						<td>10</td>
						<td>2</td>
					</tr>
				</tbody>
			</table>
			
			<a target="_blank" href="<c:url value='/stays/invoice/1'/>" class="ui blue button">Voir facture séjour</a>
			<a target="_blank" href="<c:url value='/stays/invoiceSports/1'/>" class="ui teal button">Voir facture sports</a>
			
		</div>

	</div>
</body>
</html>