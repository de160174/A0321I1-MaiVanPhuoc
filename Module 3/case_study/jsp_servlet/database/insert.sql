use db_furama_main;
insert into customer_type
values ("T1","Diamond"),
		("T2","Platinium"),
		("T3","Gold"),
		("T4","Silver"),
		("T5","Member");
insert into customer
values ("C1","T1","Mai Van Phuoc","2000-11-25",0,"201917112","0987115965","vp@gmail.com","DaNang"),
		("C2","T2","Deanna Henson","1996-11-16",1,"7682448746","0954005322","mus.proin@turpis.co.uk","Vienna"),
		("C3","T3","Davis Woods","1994-07-09",0,"5204280770","0903543340","vamet.metus@mollisvitae.edu","Loralai"),
		("C4","T4","Iris Mooney","1990-12-13",1,"7066865570","0967522584","proin.dolor.nulla@tempor.net","HaNoi"),
		("C5","T5","Scott Forbes","1999-02-14",1,"7475263817","0920385358","quis@quamelementumat.co.uk","HoChiMinh"),
		("C6","T4","Tallulah Dillon","1996-09-23",0,"4513666300","0936223864","vmollis.dui@mi.net","Seoul"),
		("C7","T5","Caesar Yang","1998-03-18",0,"6284017163","0927711274","velit.cras@sociosquad.org","Tokyo"),
		("C8","T2","Hayden Petty","1993-02-22",1,"3141248781","0986646285","pellentesque@mauris.net","Berlin"),
		("C9","T5","Cody Sullivan","2000-07-25",0,"2583328752","0906068215","non@atlacus.edu","Bejing"),
		("C10","T1","Cedric Allen","1997-03-28",0,"2018171764","0985097891","mauris@egetipsum.net","DaNang");
insert into education_degree
values ("TD1","Trung cấp"),
		("TD2","Cao đẳng"),
		("TD3","Đại học"),
		("TD4","Sau đại học");
insert into position
values ("VT1","Lễ tân"),
		("VT2","Phục vụ"),
		("VT3","Chuyên viên"),
		("VT4","Giám sát"),
		("VT5","Quản lý"),
		("VT6","Giám đốc");
insert into division
values ("BP1","Sale – Marketing"),
		("BP2","Hành Chính"),
		("BP3","Phục vụ"),
		("BP4","Quản lý");
insert into `role`
values ("R1","Admin"),
		("R2","User");
insert into user_role
values ("R1","vanphuoc"),
		("R2","bunbo"),
		("R2","myquang"),
		("R2","xoiga"),
		("R2","bunrieu"),
		("R2","caolau"),
		("R2","banhmy"),
		("R2","pho"),
		("R2","banhbeo"),
		("R2","banhcuon");
insert into `user`
values ("vanphuoc","abc123"),
		("bunbo","abc123"),
		("myquang","abc123"),
		("xoiga","abc123"),
		("bunrieu","abc123"),
		("caolau","abc123"),
		("banhmy","abc123"),
		("pho","abc123"),
		("banhbeo","abc123"),
		("banhcuon","abc123");
insert into employee
values ("E1","Phuoc","2000-11-25","987654321",25000,"0905624973","vp@gmail.com","DaNang","VT6","TD4","BP4","vanphuoc"),
		("E2","Imani Cook","1997-07-25","201863966",15000,"0905781734","ut@aodio.edu","HaNoi","VT5","TD3","BP3","bunbo"),
		("E3","Brock Heath","1996-01-11","201822592",16000,"0905132502","ante@etmalesuada.ca","HoChiMinh","VT2","TD4","BP2","myquang"),
		("E4","Wilma Brady","1991-03-25","201864625",12000,"0905432457","a@tortornunc.com","QuangNam","VT3","TD1","BP1","xoiga"),
		("E5","Joan Barrera","2000-06-26","201837893",24500,"0905638824","tincidunt@risus.net","Vinh","VT2","TD1","BP2","bunrieu"),
		("E6","Astra Alexander","1998-04-15","201812848",16500,"0905252525","mattis@enim.ca","DaNang","VT1","TD2","BP3","caolau"),
		("E7","Boris Howe","1994-01-21","201878678",20000,"0905556656","iaculis@duisa.co.uk","Granada","VT2","TD4","BP1","banhmy"),
		("E8","Stephen Albert","1997-10-18","201867388",18000,"0905137882","mi@nullamfeugiat.com","Tokyo","VT3","TD3","BP2","pho"),
		("E9","Samantha Duke","1999-11-14","201883167",19500,"0905240539","lacinia@loremac.net","Berlin","VT5","TD2","BP3","banhbeo"),
		("E10","Freya Owens","2000-08-02","201858335",21700,"0905181542","ut@morbitristique.com","Paris","VT4","TD1","BP2","banhcuon");
