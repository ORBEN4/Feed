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