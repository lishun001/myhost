package com.jiuwu.openoo.dao.mapper.kamailio.method;



import java.util.List;

import model.ApiMethod.OoApiMethodCfgModel;



/**
 * OoApiMethodCfgDAO接口
 *
 * @author admin
 */
public interface OoApiMethodCfgMapper{

	//------------------请在此添加自定义方法（开始）------------------
	//------------------请在此添加自定义方法（结束）------------------

    /**
	 * Description:根据主键id来获取对象OoApiMethodCfgModel
     * @author admin
     *
     * @param id
     * @return 对象OoApiMethodCfg
	 * @Create Date: 2014-9-10
	 */
    public OoApiMethodCfgModel getObjectById(Integer id);

    /**
	 * Description:根据Model来获取对象OoApiMethodCfgModel
     * @author admin
     *
     * @param 对象OoApiMethodCfg
     * @return 对象OoApiMethodCfg
	 * @Create Date: 2014-9-10
	 */
    public OoApiMethodCfgModel getObjectByModel(OoApiMethodCfgModel obj);

    /**
	 * Description:根据Model来获取对象OoApiMethodCfgModel
     * @author admin
     *
     * @param OoApiMethodCfgModel
     * @return List<OoApiMethodCfgModel>
	 * @Create Date: 2014-9-10
	 */
    public List<OoApiMethodCfgModel> getListByModel(OoApiMethodCfgModel obj);
    
	/**
	 * Description:新增对象OoApiMethodCfgModel
     * @author admin
     *
     * @param OoApiMethodCfgModel
     * @return Integer
	 * @Create Date: 2014-9-10
	 */
    public int insertModel(OoApiMethodCfgModel obj);
    /**
	 * Description:新增对象OoApiMethodCfgModel
     * @author admin
     *
     * @param OoApiMethodCfgModel
     * @return Integer
	 * @Create Date: 2014-9-10
	 */
    public int addModel(OoApiMethodCfgModel obj);
    
	/**
	 * Description:根据ID更新对象OoApiMethodCfgModel
	 *        只更新不为空的字段
     * @author admin
     *
	 * @param OoApiMethodCfgModel
	 * @return 返回更新的记录条数
	 * @Create Date: 2014-9-10
	 */
	public int updateModelById(OoApiMethodCfgModel obj);
    
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
