
CREATE TABLE ratings(
  id SERIAL NOT NULL,
  score NUMERIC(5,2) NOT NULL,

  CONSTRAINT pk_ratings
    PRIMARY KEY(id)
 );