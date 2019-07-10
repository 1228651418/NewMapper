package com.jyx.edu.NewMapper180831.basemapper.mymapper;

import com.jyx.edu.NewMapper180831.entity.BaseEntity;
import com.jyx.edu.NewMapper180831.entity.SysUser;
import com.jyx.edu.NewMapper180831.util.SqlUtils;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.lang.reflect.Field;

public class JoinProvider {

    public <T extends BaseEntity, E extends BaseEntity> String left2JoinNotCondition(Class<T> t, Class<E> e){
        return SqlUtils.leftJoin(t,e).toString();
    }

    public <T extends BaseEntity, E extends BaseEntity> String left2JoinWithBeanCondition(Class<T> t, Class<E> e, T record1, E record2){
        if(record1 !=null || record2 != null)
            return SqlUtils.leftJoin(t,e).append(SqlUtils.condition(record1,record2)).toString();
        return SqlUtils.leftJoin(t,e).toString();
    }

    public <T extends BaseEntity, E extends BaseEntity> String left2JoinWithSqlCondition(Class<T> t, Class<E> e,String sql){
        return SqlUtils.leftJoin(t,e).append(" where 1=1 ").append(sql).toString();
    }

    public <T extends BaseEntity, E extends BaseEntity> String left2JoinWithBeanAndSqlCondition(Class<T> t, Class<E> e, T record1, E record2,String sql){
        if(record1 !=null || record2 != null)
            return SqlUtils.leftJoin(t,e).append(SqlUtils.condition(record1,record2)).append(SqlUtils.condition(sql)).toString();
        return SqlUtils.leftJoin(t,e).append(" where 1=1 ").append(sql).toString();
    }

    public <T extends BaseEntity, E extends BaseEntity,K extends BaseEntity> String left3JoinNotCondition(Class<T> t,Class<E> e,Class<K> k){
        return SqlUtils.leftJoin(t,e,k).toString();
    }

    public <T extends BaseEntity, E extends BaseEntity,K extends BaseEntity> String left3JoinWithBeanCondition(Class<T> t, Class<E> e,Class<K> k, T record1, E record2, K record3){
        if(record1 !=null || record2 != null || record3 != null)
            return SqlUtils.leftJoin(t,e,k).append(SqlUtils.condition(record1,record2,record3)).toString();
        return SqlUtils.leftJoin(t,e,k).toString();
    }

    public <T extends BaseEntity, E extends BaseEntity,K extends BaseEntity> String left3JoinWithSqlCondition(Class<T> t, Class<E> e,Class<K> k,String sql){
        return SqlUtils.leftJoin(t,e,k).append(" where 1=1 ").append(sql).toString();
    }

    public <T extends BaseEntity, E extends BaseEntity,K extends BaseEntity> String left3JoinWithBeanAndSqlCondition(Class<T> t, Class<E> e,Class<K> k, T record1, E record2, K record3,String sql){
        if(record1 !=null || record2 != null || record3 != null)
            return SqlUtils.leftJoin(t,e,k).append(SqlUtils.condition(record1,record2,record3)).append(SqlUtils.condition(sql)).toString();
        return SqlUtils.leftJoin(t,e,k).append(" where 1=1 ").append(sql).toString();
    }


}
