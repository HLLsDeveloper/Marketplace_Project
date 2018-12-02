create database tshirt_games_web_3;
use tshirt_games_web_3;

create table PRODUTO (
idproduto int not null auto_increment primary key,
produto varchar(40),
imagem varchar(80),
descricao varchar(1000),
modelo varchar(20),
genero varchar(20),
cor varchar(20),
categoria varchar(20),
tamanho varchar(3),
valor_custo float(8,2),
valor_venda float(8,2),
quantidade int(8),
referencia varchar(6) not null,
condicao char(7)
);

insert into PRODUTO(produto, imagem, descricao, modelo, genero, cor, categoria, tamanho, valor_custo, valor_venda, quantidade, referencia, condicao) values("Camiseta Dragon Ball 1", "camisa dragonball 04.png", "Camiseta Dragon Ball de alta qualidade estampado direto na camiseta", "Manga longa", "Masculino", "Branco e Preto", "Animes", "P", 50.00, 50.00, 59, "123456", "ativo");
insert into PRODUTO(produto, imagem, descricao, modelo, genero, cor, categoria, tamanho, valor_custo, valor_venda, quantidade, referencia, condicao) values("Camiseta Dragon Ball 2", "camisa dragonball 04.png", "Camiseta Dragon Ball de alta qualidade estampado direto na camiseta", "Manga longa", "Masculino", "Branco e Preto", "Animes", "M", 50.00, 50.00, 52, "123456", "ativo");
insert into PRODUTO(produto, imagem, descricao, modelo, genero, cor, categoria, tamanho, valor_custo, valor_venda, quantidade, referencia, condicao) values("Camiseta Dragon Ball 3", "camisa dragonball 04.png", "Camiseta Dragon Ball de alta qualidade estampado direto na camiseta", "Manga longa", "Masculino", "Branco e Preto", "Animes", "G", 50.00, 50.00, 125, "123456", "ativo");
insert into PRODUTO(produto, imagem, descricao, modelo, genero, cor, categoria, tamanho, valor_custo, valor_venda, quantidade, referencia, condicao) values("Camiseta Dragon Ball 4", "camisa dragonball 04.png", "Camiseta Dragon Ball de alta qualidade estampado direto na camiseta", "Manga longa", "Masculino", "Branco e Preto", "Animes", "GG", 50.00, 50.00, 125, "123456", "ativo");