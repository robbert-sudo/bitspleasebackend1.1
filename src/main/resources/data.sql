INSERT INTO users (username, password, enabled)
VALUES
('admin', '$2y$12$h/DdHgfupi5JPVlmjrCmHefk6I4mdqvP4QLj0bldQHamNeXRQ/zsi', TRUE),
('user', '$2y$12$h/DdHgfupi5JPVlmjrCmHefk6I4mdqvP4QLj0bldQHamNeXRQ/zsi', TRUE);

INSERT INTO authorities (user_id, authority, username)
VALUES
(1, 'ROLE_USER', 'admin'),
(1, 'ROLE_ADMIN', 'admin'),
(2, 'ROLE_USER', 'admin');

INSERT INTO games (name, system, developer, uploader_id)
VALUES ('super mario world', 'snes', 'nintendo',1);

