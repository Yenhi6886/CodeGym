use quanlybanhang;

insert into customer
values (1,'Minh Quan',10),
(2,'Ngoc Anh', 20),
(3,'Hong Ha',50);

INSERT INTO `order`
VALUES
(1, 1, '2006-03-21', NULL),
(2, 2, '2006-03-23', NULL),
(3, 1, '2006-03-16', NULL);


insert into product
values (1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into orderdetail
values (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select C.cName, P.pName, OD.odQTY
from customer C 
join `order` o on C.cID = o.cID
join orderdetail od on o.cID = od.oID
join product p on od.pID = p.pID;

select cName
from Customer
where cID not in (
	select distinct cID from `order`
);

select o.oID, o.oDate, sum(od.odQTY * P.pPrice) as totalprice
from `order` o 
join orderdetail od on o.oID = od.oID
join Product p on od.pID =P.pID
group by o.oID,o.oDate;