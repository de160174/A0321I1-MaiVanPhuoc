<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/18/2021
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama resort</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body style="height: 600px">
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6 p-1 pl-2">
            <div class="row">
                <div class="col-lg-12">
                    <a href="">
                        <img width="180px" height="60px"
                             src="image/logo.png" alt="logo">
                    </a>
                </div>
            </div>
        </div>
        <div class="col-lg-6 p-3 text-right">
            <div class="row">
                <div class="col-lg-12">
                    <a href="">
                        Mai Van Phuoc
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0 px-5">
                        <li class="nav-item active px-3">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item px-3">
                            <a class="nav-link" href="/employee">Employee</a>
                        </li>
                        <li class="nav-item px-3">
                            <a class="nav-link" href="/customer">Customer</a>
                        </li>
                        <li class="nav-item px-3">
                            <a class="nav-link" href="/service">Service</a>
                        </li>
                        <li class="nav-item px-3">
                            <a class="nav-link" href="/contract">Contract</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-3">
            <div class="row">
                <div class="col-lg-12">
                    <marquee behavior="scroll" direction="up">
                        <p style="color: #cbbe73">KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI FURAMA ĐÀ NẴNG, TỰ HÀO LÀ KHU NGHỈ
                            DƯỠNG ẨM THỰC TẠI VIỆT NAM</p>
                        <p>Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di
                            sản văn hoá thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng
                            sang cùng với 70 căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí
                            trang nhã, theo phong cách thiết kế truyền thống của Việt Nam và kiến trúc thuộc địa của
                            Pháp, biến Furama thành khu nghỉ dưỡng danh giá nhất tại Việt Nam – vinh dự được đón tiếp
                            nhiều người nổi tiếng, giới hoàng gia, chính khách, ngôi sao điện ảnh và các nhà lãnh đạo
                            kinh doanh quốc tế.<br>
                            Ẩm thực tại khu nghỉ dưỡng là trải nghiệm kết hợp giữa các món ăn Việt Nam, châu Á, Ý và
                            châu Âu cùng các món bít tết nhập khẩu hảo hạng. Khu nghỉ dưỡng mang đến cho quý khách những
                            không gian ẩm thực đa dạng bao gồm – quầy bar nhìn ra biển, hồ bơi Lagoon được bao quanh bởi
                            khu vườn nhiệt đới, ẩm thực truyền thống Ý tại nhà hàng Don Cipriani’s, chất Á Đông tại Café
                            Indochine hay nhà hàng bít tết “The Fan – Cái Quạt” nằm ngay trên bãi biển. Khu nghỉ dưỡng
                            Furama Đà Nẵng còn gây ấn tượng và tạo nhiều thích thú cho khách thông qua các chương trình
                            vui chơi đầy thú vị như các chuyến du ngoạn, thể thao trên nước, lặn biển và chơi golf cũng
                            như các dịch vụ chăm sóc sức khoẻ và sắc đẹp.<br>
                            Nằm tại vị trí đắc địa gần trung tâm Đà Nẵng và là nơi kết nối quốc tế thuận tiện đến
                            Singapore, Bangkok, Xiêm Riệp, Kuala Lumpur, Đài Loan, Tokyo, Osaka, Busan, Seoul, Tokyo,
                            Osaka và Hồng Kông – Ma Cao, Trung Quốc bao gồm: Bắc Kinh, Thượng Hải, Hàng Châu, Quảng
                            Châu, Thành Đô bằng các chuyến bay trực tiếp, khu nghỉ dưỡng Furama Đà Nẵng là điểm đến lý
                            tưởng cho các đại lý du lịch, doanh nghiệp, công ty tổ chức sự kiện. Cung Hội nghị có thể
                            chứa tới 3000 người, cùng với 10 phòng chức năng khác có sức chứa từ 50 đến 300 người. Cung
                            hội nghị Ariyana Convention Centre (ACC) được xây dựng để tổ chức sự kiện APEC 2017, kết nối
                            với Cung hội nghị Furama (ICP) tạo thành quần thể MICE lớn nhất Việt Nam có sức chứa lên tới
                            5,000 khách.
                        </p>
                    </marquee>
                </div>
            </div>
        </div>
        <div class="col-lg-9 bg-light">
            <div class="row">
                <div class="col-lg-12">
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="d-block w-100"
                                     src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior-Furama-girl-with-pink-hat.jpg"
                                     alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100"
                                     src="https://furamavietnam.com/wp-content/uploads/2019/07/Vietnam_Danang_Furama_Resort_Exterior_Ocean-Pool-6.jpg"
                                     alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100"
                                     src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Courtyard.jpg"
                                     alt="Third slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                           data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button"
                           data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="row" style="height:600px;">
                <div class="col-lg-12">
                    <marquee behavior="scroll" direction="left">
                        <p><span style="color: #cbbe73">CÁC LOẠI PHÒNG</span> Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam kết hợp với
                            phong cách Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những
                            khu vườn nhiệt đới xanh tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn cung cấp các liệu
                            pháp spa, phòng xông hơi ướt, phòng xông hơi khô, dịch vụ mát-xa cạnh hồ bơi, các dịch
                            vụ thể thao dưới nước và các lớp tập yoga và Thái Cực Quyền trên bãi biển.</p>
                    </marquee>
                </div>
            </div>
        </div>
    </div>
    <div class="row bg-dark fixed-bottom py-2">
        <div class="col-lg-12">
            <p class="text-light text-center">
                &copy;Design by BunBoFullTopping
            </p>
        </div>
    </div>
</div>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
