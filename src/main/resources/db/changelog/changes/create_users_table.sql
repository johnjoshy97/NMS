create table roles(
<<<<<<< HEAD
 role_id int primary key,
 role_name varchar(20) not null
=======
 id int primary key,
 name varchar(20) not null
>>>>>>> e0825ed7cd9592bb3161b0ab99cd5b3dcff955fb
 );

--    create table roles(
--    id int primary key,
--    name varchar(20) not null
--     FOREIGN KEY (id) REFERENCES users(id)
-- );

<<<<<<< HEAD
create sequence user_id_sequence;
--
create table users (
    user_id int primary key not null default nextval('user_id_sequence'::regclass) ,
    username varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null
--     FOREIGN KEY (id) REFERENCES roles(id)
    );
--insert into users(user_id, user_name , email,password)
--values (1 , 'jesna' , 'jes@gmail.com', 'jes123');

    create table user_roles(
    user_id int ,
    role_id int,
    foreign key (user_id) references users(user_id),
    foreign key (role_id) references roles(role_id)
=======

create table users (
    id int primary key ,
    Name varchar(255) not null,
    userame varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
     FOREIGN KEY (id) REFERENCES roles(id)
>>>>>>> e0825ed7cd9592bb3161b0ab99cd5b3dcff955fb
    );

