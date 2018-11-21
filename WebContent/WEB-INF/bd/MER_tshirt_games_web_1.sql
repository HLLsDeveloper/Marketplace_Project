create database tshirt_games_web_1;
use tshirt_games_web_1;

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

create table FISICO (
idusuario int not null auto_increment primary key,
email varchar(50),
senha varchar(16),
cpf varchar(11),
nome varchar(40),
sobrenome varchar(20),
datanascimento bigint(8),
sexo varchar(9),
telefone varchar(13),
celular varchar(14),
condicao char(7)
);

create table JURIDICO (
idempresa int not null auto_increment primary key,
email varchar(50),
senha varchar(16),
cnpj varchar(13),
razao varchar(20),
nomefantasia varchar(20),
ie varchar(30),
telefone varchar(13),
celular varchar(14),
condicao char(7)
);

create table ENDERECO_FISICO (
idendereco int not null auto_increment primary key,
idenderecofisico int not null,
nomeendereco varchar(20),
endereco varchar(30),
numero int(8),
complemento varchar(50),
bairro varchar(50),
cidade varchar(40),
estado varchar(30),
cep varchar(9)
);

create table ENDERECO_JURIDICO (
idendereco int not null auto_increment primary key,
idenderecojuridico int not null,
nomeendereco varchar(20),
endereco varchar(30),
numero int(8),
complemento varchar(50),
bairro varchar(50),
cidade varchar(40),
estado varchar(30),
cep varchar(9)
);

create table COMPRAFISICO (
idcompra int not null auto_increment primary key,
numeropedido bigint(20) not null,
idusuario int not null,
destinatario varchar(20),
idproduto int not null,
tamanho varchar(10),
cor varchar(20),
quantidade int(8)
);

create table COMPRAJURIDICO (
idcompra int not null auto_increment primary key,
numeropedido bigint(20) not null,
idempresa int not null,
destinatario varchar(20),
idproduto int not null,
tamanho varchar(10),
cor varchar(20),
quantidade int(8)
);

create table FORNECEDORES (
idfornecedor int not null auto_increment primary key,
razao varchar(20),
cnpj varchar(20),
ie varchar(20),
telefone varchar(20),
endereco varchar(50),
bairro varchar(50),
cidade varchar(40),
estado varchar(10),
cep varchar(10)
);

insert into FORNECEDORES(razao,cnpj,ie,telefone,endereco,bairro,cidade,estado,cep) value ('Eldrick','55.624.644/0001-42','739.602.736.129','(11) 4326-0091','R. Célso Egídio Souza Santos, 399','Jardim Chapadão','Campinas','SP','13070-057');
insert into FORNECEDORES(razao,cnpj,ie,telefone,endereco,bairro,cidade,estado,cep) value ('Herslag','12.770.269/0001-36','636.354.536.870','(11) 4251-0236','R. Caetés, 482','Conceição','Diadema','SP','09991-110');
insert into FORNECEDORES(razao,cnpj,ie,telefone,endereco,bairro,cidade,estado,cep) value ('Hyra Suits','79.355.056/0001-19','966.698.360.102','(11) 3452-0094','Estr. Luiz Marson, 366','Batistini','São Bernardo do Campo','SP','09842-000');

