package com.jiuwu.openoo.dao.mapper.kamailio.method;



import java.util.List;

import model.ApiMethod.AppInfo;
import model.ApiMethod.OoAppInfoModel;

/**
 * OoAppInfoDAO接口
 *
 * @author admin
 */
public interface OoAppInfoMapper{

	//------------------请在此添加自定义方法（开始）------------------
	
	public List<AppInfo> getAppinfoList();
	
	//------------------请在此添加自定义方法（结束）------------------

    /**
	 * Description:根据主键id来获取对象OoAppInfoModel
     * @author admin
     *
     * @param id
     * @return 对象OoAppInfo
	 * @Create Date: 2014-9-10
	 */
    public OoAppInfoModel getObjectById(Integer id);

    /**
	 * Description:根据Model来获取对象OoAppInfoModel
     * @author admin
     *
     * @param 对象OoAppInfo
     * @return 对象OoAppInfo
	 * @Create Date: 2014-9-10
	 */
    public OoAppInfoModel getObjectByModel(OoAppInfoModel obj);

    /**
	 * Description:根据Model来获取对象OoAppInfoModel
     * @author admin
     *
     * @param OoAppInfoModel
     * @return List<OoAppInfoModel>
	 * @Create Date: 2014-9-10
	 */
    public List<OoAppInfoModel> getListByModel(OoAppInfoModel obj);
    
	/**
	 * Description:新增对象OoAppInfoModel
     * @author admin
     *
     * @param OoAppInfoModel
     * @return Integer
	 * @Create Date: 2014-9-10
	 */
    public int insertModel(OoAppInfoModel obj);
    
	/**
	 * Description:根据ID更新对象OoAppInfoModel
	 *        只更新不为空的字段
     * @author admin
     *
	 * @param OoAppInfoModel
	 * @return 返回更新的记录条数
	 * @Create Date: 2014-9-10
	 */
	public int updateModelById(OoAppInfoModel obj);
    
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
