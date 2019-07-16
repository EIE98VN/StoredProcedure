create table Student(
	id varchar(10) not null primary key,
    name varchar(30) not null,
    age int,
    class varchar(10)
);
DELIMITER $$
CREATE PROCEDURE selectAllStudents()
BEGIN
   select * from Student;
END $$
DELIMITER ;