create table if not exists categorie
(
    id integer not null primary key,
    nom varchar(255),
    description varchar(255)
);

create table if not exists produit
(
    id integer not null primary key,
    nom varchar(255),
    description varchar(255),
    quantite double precision not null,
    prix numeric(38,2),
    categorie_id integer
                constraint fk_categorie references categorie
);

create sequence if not exists categorie_seq increment by 50;
create sequence if not exists produit_seq increment by 50;