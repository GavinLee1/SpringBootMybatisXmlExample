package com.study.webApi.repository.mybatis;

import org.apache.ibatis.session.SqlSession;
import com.study.infrastructure.exception.DatabaseException;

public interface MybatisAction<T> {
	/**
     * Execute the action.
     *
     * @param sqlSession
     *            mybatis sqlSession
     * @return object
     * @throws DataBaseException
     *             Thrown if an exception occurs when trying to execute the action.
     */
    T Apply(SqlSession sqlSession) throws DatabaseException;
}
