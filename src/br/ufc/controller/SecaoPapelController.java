package br.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.model.Aluno;
import br.ufc.model.Papel;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoPapelController {

	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	@RequestMapping("/inserirPapelFormulario")
	public String inserirPapelF(){
		return "secaopapel/inserir_papel_formulario";
	}
	
	@RequestMapping("/inserirPapel")
	public String inserirPapel(@Valid Papel papel, BindingResult result){
		if(result.hasFieldErrors("nome")){
			return "secaopapel/inserir_papel_formulario";
		}
		
		this.pDAO.inserir(papel);
		
		
		return "secaopapel/papel_inserido";
	}
	
	@RequestMapping("/inserirSecaoFormulario")
	public String inserirSecaoFormulario(){
		return "secaopapel/inserir_secao_formulario";
	}
	
	@RequestMapping("/inserirSecao")
	public String inserirSecao(@Valid Secao secao, BindingResult result){
		if(result.hasFieldErrors("nome")){
			return "secaopapel/secao_inserida";
		}
		
		sDAO.inserir(secao);
		return "secaopapel/secao_inserida";	
	}
	
	@RequestMapping("/listarSecoes")
	public String listarSecoes(Model model){
		
		
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		
		
		return "secaopapel/listar_secoes";
	}	
	
}
