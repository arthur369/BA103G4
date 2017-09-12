package com.act_comm_modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ACT_COMMJNDIDAO implements ACT_COMM_DAO_interface{
	private static DataSource ds=null;
	static{
		Context ctx;
		try {
			ctx = new InitialContext();
			
			ds=(DataSource) ctx.lookup("java:comp/env/jdbc/TestDB3");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static final String INSERT_STMT ="insert into act_comm values('C' ||  comm_no_seq.nextval,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from act_comm";
	private static final String GET_ONE_STMT="select * from act_comm where COMM_NO=?";
	private static final String DELETE = "delete from act_comm where COMM_NO=?";
	private static final String UPDATE ="update act_comm set ACT_NO=?,MEM_AC=?,COMM_CONT=?,COMM_DATE=?,COMM_REPLY_CONT=?,COMM_REPLY_DATE=? where comm_no=?";
	@Override
	public void insert(ACT_COMM_VO act_comm_VO) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, act_comm_VO.getACT_NO());
			pstmt.setString(2,act_comm_VO.getMEM_AC());
			pstmt.setString(3,act_comm_VO.getCOMM_CONT());
			pstmt.setDate(4,act_comm_VO.getCOMM_DATE());
			pstmt.setString(5,act_comm_VO.getCOMM_REPLY_CONT());
			pstmt.setDate(6,act_comm_VO.getCOMM_REPLY_DATE());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		
		
	}
	@Override
	public void update(ACT_COMM_VO act_comm_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, act_comm_VO.getACT_NO());
			pstmt.setString(2,act_comm_VO.getMEM_AC());
			pstmt.setString(3,act_comm_VO.getCOMM_CONT());
			pstmt.setDate(4,act_comm_VO.getCOMM_DATE());
			pstmt.setString(5,act_comm_VO.getCOMM_REPLY_CONT());
			pstmt.setDate(6,act_comm_VO.getCOMM_REPLY_DATE());
			pstmt.setString(7, act_comm_VO.getCOMM_NO());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}
	@Override
	public void delete(String COMM_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE);
			pstmt.setString(1, COMM_NO);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	@Override
	public ACT_COMM_VO findByPrimaryKey(String COMM_NO) {
		// TODO Auto-generated method stub
		ACT_COMM_VO act_comm_vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, COMM_NO);
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 act_comm_vo=new ACT_COMM_VO();
				 act_comm_vo.setCOMM_NO(rs.getString("COMM_NO"));
				 act_comm_vo.setACT_NO(rs.getString("ACT_NO"));
				 act_comm_vo.setMEM_AC(rs.getString("MEM_AC"));
				 act_comm_vo.setCOMM_CONT(rs.getString("COMM_CONT"));
				 act_comm_vo.setCOMM_DATE(rs.getDate("COMM_DATE"));
				 act_comm_vo.setCOMM_REPLY_CONT(rs.getString("COMM_REPLY_CONT"));
				 act_comm_vo.setCOMM_REPLY_DATE(rs.getDate("COMM_REPLY_DATE"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		
		}
		return act_comm_vo;
		
		
	}
	@Override
	public List<ACT_COMM_VO> getAll() {
		// TODO Auto-generated method stub
		 List<ACT_COMM_VO> list=new  ArrayList<ACT_COMM_VO>();
		 ACT_COMM_VO act_comm_vo=new ACT_COMM_VO();
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					 act_comm_vo=new ACT_COMM_VO();
					 act_comm_vo.setCOMM_NO(rs.getString("COMM_NO"));
					 act_comm_vo.setACT_NO(rs.getString("ACT_NO"));
					 act_comm_vo.setMEM_AC(rs.getString("MEM_AC"));
					 act_comm_vo.setCOMM_CONT(rs.getString("COMM_CONT"));
					 act_comm_vo.setCOMM_DATE(rs.getDate("COMM_DATE"));
					 act_comm_vo.setCOMM_REPLY_CONT(rs.getString("COMM_REPLY_CONT"));
					 act_comm_vo.setCOMM_REPLY_DATE(rs.getDate("COMM_REPLY_DATE"));
					list.add(act_comm_vo);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return list;
		 
		 
	}
	
	
	
}
