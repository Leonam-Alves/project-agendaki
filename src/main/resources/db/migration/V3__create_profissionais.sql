CREATE TABLE profissionais (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    registro_profissional VARCHAR(20) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    categoria_id BIGINT NOT NULL,
    CONSTRAINT fk_profissional_categoria
        FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);
