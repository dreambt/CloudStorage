package cn.im47.cloud.storage.common.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 * <p/>
 * <p>Extend this interface if you want typesafe (no casting necessary) DAO's for your
 * domain objects.
 *
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 * @author baitao.jibt@gmail.com
 * @version 1.0
 * @since 2010-04-17
 */
public interface GenericAppDao<T, PK extends Serializable> {

    /**
     * Generic method to get an object based on class and identifier. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if
     * nothing is found.
     *
     * @param id the identifier (primary key) of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    T get(@Param("appKey") String appKey, @Param("id") PK id);

    /**
     * 返回实体个数
     *
     * @return 记录数
     */
    Long count(@Param("appKey") String appKey);

    /**
     * Generic method to save an object - handles insert.  will set modified_time to
     * current time and will set created_time to current_system_time if it's an insert.
     *
     * @param object the object to save
     * @return the persisted object
     */
    int save(@Param("appKey") String appKey, @Param("object") T object);

    /**
     * 更新实体
     *
     * @param object the object to save
     * @return the persisted object
     */
    int update(@Param("appKey") String appKey, @Param("object") T object);

    /**
     * 更新bool字段
     *
     * @param id     the object to save
     * @param column the object to save
     * @return the persisted object
     */
    int updateBool(@Param("appKey") String appKey, @Param("id") Long id, @Param("column") String column);

    /**
     * Generic method to delete an object based on class and id
     *
     * @param id the identifier (primary key) of the object to remove
     */
    int delete(@Param("appKey") String appKey, @Param("id") PK id);

    /**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     *
     * @return List of populated objects
     */
    List<T> search(@Param("appKey") String appKey, @Param("parameters") Map<String, Object> parameters);

}