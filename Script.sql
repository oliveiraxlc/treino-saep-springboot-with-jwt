
CREATE TABLE usuarios (
   id SERIAL PRIMARY KEY,
   nome VARCHAR(100) NOT NULL,
   email VARCHAR(100) UNIQUE NOT NULL,
   senha VARCHAR(255) NOT null,
   perfil varchar(50)
);

CREATE TABLE pretendentes (
   id SERIAL PRIMARY KEY,
   nome VARCHAR(100) NOT NULL,
   cpf VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE criancas (
   id SERIAL PRIMARY KEY,
   nome VARCHAR(100) NOT NULL,
   id_pretendentes INT NOT NULL,
   FOREIGN KEY (id_pretendentes) REFERENCES pretendentes(id)
);

CREATE TABLE atendimentos (
   id SERIAL PRIMARY KEY,
   data TIMESTAMP DEFAULT NOW(),
   descricao VARCHAR(255) NOT NULL,
   id_crianca INT NOT null REFERENCES criancas(id),
   id_usuario INT NOT NULL REFERENCES usuarios(id)
);


INSERT INTO usuarios (nome, email, senha, perfil) VALUES
('Ana', 'ana@email.com', '123', 'funcionario'),
('Carlos', 'carlos@email.com', '123', 'funcionario'),
('Fernanda', 'fernanda@email.com', '123', 'funcionario');

INSERT INTO pretendentes (nome, cpf) VALUES
('Roberto', md5('11111111111')),
('Mariana',md5('22222222222')),
('Juliana', md5('33333333333'));

INSERT INTO criancas (nome, id_pretendentes) VALUES
('Lucas', 1),
('Beatriz', 2),
('Gabriel', 3);

INSERT INTO atendimentos
(data, descricao, id_crianca, id_usuario) VALUES
('2026-10-01 09:00:00', 'Atendimento individual', 1, 1),
('2026-10-02 10:00:00', 'Acompanhamento escolar', 2, 2),
('2026-10-03 11:00:00', 'Avaliacao escolar', 3, 3);

