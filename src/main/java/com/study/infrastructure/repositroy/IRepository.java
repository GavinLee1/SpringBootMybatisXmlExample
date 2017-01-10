package com.study.infrastructure.repositroy;

import java.io.Serializable;

import com.study.infrastructure.domain.EntityBase;
import com.study.infrastructure.exception.DatabaseException;
import com.study.infrastructure.repositroy.IReadOnlyRepository;

public interface IRepository <T extends EntityBase<TId>, TId extends Serializable> extends IReadOnlyRepository<T, TId>{
//    int create(T entity) throws DatabaseException;
//    int update(T entity) throws DatabaseException;
//    int delete(T entity) throws DatabaseException;
//    int delete(TId id) throws DatabaseException;
////    boolean Truncate() throws DataBaseException;
//    void entityUpdateCallback(T oldEntity, T entity);
//    void entityCreateCallback(T entity);
}
