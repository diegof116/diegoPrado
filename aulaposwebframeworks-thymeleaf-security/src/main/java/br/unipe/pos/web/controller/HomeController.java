package br.unipe.pos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
	

   @RequestMapping("/")
   public String index(){
      return "index";
   }
   
   @RequestMapping("/login")
   public String login(){
      return "login";
   }
   
   @RequestMapping("/logout")
   public String logout(){
      return "login";
   }
   
   @RequestMapping("/negado")
   public String acessoNegado(){
      return "negado";
   }

   @RequestMapping("/sobre")
   public String sobre(){
	   return "sobre";
   }
}
