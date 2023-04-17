package it.aulab.springbootcontroller.repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.aulab.springbootcontroller.model.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class CustomAuthorRepositoryImpl implements CustomAuthorRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Author> dynamicQuery(Map<String, String> filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> query = cb.createQuery(Author.class);
        Root<Author> author = query.from(Author.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        for (Field field : Author.class.getDeclaredFields()) {
            String valueOnMap = filter.get(field.getName());
            if (valueOnMap != null) {
                Path<String> fieldPath = author.get(field.getName());
                predicates.add(cb.equal(fieldPath, valueOnMap));
            }
        }
        if (predicates.size() > 0)
            query.select(author).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        else
            query.select(author);
        return entityManager.createQuery(query).getResultList();
    }

}
