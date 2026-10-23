package com.br.agendaki.repository;

import com.br.agendaki.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByData(LocalDate data);

    List<Agendamento> findByClienteNomeContainingIgnoreCase(String nome);

    Optional<Agendamento> findByProfissionalIdAndDataAndHora(Long profissionalId, LocalDate data, LocalTime hora);

    List<Agendamento> findTop3ByOrderByIdDesc();
}
