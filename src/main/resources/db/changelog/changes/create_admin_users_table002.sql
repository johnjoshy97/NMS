create table nms_user_details(
    user_id int,
    employee_code varchar(100) not null primary key,
    username varchar(100) not null,
    email varchar(20) not null ,
    mobile int,
    date_format date,
    joining_date date,
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