create database db_thuvien;
use db_thuvien;
create table Sach(
	MaSach int not null,
    TenSach varchar(50) not null,
    NXB varchar(50) not null,
    TacGia varchar(50) not null,
    NamXB int not null,
    SoLanXB int not null,
    Gia double not null,
    Anh text,
    MaLoai int not null,
    primary key (MaSach),
    foreign key (MaLoai) references LoaiSach(MaLoai)
);
create table LoaiSach(
	MaLoai int not null,
    TenLoai varchar(50) not null,
    primary key (MaLoai)
);
create table SinhVien(
	MaSinhVien int not null,
    TenSinhVien varchar(50) not null,
    DiaChi varchar(50) not null,
    email varchar(50) not null,
    Anh text,
    MaThe int not null,
    primary key (MaSinhVien),
    foreign key (MaThe) references PhieuMuon(MaThe)
);
create table PhieuMuon(
	MaThe int not null,
    TenSinhVien varchar(50) not null,
    DiaChi varchar(50) not null,
    email varchar(50) not null,
    SoDienThoai varchar(10) not null,
    Anh text,
    MaSach int not null,
    primary key (MaThe),
    foreign key (MaSach) references Sach(MaSach)
);
insert into LoaiSach
 values (1,"trinh thám"),
		(2,"tiểu thuyết"),
        (3,"truyện tranh"),
        (4,"khoa học"),
        (5,"lập trình");
insert into Sach
values (1,"Conan","Kim Đồng","Fukiji","2010",5,20000,null,3),
		(2,"C#","Giáo dục","FPT","2020",2,250000,null,5),
		(3,"khoa học","Kim Đồng","Bình PO","2015",1,35000,null,4),
		(4,"sherlock home","Kim Đồng","John","2001",15,350000,null,1),
		(5,"cửa sổ","Kim Đồng","Nguyễn","2020",1,200000,null,2);
insert into PhieuMuon
values (1,"phuoc","Đà Nẵng","vp@gmail.com","0905624123",null,1),
		(2,"hoang","Đà Nẵng","hh@gmail.com","0905624125",null,2),
		(3,"linh","Đà Nẵng","gl@gmail.com","0905624125",null,3),
		(4,"ha","Đà Nẵng","nh@gmail.com","0905624123",null,4),
		(5,"duong","Đà Nẵng","td@gmail.com","0905621235",null,5);
insert into SinhVien
values (1,"phuoc","Đà Nẵng","vp@gmail.com",null,1),
		(2,"hoang","Đà Nẵng","hh@gmail.com",null,2),
		(3,"linh","Đà Nẵng","gl@gmail.com",null,3),
		(4,"ha","Đà Nẵng","nh@gmail.com",null,4),
		(5,"duong","Đà Nẵng","td@gmail.com",null,5);