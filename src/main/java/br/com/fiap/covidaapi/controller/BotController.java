package br.com.fiap.covidaapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.covidaapi.model.BotModel;
import br.com.fiap.covidaapi.repository.BotRepository;

@Controller
@RequestMapping("/bots")
public class BotController {
	
	private static final String FOLDER = "bots/";
	
	@Autowired
	public BotRepository repository;
	
	@GetMapping("/form")
	public String open(@RequestParam String page, 
					   @RequestParam(required = true) Integer id,
					   @ModelAttribute("botModel") BotModel botModel, 
					   Model model) {
		
		if("bot-editar".equals(page)) 
			model.addAttribute("botModel", repository.findById(id).get());
		
		return FOLDER + page;
	}
	
	@GetMapping()
	public String findAll(Model model) {
		model.addAttribute("bots", repository.findAll());
		return FOLDER + "bot";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") int id, Model model) {
		model.addAttribute("bot", repository.findById(id).get());
		return FOLDER +  "bot-detalhe";
	}
	
	@PostMapping()
	public String save(@Valid BotModel botModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) 
			return FOLDER + "bot-novo";
		
		repository.save(botModel);
		redirectAttributes.addFlashAttribute("messages", "Bot cadastrado com sucesso!");
		return "redirect:/bots";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") int id, @Valid BotModel botModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) 
			return FOLDER + "bot-editar";
		
		botModel.setId(id);
		repository.save(botModel);
		redirectAttributes.addFlashAttribute("messages", "Bot alterado com sucesso!");
		return "redirect:/bots";
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		repository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "Bot excluído com sucesso!");
		return "redirect:/bots";
	}
}
