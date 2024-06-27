CREATE SEQUENCE student_id_seq AS integer;
-- ALTER SEQUENCE student_id_seq OWNED BY student.id;

CREATE TABLE student (
    id integer NOT NULL DEFAULT nextval('student_id_seq') PRIMARY KEY,
    firstname varchar(50) NOT NULL,
    lastname varchar(100) NOT NULL,
    room varchar(5),
    created_date timestamp with time zone,
    updated_date timestamp with time zone
);


INSERT INTO student (firstname, lastname, room, created_date) VALUES
('Robert', 'Pires', '1/1', now()),
('Dennis', 'Bergkamp', '1/2', now()),
('Thiery', 'Henry', '1/2', now());

-- select * from student;