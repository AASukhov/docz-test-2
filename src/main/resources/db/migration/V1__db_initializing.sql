CREATE TABLE STUDENTS (
    id          INTEGER,
    name        VARCHAR(50),
    surname     VARCHAR(50),
    date        DATE,
    st_group    VARCHAR(10),
    primary key (id)
);

INSERT INTO STUDENTS
VALUES (1,'Alex','Petrov','1993-11-12','UPM'),
       (2,'Sergey','Vasiliev','1992-12-12','UPM'),
       (3,'Sviridov','Vasily','1998-10-10','ADB');