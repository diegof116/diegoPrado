
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
 * Usuario: rcf4@cin.ufpe.br 
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

import br.unipe.pos.web.dao.UsuarioDAO;
import br.unipe.pos.web.model.UsuarioModel;

/**
 * @author Rodrigo C. Fujioka
 * @date 28 de abr de 2017
 * @time 17:09:28
 *
 */

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDao;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "index";
	}
	
	@RequestMapping(path="/form", method=RequestMethod.GET)	
	public String form(Model model) {
		model.addAttribute("usuario", new UsuarioModel());
		return "/usuario/usuarioform";
	}

	@RequestMapping(path="/consultar",method=RequestMethod.GET)
	@ResponseBody
	public String consultar(
			@PathVariable(name="id") int id){		
		
		UsuarioModel usuario = usuarioDao.findOne(id);
		if(usuario!=null) 
			return usuario.toString();
		
		return "Sem resultado";
	}
	
	@RequestMapping(path="/remover/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String remover(
			@PathVariable(name="id") int id){				
		usuarioDao.delete(id);		
		return "Sucesso";
	}
	
	@RequestMapping("/incluir")
	@ResponseBody
	public String incluir(UsuarioModel usuario){
		usuarioDao.save(usuario);
		return "Sucesso";
	}
	
	@RequestMapping(path={"/listar","/"} , method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("usuario/usuarios");
		List<UsuarioModel> usuarios = this.usuarioDao.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}	
	
	@GetMapping("/cadastro")
    public ModelAndView preparaSalvar(UsuarioModel usuario) {
        ModelAndView mv = new ModelAndView("usuario/usuarioform");
        mv.addObject("usuario", usuario);
        return mv;
    }

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid UsuarioModel usuario, BindingResult result,RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return preparaSalvar(usuario);
		}
		this.usuarioDao.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso");
		listar();
		return new ModelAndView("redirect:/usuario/listar");
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Integer id) {
		return preparaSalvar(usuarioDao.findOne(id));
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView apagar(@PathVariable Integer id, RedirectAttributes attributes) {
		usuarioDao.delete(id);
		attributes.addFlashAttribute("mensagem", "Usuário removido com sucesso");
		listar();
		return new ModelAndView("redirect:/usuario/listar");
	}
	
	
}
