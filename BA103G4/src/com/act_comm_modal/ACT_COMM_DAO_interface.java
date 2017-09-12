package com.act_comm_modal;

import java.util.List;



public interface ACT_COMM_DAO_interface {
	 public void insert( ACT_COMM_VO act_comm_VO);
     public void update( ACT_COMM_VO act_comm_VO);
     public void delete(String COMM_NO);
     public  ACT_COMM_VO findByPrimaryKey(String COMM_NO);
     public List< ACT_COMM_VO> getAll();
	
	
	
}
