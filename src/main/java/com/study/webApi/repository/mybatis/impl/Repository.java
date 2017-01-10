package com.study.webApi.repository.mybatis.impl;

import java.io.Serializable;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.infrastructure.configuration.*;
import com.study.infrastructure.domain.EntityBase;
import com.study.infrastructure.exception.DatabaseException;
import com.study.infrastructure.repositroy.IRepository;
import com.study.webApi.repository.mybatis.MybatisAction;
import com.study.webApi.repository.mybatis.MybatisUtility;

public abstract class Repository <T extends EntityBase<TId>, TId extends Serializable> implements IRepository<T, TId> {
	private static final Logger log = LoggerFactory.getLogger(Repository.class);
	protected static final IApplicationSettings applicationSettings = ApplicationSettingsFactory.getApplicationSettings();
	
	/**
     * Entity's type this instance has to manage.
     */
    protected Class<T> typeClass;

    /**
     * The column id name for the table of the mapped entity.
     */
    private String columnIdName;

    /**
     * The name of the table
     */
    private String tableName;

    /**
     * Default namespace in mapper files.
     */
    protected static final String NAMESPACE = "mappers";

    /**
     * prefix of find queries in mapper files.
     */
    protected static final String PREFIX_FIND_QUERY = "find";
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public T find(final TId id) throws DatabaseException {
        log.debug("Starting findOne method...");

        if (id == null) {
            log.error("The identifier can not be null.");
            throw new IllegalArgumentException("The identifier can not be null.");
        }

        try {

            log.debug("Getting and returning the entity [ " + typeClass.getSimpleName() + " ] with identifier [ "
                    + id.toString() + " ]...");
            return this.ExecuteAction(new MybatisAction<T>() {

                @Override
                public T Apply(SqlSession session) throws DatabaseException {
                    String query = NAMESPACE + "." + PREFIX_FIND_QUERY + typeClass.getSimpleName();
                    return (T) session.selectOne(query, id);
                }
            }, false);

        } catch (Exception e) {
            log.error(
                    "An error has occurred while getting the entity [ " + typeClass + " ] with identifier ["
                            + id.toString() + " ].", e);
            throw new DatabaseException("An error has occurred while getting the entity " + typeClass + " ["
                    + id.toString() + " ].", e);
        }
    }
    
    /**
     * Execute the action received as parameter.
     *
     * @param action   object that specifies the MyBatis action
     * @param readOnly if this parameter is true the transaction is read-only
     * @param <T>      object's returned type.
     * @return a result object returned by the action.
     * @throws DataBaseException thrown if error occurred when trying to execute the action.
     */
    public <T> T ExecuteAction(MybatisAction<T> action, boolean readOnly) throws DatabaseException {
        SqlSession session = null;
        try {
            session = MybatisUtility.GetSession();
            T results = action.Apply(session);
            if (readOnly) {
                session.commit();
            }
            return results;
        } catch (Throwable e) {
            if (readOnly && session != null) {
                session.rollback();
            }
            log.error("An error has occurred when trying to execute action.", e);
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
