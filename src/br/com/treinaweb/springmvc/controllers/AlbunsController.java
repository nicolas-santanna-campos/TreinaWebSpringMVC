package br.com.treinaweb.springmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.treinaweb.springmvc.dominios.Album;
import br.com.treinaweb.springmvc.repositorios.RepositorioAlbum;

@Controller
@RequestMapping("/albuns")
public class AlbunsController {
	
	//Essa annotation fará com que esse atributo, que não será instanciado com o new, como tradicionalmente. Aí que entra a inversão de controle, o próprio Spring irá instancia-lo em tempo de execução.
	@Autowired //Fara com que quando o spring for criar tbm criar o objeto albunsCrontroler pra tratar a requisicao http ele tbm, com base na classe RepositorioAlbum ira inserir o objketo gerado de maneira automatica no controler, processo conhecido como CDI. JEE tbm tem essa capacidade, mas nesse projeto usamos o Spring para isso.
	private RepositorioAlbum repositorio; //Spring data devera instanciar esse objeto em tempo de execucao com a classe que sera gerada de forma dinamica, tornando desnecessario a criacao de todos os metodos da classe dentro da controler
	
	//Busca todos os albuns do banco de dados
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model){
		
		List<Album> albuns = repositorio.findAll(); //Pega a lista de albuns que sera exibida na página
		model.addAttribute("albuns", albuns); //Inserindo na página a lista de albuns carregada
		return "album.listar.tiles";
	}
	
	
	
	
	// Action (método) adicionar, que será acessada por /albuns/adicionar vai
	// somente atender a requisição SE e somente se essa requisição for feita
	// via GET, pois o que irei adicionar é uma página
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("album", new Album());
	  //return "albuns/adicionar"; //Define que a view adicionar.jsp estará em views/albuns/adicionar
		return "album.adicionar.tiles"; //Após inserir o tiles na aplicação o retorno deverá ser dessa maneira
	}
	
	//@ModelAttribute("album") faz o link com o modelAttribute="album" definido na view adicionar.jsp
	// A anotação @Valid aciona as validações que foram cadastradas como dependências no pom.xml e especificadas no servlet
	// Para obter o resultado da validação é necessário informar na action um parâmetro do tipo BindingResult (SEMPRE: Logo após o objeto que possui a anotattion Valid)
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") @Valid Album novoAlbum, BindingResult result, Model model) {
		
		//Caso ocorra algum erro de validação, deverá redirecionar o usuário novamente para a página de cadastro/edição
		if(result.hasErrors()) {
			//return "albuns/adicionar";
			return "album.adicionar.tiles"; //Após inserir o tiles na aplicação o retorno deverá ser dessa maneira
		}
		
		repositorio.save(novoAlbum); //Será feito o insert do novo album através do hibernate/Spring data
		//model.addAttribute("album", novoAlbum); Era utilizado para testes antes de inserir o banco de dados/hibernate/jpa/spring data na aplicação
		//return "albuns/exibir"; //Define que a view adicionar.jsp estará em views/albuns/exibir (Utilizado antes de inserir o Tiles na aplicação)
		//return "album.exibir.tiles"; //Após inserir o tiles na aplicação o retorno deverá ser dessa maneira
		return "redirect:/albuns/listar"; //Podemos redirecionar uma o resultado de uma action para outra, nesse caso a action "listar"
	} 
	
	//Criando a alteração do album, utilizando personalização de rota, passando o id como parâmetro do album que deverá ser alterado
	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.GET)
	public String alterar(@PathVariable("id") Long id, Model model) { //Recebemos o id do album à ser alterado
		Album albumASerAlterado = repositorio.findOne(id); //Pesquisamos o album que contém esse id
		model.addAttribute("album", albumASerAlterado); //Enviamos o album para o objeto model
		
		return "album.alterar.tiles"; //Retornamos para a view
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public String alterar(@ModelAttribute("album") @Valid Album album, BindingResult result) {
		
		if(result.hasErrors()){ //Se houve algum erro de validação
			return "album.alterar.tiles"; //Retorno para a minha página de edição
		}
		
		repositorio.save(album); //Não existe um update, o save no Spring data, tem a inteligência de saber se deve inserir ou atualizar o dado no banco de dados
		
		return "redirect:/albuns/listar";//Podemos redirecionar uma o resultado de uma action para outra, nesse caso a action "listar"
	}
	
	//Criando a alteração do album, utilizando personalização de rota, passando o id como parâmetro do album que deverá ser alterado
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id) {
		repositorio.delete(id); //Deletamos o album que contém esse id
		return "redirect:/albuns/listar"; //Podemos redirecionar uma o resultado de uma action para outra, nesse caso a action "listar"
		
	}
	
	
	//O HTML não suporta formularios que sejam submetidos via PUT ou DELETE, por esse motivo essas operacoes serao realizadas via POST.
}
