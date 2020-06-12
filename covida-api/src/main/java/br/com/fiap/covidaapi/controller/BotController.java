package br.com.fiap.covidaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.covidaapi.repository.BotRepository;

@Controller
@RequestMapping("/bots")
public class BotController {
	
	@Autowired
	public BotRepository repository;
	

}
