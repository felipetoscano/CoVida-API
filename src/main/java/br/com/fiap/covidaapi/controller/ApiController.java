package br.com.fiap.covidaapi.controller;

import br.com.fiap.covidaapi.model.BotModel;
import br.com.fiap.covidaapi.model.OptionModel;
import br.com.fiap.covidaapi.model.SegmentModel;
import br.com.fiap.covidaapi.repository.BotRepository;
import br.com.fiap.covidaapi.repository.OptionRepository;
import br.com.fiap.covidaapi.repository.SegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    public SegmentRepository segmentRepository;

    @Autowired
    public BotRepository botRepository;

    @Autowired
    public OptionRepository optionRepository;

    @GetMapping("/bots")
    public List<BotModel> findAllBots() {
        return botRepository.findAll();
    }

    @GetMapping("/segments/{id}")
    public List<SegmentModel> findSegmentsById(@PathVariable("id") int id){
        return segmentRepository.findAllByIdBot(id);
    }

    @GetMapping("/options/{id}")
    public List<OptionModel> findOptionsById(@PathVariable("id") int id){
        return optionRepository.findAllByIdSegment(id);
    }
}
