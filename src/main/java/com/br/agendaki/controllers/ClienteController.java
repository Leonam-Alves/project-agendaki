package com.br.agendaki.controllers;

import com.br.agendaki.dto.ClienteRequestDTO;
import com.br.agendaki.dto.ClienteResponseDTO;
import com.br.agendaki.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos().stream()
                .map(ClienteResponseDTO::fromEntity)
                .toList());
        return "clientes";
    }

    @GetMapping("/clientes/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new ClienteRequestDTO());
        return "cliente-form";
    }

    @PostMapping("/clientes")
    public String salvar(@ModelAttribute("cliente") @Valid ClienteRequestDTO cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "cliente-form";
        }

        clienteService.cadastrar(cliente);

        return "redirect:/clientes";
    }
}
