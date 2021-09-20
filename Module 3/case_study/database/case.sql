CREATE TABLE `bophan` (
  `IDBoPhan` int NOT NULL,
  `TenBoPhan` varchar(45) NOT NULL,
  PRIMARY KEY (`IDBoPhan`)
) ;
INSERT INTO `bophan` 
VALUES (1,'Sale – Marketing'),
		(2,'Hành Chính'),
        (3,'Phục vụ'),
        (4,'Quản lý');
CREATE TABLE `dichvu` (
  `IDDichVu` int NOT NULL,
  `TenDichVu` varchar(45) NOT NULL,
  `DienTich` double NOT NULL,
  `SoTang` int NOT NULL,
  `SoNguoiToiDa` int NOT NULL,
  `ChiPhiThue` double NOT NULL,
  `IDKieuThue` int NOT NULL,
  `IDLoaiDichVu` int NOT NULL,
  `TrangThai` varchar(45) NOT NULL,
  PRIMARY KEY (`IDDichVu`),
  KEY `IDKieuThue` (`IDKieuThue`),
  KEY `IDLoaiDichVu` (`IDLoaiDichVu`),
  CONSTRAINT `dichvu_ibfk_1` FOREIGN KEY (`IDKieuThue`) REFERENCES `kieuthue` (`IDKieuThue`) on update cascade on delete cascade,
  CONSTRAINT `dichvu_ibfk_2` FOREIGN KEY (`IDLoaiDichVu`) REFERENCES `loaidichvu` (`IDLoaiDichVu`) on update cascade on delete cascade
);
INSERT INTO `dichvu` 
VALUES (1,'Iron',15,2,10,3500,2,3,'sẵn sàng'),
		(2,'Vip',10,5,10,7500,1,1,'sẵn sàng'),
        (3,'Hulk',8,0,10,4800,4,1,'sẵn sàng'),
        (4,'Captain',25,1,10,7200,3,3,'sẵn sàng'),
        (5,'Doctor',20,2,10,9600,2,2,'sẵn sàng'),
        (7,'Spider',22,2,10,1200,1,3,'sẵn sàng'),
        (8,'Thor',35,3,10,2500,4,2,'sẵn sàng');

CREATE TABLE `dichvudikem` (
  `IDDichVuDiKem` int NOT NULL,
  `TenDichVuDiKem` varchar(45) NOT NULL,
  `Gia` double NOT NULL,
  `DonVi` int NOT NULL,
  `TrangThaiKhaDung` varchar(45) NOT NULL,
  PRIMARY KEY (`IDDichVuDiKem`)
);
INSERT INTO `dichvudikem` 
VALUES (1,'massage',1500,10,'sẵn sàng'),
		(2,'karaoke',750,10,'sẵn sàng'),
        (3,'thức ăn',850,10,'sẵn sàng'),
        (4,'nước uống',500,10,'sẵn sàng'),
        (5,'thuê xe di chuyển tham quan resort',2500,10,'sẵn sàng');
