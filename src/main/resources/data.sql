DROP TABLE IF EXISTS TRANSACTION;
DROP TABLE IF EXISTS CUSTOMER;


CREATE TABLE CUSTOMER (
  id INTEGER PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);
CREATE TABLE TRANSACTION (
  id INT PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  total DOUBLE NOT NULL,
  trnx_date TIMESTAMP NOT NULL,
  trnx_month VARCHAR(250) NOT NULL,
  CUSTOMER_ID INT NOT NULL,
  FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(ID)
);


insert into CUSTOMER (id, name) values (101, 'customer1');
insert into CUSTOMER (id, name) values (102, 'customer2');

insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (1001, 'Transaction 1', 100, '2020-06-02 15:30:00','JUNE', 101);
insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (1002, 'Transaction 2', 50, '2020-06-03 16:31:00','JUNE', 101);
insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (1003, 'Transaction 3', 140, '2020-05-20 18:30:00','MAY', 101);
insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (1004, 'Transaction 4', 70, '2020-05-21 10:20:00','MAY', 101);
insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (1005, 'Transaction 5', 90, '2020-04-26 10:20:00','APRIL', 101);
insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (1006, 'Transaction 6', 80, '2020-04-27 10:20:00','APRIL', 101);

insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (2001, 'Transaction 101', 120, '2020-06-02 14:30:00','JUNE', 102);
insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (2002, 'Transaction 102', 200, '2020-06-02 14:20:00','JUNE', 102);
insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (2003, 'Transaction 103', 130, '2020-05-02 16:10:00','MAY', 102);
insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (2004, 'Transaction 104', 40, '2020-05-02 15:20:00','MAY', 102);
insert into TRANSACTION(id, description, total, trnx_date,trnx_month, customer_id) values (2005, 'Transaction 105', 110, '2020-04-02 13:25:00','APRIL', 102);