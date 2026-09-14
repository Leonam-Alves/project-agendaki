package com.br.agendaki.controllers;

import com.br.agendaki.models.Agendamento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Controller
public class HomeController {
    private static List<Agendamento> listaAgendamentos = new ArrayList<>(Arrays.asList(
            new Agendamento(1L, "Joãozinho", "26/08/2026", "15:00", "Finalizado"),
            new Agendamento(2L, "Maria da Silva", "02/09/2026", "18:00", "Cancelado"),
            new Agendamento(3L, "José", "30/09/2026", "12:00", "Confirmado")
    ));

    @GetMapping("/")
    public String index(Model model){
        List<Agendamento> listaInvertida = new ArrayList<>(listaAgendamentos);

        Collections.reverse(listaInvertida);

        List<Agendamento> ultimosAgendamentos = listaInvertida.stream()
                .limit(3)
                .toList();

        model.addAttribute("agendamentos", ultimosAgendamentos);
        return "index";
    }

    @GetMapping("/agendamentos")
    public String agendamentos(Model model) {
        model.addAttribute("agendamentos", listaAgendamentos);
        return "agendamentos";
    }

    @GetMapping("/agendamentos/novo")
    public String agendar(Model model) {
        model.addAttribute("agendamento", new Agendamento());
        return "agendar";
    }

    @PostMapping("/agendamentos")
    public String salvarAgendamento(Agendamento agendamento) {
        long novoId = listaAgendamentos.size() + 1;
        agendamento.setId(novoId);

        if (agendamento.getStatus() == null || agendamento.getStatus().isEmpty()) {
            agendamento.setStatus("Pendente");
        }

        if (agendamento.getData() != null && !agendamento.getData().isEmpty()) {
            try {
                LocalDate dataIso = LocalDate.parse(agendamento.getData());

                DateTimeFormatter formatadorBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                agendamento.setData(dataIso.format(formatadorBr));
            } catch (Exception e) {
            }
        }

        listaAgendamentos.add(agendamento);

        return "redirect:/agendamentos";
    }
}
