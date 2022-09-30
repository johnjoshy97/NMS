
--create sequence userid;
create table nms_user_details(
    userid uuid primary key not null ,
--    default nextval('userid_sequence'::regclass) ,
--    userid int  ,
  first_name varchar(100),
  last_name varchar(100),
  employee_code varchar(100),
  email varchar(100),
  mobile varchar(20),
  date_of_birth Date,
  joining_date Date ,
  manager varchar(100),
  employee_address varchar(100),
  employment_type varchar(100),
  work_status varchar(100),
  salary int,
  probation_status varchar(100),
  probation_period varchar(100),
  gender varchar(100),
  designation varchar(100),
  PAN_number varchar(100),
  daily_work_hour varchar(100),
  weekly_work_hour varchar(100),
  aadhar_number int,
  department varchar(100)
);