package com.study.webApi.repository.mybatis;

import java.io.IOException;
import java.io.Reader;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.infrastructure.exception.DatabaseException;

public class MybatisUtility {
	/**
     * {@link MybatisUtility}'s Logger.
     */
	private static final Logger log = LoggerFactory.getLogger(MybatisUtility.class);

    /**
     * Default constructor to avoid class instantiation.
     */
    private MybatisUtility() {

    }

    /**
     * mybatis configuration file path.
     */
    private static final String RESOURCE = "mybatis/mybatis-config.xml";

    /**
     * Session factory.
     */
    private static SqlSessionFactory sqlSessionFactory;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(RESOURCE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (IOException e) {
            log.error("error occurred when trying to load mybatis configuration file [ " + RESOURCE + " ] : "
                    + e.getLocalizedMessage());
        }
        finally {
            IOUtils.closeQuietly(reader);
        }
    }

    /**
     * Get ibatis sql session.
     *
     * @return {@link SqlSession}.
     * @throws DatabaseException
     *             thrown if error occurred when trying to get sql session.
     */
    public static SqlSession GetSession() throws DatabaseException {
        if (sqlSessionFactory == null) {
            throw new DatabaseException("error occurred when trying to create sql session factory");
        }
        return sqlSessionFactory.openSession();
    }
}
