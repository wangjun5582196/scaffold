package com.business.program.cross.border.trade.common.page;

import lombok.Data;

import java.io.Serializable;


@Data
public class PageQueryDTO implements Serializable {

  private static final Long DEFAULT_PAGE_SIZE = 20L;
  private static final Long PAGE = 1L;

  /**
   * 当前页面
   */
  private Long page = PAGE;
  /**
   *  默认分页大小
   */
  private Long size = DEFAULT_PAGE_SIZE;
}
