package com.br.agendaki.controllers;

import com.br.agendaki.dto.AgendamentoRequestDTO;
import com.br.agendaki.dto.AgendamentoResponseDTO;
import com.br.agendaki.exception.AgendamentoConflitanteException;
import com.br.agendaki.exception.EntidadeNaoEncontradaException;
import com.br.agendaki.services.AgendamentoService;
import com.br.agendaki.services.CategoriaService;
import com.br.agendaki.services.ClienteService;
import com.br.agendaki.services.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    private final ClienteService clienteService;
    private final ProfissionalService profissionalService;
    private final CategoriaService categoriaService;

    public AgendamentoController(
            AgendamentoService agendamentoService,
            ClienteService clienteService,
            ProfissionalService profissionalService,
            CategoriaService categoriaService
    ) {
        this.agendamentoService = agendamentoService;
        this.clienteService = clienteService;
        this.profissionalService = profissionalService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/agendamentos")
    public String listar(Model model) {
        model.addAttribute("agendamentos", agendamentoService.listarTodos().stream()
                .map(AgendamentoResponseDTO::fromEntity)
                .toList());
        return "agendamentos";
    }

    @GetMapping("/agendamentos/novo")
    public String novo(Model model) {
        model.addAttribute("agendamento", new AgendamentoRequestDTO());
        adicionarListasDeApoio(model);
        return "agendar";
    }

    @PostMapping("/agendamentos")
    public String salvar(@ModelAttribute("agendamento") @Valid AgendamentoRequestDTO agendamento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            adicionarListasDeApoio(model);
            return "agendar";
        }

        try {
            agendamentoService.cadastrar(agendamento);
        } catch (EntidadeNaoEncontradaException | AgendamentoConflitanteException e) {
            model.addAttribute("erroNegocio", e.getMessage());
            adicionarListasDeApoio(model);
            return "agendar";
        }

        return "redirect:/agendamentos";
    }

    private void adicionarListasDeApoio(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("profissionais", profissionalService.listarTodos());
        model.addAttribute("categorias", categoriaService.listarTodos());
    }
}