insert into PRODUTO(produto, imagem, descricao, modelo, genero, cor, categoria, tamanho, valor_custo, valor_venda, quantidade, referencia, condicao) values("Camiseta Dragon Ball 1", "camisa dragonball 04.png", "Camiseta Dragon Ball de alta qualidade estampado direto na camiseta", "Manga longa", "Masculino", "Branco e Preto", "Animes", "P", 60.99, 60.99, 59, "123456", "ativo");
insert into PRODUTO(produto, imagem, descricao, modelo, genero, cor, categoria, tamanho, valor_custo, valor_venda, quantidade, referencia, condicao) values("Camiseta Dragon Ball 2", "camisa dragonball 04.png", "Camiseta Dragon Ball de alta qualidade estampado direto na camiseta", "Manga longa", "Masculino", "Branco e Preto", "Games", "M", 50.99, 50.99, 52, "234567", "ativo");
insert into PRODUTO(produto, imagem, descricao, modelo, genero, cor, categoria, tamanho, valor_custo, valor_venda, quantidade, referencia, condicao) values("Camiseta Dragon Ball 3", "camisa dragonball 04.png", "Camiseta Dragon Ball de alta qualidade estampado direto na camiseta", "Manga longa", "Masculino", "Branco e Preto", "Filmes", "G", 40.99, 40.99, 125, "345678", "ativo");
insert into PRODUTO(produto, imagem, descricao, modelo, genero, cor, categoria, tamanho, valor_custo, valor_venda, quantidade, referencia, condicao) values("Camiseta Dragon Ball 4", "camisa dragonball 04.png", "Camiseta Dragon Ball de alta qualidade estampado direto na camiseta", "Manga longa", "Masculino", "Branco e Preto", "Series", "GG", 30.99, 30.99, 125, "456789", "ativo");

insert into FISICO(email, senha, cpf, nome, sobrenome, datanascimento, sexo, telefone, celular, condicao) values("hugonsantos03@gmail.com", "123456", 43258977801, "Hugo", "Nascimento", "22031995", "Masculino", 1145236996, 11948523236, "Ativo");
insert into FISICO(email, senha, cpf, nome, sobrenome, datanascimento, sexo, telefone, celular, condicao) values("fabiananascimento@gmail.com", "123456", 15498752305, "Fabiana", "Nascimento", "22031995", "Feminino", 1145234416, 11952892146, "Ativo");

insert into ENDERECO_FISICO(idenderecofisico, endereco, numero, complemento, bairro, cidade, estado, cep) values(1, "Rua João dias", 8978, "Casa 2", "Vila Maria Matilda da Conceição Barros", "São Bernardo do Campo", "São Paulo", 09758520);
insert into ENDERECO_FISICO(idenderecofisico, endereco, numero, complemento, bairro, cidade, estado, cep) values(1, "Rua Ramelhão", 12, "", "Vila Matilda", "São Bernardo do Campo", "São Paulo", 09750225);
insert into ENDERECO_FISICO(idenderecofisico, endereco, numero, complemento, bairro, cidade, estado, cep) values(2, "Rua Coronel Prestes", 53, "", "Vila Leopoldina", "Santo Andre", "São Paulo", 09780447);
insert into ENDERECO_FISICO(idenderecofisico, endereco, numero, complemento, bairro, cidade, estado, cep) values(2, "Rua Miguel Sampaio", 168, "", "Vila Galvez", "São Caetano do Sul", "São Paulo", 09687558);

insert into JURIDICO(email, senha, cnpj, razao, nomefantasia, ie, telefone, celular, condicao) values("hllsdeveloper@gmail.com", "123456", 1000123552135, "HLLs Developer", "HLLs", "Não Consta", 1145879620, 11958623658, "Ativo");

alter table ENDERECO_FISICO add foreign key (idenderecofisico) references FISICO(idusuario);
alter table ENDERECO_JURIDICO add foreign key (idenderecojuridico) references JURIDICO(idempresa);
alter table COMPRAFISICO add foreign key (idusuario) references FISICO(idusuario);
alter table COMPRAFISICO add foreign key (idproduto) references PRODUTO(idproduto);
alter table COMPRAJURIDICO add foreign key (idempresa) references JURIDICO(idempresa);
alter table COMPRAJURIDICO add foreign key (idproduto) references PRODUTO(idproduto);

select * from comprajuridico;
select * from comprafisico;
select * from produto;

/* INFORMAÇÕES

#TABELAS (ENTIDADES)fisico
> abaixo algumas tabelas que são necessárias para desenolver o projetoo

- USUARIO > usuário comum e administrativo
- FORNECEDOR > empresa
- PRODUTOS > desejo guardar o preço após alterado?
- CLIENTES
- VENDAS
- DETALHES
*/