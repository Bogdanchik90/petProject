DROP TABLE IF EXISTS postgres.public.user;

CREATE TABLE IF NOT EXISTS postgres.public.user(
                     id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
                     name VARCHAR(128) NOT NULL ,
                     date VARCHAR(128),
                     phone VARCHAR(128)
);

