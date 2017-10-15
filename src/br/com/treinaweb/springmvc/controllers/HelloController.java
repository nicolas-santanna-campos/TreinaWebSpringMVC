package br.com.treinaweb.springmvc.controllers;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

	//<servidor:porta>/hello/message
	
	//A Seguir, diferentes maneiras de passar informações do controller para as views
	
	@RequestMapping("/message")
	public String message() {
		return "hello";
	}
	
	@RequestMapping("/mensagemDoServidor")
	public String mensagemDoServidor(Model model) {
		//model.addAttribute("mensagem", "Olá, TreinaWeb");
		model.addAttribute("mensagem", new Date().toString());
		return "mensagemDoServidor";
	}
	
	@RequestMapping("/mensagemDoServidor2")
	public ModelAndView mensagemDoServidorV2() {
		//Parâmetros 1= View a ser carregada, 2= Nome do objeto, 3= Valor do objeto
		return new ModelAndView("mensagemDoServidor", "mensagem", new Date().toString());
	}
	
	@RequestMapping("/mensagemDoServidor3")
	public ModelAndView mensagemDoServidorV3() {
		ModelAndView resultado = new ModelAndView("mensagemDoServidor", "mensagem", new Date().toString());
		return resultado;
	}
	
	//Define que a rota receberá um parâmetro chamado mensagem
	@RequestMapping("/receberMensagem/{mensagem}")
	//Define na action que o parâmetro da action está ligado com o parâmetro recebido via URL/Rota
	//Ao declarar a anottation @PathVariable isso se torna obrigatoriamente parte da rota, caso contrário receberemos erro 404
	public String receberMensagem(Model model, @PathVariable("mensagem") String msg) {
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor";
	}
	
	//Nesse caso, se define na URL através do uso do caracter "?" o valor da msg, exemplo:
	//http://localhost:8080/treinaweb-spring-mvc/hello/receberMensagem2?mensagem=teste123
	@RequestMapping("/receberMensagem2")
	public String receberMensagem2(Model model, @RequestParam(value="mensagem") String msg) {
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor";
	}
	
	//Define que o parâmetro é opcional
	@RequestMapping("/receberMensagem3")
	public String receberMensagem3(Model model, @RequestParam(value="mensagem", required = false) String msg) {
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor";
	}
	
	//Define valor padrão para caso o parâmetro não seja informado
	@RequestMapping("/receberMensagem4")
	public String receberMensagem4(Model model, @RequestParam(value="mensagem", required = false, defaultValue="Mensagem padrão") String msg) {
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor";
	}
}
