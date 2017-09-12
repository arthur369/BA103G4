package com.gift_data_modal;

import java.sql.Date;
import java.util.List;

public class GIFT_DATA_Service {
 private GIFT_DATA_DAO_interface dao;
 
 public GIFT_DATA_Service(){
	 dao=new GIFT_DATAJNDIDAO();
 }
 public GIFT_DATA_VO addGift_data(String gift_name,int gift_remain,String gift_cont,byte[] gift_img,int gift_pt,Date gift_launch_date){
	 GIFT_DATA_VO gift_data_vo=new GIFT_DATA_VO();
//	 gift_data_vo.setGIFT_NO(gift_no);
	 gift_data_vo.setGIFT_NAME(gift_name);
	 gift_data_vo.setGIFT_REMAIN(gift_remain);
	 gift_data_vo.setGIFT_CONT(gift_cont);
	 gift_data_vo.setGIFT_IMG(gift_img);
	 gift_data_vo.setGIFT_PT(gift_pt);
	 gift_data_vo.setGIFT_LAUNCH_DATE(gift_launch_date);
	 dao.insert(gift_data_vo);
	 return gift_data_vo;
	 
 }
 public GIFT_DATA_VO updateGift_data(String gift_no,String gift_name,int gift_remain,String gift_cont,byte[] gift_img,int gift_pt,Date gift_launch_date){
	 GIFT_DATA_VO gift_data_vo=new GIFT_DATA_VO();
	 gift_data_vo.setGIFT_NO(gift_no);
	 gift_data_vo.setGIFT_NAME(gift_name);
	 gift_data_vo.setGIFT_REMAIN(gift_remain);
	 gift_data_vo.setGIFT_CONT(gift_cont);
	 gift_data_vo.setGIFT_IMG(gift_img);
	 gift_data_vo.setGIFT_PT(gift_pt);
	 gift_data_vo.setGIFT_LAUNCH_DATE(gift_launch_date);
	 dao.update(gift_data_vo);
	 return gift_data_vo;
	 
 }
 public void deleteGift_data(String gift_no){
	 dao.delete(gift_no);
 }
 public GIFT_DATA_VO getOneGift_data(String gift_no){
	 return dao.findByPrimaryKey(gift_no);
 }
 public List<GIFT_DATA_VO>getAll(){
	 return dao.getAll();
 }
 
 
}
