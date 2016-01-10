<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<c:import url="head.jsp" />
<body>
	<div class="container">

		<c:import url="menu.jsp" />

		<h2 class="ui inverted header top attached">
			<i class="users small icon"></i>
			<div class="content">
				Clients
				<div class="sub header">Créer un nouveau séjour</div>
			</div>
		</h2>

		<div class="ui segment attached">
			
			<f:form class="ui form" modelAttribute="stay" action="store" method="POST">

			  <div class="field">
			    <f:label path="idClient">Numéro client</f:label>
			    <f:select path="idClient" items="${clients}" />
			  </div>

			  <div class="field">
			    <f:label path="idLocation">Numéro emplacement</f:label>
			    <f:input path="idLocation" placeholder="Numéro emplacement" />
			  </div>
			  
			  <div class="field">
			    <f:label path="numberPersons">Nombre de personnes</f:label>
			    <f:input path="numberPersons" placeholder="Nombre de personne" />
			  </div>
			  
			  <div class="two fields">
			  	<div class="field">
		    		<f:label path="startDate">Date début</f:label>
			    	<f:input path="startDate" placeholder="01/01/2015" />
			    </div>
			    <div class="field">
		    		<f:label path="endDate">Date fin</f:label>
			    	<f:input path="endDate" placeholder="01/01/2015" />
			    </div>
			  </div>
			  
			  <button class="ui button" type="submit">Créer séjour</button>
			</f:form>			

		</div>

	</div>
</body>
</html>