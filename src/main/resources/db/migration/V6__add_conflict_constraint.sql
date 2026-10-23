ALTER TABLE agendamentos
    ADD CONSTRAINT uq_profissional_data_hora UNIQUE (profissional_id, data, hora);
