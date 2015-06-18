INSERT INTO babel_user VALUES("claratatouille", "Clara", "Tatouille", "claratatouille@gmail.com", "12345");
INSERT INTO babel_user VALUES("mondentier", "Edmond", "Dentier", "mondentier@mail.com", "23456" );
INSERT INTO babel_user VALUES("mouillette", "John", "Doeuf", "mouillette@mail.com", "34567");
INSERT INTO babel_user VALUES("jobijoba", "Jo", "Bijoba", "jobijoba@mail.com", "456789");

INSERT INTO babel_game VALUES ("hangman", "Saurez-vous découvrir le mot caché avant de finir pendu?", "Le pendu", "/pendu.html");
INSERT INTO babel_game VALUES ("jumpinsheep", "Aidez Tondu le mouton à atteindre les étoiles", "Saute, mouton!", "/jumpinsheep.html");
INSERT INTO babel_game VALUES ("snake", "Faites grandir snake en mangeant. Mais attention à ne pas vous mordre la queue!", "Snake", "/snake.html");

INSERT INTO babel_trophy VALUES ("firstchallenge", "Lancez votre premier défi", 100, "noob");
INSERT INTO babel_trophy VALUES ("fivechallenge", "Lancez cinq défis", 100, "5 défis");
INSERT INTO babel_trophy VALUES ("500", "Atteignez 500 points", 100, "500 points");
INSERT INTO babel_trophy VALUES ("fiftyfriend", "Ajoutez 50 amis", 100, "50 amis");
INSERT INTO babel_trophy VALUES ("littleplayer", "Jouez 10 parties", 100, "Petit joueur");
INSERT INTO babel_trophy VALUES ("fiftychallenge", "Lancez 50 défis", 500, "50 défis");
INSERT INTO babel_trophy VALUES ("superman", "Gagnez 30 défis", 500, "imbattable");
INSERT INTO babel_trophy VALUES ("flawlessvictory", "Gagnez un défi avec au moins 100 points d'écart", 500, "victoire écrasante");
INSERT INTO babel_trophy VALUES ("soloman", "Jouez 50 parties sans lancer de défi", 200, "joueur solo");

INSERT INTO babel_trophy_user_trophy VALUES ("firstchallenge", "mondentier");
INSERT INTO babel_trophy_user_trophy VALUES ("500", "mondentier");
INSERT INTO babel_trophy_user_trophy VALUES ("firstchallenge", "claratatouille");
INSERT INTO babel_trophy_user_trophy VALUES ("fivechallenge", "claratatouille");
INSERT INTO babel_trophy_user_trophy VALUES ("littleplayer", "mondentier");
INSERT INTO babel_trophy_user_trophy VALUES ("fiftychallenge", "claratatouille");

INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("claratatouille", 321, "11/06/2015", "mondentier", null, "hangman");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("claratatouille", 321, "11/06/2015", "mondentier", null, "jumpinsheep");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("mondentier", 321, "10/06/2015", "claratatouille", null, "jumpinsheep");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("mondentier", 321, "11/06/2015", "claratatouille", null, "hangman");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("mouillette", 321, "11/06/2015", "claratatouille", null, "jumpinsheep");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("jobijoba", 321, "10/06/2015", "claratatouille", null, "jumpinsheep");

INSERT INTO babel_message (content, sender, receiver, title) VALUES ("Lorem ipsum dolor sit amet consectetur...", "claratatouille", "mondentier", "message 1");
INSERT INTO babel_message (content, sender, receiver, title) VALUES ("Lorem ipsum dolor sit amet consectetur...", "mondentier", "claratatouille", "message 2");
INSERT INTO babel_message (content, sender, receiver, title) VALUES ("Lorem ipsum dolor sit amet consectetur...", "jobijoba", "claratatouille", "message 3");
INSERT INTO babel_message (content, sender, receiver, title) VALUES ("Lorem ipsum dolor sit amet consectetur...", "mondentier", "jobijoba", "message 4");
INSERT INTO babel_message (content, sender, receiver, title) VALUES ("Lorem ipsum dolor sit amet consectetur...", "mouillette", "claratatouille", "message 5");

INSERT INTO babel_contact (username, contact) VALUES ("claratatouille", "mouillette");
INSERT INTO babel_contact (username, contact) VALUES ("claratatouille", "mondentier");
INSERT INTO babel_contact (username, contact) VALUES ("mondentier", "mouillette");
INSERT INTO babel_contact (username, contact) VALUES ("jobijoba", "mouillette");
INSERT INTO babel_contact (username, contact) VALUES ("mondentier", "claratatouille");
INSERT INTO babel_contact (username, contact) VALUES ("mouillette", "claratatouille");
