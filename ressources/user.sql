INSERT INTO babel_user VALUES(1, "Clara", "Tatouille", "claratatouille@gmail.com", "ljgjhg", "claratatouille");
INSERT INTO babel_user VALUES(2, "Edmond", "Dentier", "mondentier@mail.com", "ejffh", "mondentier");

INSERT INTO babel_game VALUES (1, "pendu");
INSERT INTO babel_game VALUES (2, "doodle jump");
INSERT INTO babel_game VALUES (3, "snake");
INSERT INTO babel_game VALUES (4, "taquin");
INSERT INTO babel_game VALUES (5, "solitaire");

INSERT INTO babel_trophy  (points, trophy_name) VALUES (100, "premier défi");
INSERT INTO babel_trophy  (points, trophy_name) VALUES (100, "cinq défis");
INSERT INTO babel_trophy  (points, trophy_name) VALUES (100, "500 points");
INSERT INTO babel_trophy  (points, trophy_name) VALUES (100, "50 amis");
INSERT INTO babel_trophy  (points, trophy_name) VALUES (100, "10 jeux");
INSERT INTO babel_trophy  (points, trophy_name) VALUES (500, "50 défis");
INSERT INTO babel_trophy  (points, trophy_name) VALUES (500, "imbatable");
INSERT INTO babel_trophy  (points, trophy_name) VALUES (500, "victoire écrasante");
INSERT INTO babel_trophy  (points, trophy_name) VALUES (200, "joueur solo");

INSERT INTO babel_trophy_user_trophy VALUES (1, 2);
INSERT INTO babel_trophy_user_trophy VALUES (3, 2);
INSERT INTO babel_trophy_user_trophy VALUES (1, 1);
INSERT INTO babel_trophy_user_trophy VALUES (2, 1);
INSERT INTO babel_trophy_user_trophy VALUES (5, 2);
INSERT INTO babel_trophy_user_trophy VALUES (6, 1);

INSERT INTO babel_challenge VALUES (1, "claratatouille", "11/06/2015", 321, 1, "mondentier", 320);
INSERT INTO babel_challenge VALUES (2, "claratatouille", 321, "11/06/2015", 2, "mondentier", 320);
INSERT INTO babel_challenge VALUES (3, "mondentier", 321, "10/06/2015", 3, "claratatouille", 320);
