package com.br.agendaki.dto;

import com.br.agendaki.utils.Validacoes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ProfissionalRequestDTO {
    @NotBlank(message = "O nome do profissional é obrigatório.")
    @Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres.")
    private String nome;

    @NotBlank(message = "O registro profissional (CRM) é obrigatório.")
    @Size(max = 20, message = "O registro profissional deve ter no máximo 20 caracteres.")
    private String registroProfissional;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = Validacoes.TELEFONE_REGEX, message = "Telefone inválido. Use o formato (xx) xxxxx-xxxx.")
    private String telefone;

    @NotNull(message = "A categoria é obrigatória.")
    private Long categoriaId;

    public ProfissionalRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
