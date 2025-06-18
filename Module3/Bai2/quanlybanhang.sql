CREATE DATABASE QuanLyBanHang;
USE QuanLyBanHang;

-- Bảng Khách hàng
CREATE TABLE Customer (
    cID INT PRIMARY KEY AUTO_INCREMENT,
    cName VARCHAR(100),
    cAge INT
);

-- Bảng Sản phẩm
CREATE TABLE Product (
    pID INT PRIMARY KEY AUTO_INCREMENT,
    pName VARCHAR(100),
    pPrice DECIMAL(10,2)
);

-- Bảng Đơn hàng
CREATE TABLE `Order` (
    oID INT PRIMARY KEY AUTO_INCREMENT,
    cID INT,
    oDate DATE,
    oTotalPrice DECIMAL(10,2),
    FOREIGN KEY (cID) REFERENCES Customer(cID)
);

-- Bảng Chi tiết hóa đơn (trung gian)
CREATE TABLE OrderDetail (
    oID INT,
    pID INT,
    odQTY INT,
    PRIMARY KEY (oID, pID),
    FOREIGN KEY (oID) REFERENCES `Order`(oID),
    FOREIGN KEY (pID) REFERENCES Product(pID)
);
