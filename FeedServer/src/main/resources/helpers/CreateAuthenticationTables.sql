create schema Users;
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
VALUES ("unknown"),
       ("I dont believe in genders"),
       ("male"),
       ("female");


create table users
(
    `user_id` VARCHAR(40)   not null,
    `gender`  int default 1 not null,
    constraint `Users_pk`
        primary key (`user_id`),
    constraint `Users_genders_id_fk`
        foreign key (`gender`) references genders (`gender_id`)
);


create table courses
(
    `course_id`   VARCHAR(40) not null,
    `course_name` VARCHAR(40) not null,
    constraint `Courses_pk`
        primary key (`course_id`)
);

create table roles
(
    `role_id` int auto_increment,
    `role`    VARCHAR(40) not null,
    constraint roles_pk
        primary key (`role_id`)
);

create unique index roles_role_uindex
    on roles (`role`);
INSERT INTO roles (role)
VALUES ("unspecified");



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