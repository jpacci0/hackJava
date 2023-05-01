create table courses (
    id bigint not null auto_increment, 
    date date, 
    description varchar(1000), 
    name varchar(100) not null, 
    teacher_firstname varchar(100) not null, 
    teacher_lastname varchar(100) not null, 
    primary key (id)
) engine=InnoDB;

create table courses_students (
    course_id bigint not null, 
    student_id bigint not null
) engine=InnoDB;

create table lessons (
    id bigint not null auto_increment, 
    date DATE default now(), 
    description varchar(1000), 
    course_id bigint, 
    primary key (id)
) engine=InnoDB;

create table students (
    id bigint not null auto_increment, 
    firstname varchar(100) not null, 
    lastname varchar(100) not null, 
    email varchar(100) not null, 
    primary key (id)
) engine=InnoDB;

alter table if exists students add constraint UK_e2rndfrsx22acpq2ty1caeuyw unique (email);

alter table if exists courses_students add constraint FKecu9b8uo86fy0wegale3gjtrw foreign key (student_id) references students (id);

alter table if exists courses_students add constraint FKcj1bvqj437mdtgllmwcd41f2u foreign key (course_id) references courses (id);

alter table if exists lessons add constraint FK17ucc7gjfjddsyi0gvstkqeat foreign key (course_id) references courses (id);