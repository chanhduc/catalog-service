CREATE TABLE book (
    id                  BIGSERIAL PRIMARY KEY,
    title               VARCHAR(255) NOT NULL,
    author              VARCHAR(255) NOT NULL,
    isbn                VARCHAR(13) UNIQUE NOT NULL,
    price               float8 NOT NULL,
    created_date        TIMESTAMP NOT NULL,
    last_modified_date  TIMESTAMP NOT NULL,
    version             INTEGER NOT NULL
);
