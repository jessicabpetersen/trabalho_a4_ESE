CREATE TABLE IF NOT EXISTS public.filmes (
	id serial,
    nome character varying NOT NULL,
    duracao bigint NOT NULL,
    genero bigint NOT NULL,
    CONSTRAINT filmes_pkey PRIMARY KEY (id)
);
INSERT INTO filmes (nome, duracao, genero) VALUES('Gladiador', 176, 1);
INSERT INTO filmes (nome, duracao, genero) VALUES('AI', 122, 2);
INSERT INTO filmes (nome, duracao, genero) VALUES('Filme3', 80, 2);

CREATE TABLE IF NOT EXISTS public.ator (
	id serial,
    nome character varying NOT NULL,
    CONSTRAINT ator_pkey PRIMARY KEY (id)
);

INSERT INTO ator (nome) VALUES('fernando');
INSERT INTO ator (nome) VALUES('caio');
INSERT INTO ator (nome) VALUES('Jussara');

CREATE TABLE IF NOT EXISTS public.oscar_melhor_filme (
	id serial,
    ano bigint NOT NULL,
    id_filme bigint,
    CONSTRAINT oscar_melhor_filme_pkey PRIMARY KEY (id),
    CONSTRAINT id_filme FOREIGN KEY (id_filme)
        REFERENCES public.filmes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

INSERT INTO oscar_melhor_filme (ano, id_filme) VALUES(2000, 1);
INSERT INTO oscar_melhor_filme (ano, id_filme) VALUES(2003, 1);
INSERT INTO oscar_melhor_filme (ano, id_filme) VALUES(2004, 1);
INSERT INTO oscar_melhor_filme (ano, id_filme) VALUES(2000, 2);

CREATE TABLE IF NOT EXISTS public.elenco (
	id serial,
    id_ator bigint,
    id_filme bigint,
    CONSTRAINT elenco_pkey PRIMARY KEY (id),
    CONSTRAINT id_ator FOREIGN KEY (id_ator)
        REFERENCES public.ator (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT id_filme FOREIGN KEY (id_filme)
        REFERENCES public.filmes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

INSERT INTO elenco (id_ator, id_filme) VALUES(1, 1);
INSERT INTO elenco (id_ator, id_filme) VALUES(1, 2);
INSERT INTO elenco (id_ator, id_filme) VALUES(2, 1);
INSERT INTO elenco (id_ator, id_filme) VALUES(3, 2);

CREATE TABLE IF NOT EXISTS public.usuario (
	id serial,
    nome character varying NOT NULL,
    senha character varying NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

INSERT INTO usuario (nome, senha) VALUES('Pedro', 'pedrinho1');
INSERT INTO usuario (nome, senha) VALUES('Ana1', 'senha123');
INSERT INTO usuario (nome, senha) VALUES('Dani', 'sc12');
INSERT INTO usuario (nome, senha) VALUES('Usuario', 'umaSenha');

CREATE TABLE IF NOT EXISTS public.classificacoes (
	id serial,
    id_filme bigint,
    id_usuario bigint,
	sn_gostou bigint NOT NULL,
	dt_momento TIMESTAMP NOT NULL,
    CONSTRAINT classificacoes_pkey PRIMARY KEY (id),
    CONSTRAINT id_filme FOREIGN KEY (id)
        REFERENCES public.filmes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

INSERT INTO classificacoes (id_filme, id_usuario, sn_gostou, dt_momento) VALUES,1, 1, 10, '2020-10-10 10:23:54');
INSERT INTO classificacoes (id_filme, id_usuario, sn_gostou, dt_momento) VALUES(2, 1, 8,  '2020-11-19 16:33:12');
INSERT INTO classificacoes (id_filme, id_usuario, sn_gostou, dt_momento) VALUES(1, 2, 5,  '2021-01-09 20:45:45');

CREATE TABLE IF NOT EXISTS public.servico (
	id integer NOT NULL UNIQUE,
    nome character varying NOT NULL,
    CONSTRAINT servicos_pkey PRIMARY KEY (id)
);

INSERT INTO servico (id,nome) VALUES(1, 'Incluir Classificação');
INSERT INTO servico (id,nome) VALUES(2, 'Alterar Classificação');
INSERT INTO servico (id,nome) VALUES(3, 'Excluir Classificação');
INSERT INTO servico (id,nome) VALUES(4, 'Assistir Filme');

CREATE TABLE IF NOT EXISTS public.servicos_autorizados (
	id serial,
    sn_autorizado bigint NOT NULL,
    id_usuario bigint,
	id_servico bigint,
    CONSTRAINT servicos_autorizados_pkey PRIMARY KEY (id),
    CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT id_servico FOREIGN KEY (id_servico)
        REFERENCES public.servico (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

INSERT INTO servicos_autorizados (sn_autorizado, id_usuario, id_servico) VALUES(1, 1,1);
INSERT INTO servicos_autorizados (sn_autorizado, id_usuario, id_servico) VALUES(2, 1,2);

CREATE TABLE IF NOT EXISTS public.filmes_assistidos (
	id serial,
    id_usuario bigint,
	id_filme bigint,
	dt_momento TIMESTAMP,
    CONSTRAINT filmes_assistidos_pkey PRIMARY KEY (id),
    CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT id_filme FOREIGN KEY (id_filme)
        REFERENCES public.filmes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

INSERT INTO filmes_assistidos (id_usuario, id_filme, dt_momento) VALUES(1, 1,'2020-12-20 12:20:23');
INSERT INTO filmes_assistidos (id_usuario, id_filme, dt_momento) VALUES(2, 1,'2021-02-11 22:22:22');

CREATE TABLE IF NOT EXISTS public.servicos_usados (
	id serial,
    id_usuario bigint,
	id_servico bigint,
	dt_momento TIMESTAMP,
    CONSTRAINT servicos_usados_pkey PRIMARY KEY (id),
    CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT id_servico FOREIGN KEY (id_servico)
        REFERENCES public.servico (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);