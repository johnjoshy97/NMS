CREATE TABLE Nms_select(
selectid INT primary key,
label VARCHAR(100) NOT NULL,
options VARCHAR(100),
createdAt VARCHAR(100),
 createBy VARCHAR(100),
 updateAt VARCHAR(100),
 updateBy VARCHAR(100)
);

CREATE SEQUENCE id_seq INCREMENT BY 1 START WITH 1 OWNED BY Nms_select.selectid;
