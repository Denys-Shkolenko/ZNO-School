CREATE TABLE users_table
(
    id            SERIAL PRIMARY KEY,
    username      VARCHAR(255) NOT NULL UNIQUE,
    user_password VARCHAR(255) NOT NULL
);

CREATE TABLE roles
(
    id        SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

-- Table for mapping user and role
CREATE TABLE user_and_role
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users_table (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

-- Fill the table of roles
INSERT INTO roles (role_name)
VALUES ('USER_ROLE'),
       ('ADMIN_ROLE');