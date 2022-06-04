CREATE TABLE actions (
    id SERIAL NOT NULL,
    nome VARCHAR(50) NOT NULL,

    CONSTRAINT pk_actions
        PRIMARY KEY (id)
);
