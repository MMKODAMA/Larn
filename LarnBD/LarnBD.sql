drop database larn;
create database Larn;
use Larn;

create table usuario(
id int auto_increment unique not null,
nome varchar(60) not null,
email varchar(60) unique not null,
password varchar (100) not null,
cpf varchar(11) unique not null,
lates varchar(60),
bio varchar(400),
primary key (id)
);

create table aula (
id int not null unique auto_increment,
materia varchar(100) not null,
tema varchar(100) not null,
descricao varchar(400) not null,
link varchar(255) not null,
data date not null,
hora time not null,
preco double,
primary key (id)
);

create table Categoria(
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

create table rel_aula_categoria(
aula_id int not null,
categoria_id int not null,
foreign key (aula_id) references aula(id),
foreign key (categoria_id) references Categoria(id)
);

insert into Categoria (nome) values ('Desenvolvimento'),
('Negocios'),('Financas e Contabilidade'),('TI e Software'),
('Desenvolvimento Pessoal'), ('Educacao Financeira'), ('Design'),('Marketing'),('Fotografia e Video'),
('Musica'),('Ensino e Estudo Academico');

create table venda(
id_venda int not null unique auto_increment,
id_aluno int not null,
id_professor int not null,
valor double not null,
id_aula int NOT NULL,
primary key (id_venda),
foreign key (id_aluno) references usuario(id),
foreign key (id_professor) references usuario(id),
foreign key (id_aula)references aula(id)
);
 