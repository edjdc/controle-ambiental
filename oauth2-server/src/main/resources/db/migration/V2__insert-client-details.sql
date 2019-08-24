-- The encrypted client_secret it `secret`
INSERT INTO oauth_client_details (client_id, client_secret, resource_ids, scope, authorized_grant_types, authorities)
  VALUES ('clientId', '{bcrypt}$2a$10$vCXMWCn7fDZWOcLnIEhmK.74dvK1Eh8ae2WrWlhr2ETPLoxQctN4.', 'ativos-service,monitoramento-service,seguranca-service', 'read,write', 'client_credentials', 'ROLE_ADMIN');