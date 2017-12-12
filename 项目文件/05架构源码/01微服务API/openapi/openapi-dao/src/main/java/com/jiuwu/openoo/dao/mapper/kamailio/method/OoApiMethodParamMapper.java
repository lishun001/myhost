package com.jiuwu.openoo.dao.mapper.kamailio.method;



import java.util.List;

import model.ApiMethod.OoApiMethodParamModel;


/**
 * OoApiMethodParamDAO接口
 *
 * @author admin
 */
public interface OoApiMethodParamMapper{

	//------------------请在此添加自定义方法（开始）------------------
	/**
	 * Description:删除所有对象
	 * @author admin
	 *
	 * @param id
	 * @return 返回删除的记录条数
	 * @Create Date: 2014-9-10
	 */
	public int deleteAll();
	//------------------请在此添加自定义方法（结束）------------------

    /**
	 * Description:根据主键id来获取对象OoApiMethodParamModel
     * @author admin
     *
     * @param id
     * @return 对象OoApiMethodParam
	 * @Create Date: 2014-9-10
	 */
    public OoApiMethodParamModel getObjectById(Integer id);

    /**
	 * Description:根据Model来获取对象OoApiMethodParamModel
     * @author admin
     *
     * @param 对象OoApiMethodParam
     * @return 对象OoApiMethodParam
	 * @Create Date: 2014-9-10
	 */
    public OoApiMethodParamModel getObjectByModel(OoApiMethodParamModel obj);

    /**
	 * Description:根据Model来获取对象OoApiMethodParamModel
     * @author admin
     *
     * @param OoApiMethodParamModel
     * @return List<OoApiMethodParamModel>
	 * @Create Date: 2014-9-10
	 */
    public List<OoApiMethodParamModel> getListByModel(OoApiMethodParamModel obj);
    
	/**
	 * Description:新增对象OoApiMethodParamModel
     * @author admin
     *
     * @param OoApiMethodParamModel
     * @return Integer
	 * @Create Date: 2014-9-10
	 */
    public int insertModel(OoApiMethodParamModel obj);
    
	/**
	 * Description:根据ID更新对象OoApiMethodParamModel
	 *        只更新不为空的字段
     * @author admin
     *
	 * @param OoApiMethodParamModel
	 * @return 返回更新的记录条数
	 * @Create Date: 2014-9-10
	 */
	public int updateModelById(OoApiMethodParamModel obj);
    
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
