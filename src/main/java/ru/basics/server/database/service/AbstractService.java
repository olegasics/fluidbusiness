package ru.basics.server.database.service;

import org.springframework.stereotype.Service;
import ru.basics.server.database.dao.AbstractDAO;

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

//    @Override
//    public void update(Object entity) {
//        super.update(entity);
//    }
//
//    @Override
//    public void delete(Object entity) {
//        super.delete(entity);
//    }
//
//    @Override
//    public boolean isExist(Object o) {
//        return super.isExist(o);
//    }
}
