TRUNCATE TABLE agendamentos;

ALTER TABLE agendamentos
    DROP COLUMN nome,
    DROP COLUMN telefone;

ALTER TABLE agendamentos
    ADD COLUMN cliente_id BIGINT,
    ADD COLUMN profissional_id BIGINT,
    ADD COLUMN categoria_id BIGINT;

ALTER TABLE agendamentos
    ALTER COLUMN data TYPE DATE USING data::date,
    ALTER COLUMN hora TYPE TIME USING hora::time,
    ALTER COLUMN status TYPE VARCHAR(20);

ALTER TABLE agendamentos
    ADD CONSTRAINT fk_agendamento_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    ADD CONSTRAINT fk_agendamento_profissional FOREIGN KEY (profissional_id) REFERENCES profissionais(id),
    ADD CONSTRAINT fk_agendamento_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id);

ALTER TABLE agendamentos
    ALTER COLUMN cliente_id SET NOT NULL,
    ALTER COLUMN profissional_id SET NOT NULL,
    ALTER COLUMN categoria_id SET NOT NULL;
