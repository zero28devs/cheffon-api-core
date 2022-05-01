DROP TABLE test;

CREATE TABLE tags (
    id SERIAL NOT NULL,
    nome VARCHAR(50) NOT NULL,

    CONSTRAINT pk_tags
        PRIMARY KEY (id)
);
