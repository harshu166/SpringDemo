INSERT INTO CATEGORY(name, description, when_created) VALUES('TEST_CATEGORY1', 'TEST_DESCRIPTION1', NOW());
INSERT INTO CATEGORY(name, description, when_created) VALUES('TEST_CATEGORY2', 'TEST_DESCRIPTION2', NOW());
INSERT INTO CATEGORY(name, description, when_created) VALUES('TEST_CATEGORY3', 'TEST_DESCRIPTION3', NOW());
INSERT INTO CATEGORY(name, description, when_created) VALUES('TEST_CATEGORY4', 'TEST_DESCRIPTION4', NOW());

INSERT INTO ITEM(description, due_date, finished, category_id) VALUES('TODO Item #1', NOW(), false, (SELECT id FROM CATEGORY WHERE name = 'TEST_CATEGORY1'));
INSERT INTO ITEM(description, due_date, finished, category_id) VALUES('TODO Item #2', NOW(), false, (SELECT id FROM CATEGORY WHERE name = 'TEST_CATEGORY2'));
INSERT INTO ITEM(description, due_date, finished, category_id) VALUES('TODO Item #3', NOW(), false, (SELECT id FROM CATEGORY WHERE name = 'TEST_CATEGORY3'));
INSERT INTO ITEM(description, due_date, finished, category_id) VALUES('TODO Item #4', NOW(), false, (SELECT id FROM CATEGORY WHERE name = 'TEST_CATEGORY4'));
INSERT INTO ITEM(description) VALUES('TODO Item #5');  
INSERT INTO ITEM(description, due_date) VALUES('TODO Item #6', NOW());  
INSERT INTO ITEM(description, due_date, finished) VALUES('TODO Item #7', NOW(), false);  
  
