create database Bank_Info;

use Bank_Info;

create table Account_Info(
Account_ID int primary key identity(1011,1),
Account_Name varchar(100) NOT NULL,
Account_Pin integer NOT NULL check (Account_Pin between 0 and 9999),
Account_Amount money NOT NULL
);

insert into Account_Info (Account_Name, Account_Pin, Account_Amount) values
('Ibrahim Yusuf', 6897, 567879.00),
('Ayomide Taiwo', 2457, 7879.00),
('Temidire Funke', 7865, 579.00),
('Matthew John', 1344, 79.00);

select * from Account_Info;