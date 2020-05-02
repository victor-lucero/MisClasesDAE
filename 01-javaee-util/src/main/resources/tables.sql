create table tbl_student
(
    id int auto_increment,
    name varchar(20) null,
    last_name_father varchar(20) null,
    last_name_mother varchar(20) null,
    age int null,
    constraint tbl_student_pk
        primary key (id)
);
