REM   Script: SQL activities
REM   All activities

SELECT salesman_id, city FROM salesman_test;

CREATE TABLE salesman_test (  
    Salesman_id int,  
    salesman_name varchar(20),  
    City varchar(20),  
    Commission int  
) 
;

INSERT INTO salesman_test VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL  
    INTO salesman_test VALUES(5005, 'Pit Alex', 'London', 11)  
    INTO salesman_test VALUES(5006, 'McLyon', 'Paris', 14)  
    INTO salesman_test VALUES(5007, 'Paul Adam', 'Rome', 13)  
    INTO salesman_test VALUES(5003, 'Lauson Hen', 'San Jose', 12)  
SELECT 1 FROM DUAL;

select *from salesman_test;

SELECT salesman_id, city FROM salesman_test;

SELECT * FROM salesman_test WHERE city='Paris';

SELECT salesman_id, commission FROM salesman_test WHERE salesman_name='Paul Adam';

ALTER TABLE salesman_test ADD grade int;

UPDATE salesman_test SET grade=50;

select *from salesman_test;

UPDATE salesman_test set = 200 where city = 'Rome';

UPDATE salesman_test set grade=200 where city = 'Rome';

SELECT * FROM salesman_test WHERE city='Rome';

select *from salesman_test;

UPDATE salesman_test set grade=300 where salesman_name = 'Nail Knite';

select *from salesman_test;

UPDATE salesman_test set salesman_name = 'Pierre' where salesman_id = '5006';

select *from salesman_test;

SELECT DISTINCT gradeFROM salesman_test;

SELECT DISTINCT grade FROM salesman_test;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

select *from orders;

SELECT DISTINCT salesman_id FROM orders;

select order_no, order_date from orders order by order_date asc;

select order_no, purchase_amount from orders order by purchase_amount desc;

select *from orders where purchase_amount < 500;

select *from orders where purchase_amount between 1000 and 2000;

SELECT SUM(purchase_amount) as “Total amount” FROM orders;

SELECT SUM(purchase_amount) AS "Total amount" FROM orders;

select AVG(purchase_amount) AS "Average" from orders;

select MAX(purchase_amount) AS "Maximum" from orders;

select MIN(purchase_amount) AS "minimum amount" from orders;

select COUNT(distinct salesman_id) AS "Total count" from orders;

SELECT customer_id, MAX(purchase_amount) AS "Max Amount" FROM orders GROUP BY customer_id;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders  
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders GROUP BY customer_id, order_date HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders GROUP BY customer_id, order_date HAVING MAX(purchase_amount) IN(2030, 2400.6, 3045.6);

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders GROUP BY customer_id, order_date HAVING MAX(purchase_amount) IN(2000, 3000, 4000);

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

Insert into customers values  
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001), 
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002), 
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

Insert all into customers values  
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001) 
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002) 
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

Insert all into customers values  
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001) 
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002) 
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

Insert all   
into customers values(3002, 'Nick Rimando', 'New York', 100, 5001) 
into customers values(3007, 'Brad Davis', 'New York', 200, 5001) 
into customers values(3005, 'Graham Zusi', 'California', 200, 5002) 
into customers values(3008, 'Julian Green', 'London', 300, 5002) 
into customers values(3004, 'Fabian Johnson', 'Paris', 300, 5006) 
into customers values(3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
into customers values(3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
into customers values(3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select *from customers;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT a.customer_name AS "Cust_Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customers a INNER JOIN salesman_test b ON a.salesman_id=b.salesman_id;

SELECT a.customer_name, a.city, a.grade, b.salesman_name AS "Salesman", b.city FROM customers a  
LEFT OUTER JOIN salesman_test b ON a.salesman_id=b.salesman_id WHERE a.grade<300  
ORDER BY a.customer_id asc;

SELECT a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman_test b ON a.salesman_id=b.salesman_id  
WHERE b.commission>12;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.salesman_name AS "Salesman", c.commission FROM orders a  
INNER JOIN customers b ON a.customer_id=b.customer_id  
INNER JOIN salesman_test c ON a.salesman_id=c.salesman_id;

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007;

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman_test WHERE city='New York');

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman_test WHERE city='Paris');

SELECT grade, COUNT(*) FROM customers 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman_test 
WHERE commission=( SELECT MAX(commission) FROM salesman_test));

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, name FROM salesman_test a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, salesman_name FROM salesman_test a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT a.salesman_id, salesman_name, order_no, 'highest on', order_date FROM salesman_test a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, salesman_name, order_no, 'lowest on', order_date FROM salesman_test a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

