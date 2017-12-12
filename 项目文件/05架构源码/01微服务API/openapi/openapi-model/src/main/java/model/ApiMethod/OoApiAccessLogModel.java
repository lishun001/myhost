package model.ApiMethod;



import java.util.Date;
import java.io.Serializable;



/**
 * OoApiAccessLog对象定义
 * 
 * 工具自动生成代码
 * 
 * @author Admin
 *
 */
public class OoApiAccessLogModel implements Serializable {

    /** uid */
	private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Integer	id;
    /**  */
    private Integer	userId;
    /** 方法名称 */
    private String	invokeMethod;
    /** 方法版本号 */
    private String	methodVer;
    /** 返回值类型（1：正常、2：异常：3：参数错误） */
    private Integer	resultType;
    /** 返回错误编码 */
    private String	resultCode;
    /** 返回错误消息 */
    private String	resultMsg;
    /** 返回异常消息 */
    private String 	exception;
    /** 设备厂商 */
    private String	deviceManufacturer;
    /** 设备型号 */
    private String	deviceModel;
    /** 系统版本号 */
    private String	systemVer;
    /** app版本号 */
    private String	appVer;
    /** 调用接口时间 */
    private Date	visitDate;
    /** 调用接口的IP */
    private String	ip;
    /** 调用接口的参数 */
    private String	invokeParam;
    /** 接口响应时间 */
    private Integer	visitTimeCost;
	
    //===============附加字段===================
    /** 调用接口时间 */
    private Date	fromDate;
    /** 调用接口时间 */
    private Date	toDate;
    /** 分区名称 */
    private String	partitionName;
    /** 分区值 */
    private String	partitionValue;
    
	/** 开始时间 */
    private Date beginTime;
    /** 结束时间*/
    private Date endTime;
	/** 分页对象 */
    private Page<OoApiAccessLogModel> page;
	/**手机号  */
    private String phone;
    /** 圈圈号 */
    private String ooNum;
	
	/** 取得主键ID */
	public Integer getId() {
		return id;
	}
	
	/** 设置主键ID */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 取得 */
	public Integer getUserId() {
		return userId;
	}
	
	/** 设置 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/** 取得方法名称 */
	public String getInvokeMethod() {
		return invokeMethod;
	}
	
	/** 设置方法名称 */
	public void setInvokeMethod(String invokeMethod) {
		this.invokeMethod = invokeMethod;
	}
	/** 取得方法版本号 */
	public String getMethodVer() {
		return methodVer;
	}
	
	/** 设置方法版本号 */
	public void setMethodVer(String methodVer) {
		this.methodVer = methodVer;
	}
	/** 取得返回值类型（1：正常、2：异常：3：参数错误） */
	public Integer getResultType() {
		return resultType;
	}
	
	/** 设置返回值类型（1：正常、2：异常：3：参数错误） */
	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}
	/** 取得返回错误编码 */
	public String getResultCode() {
		return resultCode;
	}
	
	/** 设置返回错误编码 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/** 取得设备厂商 */
	public String getDeviceManufacturer() {
		return deviceManufacturer;
	}
	
	/** 设置设备厂商 */
	public void setDeviceManufacturer(String deviceManufacturer) {
		this.deviceManufacturer = deviceManufacturer;
	}
	/** 取得设备型号 */
	public String getDeviceModel() {
		return deviceModel;
	}
	
	/** 设置设备型号 */
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	/** 取得系统版本号 */
	public String getSystemVer() {
		return systemVer;
	}
	
	/** 设置系统版本号 */
	public void setSystemVer(String systemVer) {
		this.systemVer = systemVer;
	}
	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	/** 取得app版本号 */
	public String getAppVer() {
		return appVer;
	}
	
	/** 设置app版本号 */
	public void setAppVer(String appVer) {
		this.appVer = appVer;
	}
	/** 取得调用接口时间 */
	public Date getVisitDate() {
		return visitDate;
	}
	
	/** 设置调用接口时间 */
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	/** 取得调用接口的IP */
	public String getIp() {
		return ip;
	}
	
	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}

	public String getPartitionValue() {
		return partitionValue;
	}

	public void setPartitionValue(String partitionValue) {
		this.partitionValue = partitionValue;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/** 设置调用接口的IP */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/** 取得调用接口的参数 */
	public String getInvokeParam() {
		return invokeParam;
	}
	
	/** 设置调用接口的参数 */
	public void setInvokeParam(String invokeParam) {
		this.invokeParam = invokeParam;
	}
	/** 取得接口响应时间 */
	public Integer getVisitTimeCost() {
		return visitTimeCost;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Page<OoApiAccessLogModel> getPage() {
		return page;
	}

	public void setPage(Page<OoApiAccessLogModel> page) {
		this.page = page;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOoNum() {
		return ooNum;
	}

	public void setOoNum(String ooNum) {
		this.ooNum = ooNum;
	}

	/** 设置接口响应时间 */
	public void setVisitTimeCost(Integer visitTimeCost) {
		this.visitTimeCost = visitTimeCost;
	}


}
