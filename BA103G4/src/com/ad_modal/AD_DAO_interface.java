package com.ad_modal;

import java.util.List;



public interface AD_DAO_interface {
	 public void insert(AD_VO ad_VO);
     public void update(AD_VO ad_VO);
     public void delete(String AD_NO);
     public AD_VO findByPrimaryKey(String AD_NO);
     public List<AD_VO> getAll();
}
