package com.br.agendaki.controllers;

import com.br.agendaki.dto.AgendamentoResponseDTO;
import com.br.agendaki.services.AgendamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final AgendamentoService agendamentoService;

    public HomeController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("agendamentos", agendamentoService.buscarUltimosTres().stream()
                .map(AgendamentoResponseDTO::fromEntity)
                .toList());
        return "index";
    }
}
