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
				<div class="sub header">Créer un nouveau client</div>
			</div>
		</h2>

		<div class="ui segment attached">
			
			<f:form class="ui form" modelAttribute="client" action="store">

			  <div class="field">
			    <f:label path="name">Nom</f:label>
			    <f:input path="name" placeholder="Nom" />
			  </div>

			  <div class="field">
			    <f:label path="address">Adresse</f:label>
			    <f:input path="address" placeholder="Adresse" />
			  </div>
			  <div class="two fields">
			  	<div class="field">
		    		<f:label path="zipCode">Code Postal</f:label>
			    	<f:input path="zipCode" placeholder="Code Postal" />
			    </div>
			    <div class="field">
		    		<f:label path="city">Ville</f:label>
			    	<f:input path="city" placeholder="Ville" />
			    </div>
			  </div>
			  <div class="two fields">
			  	<div class="field">
		    		<f:label path="typeIdentity">Type Piece</f:label>
			    	<f:input path="typeIdentity" placeholder="Type Piece" />
			    </div>
			    <div class="field">
		    		<f:label path="numIdentity">N° Piece</f:label>
			    	<f:input path="numIdentity" placeholder="N° Piece" />
			    </div>
			  </div>
			  <button class="ui button" type="submit">Enregistrer client</button>
			</f:form>			

		</div>

	</div>
</body>
</html>