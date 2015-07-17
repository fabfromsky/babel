USE babel;

INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_victories, user_challenges, sex) VALUES("claratatouille", "Clara", "Tatouille", "claratatouille@gmail.com", "12345", "claratatouille.jpg", 120, 145, "F");
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_victories, user_challenges, sex) VALUES("mondentier", "Edmond", "Dentier", "mondentier@mail.com", "23456", "mondentier.jpg", 25, 49, "M");
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_victories, user_challenges, sex) VALUES("mouillette", "John", "Doeuf", "mouillette@mail.com", "34567", "mouillette.jpg", 2, 6, "M");
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_victories, user_challenges, sex) VALUES("jobijoba", "Jo", "Bijoba", "jobijoba@mail.com", "456789", "jobijoba.jpg", 54, 68, "F");
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_victories, user_challenges, sex) VALUES("quenotte", "Adam", "Labrosse", "labrosseadam@mail.com", "wlkdrjt", null, 54, 68, "M");
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_victories, user_challenges, sex) VALUES("popmusic", "Agathe", "Youbeb", "igotubabe@mail.com", "rhtewh", null, 54, 68, "F");
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_victories, user_challenges, sex) VALUES("pokerface", "Jack", "Pote", "pokerface@mail.com", "sefr54", null, 54, 68, "M");
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_victories, user_challenges, sex) VALUES("maguybole", "Magguy", "Bole", "maguybole@mail.com", "q5f4e5", null, 54, 68, "F");
INSERT INTO babel_user (username, first_name, last_name, mail, pwd, user_img, user_victories, user_challenges, sex) VALUES("saravigote", "Sarah", "Vigote", "saravigote@mail.com", "dfg4df5", null, 54, 68, "F");

INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("hangman", "Saurez-vous découvrir le mot caché avant de finir pendu?", "Le pendu", "pendu.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("jumpinsheep", "Aidez Tondu le mouton à atteindre les étoiles", "Saute, mouton!", "jumpinsheep.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("snake", "Faites grandir snake en mangeant. Mais attention à ne pas vous mordre la queue!", "Snake", "snake.jpg");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("taquin", "Reconstituez l'image en faisant le moins de coups possible !", "Le taquin", "taquin.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("angrybird", "Les oiseaux sont en colère! Aidez-les à se venger des infâmes cochons!!", "Angry bird", "angrybird.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("spaceinvaders", "Les extra-terrestres attaquent !! Défendez la planette contre ces envahisseurs", "Space invaders", "spaceinvader.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("felfkkmls", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 7", "default.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("gbwxfyame8", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 8", "default.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("hzdfij", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 9", "default.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("lseopfgr", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 10", "default.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("ntyze", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 11", "default.png");
INSERT INTO babel_game (game_title, game_description, game_name, game_img) VALUES ("zeqvbtb", "Cupcake ipsum dolor sit amet apple pie. Topping tiramisu cotton candy chocolate oat cake cheesecake sweet toffee.", "game 12", "default.png");

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
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("challenges", "brucelee", "Bruce Lee", "Remporter 500 défis", 100);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("challenges", "superman", "Superman", "Remporter 1000 défis", 100);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("challenges", "terminator", "Terminator", "Remporter 5000 défis", 500);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("special", "flawlessvictory", "Victoire écrasante", "Remporter un défi aevc au moins 500 points d'écarts", 500);
INSERT INTO babel_trophy (trophy_category, trophy_title, trophy_name, description, points) VALUES ("special", "galacticshame", "Honte intergalactique", "Perdre un défi aevc au moins 500 points d'écarts", 100);

INSERT INTO babel_user_trophies (trophy, user) VALUES ("1", "mondentier");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("2", "mondentier");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("17", "mondentier");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("1", "claratatouille");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("2", "claratatouille");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("3", "claratatouille");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("6", "claratatouille");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("7", "claratatouille");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("8", "claratatouille");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("9", "claratatouille");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("11", "claratatouille");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("12", "claratatouille");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("1", "jobijoba");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("2", "jobijoba");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("6", "jobijoba");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("7", "jobijoba");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("11", "jobijoba");
INSERT INTO babel_user_trophies (trophy, user) VALUES ("16", "jobijoba");

INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("claratatouille", 321, "1434029757", "mondentier", null, "1");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("claratatouille", 321, "1434029757", "mondentier", null, "2");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("mondentier", 321, "1434029757", "claratatouille", null, "2");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("mondentier", 321, "1434029757", "claratatouille", null, "1");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("mouillette", 321, "1434029757", "claratatouille", null, "2");
INSERT INTO babel_challenge (player, player_score, date, challenger, challenger_score, game_id) VALUES ("jobijoba", 321, "1434029757", "claratatouille", null, "2");

INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "claratatouille", "mondentier", "message 1", "1434029755");
INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "mondentier", "claratatouille", "message 2", "1434029756");
INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "jobijoba", "claratatouille", "message 3", "1434029759");
INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "mondentier", "jobijoba", "message 4", "1434029768");
INSERT INTO babel_message (content, sender, receiver, title, date) VALUES ("Lorem ipsum dolor sit amet consectetur...", "mouillette", "claratatouille", "message 5", "1434029775");

