package com.soccer.controller;

import com.soccer.model.Atleta;
import com.soccer.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeViewController {

    @Autowired
    private AtletaService atletaService;

    @GetMapping
    public String home(Model model) {
        List<Atleta> atletaList = atletaService.getAtletaList();
        model.addAttribute("atletaList", atletaList);
        return "soccer-view";
    }

}
