package com.soccer.controller;

import com.soccer.model.Selecao;
import com.soccer.service.ConvocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/convocacao")
@RestController
public class ConvocacaoController {

    @Autowired
    private ConvocacaoService convocacaoService;

    @GetMapping
    public List<Selecao> execute(){
        List<Selecao> selecaoList = convocacaoService.execute();
        return selecaoList;
    }

}
