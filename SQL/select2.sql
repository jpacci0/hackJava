SELECT students.nome, GROUP_CONCAT(courses.course_name SEPARATOR ', ') AS courses
FROM students
JOIN students_courses ON students.id = students_courses.student_id
JOIN courses ON students_courses.course_id = courses.id
GROUP BY students.id;



