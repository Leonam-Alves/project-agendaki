package com.br.agendaki.models;

import com.br.agendaki.utils.Validacoes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "profissionais")
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do profissional é obrigatório.")
    @Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres.")
    @Column(nullable = false, length = 150)
    private String nome;

    @NotBlank(message = "O registro profissional (CRM) é obrigatório.")
    @Size(max = 20, message = "O registro profissional deve ter no máximo 20 caracteres.")
    @Column(name = "registro_profissional", nullable = false, length = 20, unique = true)
    private String registroProfissional;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = Validacoes.TELEFONE_REGEX, message = "Telefone inválido. Use o formato (xx) xxxxx-xxxx.")
    @Column(nullable = false, length = 20)
    private String telefone;

    @NotNull(message = "A categoria é obrigatória.")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Profissional() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
