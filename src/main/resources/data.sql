INSERT INTO users (username, password, enabled, email)
VALUES
('admin', '$2y$12$h/DdHgfupi5JPVlmjrCmHefk6I4mdqvP4QLj0bldQHamNeXRQ/zsi', true, 'admin@admin.com'),
('user', '$2y$12$h/DdHgfupi5JPVlmjrCmHefk6I4mdqvP4QLj0bldQHamNeXRQ/zsi', true, null);

INSERT INTO authorities (username, authority)
VALUES
('admin', 'ROLE_USER'),
('admin', 'ROLE_ADMIN'),
('user', 'ROLE_USER');
