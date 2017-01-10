package com.study.infrastructure.repositroy;

import java.io.Serializable;
import java.util.List;

import com.study.infrastructure.domain.EntityBase;
import com.study.infrastructure.exception.DatabaseException;

public interface IReadOnlyRepository<T extends EntityBase<TId>, TId extends Serializable> {
	T find(TId id) throws DatabaseException;
//    List<T> find(List<TId> idList) throws DatabaseException;
//    List<T> findAll() throws DatabaseException;
//    TId getIdentifier(T entity);
//    int countAll() throws DatabaseException;
//    int selectMaxIdentifier() throws DatabaseException;
//    PaginationQueryResponse<T, TId> paginationQuery(PaginationQueryRequest<T, TId> request) throws DataBaseException;
}
