CREATE TABLE catalog_storage.item_en (
    id   BIGSERIAL PRIMARY KEY,
    name CHARACTER VARYING(256) NOT NULL,
    code INTEGER UNIQUE         NOT NULL
);

CREATE TABLE catalog_storage.attribute_en (
    id   BIGSERIAL PRIMARY KEY,
    name CHARACTER VARYING(256) NOT NULL
);

CREATE TABLE catalog_storage.item_attribute_en (
    item_id      BIGINT NOT NULL REFERENCES catalog_storage.item_en (id),
    attribute_id BIGINT NOT NULL REFERENCES catalog_storage.attribute_en (id),
    PRIMARY KEY (item_id, attribute_id)
);

INSERT INTO catalog_storage.item_en (name, code)
VALUES ('Telephone', 1);

INSERT INTO catalog_storage.attribute_en (name)
VALUES ('Model'),
       ('Manufacture'),
       ('Screen size');

INSERT INTO catalog_storage.item_attribute_en (item_id, attribute_id)
VALUES (1, 1),
       (1, 2),
       (1, 3);

CREATE TABLE catalog_storage.item_ru (
    id   BIGSERIAL PRIMARY KEY,
    name CHARACTER VARYING(256) NOT NULL,
    code INTEGER UNIQUE         NOT NULL
);

CREATE TABLE catalog_storage.attribute_ru (
    id   BIGSERIAL PRIMARY KEY,
    name CHARACTER VARYING(256) NOT NULL
);

CREATE TABLE catalog_storage.item_attribute_ru (
    item_id      BIGINT NOT NULL REFERENCES catalog_storage.item_ru (id),
    attribute_id BIGINT NOT NULL REFERENCES catalog_storage.attribute_ru (id),
    PRIMARY KEY (item_id, attribute_id)
);

INSERT INTO catalog_storage.item_ru (name, code)
VALUES ('Телефон', 1);

INSERT INTO catalog_storage.attribute_ru (name)
VALUES ('Модель'),
       ('Производитель'),
       ('Размер экрана');

INSERT INTO catalog_storage.item_attribute_ru (item_id, attribute_id)
VALUES (1, 1),
       (1, 2),
       (1, 3);