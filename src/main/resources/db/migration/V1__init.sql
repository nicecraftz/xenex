CREATE TABLE IF NOT EXISTS customers
(
    id    SERIAL PRIMARY KEY NOT NULL,
    name  VARCHAR(32)        NOT NULL,
    email VARCHAR(255)       NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS products
(
    id           SERIAL PRIMARY KEY NOT NULL,
    name         VARCHAR(32)        NOT NULL,
    version      VARCHAR(32)        NOT NULL,
    description  TEXT               NOT NULL,
    release_date DATE               NOT NULL
);

CREATE TABLE IF NOT EXISTS licenses
(
    id          SERIAL PRIMARY KEY NOT NULL,
    license_key CHAR(36)           NOT NULL UNIQUE,
    customer_id INT                NOT NULL,
    product_id  INT                NOT NULL,
    issued_by   VARCHAR(32)        NOT NULL,
    issued_at   TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);