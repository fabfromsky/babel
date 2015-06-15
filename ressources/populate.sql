INSERT INTO babel_user VALUES(1, "Clara", "Tatouille", "claratatouille@gmail.com", "ljgjhg", "claratatouille");
INSERT INTO babel_user VALUES(2, "Edmond", "Dentier", "mondentier@mail.com", "ejffh", "mondentier");

INSERT INTO babel_game VALUES ("hangman", "Saurez-vous découvrir le mot caché avant de finir pendu?", "Le pendu");
INSERT INTO babel_game VALUES ("jumpinhseep", "Aidez Tondu le mouton à atteindre les étoiles", "Saute, mouton!");
INSERT INTO babel_game VALUES ("snake", "Faites grandir snake en mangeant. Mais attention à ne pas vous mordre la queue!", "Snake");

INSERT INTO babel_trophy VALUES ("firstchallenge", "Lancez votre premier défi", 100, "noob");
INSERT INTO babel_trophy VALUES ("fivechallenge", "Lancez cinq défis", 100, "5 défis");
INSERT INTO babel_trophy VALUES ("500", "Atteignez 500 points", 100, "500 points");
INSERT INTO babel_trophy VALUES ("fiftyfriend", "Ajoutez 50 amis", 100, "50 amis");
INSERT INTO babel_trophy VALUES ("littleplayer", "Jouez 10 parties", 100, "Petit joueur");
INSERT INTO babel_trophy VALUES ("fiftychallenge", "Lancez 50 défis", 500, "50 défis");
INSERT INTO babel_trophy VALUES ("superman", "Gagnez 30 défis", 500, "imbattable");
INSERT INTO babel_trophy VALUES ("flawlessvictory", "Gagnez un défi avec au moins 100 points d'écart", 500, "victoire écrasante");
INSERT INTO babel_trophy VALUES ("soloman", "Jouez 50 parties sans lancer de défi", 200, "joueur solo");

INSERT INTO babel_trophy_user_trophy VALUES ("firstchallenge", 2);
INSERT INTO babel_trophy_user_trophy VALUES ("500", 2);
INSERT INTO babel_trophy_user_trophy VALUES ("firstchallenge", 1);
INSERT INTO babel_trophy_user_trophy VALUES ("fivechallenge", 1);
INSERT INTO babel_trophy_user_trophy VALUES ("littleplayer", 2);
INSERT INTO babel_trophy_user_trophy VALUES ("fiftychallenge", 1);

INSERT INTO babel_challenge VALUES (1, "claratatouille", 321, "11/06/2015", "mondentier", 320, "hangman");
INSERT INTO babel_challenge VALUES (2, "claratatouille", 321, "11/06/2015", "mondentier", 320, "jumpinhseep");
INSERT INTO babel_challenge VALUES (3, "mondentier", 321, "10/06/2015", "claratatouille", 320, "jumpinhseep");

INSERT INTO babel_message VALUES (1, "Lorem ipsum dolor sit amet consectetur...", "claratatouille", "mondentier", "message 1");
INSERT INTO babel_message VALUES (2, "Lorem ipsum dolor sit amet consectetur...", "mondentier", "claratatouille", "message 2");