INSERT INTO babel_contact (user, contact) VALUES ("claratatouille", "mouillette");
INSERT INTO babel_contact (user, contact) VALUES ("claratatouille", "mondentier");
INSERT INTO babel_contact (user, contact) VALUES ("mondentier", "mouillette");
INSERT INTO babel_contact (user, contact) VALUES ("jobijoba", "mouillette");
INSERT INTO babel_contact (user, contact) VALUES ("mondentier", "claratatouille");
INSERT INTO babel_contact (user, contact) VALUES ("mouillette", "claratatouille");
INSERT INTO babel_contact (user, contact) VALUES ("saravigote", "claratatouille");
INSERT INTO babel_contact (user, contact) VALUES ("maguybole", "claratatouille");
INSERT INTO babel_contact (user, contact) VALUES ("pokerface", "claratatouille");
INSERT INTO babel_contact (user, contact) VALUES ("popmusic", "claratatouille");

INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 679);
INSERT INTO babel_user_games (game, username, score) VALUES ("1", "claratatouille", 456);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 546);
INSERT INTO babel_user_games (game, username, score) VALUES ("3", "claratatouille", 345);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 543);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 456);
INSERT INTO babel_user_games (game, username, score) VALUES ("3", "claratatouille", 175);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 546);
INSERT INTO babel_user_games (game, username, score) VALUES ("1", "claratatouille", 546);
INSERT INTO babel_user_games (game, username, score) VALUES ("4", "claratatouille", 68);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 648);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 348);
INSERT INTO babel_user_games (game, username, score) VALUES ("5", "claratatouille", 345);
INSERT INTO babel_user_games (game, username, score) VALUES ("5", "claratatouille", 945);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 456);
INSERT INTO babel_user_games (game, username, score) VALUES ("6", "claratatouille", 494);
INSERT INTO babel_user_games (game, username, score) VALUES ("6", "claratatouille", 158);
INSERT INTO babel_user_games (game, username, score) VALUES ("3", "claratatouille", 645);
INSERT INTO babel_user_games (game, username, score) VALUES ("4", "claratatouille", 312);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 185);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 754);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 325);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "claratatouille", 679);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "jobijoba", 679);
INSERT INTO babel_user_games (game, username, score) VALUES ("1", "jobijoba", 456);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "jobijoba", 546);
INSERT INTO babel_user_games (game, username, score) VALUES ("3", "jobijoba", 345);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "jobijoba", 543);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "jobijoba", 456);
INSERT INTO babel_user_games (game, username, score) VALUES ("3", "jobijoba", 175);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "jobijoba", 546);
INSERT INTO babel_user_games (game, username, score) VALUES ("1", "jobijoba", 546);
INSERT INTO babel_user_games (game, username, score) VALUES ("4", "jobijoba", 68);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "jobijoba", 648);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "jobijoba", 348);
INSERT INTO babel_user_games (game, username, score) VALUES ("5", "jobijoba", 345);
INSERT INTO babel_user_games (game, username, score) VALUES ("5", "mouillette", 945);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "mouillette", 456);
INSERT INTO babel_user_games (game, username, score) VALUES ("6", "mouillette", 494);
INSERT INTO babel_user_games (game, username, score) VALUES ("6", "mouillette", 158);
INSERT INTO babel_user_games (game, username, score) VALUES ("3", "mouillette", 645);
INSERT INTO babel_user_games (game, username, score) VALUES ("4", "mondentier", 312);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "mondentier", 185);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "mondentier", 754);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "mondentier", 325);
INSERT INTO babel_user_games (game, username, score) VALUES ("2", "mondentier", 679);