package it.aulab.springbootcontroller.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springbootcontroller.dto.AuthorDTO;
import it.aulab.springbootcontroller.model.Author;

public class AuthorToAuthorDTOPropertyMap extends PropertyMap<Author, AuthorDTO> {

    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getPosts()).setNumberOfPost(null);
    }
    
}
