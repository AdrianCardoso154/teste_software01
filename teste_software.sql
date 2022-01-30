SET GLOBAL time_zone = '+3:00';

create database produto ;
use produto;
create table produtos(
idproduct int not null auto_increment primary key,
nome varchar(60),
qtdProd integer,
valorProduto float
);

create table cliente(
idCliente int not null auto_increment primary key,
nomeCliente varchar(60),
emailCliente varchar(60)
);

create table cliente_has_produto(
	fk_produtos int,
    fk_cliente int
);

alter table cliente_has_produto add constraint fk_produtos foreign key(fk_produtos) references produtos(idproduct);
alter table cliente_has_produto add constraint fk_cliente foreign key(fk_cliente) references cliente(idCliente);

create view select_join as
select * from  produtos join cliente_has_produto join cliente on cliente_has_produto.fk_cliente = cliente.idCliente and cliente_has_produto.fk_produtos = produtos.idproduct ;

select * from select_join;