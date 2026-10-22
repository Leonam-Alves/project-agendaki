package com.br.agendaki.repository;

import com.br.agendaki.models.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    List<Profissional> findByCategoriaId(Long categoriaId);

    Optional<Profissional> findByRegistroProfissional(String registroProfissional);
}
