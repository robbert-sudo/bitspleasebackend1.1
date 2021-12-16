INSERT INTO users (username, password, enabled)
VALUES
('admin', '$2y$12$h/DdHgfupi5JPVlmjrCmHefk6I4mdqvP4QLj0bldQHamNeXRQ/zsi', TRUE),
('user', '$2y$12$h/DdHgfupi5JPVlmjrCmHefk6I4mdqvP4QLj0bldQHamNeXRQ/zsi', TRUE);

INSERT INTO authorities (user_id, authority)
VALUES
(1, 'ROLE_USER'),
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO games (name, system, developer, uploader_id)
VALUES ('super mario world', 'snes', 'nintendo',1);

