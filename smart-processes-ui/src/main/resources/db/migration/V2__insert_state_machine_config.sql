

----

INSERT INTO cms_event(id, description, name)VALUES ('f919f401-783f-4cc1-8397-ce4005ba59b0', 'START DESC', 'START');
INSERT INTO cms_event(id, description, name)VALUES ('2d62b503-0f82-4c69-9ffa-5ce1bfdcc315', 'PROCESS DESC', 'PROCESS');
INSERT INTO cms_event(id, description, name)VALUES ('f92219ce-0ca4-4e6a-991e-5a5e42ced300', 'REQUIRE_MORE_INFO DESC', 'REQUIRE_MORE_INFO');
INSERT INTO cms_event(id, description, name)VALUES ('a9b15b80-3770-415d-87f1-29440e1be514', 'COMPLETE DESC', 'COMPLETE');
INSERT INTO cms_event(id, description, name)VALUES ('599d3b62-3160-4a0f-831b-42be5d021c3b', 'CLOSE DESC', 'CLOSE');


INSERT INTO cms_state(id, start_date, end_date, name, description, create_date)
	VALUES ('e84763fc-5c22-4661-9472-e52dfede0236', '2023-01-01', '9999-12-01', 'NEW', 'NEW DESCRIPTION', '2000-01-01');
INSERT INTO cms_state(id, start_date, end_date, name, description, create_date)
	VALUES ('2bcfb975-b46a-4c77-856a-8d4b87f6a41f', '2023-01-01', '9999-12-01', 'PROCESSING', 'PROCESSING DESCRIPTION', '2000-01-01');
INSERT INTO cms_state(id, start_date, end_date, name, description, create_date)
	VALUES ('03ad205c-9f49-4043-810e-57cbb6a7be0c', '2023-01-01', '9999-12-01', 'PROCESSED', 'PROCESSED DESCRIPTION', '2000-01-01');
INSERT INTO cms_state(id, start_date, end_date, name, description, create_date)
	VALUES ('19991675-0ca6-4e5d-a7c7-7716a6537aaf', '2023-01-01', '9999-12-01', 'COMPLETED', 'COMPLETE DESCRIPTION', '2000-01-01');


INSERT INTO cms_state_config(id, current_state_id, next_state_id, event_id)
	VALUES ('18080a59-2447-4bbb-a2c0-77eb357e36eb',
	(SELECT ID FROM cms_state WHERE name = 'NEW'),
	(SELECT ID FROM cms_state WHERE name = 'PROCESSING'),
	(SELECT ID FROM cms_event WHERE name = 'START')
);

INSERT INTO cms_state_config(id, current_state_id, next_state_id, event_id)
	VALUES ('6ddcc491-4b8c-42c2-aa03-785c831bdb6c',
	(SELECT ID FROM cms_state WHERE name = 'PROCESSING'),
	(SELECT ID FROM cms_state WHERE name = 'PROCESSED'),
	(SELECT ID FROM cms_event WHERE name = 'COMPLETE')
);

INSERT INTO cms_state_config(id, current_state_id, next_state_id, event_id)
	VALUES ('599d3b62-3160-4a0f-831b-42be5d021c3b',
	(SELECT ID FROM cms_state WHERE name = 'NEW'),
	(SELECT ID FROM cms_state WHERE name = 'COMPLETED'),
	(SELECT ID FROM cms_event WHERE name = 'PROCESS')
);

INSERT INTO cms_state_config(id, current_state_id, next_state_id, event_id)
	VALUES ('03ad205c-9f49-4043-810e-57cbb6a7be0c',
	(SELECT ID FROM cms_state WHERE name = 'COMPLETED'),
	(SELECT ID FROM cms_state WHERE name = 'PROCESSING'),
	(SELECT ID FROM cms_event WHERE name = 'COMPLETE')
);

INSERT INTO cms_state_config(id, current_state_id, next_state_id, event_id)
	VALUES ('a9818521-ab76-4a44-93bd-1a6fb9070527',
	(SELECT ID FROM cms_state WHERE name = 'NEW'),
	(SELECT ID FROM cms_state WHERE name = 'PROCESSING'),
	(SELECT ID FROM cms_event WHERE name = 'COMPLETE')
);
