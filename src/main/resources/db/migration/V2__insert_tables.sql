INSERT INTO users (id,created_at,password,username)values
(1,null,'$2y$12$KxcxBSjSyaDV.r1PxNsAjO3L1nSu/JiLfVOueHdGwPnQINcS6sA6u','admin'),
(2,null,'$2y$12$W8FxM.j4cWGr2Ai6nKn3TOAF4K5FmBGBFuGiim50DvYoWePbK..fG','user1'),
(3,null,'$2y$12$qkk3vIoZChCGnOxvHECdDeCe/q5bw0eTG6qIA1k8EO.TDS7lUI.ou','user2'),
(4,null,'$2y$12$p2B5S8.hZo3PlzgKYS/oi.Idq/y7Ux6/ww9KqxDWqSa52hUiAeIYK','user3');

INSERT INTO roles(id,name)values
(1,'ROLE_ADMIN'),
(2,'ROLE_USER');

INSERT INTO user_role(user_id,role_id)values
(1,1),
(2,2),
(3,2),
(4,2);
