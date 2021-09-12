create database car_shop;
use car_shop;
create table customers(
	customerNumber int not null,
    customerName varchar(50) not null,
    contactLastName varchar(50) not null,
    contactFirstName  varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50) not null,
    city varchar(50) not null,
    state varchar(50) not null,
    postalCode varchar(15) not null,
    country varchar(50) not null,
    creditLimit double,
    employeeNumber int not null,
    primary key(customerNumber),
    foreign key (employeeNumber) references employees(employeeNumber)
);
create table orders(
	orderNumber int not null,
    orderDate date not null,
    requiredDate date not null,
    shippedDate date not null,
    `status` varchar(15) not null,
    comments text,
    quantityOrdered int not null,
    priceEach double not null,
    customerNumber int not null,
    primary key(orderNumber),
    foreign key (customerNumber) references customers(customerNumber)
);
create table payments(
	customerNumber int not null,
	checkNumber varchar(50) not null,
	paymentDate date not null,
    amount double not null,
    primary key(customerNumber),
    foreign key (customerNumber) references customers(customerNumber)
);
create table products(
	productCode varchar(15) not null,
    productName varchar(70) not null,
    productSale varchar(10) not null,
    productVendor varchar(50) not null,
    productDescription text not null,
    quantityInStock  int not null,
    buyPrice double not null,
    MSRP double not null,
    productLine varchar(50) not null,
    primary key(productCode),
	foreign key (productLine) references productlines(productLine)
);
create table OrderDetails(
	orderNumber int not null,
    productCode varchar(15) not null,
    primary key(orderNumber,productCode),
    foreign key (orderNumber) references orders(orderNumber),
    foreign key (productCode) references products(productCode)
);
create table productlines(
	productLine varchar(50) not null,
    textDescription text,
    image text,
    primary key(productLine)
);
create table employees(
	employeeNumber int not null,
	lastName varchar(50) not null,
	firstName varchar(50) not null,
	email varchar(100) not null,
	jobTitle varchar(50) not null,
    officeCode varchar(10) not null,
    reportTo int not null,
    primary key(employeeNumber),
    foreign key (officeCode) references offices(officeCode),
    foreign key (reportTo) references employees(reportTo)
);
create table offices(
	officeCode varchar(10) not null,
	city varchar(50) not null,
	phone varchar(50) not null,
	addressLine1 varchar(50) not null,
    addressLine2 varchar(50) not null,
	state varchar(50) not null,
	country varchar(50) not null,
    postalCode varchar(15) not null,
    primary key(officeCode)
);


