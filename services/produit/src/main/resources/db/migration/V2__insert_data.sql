INSERT INTO categorie (id, nom, description)
VALUES (nextval('categorie_seq'), 'Computer', 'Computer KeyBoard');

INSERT INTO public.produit(id,nom,description,quantite,prix,categorie_id)
VALUES
    (nextval('produit_seq'),'Samsung','description Samsung',20,150000,1)

