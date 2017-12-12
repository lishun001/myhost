package com.jiuwu.openoo.dao.mapper.kamailio.method;



import java.util.List;

import model.ApiMethod.OoApiMethodModel;


/**
 * OoApiMethodDAO接口
 *
 * @author admin
 */
public interface OoApiMethodMapper{

	//------------------请在此添加自定义方法（开始）------------------
	
	public List<OoApiMethodModel> getApiMethodInfoList();
	
	//------------------请在此添加自定义方法（结束）------------------

    /**
	 * Description:根据主键id来获取对象OoApiMethodModel
     * @author admin
     *
     * @param id
     * @return 对象OoApiMethod
	 * @Create Date: 2014-9-10
	 */
    public OoApiMethodModel getObjectById(Integer id);

    /**
	 * Description:根据Model来获取对象OoApiMethodModel
     * @author admin
     *
     * @param 对象OoApiMethod
     * @return 对象OoApiMethod
	 * @Create Date: 2014-9-10
	 */
    public OoApiMethodModel getObjectByModel(OoApiMethodModel obj);

    /**
	 * Description:根据Model来获取对象OoApiMethodModel
     * @author admin
     *
     * @param OoApiMethodModel
     * @return List<OoApiMethodModel>
	 * @Create Date: 2014-9-10
	 */
    public List<OoApiMethodModel> getListByModel(OoApiMethodModel obj);
    
	/**
	 * Description:新增对象OoApiMethodModel
     * @author admin
     *
     * @param OoApiMethodModel
     * @return Integer
	 * @Create Date: 2014-9-10
	 */
    public int insertModel(OoApiMethodModel obj);
	/**
	 * Description:新增对象OoApiMethodModel
     * @author admin
     *
     * @param OoApiMethodModel
     * @return Integer
	 * @Create Date: 2014-9-10
	 */
    public int addModel(OoApiMethodModel obj);
	/**
	 * Description:根据ID更新对象OoApiMethodModel
	 *        只更新不为空的字段
     * @author admin
     *
	 * @param OoApiMethodModel
	 * @return 返回更新的记录条数
	 * @Create Date: 2014-9-10
	 */
	public int updateModelById(OoApiMethodModel obj);
    
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
