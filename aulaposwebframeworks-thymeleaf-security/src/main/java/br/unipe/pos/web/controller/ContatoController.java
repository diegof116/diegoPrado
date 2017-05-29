/**
 * Projeto das trilhas de especialização em desenvolvimento Web coordenada 
 * pelo professor Rodrigo Fujioka.
 * Disciplina: Web Frameworks.
 * Fontes disponíveis em https://github.com/rodrigofujioka/aulaposwebframeworks
 * 
 * Professor: Rodrigo da Cruz Fujioka
 * Ano: 2017
 * http://www.rodrigofujioka.com
 * http://www.fujideia.com.br
 * http://lattes.cnpq.br/0843668802633139
 * 
 * Contato: rcf4@cin.ufpe.br 
 */
package br.unipe.pos.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.unipe.pos.web.dao.ContatoDAO;
import br.unipe.pos.web.dao.ContatoDAO;
import br.unipe.pos.web.model.ContatoModel;
import br.unipe.pos.web.model.ContatoModel;

/**
 * @author Rodrigo C. Fujioka
 * @date 28 de abr de 2017
 * @time 17:09:28
 *
 */

@Controller
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	private ContatoDAO contatoDao;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "index";
	}
	
	@RequestMapping(path="/form", method=RequestMethod.GET)	
	public String form(Model model) {
		model.addAttribute("contato", new ContatoModel());
		return "/contato/contatoform";
	}

	@RequestMapping(path="/consultar",method=RequestMethod.GET)
	@ResponseBody
	public String consultar(
			@PathVariable(name="id") int id){		
		
		ContatoModel contato = contatoDao.findOne(id);
		if(contato!=null) 
			return contato.toString();
		
		return "Sem resultado";
	}
	
	@RequestMapping(path="/remover/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String remover(
			@PathVariable(name="id") int id){				
		contatoDao.delete(id);		
		return "Sucesso";
	}
	
	@RequestMapping("/incluir")
	@ResponseBody
	public String incluir(ContatoModel contato){
		contatoDao.save(contato);
		return "Sucesso";
	}
	
	@RequestMapping(path={"/listar","/"} , method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("contato/contatos");
		List<ContatoModel> contatos = this.contatoDao.findAll();
		mv.addObject("contatos", contatos);
		return mv;
	}	
	
	@GetMapping("/cadastro")
    public ModelAndView preparaSalvar(ContatoModel contato) {
        ModelAndView mv = new ModelAndView("contato/contatoform");
        mv.addObject("contato", contato);
        return mv;
    }

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid ContatoModel contato, BindingResult result,RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return preparaSalvar(contato);
		}
		this.contatoDao.save(contato);
		attributes.addFlashAttribute("mensagem", "Contato salvo com sucesso");
		listar();
		return new ModelAndView("redirect:/contato/listar");
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Integer id) {
		return preparaSalvar(contatoDao.findOne(id));
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView apagar(@PathVariable Integer id, RedirectAttributes attributes) {
		contatoDao.delete(id);
		attributes.addFlashAttribute("mensagem", "Contato removido com sucesso");
		listar();
		return new ModelAndView("redirect:/contato/listar");
	}
	
}
