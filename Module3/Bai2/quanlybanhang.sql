create database `quanlybanhang`;
use `quanlybanhang`;

CREATE TABLE `Order` (
    oID INT PRIMARY KEY AUTO_INCREMENT,
    cID INT,
    oDate DATE,
    oTotalPrice DECIMAL(10 , 2 ),
    FOREIGN KEY (cID)
        REFERENCES Customer (cID)
);

create table OrderDetail(
oID int,
pID int,
odQTY int,
primary key(oID,pID),
foreign key(oID) references `Order` (oID),
foreign key(pID) references Product (pID)
);