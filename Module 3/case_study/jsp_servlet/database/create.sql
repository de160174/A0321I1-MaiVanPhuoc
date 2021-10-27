create database db_furama_main;
use db_furama_main;
create table `position`(
	position_id varchar(10) not null,
	position_name varchar(45) not null,
    primary key (position_id)
);
create table education_degree(
	education_degree_id varchar(10) not null,
	education_degree_name varchar(45) not null,
    primary key (education_degree_id)
);
create table division(
	division_id varchar(10) not null,
	division_name varchar(45) not null,
    primary key (division_id)
);
create table employee(
	employee_id varchar(10) not null,
	employee_name varchar(45) not null,
	employee_birthday date ,
    employee_id_card varchar(45),
    employee_salary double,
    employee_phone varchar(45),
    customer_email varchar(45),
    customer_address varchar(45),
    position_id varchar(10) not null,
    education_degree_id varchar(10) not null,
    division_id varchar(10) not null,
	username varchar(255) not null,
    primary key (employee_id),
    foreign key (position_id) references `position`(position_id) on update cascade on delete cascade,
    foreign key (education_degree_id) references education_degree(education_degree_id) on update cascade on delete cascade,
    foreign key (division_id) references division(division_id) on update cascade on delete cascade
);
ALTER TABLE employee ADD FOREIGN KEY(username) REFERENCES `user`(username);
create table `role`(
	role_id varchar(10) not null,
	role_name varchar(255) not null,
    primary key (role_id)
);
create table user_role(
	role_id varchar(10) not null,
	username varchar(255) not null,
    foreign key (role_id) references `role`(role_id) on update cascade on delete cascade,
    foreign key (username) references `user`(username) on update cascade on delete cascade
);
create table `user`(
	username varchar(255) not null,
	`password` varchar(255) not null,
    primary key (username)
);
create table customer_type(
	customer_type_id varchar(10) not null,
	customer_type_name varchar(45) not null,
    primary key (customer_type_id)
);
create table customer(
	customer_id varchar(10) not null,
	customer_type_id varchar(10) not null,
	customer_name varchar(45) not null,
	customer_birthday date ,
	customer_gender bit(1),
    customer_id_card varchar(45),
    customer_phone varchar(45),
    customer_email varchar(45),
    customer_address varchar(45),
    primary key (customer_id),
    foreign key (customer_type_id) references customer_type(customer_type_id) on update cascade on delete cascade
);
create table service_type(
	service_type_id varchar(10) not null,
	service_type_name varchar(45) not null,
    primary key (service_type_id)
);
create table rent_type(
	rent_type_id varchar(10) not null,
	rent_type_name varchar(45) not null,
	rent_type_cost double,
    primary key (rent_type_id)
);
create table service(
	service_id varchar(10) not null,
    service_name varchar(45) not null,
    service_area int,
    service_cost double,
    service_max_people int,
    rent_type_id varchar(10) not null,
	service_type_id varchar(10) not null,
    standard_room varchar(45),
    `description` varchar(45),
    pool_area double,
    number_of_floor int,
    primary key (service_id),
    foreign key (rent_type_id) references rent_type(rent_type_id) on update cascade on delete cascade,
    foreign key (service_type_id) references service_type(service_type_id) on update cascade on delete cascade
);
create table attach_service(
	attach_service_id varchar(10) not null,
	attach_service_name varchar(45) not null,
	attach_service_cost double,
	attach_service_unit int,
	attach_service_status varchar(45),
    primary key (attach_service_id)
);
create table contract_detail(
	contract_detail_id varchar(10) not null,
	contract_id varchar(10) not null,
    attach_service_id varchar(10) not null,
	quantity int,
    primary key (contract_detail_id),
    foreign key (contract_id) references contract(contract_id) on update cascade on delete cascade,
    foreign key (attach_service_id) references attach_service(attach_service_id) on update cascade on delete cascade
);
create table contract(
	contract_id varchar(10) not null,
	contract_start_date datetime,
	contract_end_date datetime,
	contract_deposit double,
	contract_total_money double,
    employee_id varchar(10) not null,
	customer_id varchar(10) not null,
    service_id varchar(10) not null,
    primary key (contract_id),
    foreign key (employee_id) references employee(employee_id) on update cascade on delete cascade,
    foreign key (customer_id) references customer(customer_id) on update cascade on delete cascade,
    foreign key (service_id) references service(service_id) on update cascade on delete cascade
);

