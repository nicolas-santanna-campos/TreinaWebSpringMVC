<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Código desnecessário pois todas as informações estão vindo da página de layout
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TreinaWeb Spring MCV - Adição de Albuns</title>
</head>
<body>
 -->
	<!-- Form será submetido via post para uma action /albuns/adicionar -->
	
	<c:url var="actionAdicionar" value="/albuns/adicionar"/>
	<form:form action="${actionAdicionar}" method="post" modelAttribute="album">
	
	<!-- A propriedade modelAttribute faz a conexão com o pojo "Album" criado em domínios.
	Faz se necessário utilizar o form:input para popular corretamente os campos do Pojo -->
		
		<div class="row"> <!-- Define que cada elemento fica em uma linha, n necessitando incluir a tag <br/> para quebra de linha -->	
			<div class="col-md-6"> <!-- Os elementos dentro dessa div ocuparão 6 das 12 posições utilizadas pelo bootstrap -->
				<div class="form-group"> <!-- Define que os elementos dentro dessa div pertencem ao mesmo grupo -->
					<label>Nome:</label>
					<form:input path="nome" cssClass="form-control"/> <!-- Bootstrap possui uma classe especial para os elementos html que fornecem interação com o usuário (input, checkbox...) essa classe é a form-control, que deixa o elemento mais visível, com fonte mais agradável ao usuário e identifica melhor o foco do elemento -->
					<form:errors path="nome" cssStyle="color: red"></form:errors><!-- Ira exibir as mensagens de erros de validacao do campo nome (Verifica se contem erros no objeto do tipo BindingResults) -->
														   						 <!-- Para alterar a cor das mensagens de erro será adicionada o cssStyle -->
				</div>
			</div>
		</div>
		<div class="row"> <!-- Define que cada elemento fica em uma linha, n necessitando incluir a tag <br/> para quebra de linha -->
			<div class="col-md-6"> <!-- Os elementos dentro dessa div ocuparão 6 das 12 posições utilizadas pelo bootstrap -->
				<div class="form-group"> <!-- Define que os elementos dentro dessa div pertencem ao mesmo grupo -->	
					<label>Ano de Lançamento:</label>
					<form:input path="anoDeLancamento" cssClass="form-control"/> <!-- Bootstrap possui uma classe especial para os elementos html que fornecem interação com o usuário (input, checkbox...) essa classe é a form-control, que deixa o elemento mais visível, com fonte mais agradável ao usuário e identifica melhor o foco do elemento -->
					<form:errors path="anoDeLancamento" cssStyle="color: red"></form:errors> <!-- Ira exibir as mensagens de erros de validacao do campo anoDeLancamento (Verifica se contem erros no objeto do tipo BindingResults) -->
												  										     <!-- Para alterar a cor das mensagens de erro será adicionada o cssStyle -->
				</div>
			</div>
		</div>
		
		<!-- html normal, não é struts -->
		<input type="submit" value="Salvar" class="btn btn-default"> <!-- Através da classe btn informo ao bootstrap que esse input é um botão, e adicionando btn-default informo o padrão do layout do mesmo, ou outras cores, como btn-warning, btn-danger... -->
		
	</form:form>
<!-- 	
</body>
</html>
 -->