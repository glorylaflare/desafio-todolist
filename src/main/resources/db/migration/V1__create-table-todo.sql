CREATE TABLE todos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    realizado BOOLEAN NOT NULL,
    prioridade INT NOT NULL
);