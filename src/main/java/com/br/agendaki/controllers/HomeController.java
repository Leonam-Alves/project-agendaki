package com.br.agendaki.controllers;

import com.br.agendaki.models.Agendamento;
import com.br.agendaki.services.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final AgendamentoService agendamentoService;

    public HomeController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("agendamentos", agendamentoService.buscarUltimosTres());
        return "index";
    }

    @GetMapping("/agendamentos")
    public String agendamentos(Model model) {
        model.addAttribute("agendamentos", agendamentoService.listarTodos());
        return "agendamentos";
    }

    @GetMapping("/agendamentos/novo")
    public String agendar(Model model) {
        model.addAttribute("agendamento", new Agendamento());
        return "agendar";
    }

    @PostMapping("/agendamentos")
    public String salvarAgendamento(@Valid Agendamento agendamento, BindingResult result) {
        if (result.hasErrors()) {
            return "agendar";
        }

        agendamentoService.cadastrar(agendamento);

        return "redirect:/agendamentos";
    }
}
