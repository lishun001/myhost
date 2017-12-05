package com.eason.task.scheduler.service;


import com.eason.task.scheduler.entity.JobAndTrigger;
import com.github.pagehelper.PageInfo;

public interface IJobAndTriggerService {
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}
