package it.aulab.learningplatform.util.mapping;

import org.modelmapper.PropertyMap;

import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.model.Course;

public class CreateCourseDtoToCoursePropertyMap extends PropertyMap<CreateCourseDTO, Course> {

    @Override
    protected void configure() {
        using(new ConvertStringToDate()).map(source.getDate()).setDate(null);
    }
    
}
