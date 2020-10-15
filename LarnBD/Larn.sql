drop database larn;
create database Larn;
use Larn;

create table aluno(
id int auto_increment unique not null,
nome varchar(60) not null,
dataNasc date not null,
email varchar(60) unique not null,
senha varchar (100) not null,
aulas varchar(500),
cpf varchar(11) unique not null,
primary key (id)
);
create table professor(
id int not null unique auto_increment,
nome varchar(60) not null,
aulas varchar(500),
dataNasc date not null,
email varchar(60) unique not null,
senha varchar (100) not null,
curriculo varchar(500) not null,
lates varchar(500) not null,
bio varchar(400),
avaliacao double,
cpf varchar(11) unique NOT NULL,
primary key(id)
);

create table aula (
id int not null unique auto_increment,
dataA date ,
horaA time ,
materia varchar(100) not null,
tema varchar(100) not null,
valor double,
id_professor int not null,
primary key (id),
foreign key (id_professor)references professor(id)
);

 create table venda(
 id int not null unique auto_increment,
 id_aluno int not null,
 id_professor int not null,
 valor double not null,
 id_aula int NOT NULL,
 primary key (id),
 foreign key (id_aluno) references aluno(id),
 foreign key (id_professor) references professor(id),
 foreign key (id_aula)references aula(id)
);
 