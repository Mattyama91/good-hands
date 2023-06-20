-- # Insert data to category table:

INSERT INTO category(name)
SELECT *
FROM (
         VALUES
             ROW('ubrania, które nadają się do ponownego użycia'),
             ROW('ubrania, do wyrzucenia'),
             ROW('zabawki'),
             ROW('książki'),
             ROW('inne')
     ) source_data
WHERE NOT EXISTS (
    SELECT NULL
    FROM category
);

-- # Insert data to institution table:

INSERT INTO institution(name, description)
SELECT *
FROM (
         VALUES
             ROW('Fundacja "Dbam o Zdrowie"', 'Pomoc dzieciom z ubogich rodzin.'),
             ROW('Fundacja "A kogo"', 'Pomoc wybudzaniu dzieci ze śpiączki.'),
             ROW('Fundacja “Dla dzieci"', 'Pomoc osobom znajdującym się w trudnej sytuacji życiowej.'),
             ROW('Fundacja “Bez domu”', 'Pomoc dla osób nie posiadających miejsca zamieszkania.')
     ) source_data
WHERE NOT EXISTS (
    SELECT NULL
    FROM institution
);

-- Insert data to role table

INSERT INTO role (id, name) VALUES (NULL, "ROLE_USER");