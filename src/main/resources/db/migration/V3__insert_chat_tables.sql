INSERT INTO chats(id,created_at,name)values
(1,null,'First Chat'),
(2,null,'Second Chat'),
(3,null,'Third Chat');

INSERT INTO chat_user(id,user_id,chat_id)values
(1,2,1),
(2,3,1),
(3,3,2),
(4,4,1),
(5,2,3),
(6,4,3);

