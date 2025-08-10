CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(254) NOT NULL
);

CREATE TABLE usuarios_roles (
    usuario_id BIGINT NOT NULL,
    roles VARCHAR(255) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

CREATE TABLE ordem_de_servico (
    id BIGSERIAL PRIMARY KEY,
    nr INTEGER NOT NULL,
    fazenda VARCHAR(255) NOT NULL,
    nome_proprietario VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    sog VARCHAR(255) NOT NULL,
    uc VARCHAR(255) NOT NULL,
    hora_do_chamado TIMESTAMP NOT NULL
);

CREATE TABLE drops (
    id BIGSERIAL PRIMARY KEY,
    ordem_id BIGINT NOT NULL,
    uc_chamado VARCHAR(255) NOT NULL,
    uc_atendimento VARCHAR(255) NOT NULL,
    fazenda VARCHAR(255) NOT NULL,
    hora_deslocamento TIMESTAMP NOT NULL,
    hora_chegada TIMESTAMP NOT NULL,
    hora_conclusao TIMESTAMP NOT NULL,
    status_controlador VARCHAR(255) NOT NULL,
    status_baterias VARCHAR(255) NOT NULL,
    status_inversor VARCHAR(255) NOT NULL,
    status_disjuntor VARCHAR(255) NOT NULL,
    relato_cliente TEXT NOT NULL,
    causa TEXT NOT NULL,
    efeito TEXT NOT NULL,
    amperagem_disjuntor VARCHAR(255) NOT NULL,
    potencia_utilizada INTEGER NOT NULL,
    lacre_caixa_disjuntor VARCHAR(255) NOT NULL,
    tratativa TEXT NOT NULL,
    observacao TEXT NOT NULL,
    material_retirado VARCHAR(255),
    material_aplicado VARCHAR(255),
    FOREIGN KEY (ordem_id) REFERENCES ordem_de_servico(id) ON DELETE CASCADE
);

CREATE TABLE fotos (
    id BIGSERIAL PRIMARY KEY,
    drop_id BIGINT NOT NULL,
    url VARCHAR(255) NOT NULL,
    FOREIGN KEY (drop_id) REFERENCES drops(id) ON DELETE CASCADE
);