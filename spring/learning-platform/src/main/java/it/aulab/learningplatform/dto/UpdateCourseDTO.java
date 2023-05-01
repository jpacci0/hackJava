package it.aulab.learningplatform.dto;

import java.util.List;

import it.aulab.learningplatform.model.Student;

public class UpdateCourseDTO {
    private String description;
    private String date;
    private List<Student> students;
    private List<Long> addedStudentsIds;
    private List<Long> removedStudentsIds;
    public UpdateCourseDTO() {
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setAddStudentId(Long id) {
        this.addedStudentsIds.add(id);
    }
    public void setAddedStudentsIds(List<Long> addedStudentsIds) {
        this.addedStudentsIds = addedStudentsIds;
    }
    public List<Long> getRemovedStudentsIds() {
        return removedStudentsIds;
    }
    public void setRemovedStudentsIds(List<Long> removedStudentsIds) {
        this.removedStudentsIds = removedStudentsIds;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}