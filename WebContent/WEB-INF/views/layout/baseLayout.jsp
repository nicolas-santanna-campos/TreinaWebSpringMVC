<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> <!-- Taglib do Tiles para que seja possível utilizar suas funcoes -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> <!-- Taglib do Spring para que seja possível utilizar as funcoes do Jquery + Bootstrap -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<!-- Define o local onde os arquivos do Jquery e Bootstrap estao, conforme especificado em TreinaWebSpringMVC-servlet.xml -->
		<spring:url value="/resources/js/jquery.min.js" var="jqueryJS"></spring:url>
		<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"></spring:url>
		<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS"></spring:url>
	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title> <!-- Definicao de title sera buscada no arquivo tiles.xml (atributo ignore serve para caso o title não tenha sido declarado)-->
		
		<!-- Adiciona as referencias -->
		<script type="text/javascript" src="${jqueryJS}"></script>
		<link href="${bootstrapCSS}" rel="stylesheet"/>
		<script type="text/javascript" src="${bootstrapJS}"></script>
	
	</head>
	
	<body>
		<div style="width: 100%">
			<tiles:insertAttribute name="header" ignore="false"/>
		</div>
		<div style="width: 100%; height: 100%; margin: 2%;"> <!-- A margem irá afastar as páginas do lado esquerdo do browser -->
			<tiles:insertAttribute name="body" ignore="false"/>
		</div>
		<div style="width: 100%; position: fixed; bottom: 0; margin: auto"> <!-- Position, bottom e margim definem que o rodapé ficará no final da página independente do tamanho do body -->
			<tiles:insertAttribute name="footer" ignore="false"/>
		</div>
	</body>

</html>