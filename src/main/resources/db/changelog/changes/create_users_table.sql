create table nms_roles(
 roleid int primary key,
 role_name varchar(20) not null
 );

--create sequence userId_sequence;
--
create table nms_users (
    userid uuid primary key not null,
--    default nextval('userid_sequence'::regclass) ,
    employee_code varchar(50),
    username varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    mobile varchar(25) ,
    dateFormat date
--     FOREIGN KEY (id) REFERENCES roles(id)
    );
--insert into users(user_id, user_name , email,password)
--values (1 , 'jesna' , 'jes@gmail.com', 'jes123');

create table nms_user_roles(
    userid uuid ,
    roleid int,
    foreign key (userid) references nms_users(userid),
    foreign key (roleid) references nms_roles(roleid)
    );

