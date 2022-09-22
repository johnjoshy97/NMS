
--create sequence userid;
create table nms_user_details(
    userid uuid primary key not null ,
--    default nextval('userid_sequence'::regclass) ,
--uuid varchar(20);
--    userid int  ,
    employee_Code varchar(100) not null,
    username varchar(100) not null,
    email varchar(20) not null ,
    mobile varchar(20) not null ,
    date_format date,
    joining_Date date,
    timezone varchar(50),
    department varchar(100),
    last_name varchar(20),
    manager varchar(20),
    office varchar(100),
    date_of_birth date ,
    salary_wages int ,
    gender varchar(10),
    weekly_working_hours varchar(30),
    aadhar_number int,
    PAN_number varchar(20)

);