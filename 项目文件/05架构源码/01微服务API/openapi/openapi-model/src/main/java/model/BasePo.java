package model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BasePo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3324113989309576313L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
