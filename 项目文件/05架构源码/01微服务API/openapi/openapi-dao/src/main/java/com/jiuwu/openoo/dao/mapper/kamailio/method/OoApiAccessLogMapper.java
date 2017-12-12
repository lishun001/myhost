package com.jiuwu.openoo.dao.mapper.kamailio.method;



import java.util.List;
import java.util.Map;

import model.ApiMethod.OoApiAccessLogModel;


/**
 * OoApiAccessLogDAO接口
 *
 * @author admin
 */
public interface OoApiAccessLogMapper{

	/**
	 * Description:新增表分区
	 * @param OoApiAccessLogModel
	 * @author SamFan
	 * @return int
	 * @Create Date: 2014-11-13
	 */
	public int addPartition(OoApiAccessLogModel obj);
	
	public List<OoApiAccessLogModel> getApiLogPage(Map<String,Object>map);
	
	public int getCountByCiteria(Map<String,Object>map);
	
	
	/**
	 * Description:删除表分区
	 * @param OoApiAccessLogModel
	 * @author SamFan
	 * @return int
	 * @Create Date: 2014-11-13
	 */
	public int deletePartition(OoApiAccessLogModel obj);
	
	//------------------请在此添加自定义方法（结束）------------------

    /**
	 * Description:根据主键id来获取对象OoApiAccessLogModel
     * @author admin
     *
     * @param id
     * @return 对象OoApiAccessLog
	 * @Create Date: 2014-9-10
	 */
    public OoApiAccessLogModel getObjectById(Integer id);

    /**
	 * Description:根据Model来获取对象OoApiAccessLogModel
     * @author admin
     *
     * @param 对象OoApiAccessLog
     * @return 对象OoApiAccessLog
	 * @Create Date: 2014-9-10
	 */
    public OoApiAccessLogModel getObjectByModel(OoApiAccessLogModel obj);

    /**
	 * Description:根据Model来获取对象OoApiAccessLogModel
     * @author admin
     *
     * @param OoApiAccessLogModel
     * @return List<OoApiAccessLogModel>
	 * @Create Date: 2014-9-10
	 */
    public List<OoApiAccessLogModel> getListByModel(OoApiAccessLogModel obj);
    
	/**
	 * Description:新增对象OoApiAccessLogModel
     * @author admin
     *
     * @param OoApiAccessLogModel
     * @return Integer
	 * @Create Date: 2014-9-10
	 */
    public Integer insertModel(OoApiAccessLogModel obj);
    
	/**
	 * Description:根据ID更新对象OoApiAccessLogModel
	 *        只更新不为空的字段
     * @author admin
     *
	 * @param OoApiAccessLogModel
	 * @return 返回更新的记录条数
	 * @Create Date: 2014-9-10
	 */
	public int updateModelById(OoApiAccessLogModel obj);
    
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
