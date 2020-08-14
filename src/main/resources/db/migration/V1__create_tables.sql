use chat;

CREATE TABLE users (
	id serial PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 128 ) NOT NULL,
	created_at TIMESTAMP WITH TIMEZONE NOT NULL
);

CREATE TABLE chats (
    id serial PRIMARY KEY,
    text varchar ( 500 ) not null,
    created_at TIMESTAMP WITH TIMEZONE NOT NULL
);

CREATE TABLE messages (
    id serial PRIMARY KEY,
    text varchar ( 500 ) not null,
    user_id  INT NOT NULL,
    chat_id INT NOT NULL,
    FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id` ),
    FOREIGN KEY (`chat_id`)
        REFERENCES `chats` (`id` ),
)