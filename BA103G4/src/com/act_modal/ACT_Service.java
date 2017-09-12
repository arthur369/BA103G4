package com.act_modal;

import java.sql.Date;
import java.util.List;

import com.act_comm_modal.ACT_COMM_VO;

public class ACT_Service {

	private ACT_DAO_interface dao;
	
	public ACT_Service(){
		dao= new ACT_JNDIDAO();
	}
	
	public ACT_VO addAct(String act_no,String mem_ac,String org_cont,String act_name, int min_mem,int max_mem,int mem_count,Date act_op_date,Date act_ed_date,Date dl_date,Date fd_date,String act_add,String act_add_lat,String act_add_lon,String act_cont,String act_tag,int act_fee,String pay_way,byte[] act_pic1,byte[] act_pic2,byte[] act_pic3,String act_stat,String re_cont,Date review_ed_date){
		
		
		ACT_VO act_VO=new ACT_VO();
		act_VO.setACT_NO(act_no);
		act_VO.setMEM_AC(mem_ac);
		act_VO.setORG_CONT(org_cont);
		act_VO.setACT_NAME(act_name);
		act_VO.setMIN_MEM(min_mem);
		act_VO.setMAX_MEM(max_mem);
		act_VO.setMEM_COUNT(mem_count);
		act_VO.setACT_OP_DATE(act_op_date);
		act_VO.setACT_ED_DATE(act_ed_date);
		act_VO.setDL_DATE(dl_date);
		act_VO.setFD_DATE(fd_date);
		act_VO.setACT_ADD(act_add);
		act_VO.setACT_ADD_LAT(act_add_lat);
		act_VO.setACT_ADD_LON(act_add_lon);
		act_VO.setACT_CONT(act_cont);
		act_VO.setACT_TAG(act_tag);
		act_VO.setACT_FEE(act_fee);
		act_VO.setPAY_WAY(pay_way);
		act_VO.setACT_PIC1(act_pic1);
		act_VO.setACT_PIC2(act_pic2);
		act_VO.setACT_PIC3(act_pic3);
		act_VO.setACT_STAT(act_stat);
		act_VO.setRE_CONT(re_cont);
		act_VO.setREVIEW_ED_DATE(review_ed_date);
		
		dao.insert(act_VO);
		return act_VO;
	}
	
public ACT_VO updateAct(String act_no,String mem_ac,String org_cont,String act_name, int min_mem,int max_mem,int mem_count,Date act_op_date,Date act_ed_date,Date dl_date,Date fd_date,String act_add,String act_add_lat,String act_add_lon,String act_cont,String act_tag,int act_fee,String pay_way,byte[] act_pic1,byte[] act_pic2,byte[] act_pic3,String act_stat,String re_cont,Date review_ed_date){
		
		ACT_VO act_VO=new ACT_VO();
		act_VO.setACT_NO(act_no);
		act_VO.setMEM_AC(mem_ac);
		act_VO.setORG_CONT(org_cont);
		act_VO.setACT_NAME(act_name);
		act_VO.setMIN_MEM(min_mem);
		act_VO.setMAX_MEM(max_mem);
		act_VO.setMEM_COUNT(mem_count);
		act_VO.setACT_OP_DATE(act_op_date);
		act_VO.setACT_ED_DATE(act_ed_date);
		act_VO.setDL_DATE(dl_date);
		act_VO.setFD_DATE(fd_date);
		act_VO.setACT_ADD(act_add);
		act_VO.setACT_ADD_LAT(act_add_lat);
		act_VO.setACT_ADD_LON(act_add_lon);
		act_VO.setACT_CONT(act_cont);
		act_VO.setACT_TAG(act_tag);
		act_VO.setACT_FEE(act_fee);
		act_VO.setPAY_WAY(pay_way);
		act_VO.setACT_PIC1(act_pic1);
		act_VO.setACT_PIC2(act_pic2);
		act_VO.setACT_PIC3(act_pic3);
		act_VO.setACT_STAT(act_stat);
		act_VO.setRE_CONT(re_cont);
		act_VO.setREVIEW_ED_DATE(review_ed_date);
		
		dao.update(act_VO);
		return act_VO;
	}
	
public void deleteAct(String act_no){
	dao.delete(act_no);
}

public ACT_VO getOneAct(String act_no) {
	return dao.findByPrimaryKey(act_no);
}

public List<ACT_VO> getAll() {
	return dao.getAll();
}


}
