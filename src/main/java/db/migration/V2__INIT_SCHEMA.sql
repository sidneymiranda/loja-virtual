-- INSERT INTO person (id, name, email, phone)
-- VALUES ('1', 'Sidney Miranda', 'sidney@google.com', '71988761427');
--
-- INSERT INTO physical_person (cpf, dob, person_id)
-- VALUES ('84204222587', '03/03/1988', '1');
--
-- INSERT INTO users (id, firstname, lastname, username, password, person)
-- VALUES ('1', 'sidney', 'miranda', 'admin', '{bcrypt}df790ef4-f636-4adb-98e6-a94ebe7e538b', '1');
--
-- INSERT INTO role (id, name)
-- VALUES ('1', 'ROLE_ADMIN');
--
-- INSERT INTO user_roles (user_id, role_id)
-- VALUES ('1','1');