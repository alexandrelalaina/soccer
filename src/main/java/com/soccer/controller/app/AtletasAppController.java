package com.soccer.controller.app;

import com.soccer.model.Atleta;
import com.soccer.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/app/v1/atletas")
@Controller
public class AtletasAppController {

    @Autowired
    private AtletaService atletaService;

    @GetMapping
    public String homeAtletas(Model model) {
        List<Atleta> atletaList = atletaService.getAtletaListOrdenacaoPadrao();
        model.addAttribute("atletaList", atletaList);
        return "atletas-view";
    }

}
