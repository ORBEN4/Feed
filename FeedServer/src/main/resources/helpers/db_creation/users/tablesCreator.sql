use Users;


create table genders
(
    `gender_id` int auto_increment,
    `gender`    VARCHAR(30) not null,
    constraint genders_pk
        primary key (`gender_id`)
);

create unique index genders_gender_uindex
    on genders (`gender`);


INSERT INTO genders (`gender`)
VALUES ('unknown'),
       ('I dont believe in genders'),
       ('male'),
       ('female');



create table registration_type
(
    type_id           int auto_increment,
    registration_type VARCHAR(40) not null,
    constraint registration_type_pk
        primary key (type_id)
);


create unique index registration_type_registration_type_uindex
    on registration_type (registration_type);


INSERT INTO users.registration_type (registration_type) VALUE
    ('Internal Developer Registration'),
    ('Green Team'),
    ('MyIdf'),
    ('Google'),
    ('Facebook'),
    ('Microsoft'),
    ('Undefined');



create table users
(
    user_id           VARCHAR(40)             not null,
    gender            INT       default 1     not null,
    registration_type INT                     not null,
    creation_time     TIMESTAMP default NOW() not null,
    constraint users_pk
        primary key (user_id),
    constraint users_genders_gender_id_fk
        foreign key (gender) references genders (gender_id),
    constraint users_registration_type_type_id_fk
        foreign key (registration_type) references registration_type (type_id)
);



create table internal_users
(
    user_id  VARCHAR(40) null,
    username VARCHAR(40) not null,
    password VARCHAR(40) not null,
    constraint internal_users_pk
        primary key (username),
    constraint internal_users_users_user_id_fk
        foreign key (user_id) references users (user_id)
);



create table courses
(
    `course_id`   VARCHAR(40) not null,
    `course_name` VARCHAR(40) not null,
    constraint `Courses_pk`
        primary key (`course_id`)
);

INSERT INTO users.courses (course_id, course_name) VALUE ('abc', 'test course');



create table roles
(
    `role_id` int         not null,
    `role`    VARCHAR(40) not null,
    constraint roles_pk
        primary key (`role_id`)
);

create unique index roles_role_uindex
    on roles (`role`);
INSERT INTO roles (role_id, role)
VALUES (0, 'unspecified'),
       (100, 'student'),
       (200, 'commander'),
       (300, 'makas'),
       (400, 'ramad'),
       (500, 'ra\'an'),
       (1000, 'admin'),
       (1100, 'super-admin'),
       (1200, 'developer'),
       (1300, 'owner'),
       (10000, 'OR');



create table users_courses
(
    `user_id`   VARCHAR(40)   not null,
    `course_id` VARCHAR(40)   not null,
    `role`      int default 1 not null,
    constraint users_courses_pk
        primary key (`user_id`, `course_id`),
    constraint users_courses_courses_course_id_fk
        foreign key (`course_id`) references courses (`course_id`),
    constraint users_courses_users_user_id_fk
        foreign key (`user_id`) references users (`user_id`),
    constraint users_courses_users_role_fk
        foreign key (`role`) references roles (`role_id`)
);