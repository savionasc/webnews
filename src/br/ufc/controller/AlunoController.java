package br.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IAlunoDAO;
import br.ufc.model.Aluno;

@Transactional
@Controller
public class AlunoController {
	
	@Autowired
	@Qualifier(value="alunoDAO")
	private IAlunoDAO aDAO;
	
	@RequestMapping("/inserirAlunoFormulario")
	public String inserirAlunoFormulario(){
		return "aluno/inserir_aluno_formulario";
		
	}
	
	@RequestMapping("/inserirAluno")
	public String inserirAluno(@Valid Aluno aluno,
							   BindingResult result){
		
		if(result.hasFieldErrors("nome")){
			return "aluno/inserir_aluno_formulario";
		}
		
		
		this.aDAO.inserir(aluno);
		
		return "aluno/aluno_inserido_ok";
	}
	
	@RequestMapping("/listarAluno")
	public String listarAluno(Model model){
		
		
		List<Aluno> alunos = this.aDAO.listar();
		model.addAttribute("alunos", alunos);
		
		
		return "aluno/listar_aluno";
	}	
	
	@RequestMapping("/apagarAluno")
	public String apagarAluno(Long id){
		
		this.aDAO.apagar(id);
		return "redirect:listarAluno";
	}
	
	@RequestMapping("/alterarAlunoFormulario")
	public String alterarAlunoFormulario(Long id, Model model){
		
		Aluno aluno = this.aDAO.recuperar(id);
		model.addAttribute("aluno", aluno);
		return "aluno/alterar_aluno_formulario";
	}
	
	@RequestMapping("/alterarAluno")
	public String alterarAluno(Aluno aluno){
		
		this.aDAO.alterar(aluno);
		return "redirect:listarAluno";
	}
}