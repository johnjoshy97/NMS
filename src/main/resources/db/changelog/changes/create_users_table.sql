create table nms_roles(
 role_id int primary key,
 role_name varchar(20) not null
 );

--    create table roles(
--    id int primary key,
--    name varchar(20) not null
--     FOREIGN KEY (id) REFERENCES users(id)
-- );

create sequence user_id_sequence;
--
create table nms_users (
    user_id int primary key not null default nextval('user_id_sequence'::regclass) ,
    employee_code varchar(50),
    username varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    mobile varchar(25) not null,
    date_time date
--     FOREIGN KEY (id) REFERENCES roles(id)
    );
--insert into users(user_id, user_name , email,password)
--values (1 , 'jesna' , 'jes@gmail.com', 'jes123');

create table nms_user_roles(
    user_id int ,
    role_id int,
    foreign key (user_id) references nms_users(user_id),
    foreign key (role_id) references nms_roles(role_id)
    );

