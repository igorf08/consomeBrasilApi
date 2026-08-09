CREATE TABLE tb_ceps (
    id SERIAL PRIMARY KEY,
    cep VARCHAR(10) UNIQUE NOT NULL,
    state VARCHAR(2),
    city VARCHAR(100),
    neighborhood VARCHAR(100),
    street VARCHAR(150),
    timezone_name VARCHAR(100),
    longitude VARCHAR(30),
    latitude VARCHAR(30),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE tb_cnpjs (
    id SERIAL PRIMARY KEY,
    cnpj VARCHAR(20) UNIQUE NOT NULL,
    uf VARCHAR(2),
    cep VARCHAR(10),
    email VARCHAR(150),
    porte VARCHAR(50),
    bairro VARCHAR(100),
    municipio VARCHAR(100),
    logradouro VARCHAR(150),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);