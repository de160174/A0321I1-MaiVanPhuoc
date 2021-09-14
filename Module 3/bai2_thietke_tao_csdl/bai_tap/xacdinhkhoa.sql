create database db_nganhang;
use db_nganhang;
create table KhachHang(
	MaKhachHang int not null,
    HoTen varchar(50) not null,
    DiaChi varchar(50) not null,
    email varchar(50) not null,
    SoDienThoai varchar(15) not null,
    primary key (MaKhachHang)
);
create table TaiKhoan(
	SoTaiKhoan int not null,
    KieuTaiKhoan varchar(50),
    NgayMoTK date,
    SoDu double not null,
    primary key (SoTaiKhoan)
);
create table GiaoDich(
	MaGiaoDich int not null,
    SoTaiKhoan int not null,
    ThoiGianGD date,
    SoTienGD double,
    MoTa varchar(50),
    primary key (MaGiaoDich),
    foreign key (SoTaiKhoan) references TaiKhoan(SoTaiKhoan)
);

