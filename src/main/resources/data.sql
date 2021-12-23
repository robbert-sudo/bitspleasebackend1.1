INSERT INTO users (username, password, enabled)
VALUES
('admin', '$2y$12$h/DdHgfupi5JPVlmjrCmHefk6I4mdqvP4QLj0bldQHamNeXRQ/zsi', TRUE),
('user', '$2y$12$h/DdHgfupi5JPVlmjrCmHefk6I4mdqvP4QLj0bldQHamNeXRQ/zsi', TRUE);

INSERT INTO authorities ( authority, user_id)
VALUES
('ROLE_USER', 1),
('ROLE_ADMIN', 1),
('ROLE_USER', 2);

INSERT INTO games (name, system, developer, uploader_id)
VALUES ('super mario world', 'snes', 'nintendo',1);

INSERT INTO sellers_rating (rated_user_id, rating)
VALUES
(1,7),
(1,6),
(1,8),
(2,5),
(2,5),
(2,5);