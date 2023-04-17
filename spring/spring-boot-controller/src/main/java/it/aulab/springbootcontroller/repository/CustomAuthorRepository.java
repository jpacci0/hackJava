package it.aulab.springbootcontroller.repository;

import java.util.List;
import java.util.Map;

import it.aulab.springbootcontroller.model.Author;

public interface CustomAuthorRepository {
    public List<Author> dynamicQuery(Map<String, String> filter);
}
