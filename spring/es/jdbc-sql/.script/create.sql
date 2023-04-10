CREATE TABLE prodotti (
    id BIGINT auto_increment primary key,
    nome varchar(100),
    descrizione varchar(1000),
    prezzo float check (prezzo > 0)
);

CREATE TABLE varianti (
    id BIGINT auto_increment primary key,
    attributo varchar(100),
    valore varchar(100),
    prodotto_id BIGINT references prodotti(id)
);

CREATE TABLE fornitori (
    id BIGINT auto_increment primary key,
    nome varchar(100)
);

CREATE TABLE fornitori_prodotti(
    fornitore_id BIGINT references fornitori(id),
    prodotto_id BIGINT references prodotti(id)
);