CREATE TABLE `hopdong` (
  `IDHopDong` int NOT NULL,
  `IDNhanVien` int NOT NULL,
  `IDKhachHang` int NOT NULL,
  `IDDichVu` int NOT NULL,
  `NgayLamHopDong` date NOT NULL,
  `NgayKetThuc` date NOT NULL,
  `TienDatCoc` double NOT NULL,
  `TongTien` double NOT NULL,
  PRIMARY KEY (`IDHopDong`),
  KEY `IDNhanVien` (`IDNhanVien`),
  KEY `IDKhachHang` (`IDKhachHang`),
  KEY `IDDichVu` (`IDDichVu`),
  CONSTRAINT `hopdong_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`IDNhanVien`) on update cascade on delete cascade,
  CONSTRAINT `hopdong_ibfk_2` FOREIGN KEY (`IDKhachHang`) REFERENCES `khachhang` (`IDKhachHang`) on update cascade on delete cascade,
  CONSTRAINT `hopdong_ibfk_3` FOREIGN KEY (`IDDichVu`) REFERENCES `dichvu` (`IDDichVu`) on update cascade on delete cascade
);
INSERT INTO `hopdong` 
VALUES (1,1,1,1,'2020-11-25','2021-01-01',10000),
		(2,2,2,2,'2021-02-07','2021-03-26',10000),
        (3,3,3,3,'2020-11-19','2021-02-15',10000),
        (4,4,4,4,'2020-12-20','2021-04-30',10000),
        (5,5,5,5,'2021-03-18','2021-06-06',10000),
        (6,9,9,5,'2020-10-29','2021-01-17',10000),
        (7,7,7,7,'2021-02-09','2021-05-21',10000),
        (8,8,8,8,'2020-12-14','2021-04-30',10000),
        (9,9,9,1,'2021-03-16','2021-08-04',10000),
        (10,10,10,2,'2020-11-05','2021-02-10',10000),
        (11,1,1,3,'2019-03-30','2020-01-01',10000);

CREATE TABLE `hopdongchitiet` (
  `IDHopDongChiTiet` int NOT NULL,
  `IDHopDong` int NOT NULL,
  `IDDichVuDiKem` int NOT NULL,
  `SoLuong` int NOT NULL,
  PRIMARY KEY (`IDHopDongChiTiet`),
  KEY `IDDichVuDiKem` (`IDDichVuDiKem`),
  KEY `IDHopDong` (`IDHopDong`),
  CONSTRAINT `hopdongchitiet_ibfk_1` FOREIGN KEY (`IDDichVuDiKem`) REFERENCES `dichvudikem` (`IDDichVuDiKem`) on update cascade on delete cascade,
  CONSTRAINT `hopdongchitiet_ibfk_2` FOREIGN KEY (`IDHopDong`) REFERENCES `hopdong` (`IDHopDong`) on update cascade on delete cascade
);
INSERT INTO `hopdongchitiet` 
VALUES (1,1,1,2),
		(2,2,2,2),
        (3,3,3,2),
        (4,4,4,2),
        (5,5,5,2),
        (6,6,5,2),
        (7,7,4,2),
        (8,8,3,2),
        (9,9,2,2),
        (10,10,1,2);
CREATE TABLE `khachhang` (
  `IDKhachHang` int NOT NULL,
  `IDLoaiKhach` int NOT NULL,
  `HoTen` varchar(45) NOT NULL,
  `NgaySinh` date NOT NULL,
  `SoCMND` varchar(15) NOT NULL,
  `SDT` varchar(15) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `DiaChi` varchar(45) NOT NULL,
  PRIMARY KEY (`IDKhachHang`),
  KEY `IDLoaiKhach` (`IDLoaiKhach`),
  CONSTRAINT `khachhang_ibfk_1` FOREIGN KEY (`IDLoaiKhach`) REFERENCES `loaikhach` (`IDLoaiKhach`) on update cascade on delete cascade
);

INSERT INTO `khachhang` 
VALUES (1,1,'Văn Khánh','2000-11-25','69962496','0912345678','vankhanh@gmail.com','Quảng Nam'),
		(2,2,'Khánh Hiền','1996-10-16','61649492','0616216246','khanhhien@gmail.com','Hồ Chí Minh'),
        (3,3,'Ngọc Hải','2001-03-24','696314626','0923246188','ngochai@gmail.com','Đà Nẵng'),
        (4,4,'Đình Khải','1998-10-28','626266666','092232611618','dinhkhai@gmail.com','Hà Nội'),
        (5,5,'Thanh Trà','2000-02-27','962654628','072326684599','thanhtra@gmail.com','Hồ Chí Minh'),
        (6,5,'Ngọc Ánh','1997-09-14','3656599625','076225959274','ngocanh@gmail.com','Quảng Nam'),
        (7,4,'Hoàng Trung','1996-01-31','462262687','092261549667','hoangtrung@gmail.com','Đà Nẵng'),
        (8,3,'Khánh Chi','1998-05-12','5626266259','072233662686','khanhchi@gmail.com','Hồ Chí Minh'),
        (9,2,'Công Khoa','1999-04-06','6162629289','081662843148','congkhoa@gmail.com','Quảng Nam'),
        (10,1,'Khánh Linh','1998-11-23','1656262686','09226848677','khanhlinh@gmail.com','Đà Nẵng');

CREATE TABLE `kieuthue` (
  `IDKieuThue` int NOT NULL,
  `TenKieuThue` varchar(45) NOT NULL,
  `Gia` double NOT NULL,
  PRIMARY KEY (`IDKieuThue`)
);
INSERT INTO `kieuthue`
 VALUES (1,'năm',50000),
		(2,'tháng',25000),
        (3,'ngày',10000),
        (4,'giờ',5000);

CREATE TABLE `loaidichvu` (
  `IDLoaiDichVu` int NOT NULL,
  `TenLoaiDichVu` varchar(45) NOT NULL,
  PRIMARY KEY (`IDLoaiDichVu`)
);
INSERT INTO `loaidichvu` 
VALUES (1,'Villa'),(2,'House'),(3,'Room');

CREATE TABLE `loaikhach` (
  `IDLoaiKhach` int NOT NULL,
  `TenLoaiKhach` varchar(45) NOT NULL,
  PRIMARY KEY (`IDLoaiKhach`)
);
INSERT INTO `loaikhach` VALUES (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');

CREATE TABLE `nhanvien` (
  `IDNhanVien` int NOT NULL,
  `HoTen` varchar(45) NOT NULL,
  `IDViTri` int NOT NULL,
  `IDTrinhDo` int NOT NULL,
  `IDBoPhan` int NOT NULL,
  `NgaySinh` date NOT NULL,
  `SoCMND` varchar(15) NOT NULL,
  `Luong` double NOT NULL,
  `SDT` varchar(15) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `DiaChi` varchar(45) NOT NULL,
  PRIMARY KEY (`IDNhanVien`),
  KEY `IDViTri` (`IDViTri`),
  KEY `IDTrinhDo` (`IDTrinhDo`),
  KEY `IDBoPhan` (`IDBoPhan`),
  CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`IDViTri`) REFERENCES `vitri` (`IDViTri`) on update cascade on delete cascade,
  CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`IDTrinhDo`) REFERENCES `trinhdo` (`IDTrinhDo`) on update cascade on delete cascade,
  CONSTRAINT `nhanvien_ibfk_3` FOREIGN KEY (`IDBoPhan`) REFERENCES `bophan` (`IDBoPhan`) on update cascade on delete cascade
);

INSERT INTO `nhanvien` 
VALUES (1,'Mai Văn Phước',6,4,4,'2000-11-25','12345678',12000,'0912345678','vanphuoc@gmail.com','Đà Nẵng'),
		(2,'Thùy Trang',5,3,2,'1996-10-02','616268486',5800,'098416487','thuytrang@gmail.com','Hà Nội'),
        (3,'Võ Thảo',1,1,1,'2001-05-21','659416862',2500,'079626549','vothao@gmail.com','Quảng Nam'),
        (4,'Hoàng Lâm',6,2,3,'1999-10-03','646655165',3500,'0935116296','hoanglam@gmail.com','Đà Nẵng'),
        (5,'Thanh Thảo',5,3,4,'1996-08-21','976236616',4800,'0762354511','thanhthao@gmail.com','Huế'),
        (6,'Minh Ngọc',2,3,1,'1995-05-02','361155151',7800,'0563662616','minhngoc@gmail.com','Hồ Chí Minh'),
        (7,'Giai Linh',5,2,4,'1998-04-09','513646314',2500,'0906464629','giailinh@gmail.com','Đà Nẵng'),
        (8,'Hoàng Uyên',1,2,1,'2002-06-30','156233652',9000,'0932644926','hoanguyen@gmail.com','Huế'),
        (9,'Lê Hoàng Long',3,2,4,'1997-11-15','4262323151',5600,'0931453624','lelong@gmail.com','Hồ Chí Minh'),
        (10,'Bùi Thanh Tùng',2,1,3,'1996-12-26','763326565',3700,'0762265636','thanhtung@gmail.com','Đà Nẵng'),
        (11,'Hoàng Thảo Nguyên',4,4,2,'2000-02-27','366324151',7800,'0156569279','thaonguyen@gmail.com','Hà Nội');

CREATE TABLE `trinhdo` (
  `IDTrinhDo` int NOT NULL,
  `TrinhDo` varchar(45) NOT NULL,
  PRIMARY KEY (`IDTrinhDo`)
);

INSERT INTO `trinhdo` VALUES (1,'Trung cấp'),(2,'Cao đẳng'),(3,'Đại học'),(4,'Sau đại học');

CREATE TABLE `vitri` (
  `IDViTri` int NOT NULL,
  `TenViTri` varchar(45) NOT NULL,
  PRIMARY KEY (`IDViTri`)
);
INSERT INTO `vitri` VALUES (1,'Lễ tân'),(2,'phục vụ'),(3,'chuyên viên'),(4,'giám sát'),(5,'quản lý'),(6,'giám đốc');
