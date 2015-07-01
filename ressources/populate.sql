USE babel;

INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_points, user_game_count, user_victories, user_challenges) VALUES("claratatouille", "Clara", "Tatouille", "claratatouille@gmail.com", "12345", "claratatouille.jpg", 55648, 150, 120, 145);
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_points, user_game_count, user_victories, user_challenges) VALUES("mondentier", "Edmond", "Dentier", "mondentier@mail.com", "23456", "mondentier.jpg", 8695, 52, 25, 49);
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_points, user_game_count, user_victories, user_challenges) VALUES("mouillette", "John", "Doeuf", "mouillette@mail.com", "34567", null, 540, 12, 2, 6);
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_points, user_game_count, user_victories, user_challenges) VALUES("jobijoba", "Jo", "Bijoba", "jobijoba@mail.com", "456789", "jobijoba.jpg", 15023, 78, 54, 68);

INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("hangman", "Saurez-vous découvrir le mot caché avant de finir pendu?", "Le pendu", "pendu.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("jumpinsheep", "Aidez Tondu le mouton à atteindre les étoiles", "Saute, mouton!", "jumpinsheep.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("snake", "Faites grandir snake en mangeant. Mais attention à ne pas vous mordre la queue!", "Snake", "snake.jpg");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("taquin", "Reconstituez l'image en faisant le moins de coups possible !", "Le taquin", "taquin.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("angrybird", "Les oiseaux sont en colère! Aidez-les à se venger des infâmes cochons!!", "Angry bird", "angrybird.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("spaceinvaders", "Les extra-terrestres attaquent !! Défendez la planette contre ces envahisseurs", "Space invaders", "spaceinvader.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("felfkkmls", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 7", "default.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("gbwxfyame8", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 8", "default.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("hzdfij", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 9", "default.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("lseopfgr", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 10", "default.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("ntyze", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 11", "default.png");
INSERT INTO babel_game (game_id, game_description, game_name, game_img) VALUES ("zeqvbtb", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 12", "default.png");

INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("games", "newbie", "Newbie", "Jouez votre première partie", 100);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("games", "goodstart", "C'est un bon début", "Jouez 50 parties", 100);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("games", "littleplayer", "Petit joueur", "Jouez 100 parties", 500);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("games", "addict", "Accroc", "Jouez 500 parties", 500);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("games", "veteran", "Vétéran", "Jouez 1000 parties", 1000);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("points", "feather", "Poid plume", "Atteignez 500 points", 50);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("points", "barracuda", "Barracuda", "Atteignez 1000 points", 100);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("points", "therock", "The rock", "Atteignez 5000 points", 100);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("points", "themountain", "La Montagne", "Atteignez 10000 points", 500);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("points", "thehulk", "Hulk", "Atteignez 50000 points", 1000);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("challenges", "padawan", "Padawan", "Remporter 10 défis", 50);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("challenges", "hitman", "Hitman", "Remporter 100 défis", 50);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("challenges", "virtuose", "Virtuose", "Remporter 500 défis", 100);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("challenges", "superman", "Superman", "Remporter 1000 défis", 100);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("challenges", "terminator", "Terminator", "Remporter 5000 défis", 500);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("other", "flawlessvictory", "Victoire écrasante", "Remporter un défi aevc au moins 500 points d'écarts", 500);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("other", "galacticshame", "Honte intergalactique", "Perdre un défi aevc au moins 500 points d'écarts", 100);

INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("1", "mondentier");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("2", "mondentier");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("17", "mondentier");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("1", "claratatouille");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("2", "claratatouille");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("3", "claratatouille");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("6", "claratatouille");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("7", "claratatouille");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("8", "claratatouille");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("9", "claratatouille");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("11", "claratatouille");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("12", "claratatouille");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("1", "jobijoba");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("2", "jobijoba");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("6", "jobijoba");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("7", "jobijoba");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("11", "jobijoba");
INSERT INTO babel_user_trophies (trophy_id, username) VALUES ("16", "jobijoba");

INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("claratatouille", 321, "1434029757", "mondentier", null, "hangman");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("claratatouille", 321, "1434029757", "mondentier", null, "jumpinsheep");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("mondentier", 321, "1434029757", "claratatouille", null, "jumpinsheep");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("mondentier", 321, "1434029757", "claratatouille", null, "hangman");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("mouillette", 321, "1434029757", "claratatouille", null, "jumpinsheep");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("jobijoba", 321, "1434029757", "claratatouille", null, "jumpinsheep");

INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "claratatouille", "mondentier", "message 1", "1434029755");
INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "mondentier", "claratatouille", "message 2", "1434029756");
INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "jobijoba", "claratatouille", "message 3", "1434029759");
INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "mondentier", "jobijoba", "message 4", "1434029768");
INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "mouillette", "claratatouille", "message 5", "1434029775");

INSERT INTO babel_contact (username, contact) VALUES ("claratatouille", "mouillette");
INSERT INTO babel_contact (username, contact) VALUES ("claratatouille", "mondentier");
INSERT INTO babel_contact (username, contact) VALUES ("mondentier", "mouillette");
INSERT INTO babel_contact (username, contact) VALUES ("jobijoba", "mouillette");
INSERT INTO babel_contact (username, contact) VALUES ("mondentier", "claratatouille");
INSERT INTO babel_contact (username, contact) VALUES ("mouillette", "claratatouille");
