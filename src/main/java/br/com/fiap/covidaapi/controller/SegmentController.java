package br.com.fiap.covidaapi.controller;

import javax.validation.Valid;

import br.com.fiap.covidaapi.repository.SegmentRepository;
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

import br.com.fiap.covidaapi.model.SegmentModel;

@Controller
@RequestMapping("/segments")
public class SegmentController {
	
	private static final String FOLDER = "segments/";

	@Autowired
	public SegmentRepository repository;
	
	@GetMapping("/form")
	public String open(@RequestParam String page, 
					   @RequestParam(required = true) Integer id,
					   @ModelAttribute("segmentModel") SegmentModel segmentModel, 
					   Model model) {
		
		if("segment-editar".equals(page)) 
			model.addAttribute("segmentModel", repository.findById(id).get());
		
		return FOLDER + page;
	}
	
	@GetMapping()
	public String findAll(Model model) {
		model.addAttribute("segments", repository.findAll());
		return FOLDER +  "segments";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") int id, Model model) {
		model.addAttribute("segment", repository.findById(id).get());
		return FOLDER +  "segment-detalhe";
	}
	
	@PostMapping()
	public String save(@Valid SegmentModel segmentModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) 
			return FOLDER + "segment-novo";
		
		repository.save(segmentModel);
		redirectAttributes.addFlashAttribute("messages", "Segmento cadastrado com sucesso!");
		return "redirect:/segments";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") int id, @Valid SegmentModel segmentModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) 
			return FOLDER + "segment-editar";
		
		segmentModel.setId(id);
		repository.save(segmentModel);
		redirectAttributes.addFlashAttribute("messages", "Segmento alterado com sucesso!");
		return "redirect:/segments";
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		repository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "Segmento excluído com sucesso!");
		return "redirect:/segments";
	}

}
