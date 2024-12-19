DELETE FROM user;

INSERT INTO user (name, age, location, email, password) VALUES
('Jorge',20, 'porto','ola@gmail.com', '123'),
('Paulo',45, 'porto','ola@gmail.com', '123'),
('Marco',20, 'gaia','ola@gmail.com', '123'),
('Miguel',19, 'gaia','ola@gmail.com', '123');

DELETE FROM activity;

INSERT INTO activity (name, description) VALUES
('Futebol', 'Jogar futebol'),
('Corrida', 'Correr'),
('Passeio', 'Passear');

DELETE FROM planned_activities;

INSERT INTO planned_activities ( activity_id, user_id, number_of_people, date, time, location) VALUES
(1, 1, 3, '2022-03-01', '10:00', 'porto'),
( 2, 1, 3, '2022-03-01', '20:00', 'porto'),
( 3, 1, 3, '2022-03-01', '15:00', 'porto'),
( 1, 2, 3, '2022-03-01', '10:00', 'porto'),
( 2, 2, 3, '2022-03-01', '10:00', 'porto'),
( 3, 2, 3, '2022-03-01', '10:00', 'porto'),
( 1, 3, 3, '2022-03-01', '10:00', 'gaia'),
( 2, 3, 3, '2022-03-01', '10:00', 'gaia'),
( 3, 3, 3, '2022-03-01', '10:00', 'gaia'),
( 1, 4, 3, '2022-03-01', '10:00', 'gaia'),
( 2, 4, 3, '2022-03-01', '10:00', 'gaia'),
( 3, 4, 3, '2022-03-01', '10:00', 'gaia');

DELETE FROM activity_participants;

INSERT INTO activity_participants (user_id, planned_activity_id) VALUES
(2, 1),
(3, 2),
(4, 3),
(1, 4),
(3, 5),
(4, 6),
(1, 7),
(2, 8),
(4, 9),
(1, 10),
(2, 11),
(3, 12);


