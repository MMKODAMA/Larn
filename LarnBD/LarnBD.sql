drop database larn;
create database Larn;
use Larn;

create table usuario(
id int auto_increment unique not null,
nome varchar(60) not null,
dataNasc date not null,
email varchar(60) unique not null,
senha varchar (100) not null,
cpf varchar(11) unique not null,
curriculo varchar(500),
lates varchar(500),
bio varchar(400),
primary key (id)
);

create table aula (
id int not null unique auto_increment,
postado datetime not null,
materia varchar(100) not null,
tema varchar(100) not null,
valor double,
primary key (id)
);

create table Category(
id int(11) not null unique auto_increment,
nome varchar(100)not null unique,
primary key (id)
);

create table cargo (
id int not null unique auto_increment,
nome varchar(50),
primary key (id)
);

create table rel_cargo_usuario(
cargo_id int not null,
usuario_id int not null,
foreign key (cargo_id) references cargo(id),
foreign key (usuario_id) references usuario(id)
);

create table rel_aula_professor(
aula_id int not null,
usuario_id int not null,
foreign key (aula_id) references aula(id),
foreign key (usuario_id) references usuario(id)
);

create table rel_aula_aluno(
aula_id int not null,
usuario_id int not null,
foreign key (aula_id) references aula(id),
foreign key (usuario_id) references usuario(id)
);

create table rel_aula_category(
aula_id int not null,
category_id int not null,
foreign key (aula_id) references aula(id),
foreign key (category_id) references Category(id)
);

insert into Category (nome) values ('Desenvolvimento'),
('Negocios'),('Finanças e Contabilidade'),('TI e Software'),
('Desenvolvimento Pessoal'),('Design'),('Marketing'),('Fotografia e Video'),
('Musica'),('Ensino e Estudo Academico');



 -- create table venda(
 -- id int not null unique auto_increment,
 -- id_aluno int not null,
 -- id_professor int not null,
 -- valor double not null,
 -- id_aula int NOT NULL,
 -- primary key (id),
 -- foreign key (id_aluno) references aluno(id),
 -- foreign key (id_professor) references professor(id),
 -- foreign key (id_aula)references aula(id)
-- );
 