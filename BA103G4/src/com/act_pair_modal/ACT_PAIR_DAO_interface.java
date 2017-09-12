package com.act_pair_modal;

import java.util.List;



public interface ACT_PAIR_DAO_interface {
	 public void insert(ACT_PAIR_VO act_pair_VO);
     public void update(ACT_PAIR_VO act_pair_VO);
     public void delete(String ACT_NO,String MEM_AC);
     public ACT_PAIR_VO findByPrimaryKey(String ACT_NO,String MEM_AC);
     public List<ACT_PAIR_VO> getAll();
     
}
