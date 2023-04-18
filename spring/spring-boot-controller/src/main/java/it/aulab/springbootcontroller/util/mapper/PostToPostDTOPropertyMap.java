package it.aulab.springbootcontroller.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springbootcontroller.dto.PostDTO;
import it.aulab.springbootcontroller.model.Post;

public class PostToPostDTOPropertyMap extends PropertyMap<Post, PostDTO> {

    @Override
    protected void configure() {
        using(new ConvertStringToInteger()).map(source.getBody()).setBodyLenght(null);
    }
    
}
