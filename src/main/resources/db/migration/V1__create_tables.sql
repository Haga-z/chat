
CREATE TABLE if not exists users (
    id serial PRIMARY KEY,
    username VARCHAR ( 50 ) UNIQUE NOT NULL,
    password VARCHAR ( 128 ) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE chats (
    id serial PRIMARY KEY,
    text varchar ( 500 ) not null,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE messages (
   id serial PRIMARY KEY,
   text varchar ( 500 ) NOT NULL,
   created_at TIMESTAMP NOT NULL,
   user_id INT NOT NULL,
   chat_id INT NOT NULL,
       FOREIGN KEY (user_id)
           REFERENCES users (id),
       FOREIGN KEY (chat_id)
           REFERENCES chats (id)
);

CREATE TABLE roles (
    id serial PRIMARY KEY,
    name varchar (50) not null
);

CREATE TABLE chat_user(
    user_id int not null,
    chat_id int not null
);

CREATE TABLE user_role(
    user_id int not null,
    role_id int not null
);