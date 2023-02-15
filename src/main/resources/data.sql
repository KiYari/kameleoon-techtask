INSERT INTO users (name, email, password, date_of_creation)
VALUES('John', 'imJohn@john.com', 'mypas', '2023-02-14 15:44:35'),
('notJohn', 'imnotJohn@john.com', 'notmypas', '2023-02-14 15:45:35'),
('imnotJohn', 'imnotnotJohn@john.com', 'notjmypas', '2023-02-15 16:44:35'),
('imnotnotJohn', 'imoooJohn@john.com', 'mypasjav', '2023-02-17 12:44:35'),
('Johnest', 'imJohnest@john.com', 'mypasest', '2023-02-18 15:32:35');

INSERT INTO quotes (content, last_update_time, date_of_creation,score, author_id)
VALUES ('I am big', '2023-02-20 16:44:35','2023-02-20 16:44:35', 0, 1),
       ('cool', '2023-02-20 16:45:35','2023-02-20 16:44:35', 4, 2),
       ('sdasdddd', '2023-02-20 16:46:35','2023-02-20 16:44:35', 0, 2),
       ('keyboard', '2023-02-20 16:46:35','2023-02-20 16:44:35', 0, 2),
       ('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex', '2023-02-20 16:44:35','2023-02-20 16:44:35', -2, 1),
       ('Lorem ipsum dolor sit amet, consectetur adipiscing elit,', '2023-02-20 16:47:35','2023-02-20 16:44:35', -1, 3),
       ('labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ', '2023-02-20 16:48:35','2023-02-20 16:44:35', 0, 3),
       ('et dolore ', '2023-02-20 16:49:35','2023-02-20 16:44:35', 0, 4),
       ('dolor sit amet,', '2023-02-20 16:44:45','2023-02-20 16:44:35', 0, 5),
       ('do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ', '2023-02-20 17:44:35','2023-02-20 16:44:35', 0, 5),
       ('loremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione vo', '2023-02-20 16:44:35','2023-02-20 16:44:35', 0, 1),
       ('d ut persp', '2023-02-20 16:44:35','2023-02-20 16:44:35', 0, 2),
       ('llamco laboris nisi ut aliquip e', '2023-02-20 18:44:35','2023-02-20 16:44:35', 0, 3),
       ('umquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis', '2023-02-20 16:44:35','2023-02-20 16:44:35', 0, 1),
       ('numquam eius modi tempora incidunt ut labore et', '2023-02-20 19:44:35','2023-02-20 16:44:35', 0, 1),
       ('odi consequatur? Quis autem vel ', '2023-02-20 16:44:35','2023-02-20 16:44:35', 0, 2),
       ('derit qui in ea voluptate velit esse', '2023-02-20 16:44:35','2023-02-20 16:44:35', 0, 5),
       (' omnis iste natus error sit voluptatem accusantium doloremqu', '2023-02-20 16:42:35','2023-02-20 16:44:35', 0, 5),
       ('m ipsum quia dolor sit amet, consectetur, adipisci velit, s', '2023-02-20 16:41:35','2023-02-20 16:44:35', 0, 5);

INSERT INTO votes (user_id, quote_id, is_upvoted, vote_date)
VALUES ( 4, 2, true,  '2023-02-20 16:47:35'),
( 3, 2, true,  '2023-02-20 16:47:35'),
( 2, 2, true,  '2023-02-20 16:47:35'),
( 1, 2, true,  '2023-02-20 16:47:35'),
( 5, 2, false,  '2023-02-20 16:47:35'),
( 2, 2, true,  '2023-02-20 16:47:35'),
( 2, 6, false,  '2023-02-20 16:47:35'),
( 3, 6, false,  '2023-02-20 16:47:35'),
( 5, 7, false,  '2023-02-20 16:47:35');



