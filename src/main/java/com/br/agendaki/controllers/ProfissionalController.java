package com.br.agendaki.controllers;

import com.br.agendaki.dto.ProfissionalRequestDTO;
import com.br.agendaki.dto.ProfissionalResponseDTO;
import com.br.agendaki.exception.EntidadeNaoEncontradaException;
import com.br.agendaki.exception.NomeDuplicadoException;
import com.br.agendaki.services.CategoriaService;
import com.br.agendaki.services.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfissionalController {

    private final ProfissionalService profissionalService;
    private final CategoriaService categoriaService;

    public ProfissionalController(ProfissionalService profissionalService, CategoriaService categoriaService) {
        this.profissionalService = profissionalService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/profissionais")
    public String listar(Model model) {
        model.addAttribute("profissionais", profissionalService.listarTodos().stream()
                .map(ProfissionalResponseDTO::fromEntity)
                .toList());
        return "profissionais";
    }

    @GetMapping("/profissionais/novo")
    public String novo(Model model) {
        model.addAttribute("profissional", new ProfissionalRequestDTO());
        model.addAttribute("categorias", categoriaService.listarTodos());
        return "profissional-form";
    }

    @PostMapping("/profissionais")
    public String salvar(@ModelAttribute("profissional") @Valid ProfissionalRequestDTO profissional, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaService.listarTodos());
            return "profissional-form";
        }

        try {
            profissionalService.cadastrar(profissional);
        } catch (EntidadeNaoEncontradaException | NomeDuplicadoException e) {
            model.addAttribute("erroNegocio", e.getMessage());
            model.addAttribute("categorias", categoriaService.listarTodos());
            return "profissional-form";
        }

        return "redirect:/profissionais";
    }
}
