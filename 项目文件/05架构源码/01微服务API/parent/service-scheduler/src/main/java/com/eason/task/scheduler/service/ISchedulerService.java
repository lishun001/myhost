package com.eason.task.scheduler.service;


public interface ISchedulerService {
	public void addJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception;
	public void jobPause(String jobClassName, String jobGroupName) throws Exception ;
	public void jobresume(String jobClassName, String jobGroupName) throws Exception;
	public void jobreschedule(String jobClassName, String jobGroupName, String cronExpression) throws Exception;
	public void jobdelete(String jobClassName, String jobGroupName) throws Exception;
}
