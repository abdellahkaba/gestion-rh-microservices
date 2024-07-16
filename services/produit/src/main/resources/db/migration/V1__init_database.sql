-- Création des séquences si elles n'existent pas
CREATE SEQUENCE IF NOT EXISTS categorie_seq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS produit_seq INCREMENT BY 1 START WITH 1;

-- Création des tables si elles n'existent pas
CREATE TABLE IF NOT EXISTS categorie
(
    id INTEGER NOT NULL PRIMARY KEY,
    nom VARCHAR(255),
    description VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS produit
(
    id INTEGER NOT NULL PRIMARY KEY,
    nom VARCHAR(255),
    description VARCHAR(255),
    quantite DOUBLE PRECISION NOT NULL,
    prix NUMERIC(38,2),
    categorie_id INTEGER
    CONSTRAINT fk_categorie REFERENCES categorie
    );

-- Insertion de données dans la table categorie
INSERT INTO categorie (id, nom, description)
VALUES
    (1, 'Électronique', 'Appareils électroniques et gadgets'),
    (2, 'Livres', 'Livres de toutes catégories'),
    (3, 'Vêtements', 'Vêtements pour hommes, femmes et enfants'),
    (4, 'Alimentation', 'Produits alimentaires'),
    (5, 'Jouets', 'Jouets pour enfants de tous âges');

-- Insertion de données dans la table produit
INSERT INTO produit (id, nom, description, quantite, prix, categorie_id)
VALUES
    (nextval('produit_seq'), 'Smartphone', 'Un smartphone moderne avec écran tactile', 50, 299.99, 1),
    (nextval('produit_seq'), 'Ordinateur portable', 'Un ordinateur portable performant', 30, 799.99, 1),
    (nextval('produit_seq'), 'Tablette', 'Une tablette avec écran haute résolution', 40, 199.99, 1),
    (nextval('produit_seq'), 'Casque audio', 'Casque audio sans fil', 70, 99.99, 1),
    (nextval('produit_seq'), 'Télévision', 'Télévision 4K 55 pouces', 20, 499.99, 1),
    (nextval('produit_seq'), 'Roman policier', 'Un roman captivant plein de suspense', 100, 12.99, 2),
    (nextval('produit_seq'), 'Roman d''amour', 'Un roman d''amour touchant', 90, 10.99, 2),
    (nextval('produit_seq'), 'Livre de cuisine', 'Livre de recettes gourmandes', 60, 15.99, 2),
    (nextval('produit_seq'), 'Bande dessinée', 'Une bande dessinée pour enfants', 80, 9.99, 2),
    (nextval('produit_seq'), 'Magazine', 'Magazine mensuel de mode', 120, 5.99, 2),
    (nextval('produit_seq'), 'T-shirt', 'Un t-shirt confortable en coton', 200, 9.99, 3),
    (nextval('produit_seq'), 'Pantalon', 'Un pantalon élégant pour toutes occasions', 150, 29.99, 3),
    (nextval('produit_seq'), 'Robe', 'Robe de soirée chic', 80, 49.99, 3),
    (nextval('produit_seq'), 'Chaussures', 'Chaussures de sport légères', 100, 39.99, 3),
    (nextval('produit_seq'), 'Casquette', 'Casquette tendance', 110, 14.99, 3),
    (nextval('produit_seq'), 'Chocolat', 'Délicieux chocolat noir', 500, 2.50, 4),
    (nextval('produit_seq'), 'Biscuit', 'Biscuits croustillants', 450, 3.00, 4),
    (nextval('produit_seq'), 'Jus d''orange', 'Jus d''orange 100% pur jus', 300, 1.99, 4),
    (nextval('produit_seq'), 'Pâtes', 'Pâtes italiennes de qualité', 400, 1.50, 4),
    (nextval('produit_seq'), 'Céréales', 'Céréales complètes pour le petit déjeuner', 350, 3.50, 4),
    (nextval('produit_seq'), 'Poupée', 'Poupée pour enfants', 120, 15.99, 5),
    (nextval('produit_seq'), 'Puzzle', 'Puzzle de 1000 pièces', 80, 19.99, 5),
    (nextval('produit_seq'), 'Lego', 'Jeu de construction Lego', 60, 29.99, 5),
    (nextval('produit_seq'), 'Voiture télécommandée', 'Voiture télécommandée rapide', 50, 39.99, 5),
    (nextval('produit_seq'), 'Jeu de société', 'Jeu de société amusant', 100, 24.99, 5),
    (nextval('produit_seq'), 'Drone', 'Drone avec caméra HD', 30, 99.99, 1),
    (nextval('produit_seq'), 'Caméra', 'Caméra numérique haute résolution', 25, 299.99, 1),
    (nextval('produit_seq'), 'E-book', 'Livre électronique avec écran e-ink', 70, 129.99, 2);
