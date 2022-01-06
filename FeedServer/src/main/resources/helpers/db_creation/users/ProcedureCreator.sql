USE users;

DELIMITER //
CREATE PROCEDURE users.register(IN user_id VARCHAR(40), IN gender INT)
BEGIN
    INSERT INTO users.users (user_id, gender) VALUE (user_id, gender);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE users.register_to_course(IN user_id VARCHAR(40),
                                          IN course_id VARCHAR(40), IN role INT)
BEGIN
    INSERT INTO users.users_courses (user_id, course_id, role) VALUE (user_id, course_id, role);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE users.create_course(IN course_id VARCHAR(40), IN course_name VARCHAR(40))
BEGIN
    INSERT INTO users.courses (course_id, course_name) VALUE (course_id, course_name);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE users.register_internal_user(IN user_id VARCHAR(40),IN username VARCHAR(40),IN password VARCHAR(40), IN gender INT)
BEGIN
    INSERT INTO users.users (user_id, gender, registration_type) VALUE (user_id, gender, (SELECT type_id FROM users.registration_type WHERE registration_type = 'Internal Developer Registration'));
    INSERT INTO users.internal_users (user_id, username, password) VALUE (user_id, username, password);
END //
DELIMITER ;