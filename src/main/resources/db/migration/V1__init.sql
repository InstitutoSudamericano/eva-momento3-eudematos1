CREATE TABLE IF NOT EXISTS film(
    id SERIAL,
    title VARCHAR (100) NOT NULL,
    director VARCHAR (100) NOT NULL,
    duration INT NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS scene(
    id Serial,
    description VARCHAR(200) NOT NULL,
    budget decimal(9,2) NOT NULL,
    minutes INT NOT NULL,
    film_id INT,
    FOREIGN KEY (film_id) REFERENCES film(id),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS characters(
    id SERIAL,
    description VARCHAR(200) NOT NULL,
    cost decimal(9,2) NOT NULL,
    scene_id INT ,
    FOREIGN KEY (scene_id) REFERENCES scene(id),
    PRIMARY KEY (id)
);
