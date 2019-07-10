package com.jyx.edu.NewMapper180831.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyx.edu.NewMapper180831.basemapper.BaseMapper;
import com.jyx.edu.NewMapper180831.entity.BaseEntity;
import com.jyx.edu.NewMapper180831.entity.SysUser;
import com.jyx.edu.NewMapper180831.pojo.EasyUIResult;
import com.jyx.edu.NewMapper180831.pojo.PageTree;
import com.jyx.edu.NewMapper180831.pojo.QueryInfo;
import com.jyx.edu.NewMapper180831.service.BaseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public int insert(T record, SysUser operator) {
        setBaseEntityInsert(record, operator);
        return baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record, SysUser operator) {
        setBaseEntityInsert(record, operator);
        return baseMapper.insertSelective(record);
    }

    @Override
    public int insertUseGeneratedKeys(T record, SysUser operator) {
        setBaseEntityInsert(record, operator);
        return baseMapper.insertUseGeneratedKeys(record);
    }

    @Override
    public int insertList(List<T> recordList, SysUser operator) {
        recordList.forEach(record -> setBaseEntityInsert(record, operator));
        return baseMapper.insertList(recordList);
    }

    @Override
    public int updateByPrimaryKey(T record, SysUser operator) {
        setBaseEntityUpdate(record, operator);
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record, SysUser operator) {
        setBaseEntityUpdate(record, operator);
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByExample(T record, Object example, SysUser operator) {
        setBaseEntityUpdate(record, operator);
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(T record, Object example, SysUser operator) {
        // setBaseEntityUpdate(record,operator);
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int delete(T record) {
        return baseMapper.delete(record);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return baseMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int deleteByExample(Object example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByIds(String ids) {
        return baseMapper.deleteByIds(ids);
    }

    @Override
    public List<T> select(T record) {
        return baseMapper.select(record);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return baseMapper.selectByExample(example);
    }


    @Override
    public T selectByPrimaryKey(Object key) {
        return baseMapper.selectByPrimaryKey(key);
    }

    @Override
    public T selectOne(T record) {
        return baseMapper.selectOne(record);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public List<T> selectByIds(String ids) {
        return baseMapper.selectByIds(ids);
    }

    @Override
    public int selectCount(T record) {
        return baseMapper.selectCount(record);
    }

    @Override
    public int selectCountByExample(Object example) {
        return baseMapper.selectCountByExample(example);
    }

    @Override
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return baseMapper.selectByRowBounds(record, rowBounds);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return baseMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    /**
     * 通用分页查询
     *
     * @param queryInfo:int page,int rows
     * @return
     */
    @Override
    public EasyUIResult queryListPage(QueryInfo queryInfo, Example example) {
        PageHelper.startPage(queryInfo.getPage(), queryInfo.getRows());
        List<T> t = baseMapper.selectByExample(example);
        // 获取分页之后的信息
        PageInfo<T> pageInfo = new PageInfo<T>(t);
        return new EasyUIResult(pageInfo.getTotal(), t);
    }

    //#######################################树查询相关方法############################################################//
    @Override
    public List<PageTree> getAllTree(Class<T> t) {
        List<PageTree> pageTrees = baseMapper.getAllTree(t);
        setTree(t, pageTrees);
        return pageTrees;
    }


    @Override
    public List<PageTree> getRootNode(Class<T> t) {
        List<PageTree> pageTrees = baseMapper.getAllTree(t);
        return pageTrees;
    }

    @Override
    public List<PageTree> getChildrens(Class<T> t, Object parentId) {
        return baseMapper.getByParentId(t, parentId);
    }

    @Override
    public List<PageTree> getAllChildrens(Class<T> t, Object parentId) {
        List<PageTree> pageTrees = baseMapper.getByParentId(t, parentId);
        setTree(t, pageTrees);
        return pageTrees;
    }

    /**
     * 获取到下下级子节点，供异步加载时使用，告诉系统此节点是否能展开
     *
     * @param t
     * @param
     * @returnp
     */
    @Override
    public List<PageTree> getChildrensChildrens(Class<T> t, PageTree pageTree) {
        List<PageTree> childrens = pageTree.getChildren();
        if (childrens == null) {
            childrens = baseMapper.getByParentId(t, pageTree.getId());
            // pageTree.setChildren(childrens);   //最终不是返回pageTree，无需set
        }
        for (PageTree p : childrens) {
            List<PageTree> childrensChildren = baseMapper.getByParentId(t, p.getId());
            p.setChildren(childrensChildren);
        }
        return childrens;
    }

    //###############################################################################################################//

    /**
     * 递归pageTrees下 所有子节点
     */
    public void setTree(Class<T> t, List<PageTree> pageTrees) {
        for (PageTree pageTree : pageTrees) {
            List<PageTree> childrens = baseMapper.getByParentId(t, pageTree.getId());
            pageTree.setChildren(childrens);
            setTree(t, childrens);
        }
    }


    /**
     * 附带插入基础数据
     */
    public void setBaseEntityInsert(T record, SysUser operator) {
        Date date = new Date();
        record.setCreatePerson(operator.getUsername());
        record.setCreateTime(date);
        record.setUpdatePerson("");
        record.setUpdateTime(date);
    }

    /**
     * 附带更新基础数据
     */
    public void setBaseEntityUpdate(T record, SysUser operator) {
        Date date = new Date();
        record.setUpdateTime(date);
        record.setUpdatePerson(operator.getUsername());
    }

    //####################################################mybatis 结束########################################################//

   /* public T save(T t, SysUser operator) {//addOrUadate
        setBaseEntityInsert(t, operator);
        return reposirory.save(t);
    }

    public void remove(Object id) {
         reposirory.deleteById(id);
    }

    public void remove(T t) {
        reposirory.delete(t);
    }*/



}
