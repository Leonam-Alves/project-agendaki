package com.br.agendaki.repository;

import com.br.agendaki.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    // Método customizado que o Spring implementa sozinho:
    // Busca todos os agendamentos de um dia específico
    List<Agendamento> findByData(String data);

    // Método customizado: Busca agendamentos de um cliente específico pelo nome
    List<Agendamento> findByNomeContainingIgnoreCase(String nome);

    // Método customizado: Busca um agendamento específico pela data e hora (para evitar choques de horário)
    Optional<Agendamento> findByDataAndHora(String data, String hora);
}

