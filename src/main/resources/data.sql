create schema if not exists moviebattle;

drop table moviebattle.quiz IF EXISTS;
CREATE TABLE moviebattle.quiz (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
jogador_id MEDIUMINT NOT NULL,
filme_id MEDIUMINT NOT NULL,
data_quiz VARCHAR(15),
tentativas MEDIUMINT,
respondido MEDIUMINT,
PRIMARY KEY (id));

drop table moviebattle.jogador IF EXISTS;
CREATE TABLE moviebattle.jogador (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
quiz_id MEDIUMINT NOT NULL,
nome VARCHAR(200),
endereco VARCHAR(200),
telefone VARCHAR(20) default '',
email VARCHAR(150),
pontuacao DOUBLE,
PRIMARY KEY (id),
UNIQUE INDEX nome_unique (nome ASC));

drop table moviebattle.filme IF EXISTS;
CREATE TABLE moviebattle.filme (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
nome VARCHAR(250),
pontuacao DOUBLE,
nota DOUBLE,
voto MEDIUMINT,
PRIMARY KEY (id));

drop table moviebattle.ranking IF EXISTS;
CREATE TABLE moviebattle.ranking (
 id MEDIUMINT NOT NULL AUTO_INCREMENT,
 jogador_id MEDIUMINT NOT NULL,
 pontuacao DOUBLE,
 PRIMARY KEY (id));

-- ----------------------------------------
-- DADOS JOGADOR
-- ----------------------------------------
insert into moviebattle.jogador(quiz_id,nome,endereco,email,pontuacao) values (1,'Jogador 1','Enable debug logs.','teste@letscode.com',0);
insert into moviebattle.jogador(quiz_id,nome,endereco,email,pontuacao) values (2,'Jogador 2','Enable debug logs.','teste@letscode.com',0);

-- ----------------------------------------
-- DADOS FILME
-- ----------------------------------------
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('The Batman',1,1,1);
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('Doutor Estranho no Multiverso da Loucura',1,1,1);
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('Thor: Amor e Trovão',1,1,1);
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('Pantera Negra: Wakanda Forever',1,1,1);
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('Spencer',1,1,1);
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('John Wick 4',1,1,1);
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('Homem-Aranha através do Aranhaverso',1,1,1);
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('Avatar 2',1,1,1);
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('O Beco do Pesadelo',1,1,1);
insert into moviebattle.filme(nome,pontuacao,nota,voto) values ('Missão Impossível 7',1,1,1);

-- ----------------------------------------
-- DADOS QUIZ
-- ----------------------------------------
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
insert into moviebattle.quiz(jogador_id,filme_id,data_quiz,tentativas,respondido) values (1,1,'01/01/2022',0,0);
-- ----------------------------------------
-- DADOS RANKING
-- ----------------------------------------
insert into moviebattle.ranking(jogador_id,pontuacao) values (1,0);
insert into moviebattle.ranking(jogador_id,pontuacao) values (1,0);
insert into moviebattle.ranking(jogador_id,pontuacao) values (1,0);
insert into moviebattle.ranking(jogador_id,pontuacao) values (1,0);
insert into moviebattle.ranking(jogador_id,pontuacao) values (1,0);
insert into moviebattle.ranking(jogador_id,pontuacao) values (1,0);
insert into moviebattle.ranking(jogador_id,pontuacao) values (1,0);
insert into moviebattle.ranking(jogador_id,pontuacao) values (1,0);
insert into moviebattle.ranking(jogador_id,pontuacao) values (1,0);
