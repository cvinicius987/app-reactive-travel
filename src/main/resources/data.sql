INSERT INTO tbl_user(id, name) VALUES ('eb45c2e6-863d-4e17-9063-da9e14cf79ae', 'José Aires');
INSERT INTO tbl_user(id, name) VALUES ('26d21ad1-2550-486c-864d-bf815d0faa5b', 'Ana Maria');
INSERT INTO tbl_user(id, name) VALUES ('841103e5-2bd0-4126-b963-103002b73be7', 'Claudio');

INSERT INTO tbl_provider(id, name) VALUES ('3cf42335-ce89-46c6-9288-dced1f62a7ec', 'Agência Figueiredo Turismo S/A');
INSERT INTO tbl_provider(id, name) VALUES ('d6591c9e-abf4-4674-8308-97e2d7bf18e5', 'Maceio Turismo S/A');
INSERT INTO tbl_provider(id, name) VALUES ('eb56b53e-328d-4650-a838-818a363e2541', 'Turismo e Lazer Paulista LTDA.');

INSERT INTO tbl_destiny(id, name, value, state, description) VALUES ('8c89e80e-bed9-41f7-896d-dedf237db558', 'Cataratas do Iguaçu', 100.50, 'PR', 'Cataratas do Brasil localizada no Estado do Parana');
INSERT INTO tbl_destiny(id, name, value, state, description) VALUES ('f257a6e9-ba2e-45b9-9d31-b79246921ef1', 'Ponta Negra', 134.65, 'RN', 'Praia de Ponta Negra em Natal');
INSERT INTO tbl_destiny(id, name, value, state, description) VALUES ('318e5680-239f-494c-86d8-023b48fcd7d4', 'Porto Seguro', 98.25, 'BA', 'Praia de Porto Seguro com Passeio de Barco');

INSERT INTO tbl_travel(id, datetime, qtd, user_id, destiny_id, provider_id) VALUES ('3223503a-6c7c-4bd7-aa52-5b58008d270f', '2021-08-01 12:00:00', 10,  '841103e5-2bd0-4126-b963-103002b73be7', '8c89e80e-bed9-41f7-896d-dedf237db558', '3cf42335-ce89-46c6-9288-dced1f62a7ec');