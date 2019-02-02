CREATE TABLE empresa
(
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	cnpj varchar(255) NOT NULL,
	data_atualizacao datetime NOT NULL,
	data_criacao datetime NOT NULL,
	razao_social varchar(255) NOT NULL
	
)
ENGINE = InnoDb DEFAULT CHARSET=utf8;