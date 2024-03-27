create database insuranceManagementSystem;
use insuranceManagementSystem;

create table User(
userId int primary key,
username varchar(255),
password varchar(255),
role varchar(255)
);

create table Client(
clientId int primary key,
clientName varchar(255),
contactInfo varchar(255),
policy varchar(255)
);

create table Claim(
claimId int primary key,
claimNumber varchar(255),
dateFiled date,
claimAmount decimal(10,2),
status varchar(255),
policy varchar(255),
clientId int,
foreign key (clientId) references Client(clientId)
);

create table payment(
paymentId int,
paymentDate date,
paymentAmount decimal(10,2),
clientId int,
foreign key (clientId) references Client(clientId)
);

CREATE TABLE Policy (
    policyId INT PRIMARY KEY,
    policyName VARCHAR(255),
    policyType VARCHAR(255),
    policyAmount DECIMAL(10, 2),
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
);


insert into User values
(1, 'user1', 'password1', 'admin'),
(2, 'user2', 'password2', 'user'),
(3, 'user3', 'password3', 'user');


insert into Client values
(1, 'Client A', 'contact@example.com', 'Policy X'),
(2, 'Client B', 'clientb@example.com', 'Policy Y'),
(3, 'Client C', 'clientc@example.com', 'Policy Z');

insert into Claim values
(1, 'C123', '2024-03-25', 1500.00, 'Pending', 'Policy X', 1),
(2, 'C124', '2024-03-26', 2000.00, 'Approved', 'Policy Y', 2),
(3, 'C125', '2024-03-27', 1800.00, 'Pending', 'Policy Z', 3);


insert into Payment values
(1, '2024-03-26', 1500.00, 1),
(2, '2024-03-27', 2000.00, 2),
(3, '2024-03-28', 1800.00, 3);


insert into Policy values
(1, 'Policy X', 'Type A', 5000.00, 1),
(2, 'Policy Y', 'Type B', 6000.00, 2),
(3, 'Policy Z', 'Type C', 7000.00, 3);

