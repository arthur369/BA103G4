package com.fo_act_modal;

import java.util.List;

import com.gift_data_modal.GIFT_DATA_VO;

public interface FO_ACT_DAO_interface {
	 public void insert(FO_ACT_VO fo_act_VO);
     public void update(FO_ACT_VO fo_act_VO);
     public void delete(String MEM_AC,String ACT_NO);
     public FO_ACT_VO findByPrimaryKey(String MEM_AC,String ACT_NO);
     public List<FO_ACT_VO> getAll();
}
