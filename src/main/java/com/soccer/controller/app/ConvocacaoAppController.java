package com.soccer.controller.app;

import com.soccer.model.Atleta;
import com.soccer.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/app/v1/convocacao")
@Controller
public class ConvocacaoAppController {

    @Autowired
    private AtletaService atletaService;

    @GetMapping
    public String homeConvocacao(Model model) {
        List<Atleta> atletaListOrdenacaoPadrao = atletaService.getAtletaListOrdenacaoPadrao();
        model.addAttribute("atletaList", atletaListOrdenacaoPadrao);

        model.addAttribute("botaoConvacacao", true);

        return "atletas-view";
    }

}
