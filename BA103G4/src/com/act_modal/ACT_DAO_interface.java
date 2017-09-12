package com.act_modal;

import java.util.List;



public interface ACT_DAO_interface {
	 public void insert(ACT_VO act_VO);
     public void update(ACT_VO act_VO);
     public void delete(String ACT_NO);
     public ACT_VO findByPrimaryKey(String ACT_NO);
     public List<ACT_VO> getAll();
}