insert into service_type
values ("L1","Villa"),
		("L2","House"),
		("L3","Room");
insert into rent_type
values ("K1","Năm",10000),
		("K2","Tháng",8000),
		("K3","Ngày",5000),
		("K4","Giờ",2500);
insert into service
values ("S1","Thor",10,25000,20,"K2","L1","vip","",5,2),
		("S2","Iron Man",15,25000,15,"K3","L2","standard","",0,2),
		("S3","Captain America",10,25000,20,"K4","L2","vip","",5,1),
		("S4","Black Widow",8,25000,20,"K1","L3","standard","",5,2),
		("S5","Hulk",10,25000,15,"K2","L1","vip","",0,2),
		("S6","Ant-man",15,25000,20,"K4","L3","vip","",5,2),
		("S7","Spider-man",10,25000,15,"K3","L2","standard","",0,1),
		("S8","Loki",8,25000,20,"K3","L3","vip","",5,2),
		("S9","Captain Marvel",10,25000,20,"K1","L2","standard","",5,2),
		("S10","Doctor Strange",10,25000,20,"K2","L1","vip","",5,1);
insert into attach_service
values ("AS1","massage",3500,20,"active"),
		("AS2","karaoke",2500,20,"active"),
		("AS3","thức ăn",1500,20,"active"),
		("AS4","nước uống",500,20,"active"),
		("AS5","thuê xe di chuyển tham quan resort",4500,20,"active");
insert into contract
values ("HD1","2021-01-15 12:00:00","2021-05-15 12:00:00",15000,30000,"E1","C3","S7"),
		("HD2","2021-05-27 12:00:00","2021-08-16 12:00:00",10000,30000,"E2","C10","S9"),
		("HD3","2021-02-25 12:00:00","2021-05-18 12:00:00",15000,25000,"E3","C8","S2"),
		("HD4","2021-01-18 12:00:00","2021-03-02 12:00:00",15000,30000,"E4","C2","S5"),
		("HD5","2021-05-20 12:00:00","2021-09-20 12:00:00",10000,25000,"E5","C5","S1"),
		("HD6","2021-02-16 12:00:00","2021-06-30 12:00:00",15000,40000,"E6","C7","S3"),
		("HD7","2021-03-02 12:00:00","2021-05-15 12:00:00",10000,28000,"E7","C9","S6"),
		("HD8","2021-05-30 12:00:00","2021-07-08 12:00:00",15000,30000,"E8","C4","S10"),
		("HD9","2021-04-18 12:00:00","2021-06-14 12:00:00",10000,20000,"E9","C1","S8"),
		("HD10","2021-06-02 12:00:00","2021-08-12 12:00:00",15000,35000,"E10","C6","S4");
insert into contract_detail
values ("CTHD1","HD1","AS1",1),
		("CTHD2","HD2","AS2",1),
		("CTHD3","HD3","AS3",1),
		("CTHD4","HD4","AS4",1),
		("CTHD5","HD5","AS5",2),
		("CTHD6","HD6","AS4",1),
		("CTHD7","HD7","AS3",1),
		("CTHD8","HD8","AS2",1),
		("CTHD9","HD9","AS1",2),
		("CTHD10","HD10","AS5",1);
