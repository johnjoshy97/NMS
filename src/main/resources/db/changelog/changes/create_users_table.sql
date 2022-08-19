create table roles(
 id int primary key,
 name varchar(20) not null
 );

--    create table roles(
--    id int primary key,
--    name varchar(20) not null
--     FOREIGN KEY (id) REFERENCES users(id)
-- );


create table users (
    id int primary key ,
    Name varchar(255) not null,
    userame varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
     FOREIGN KEY (id) REFERENCES roles(id)
    );

