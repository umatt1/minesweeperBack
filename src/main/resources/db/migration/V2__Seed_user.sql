--{
--    "username": "usr1",
--    "password": "password1",
--    "email": "user@ser.net"
--}
INSERT INTO player (username, email, password, enabled)
VALUES ('usr1', 'user@user.user', '$2a$10$YsCqFxAgDOYCNmGx4EP3nO7R.SCPrj8AfJUWJrBiynK5C8NeRhDKK', true);

INSERT INTO authority (email, authority)
VALUES ('user@user.user', 'ROLE_USER');
