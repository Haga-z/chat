CREATE SCHEMA IF NOT EXISTS chat;

CREATE TABLE chat.users (
	id serial PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 128 ) NOT NULL,
	created_at TIMESTAMP NOT NULL
);

CREATE TABLE chat.chats (
    id serial PRIMARY KEY,
    text varchar ( 500 ) not null,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE chat.messages (
    id serial PRIMARY KEY,
    text varchar ( 500 ) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id INT NOT NULL,
    chat_id INT NOT NULL,
    FOREIGN KEY (`user_id`)
        REFERENCES users (id),
    FOREIGN KEY (`chat_id`)
        REFERENCES chats (id)
);

CREATE TABLE chat.roles (
    id serial PRIMARY KEY,
    name varchar (50) not null
);