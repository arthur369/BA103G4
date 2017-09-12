package com.convert_gift_modal;

import java.util.List;



public interface CONVERT_GIFT_DAO_interface {
	 public void insert(CONVERT_GIFT_VO convert_gift_VO);
     public void update(CONVERT_GIFT_VO convert_gift_VO);
     public void delete(String APPLY_NO);
     public CONVERT_GIFT_VO findByPrimaryKey(String APPLY_NO);
     public List<CONVERT_GIFT_VO> getAll();
     
}
