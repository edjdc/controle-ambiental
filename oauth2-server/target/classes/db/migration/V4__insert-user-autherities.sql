-- The encrypted password is `pass`
INSERT INTO users (id, username, password, enabled) VALUES (1, 'admin@admin.com', '{bcrypt}$2a$10$cyf5NfobcruKQ8XGjUJkEegr9ZWFqaea6vjpXWEaSqTa2xL9wjgQC', 1);
INSERT INTO authorities (username, authority) VALUES ('admin@admin.com', 'ROLE_ADMIN');
