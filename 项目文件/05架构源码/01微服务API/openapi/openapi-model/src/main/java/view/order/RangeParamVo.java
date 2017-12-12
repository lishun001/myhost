package view.order;

import java.io.Serializable;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("rangeParamVo")
public class RangeParamVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1596681561740052926L;
	private String rangeParamId;	//范围配送参数
	private Integer distanceMin;
    private Integer distanceMax;
	private Integer distance;		//距离
	private Integer cargoNum;		//货物数量
	private Integer rangeMin;		//范围最低值
	private Integer rangeMax;		//范围最高值
	private Double  rangeCharge;	//距离费用
	private Date createTime;
    private Date updateTime;
    private String createBy;
    private String updateBy;
    
	public String getRangeParamId() {
		return rangeParamId;
	}
	public void setRangeParamId(String rangeParamId) {
		this.rangeParamId = rangeParamId;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Integer getRangeMin() {
		return rangeMin;
	}
	public void setRangeMin(Integer rangeMin) {
		this.rangeMin = rangeMin;
	}
	public Integer getRangeMax() {
		return rangeMax;
	}
	public void setRangeMax(Integer rangeMax) {
		this.rangeMax = rangeMax;
	}
	public Double getRangeCharge() {
		return rangeCharge;
	}
	public void setRangeCharge(Double rangeCharge) {
		this.rangeCharge = rangeCharge;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Integer getCargoNum() {
		return cargoNum;
	}
	public void setCargoNum(Integer cargoNum) {
		this.cargoNum = cargoNum;
	}
	public Integer getDistanceMin() {
		return distanceMin;
	}
	public void setDistanceMin(Integer distanceMin) {
		this.distanceMin = distanceMin;
	}
	public Integer getDistanceMax() {
		return distanceMax;
	}
	public void setDistanceMax(Integer distanceMax) {
		this.distanceMax = distanceMax;
	}
	
    
}
