package com.luffy.todo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.luffy.todo.model.Todo;
import com.luffy.todo.service.Todoservice;

@Controller
public class Todocontroller {
   @Autowired	
   private Todoservice service;
   
  @GetMapping({"/", "viewtodo"})
  public String viewallitems(Model model, @ModelAttribute("message") String message) {
	  model.addAttribute("list",  service.getallitems());
	  model.addAttribute("message",  message);
	  return "Viewtodo"; 
  }
  @GetMapping("/updatetodostatus/{id}")
  public String updatetodostatus(@PathVariable Long id,RedirectAttributes redirectAttributes) {
	  if(service.updatestatus(id)) { 
		  redirectAttributes.addFlashAttribute("message", "update succcess");
		  return "redirect:/viewtodo" ;
		  }
	  redirectAttributes.addFlashAttribute("message", "update failure");
	  return "redirect:/viewtodo";
  }
  
  
  @GetMapping("/addtodo")
  public String add(Model model) {
	  model.addAttribute("todo", new Todo());
	  return "Addtodo";
  }  
  
  
  @PostMapping("/savetodo")
  public String save(Todo todo,RedirectAttributes redirectAttributes ) {
	  if(service.saveorupdate(todo)) { 
		  
		  redirectAttributes.addFlashAttribute("message", "save success");
		  return "redirect:/viewtodo";
	  }
	  redirectAttributes.addFlashAttribute("message", "save failure");
	  return "redirect:/addtodo";
  }
  
  
  @GetMapping("/edittodo/{id}")
  public String edit(@PathVariable Long id, Model model) {
	  model.addAttribute("todo", service.getitembyid(id));
	  
	  return "Edittodo";
  }  
  
  
  
  @PostMapping("/editsavetodo")
  public String editsave(Todo todo,RedirectAttributes redirectAttributes) {
if(service.saveorupdate(todo)) { 
		  
		  redirectAttributes.addFlashAttribute("message", "edit success");
		  return "redirect:/viewtodo";
	  }
	  redirectAttributes.addFlashAttribute("message", "edit failure");
	  return "redirect:/edittodo/" + todo.getId();
  } 
  
  @GetMapping("/deletetodo/{id}")
  public String deletetodo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
	  if(service.delete(id)) {
		  redirectAttributes.addFlashAttribute("message", "delete success");
	  }
	  redirectAttributes.addFlashAttribute("message", "delete failure");
	  return "redirect:/viewtodo";
  } 
}
