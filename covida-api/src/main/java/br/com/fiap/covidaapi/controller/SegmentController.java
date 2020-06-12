package br.com.fiap.covidaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.fiap.covidaapi.repository.SegmentRepository;

@Controller
@RequestMapping("/segments")
public class SegmentController {
	
	@Autowired
	public SegmentRepository repository;

}
