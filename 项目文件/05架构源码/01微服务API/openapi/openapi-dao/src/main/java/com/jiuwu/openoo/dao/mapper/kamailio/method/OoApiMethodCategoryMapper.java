package com.jiuwu.openoo.dao.mapper.kamailio.method;

import java.util.List;

import model.ApiMethod.OoApiMethodCategoryModel;



/**
 * OoApiMethodCategoryDAO接口
 *
 * @author admin
 */
public interface OoApiMethodCategoryMapper{

	//------------------请在此添加自定义方法（开始）------------------
	//------------------请在此添加自定义方法（结束）------------------

    /**
	 * Description:根据主键id来获取对象OoApiMethodCategoryModel
     * @author admin
     *
     * @param id
     * @return 对象OoApiMethodCategory
	 * @Create Date: 2014-9-10
	 */
    public OoApiMethodCategoryModel getObjectById(Integer id);

    /**
	 * Description:根据Model来获取对象OoApiMethodCategoryModel
     * @author admin
     *
     * @param 对象OoApiMethodCategory
     * @return 对象OoApiMethodCategory
	 * @Create Date: 2014-9-10
	 */
    public OoApiMethodCategoryModel getObjectByModel(OoApiMethodCategoryModel obj);

    /**
	 * Description:根据Model来获取对象OoApiMethodCategoryModel
     * @author admin
     *
     * @param OoApiMethodCategoryModel
     * @return List<OoApiMethodCategoryModel>
	 * @Create Date: 2014-9-10
	 */
    public List<OoApiMethodCategoryModel> getListByModel(OoApiMethodCategoryModel obj);
    
	/**
	 * Description:新增对象OoApiMethodCategoryModel
     * @author admin
     *
     * @param OoApiMethodCategoryModel
     * @return Integer
	 * @Create Date: 2014-9-10
	 */
    public int insertModel(OoApiMethodCategoryModel obj);
    
	/**
	 * Description:根据ID更新对象OoApiMethodCategoryModel
	 *        只更新不为空的字段
     * @author admin
     *
	 * @param OoApiMethodCategoryModel
	 * @return 返回更新的记录条数
	 * @Create Date: 2014-9-10
	 */
	public int updateModelById(OoApiMethodCategoryModel obj);
    
	/**
	 * Description:删除对象
     * @author admin
     *
	 * @param id
	 * @return 返回删除的记录条数
	 * @Create Date: 2014-9-10
	 */
	public int deleteById(Integer id);
    
}
