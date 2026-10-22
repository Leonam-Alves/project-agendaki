package com.br.agendaki.controllers;

import com.br.agendaki.dto.CategoriaRequestDTO;
import com.br.agendaki.dto.CategoriaResponseDTO;
import com.br.agendaki.exception.NomeDuplicadoException;
import com.br.agendaki.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorias")
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodos().stream()
                .map(CategoriaResponseDTO::fromEntity)
                .toList());
        return "categorias";
    }

    @GetMapping("/categorias/novo")
    public String novo(Model model) {
        model.addAttribute("categoria", new CategoriaRequestDTO());
        return "categoria-form";
    }

    @PostMapping("/categorias")
    public String salvar(@ModelAttribute("categoria") @Valid CategoriaRequestDTO categoria, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "categoria-form";
        }

        try {
            categoriaService.cadastrar(categoria);
        } catch (NomeDuplicadoException e) {
            model.addAttribute("erroNegocio", e.getMessage());
            return "categoria-form";
        }

        return "redirect:/categorias";
    }
}
