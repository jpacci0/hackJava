package it.aulab.learningplatform.util.mapping;

import org.modelmapper.PropertyMap;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.model.Course;

public class CourseToCourseDtoPropertyMap extends PropertyMap<Course, CourseDTO> {

    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getStudents()).setNumberOfStudents(null);
    }
    
}
