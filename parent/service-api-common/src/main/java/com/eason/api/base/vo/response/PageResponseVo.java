package com.eason.api.base.vo.response;

import java.util.List;

/**
 * 分页VO
 */
public class PageResponseVo<T>  {
    /**
     *
     */
    private static final long serialVersionUID = 5978972533503756942L;

    /** 总数*/
    private Integer total;

    private List<T> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
