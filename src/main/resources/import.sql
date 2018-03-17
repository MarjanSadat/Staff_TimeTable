INSERT INTO users (id,firstname,lastname,username,password) VALUES (USERS_SEQ.nextval,'marjan_sadat','mousavi','marjan','mypass');
INSERT INTO users (id,firstname,lastname,username,password) VALUES (USERS_SEQ.nextval,'admin','admin','admin','adminpass');
INSERT INTO roles (id,username,permission) VALUES (ROLES_SEQ.nextval,'marjan','user');
INSERT INTO roles (id,username,permission) VALUES (ROLES_SEQ.nextval,'admin','admin');

