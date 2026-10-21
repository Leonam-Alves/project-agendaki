CREATE TABLE agendamentos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    data VARCHAR(20) NOT NULL,
    hora VARCHAR(20) NOT NULL,
    status VARCHAR(50) NOT NULL,
    telefone VARCHAR(20),
    descricao TEXT
);