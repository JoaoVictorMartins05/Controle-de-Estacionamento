
use estacionamento;

CREATE TABLE tbl_usuario(
	id int auto_increment NOT NULL, 
	nome  varchar(150) NOT NULL, 
	usuario varchar(150) NOT NULL, 
	senha varchar(150) NOT NULL,

CONSTRAINT PK_tbl_usuario PRIMARY KEY CLUSTERED 
	(
	id 
	)	
);


CREATE TABLE tbl_movimentacao(
		id int auto_increment NOT NULL, 
		placa  varchar(150) NOT NULL, 
		modelo varchar(150) NOT NULL, 
		data_entrada DateTime NOT NULL,
		data_saida DateTime NULL,
		tempo int NOT NULL,
		valor_pago float NULL,

	CONSTRAINT PK_tbl_movimentacao PRIMARY KEY CLUSTERED 
	(
		id ASC
	));



CREATE TABLE tbl_valor(
		id int auto_increment NOT NULL, 
		valor_primeira_hora float NOT NULL, 
		valor_demais_horas float NULL,
		data_fim DateTime NULL,

	CONSTRAINT PK_tbl_valor PRIMARY KEY CLUSTERED 
	(
		id ASC
	));



insert into tbl_usuario (nome, usuario, senha) values ('admin', 'admin', '123456');

insert into tbl_valor (valor_primeira_hora, valor_demais_horas, data_fim) values (6.00, 4.00, null);


