DROP DATABASE E2;

CREATE DATABASE E2;

USE E2;

CREATE TABLE TrabalhadoresDeEscritorio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    salario DOUBLE NOT NULL
);

CREATE TABLE Cachorro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    raca VARCHAR(100) NOT NULL,
    peso DOUBLE NOT NULL
);

CREATE TABLE Flores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cor VARCHAR(50) NOT NULL,
    tipo VARCHAR(100) NOT NULL
);

CREATE TABLE KpopSingers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    grupo VARCHAR(100) NOT NULL
);

CREATE TABLE Planeta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    massa DOUBLE NOT NULL,
    diametro DOUBLE NOT NULL,
    distanciaDoSol DOUBLE NOT NULL,
    temAnel BOOLEAN NOT NULL
);

CREATE TABLE Refrigerante (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    sabor VARCHAR(50) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    volumeML INT NOT NULL,
    diet BOOLEAN NOT NULL
);

CREATE TABLE Salgadinhos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sabor VARCHAR(100) NOT NULL,
    peso DOUBLE NOT NULL,
    qtnde INT NOT NULL
);

CREATE TABLE Sanrio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    comidaFav VARCHAR(100),
    cor VARCHAR(50),
    idade INT
);

CREATE TABLE TiposDeCabelo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL,
    cor VARCHAR(50),
    comprimento DOUBLE,
    isNatural BOOLEAN
);

CREATE TABLE jogadoras_de_volei (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    posicao VARCHAR(50) NOT NULL,
    altura DECIMAL(5,2) NOT NULL,
    numero_camisa INT NOT NULL,
    idade INT NOT NULL
);

select * from flores;
select * from kpopsingers;