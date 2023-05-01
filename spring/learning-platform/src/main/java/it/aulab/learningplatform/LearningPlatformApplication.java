package it.aulab.learningplatform;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.aulab.learningplatform.util.mapping.CourseToCourseDtoPropertyMap;
import it.aulab.learningplatform.util.mapping.CreateCourseDtoToCoursePropertyMap;

@SpringBootApplication
public class LearningPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningPlatformApplication.class, args);
	}

	@Bean
	public ModelMapper instanceModelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new CreateCourseDtoToCoursePropertyMap());
		mapper.addMappings(new CourseToCourseDtoPropertyMap());
		return mapper;
	}

}
