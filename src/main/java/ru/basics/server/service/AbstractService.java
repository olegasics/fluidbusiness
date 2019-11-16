package ru.basics.server.service;

import org.springframework.stereotype.Service;
import ru.basics.server.repository.dao.AbstractDAO;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
@Service
@Transactional
public abstract class AbstractService<T> implements Serializable {


    public abstract AbstractDAO getDao();

    public T create(T entity) {
        return (T) getDao().create(entity);
    }


    public T findByField(String field, Object key) {
        return (T) getDao().findByField(field, key);
    }


    public List<T> findAllField() {
        return getDao().findAllField();
    }

    public boolean isExist(Object o) {
        return getDao().isExist(o);
    }

    public T findById(Long id) {
        return (T) getDao().findById(id);
    }


    public void update(Object entity) {
         getDao().update(entity);
    }


    public void delete(Object entity) {
        getDao().delete(entity);
    }
//
//    @Override
//    public boolean isExist(Object o) {
//        return super.isExist(o);
//    }
}
