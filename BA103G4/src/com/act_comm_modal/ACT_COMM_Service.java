package com.act_comm_modal;

import java.util.List;
import java.util.Set;





public class ACT_COMM_Service {

	private ACT_COMM_DAO_interface dao;
	
	public ACT_COMM_Service(){
		dao=new ACT_COMMJNDIDAO();
	}
	
	public ACT_COMM_VO addAct_comm(String comm_no, String act_no, String mem_ac,
		String	comm_cont,java.sql.Date comm_date, String comm_reply_cont,java.sql.Date comm_reply_date) {

		ACT_COMM_VO act_comm_VO = new ACT_COMM_VO();

		act_comm_VO.setCOMM_NO(comm_no);
		act_comm_VO.setACT_NO(act_no);
		act_comm_VO.setMEM_AC(mem_ac);
		act_comm_VO.setCOMM_CONT(comm_cont);
		act_comm_VO.setCOMM_DATE(comm_date);
		act_comm_VO.setCOMM_REPLY_CONT(comm_reply_cont);
		act_comm_VO.setCOMM_REPLY_DATE(comm_reply_date);
		dao.insert(act_comm_VO);

		return act_comm_VO;
	}
	public ACT_COMM_VO updateAct_comm(String comm_no, String act_no, String mem_ac,
			String	comm_cont,java.sql.Date comm_date, String comm_reply_cont,java.sql.Date comm_reply_date) {
		ACT_COMM_VO act_comm_VO = new ACT_COMM_VO();
		act_comm_VO.setCOMM_NO(comm_no);
		act_comm_VO.setACT_NO(act_no);
		act_comm_VO.setMEM_AC(mem_ac);
		act_comm_VO.setCOMM_CONT(comm_cont);
		act_comm_VO.setCOMM_DATE(comm_date);
		act_comm_VO.setCOMM_REPLY_CONT(comm_reply_cont);
		act_comm_VO.setCOMM_REPLY_DATE(comm_reply_date);
		dao.update(act_comm_VO);

		return act_comm_VO;
	}

	public void deleteAct_comm(String comm_no) {
		dao.delete(comm_no);
	}

	public ACT_COMM_VO getOneAct_comm(String comm_no) {
		return dao.findByPrimaryKey(comm_no);
	}

	public List<ACT_COMM_VO> getAll() {
		return dao.getAll();
	}
	
	
	
	
}
