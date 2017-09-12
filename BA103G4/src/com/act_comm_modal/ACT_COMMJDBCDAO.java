package com.act_comm_modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ACT_COMMJDBCDAO implements ACT_COMM_DAO_interface{

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid="b0402015";
	String password="02015";
	
	private static final String INSERT_STMT ="insert into act_comm values('C' ||  comm_no_seq.nextval,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from act_comm";
	private static final String GET_ONE_STMT="select * from act_comm where COMM_NO=?";
	private static final String DELETE = "delete from act_comm where COMM_NO=?";
	private static final String UPDATE ="update act_comm set ACT_NO=?,MEM_AC=?,COMM_CONT=?,COMM_DATE=?,COMM_REPLY_CONT=?,COMM_REPLY_DATE=? where comm_no=?";
	@Override
	public void insert(ACT_COMM_VO act_comm_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
		
				con = DriverManager.getConnection(url, userid, password);
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
			
		} catch (ClassNotFoundException e) {
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
			Class.forName(driver);
			
				con = DriverManager.getConnection(url, userid, password);
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
			
		} catch (ClassNotFoundException e) {
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
			Class.forName(driver);
	
				con = DriverManager.getConnection(url, userid, password);
				pstmt=con.prepareStatement(DELETE);
				pstmt.setString(1, COMM_NO);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
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
			Class.forName(driver);

				con = DriverManager.getConnection(url, userid, password);
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
			
		} catch (ClassNotFoundException e) {
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
				Class.forName(driver);
	
					con = DriverManager.getConnection(url, userid, password);
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
				
			} catch (ClassNotFoundException e) {
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

	public static void main(String[] args){
		
		ACT_COMMJDBCDAO dao=new 	ACT_COMMJDBCDAO();
		ACT_COMM_VO act_comm_vo1=new ACT_COMM_VO();
		act_comm_vo1.setACT_NO("A1000000005");
		act_comm_vo1.setMEM_AC("starter9244");
		act_comm_vo1.setCOMM_CONT("bababa~~");
		act_comm_vo1.setCOMM_DATE(java.sql.Date.valueOf("2017-09-08"));
		act_comm_vo1.setCOMM_REPLY_CONT("haha~");
		act_comm_vo1.setCOMM_REPLY_DATE(java.sql.Date.valueOf("2017-09-10"));
		dao.insert(act_comm_vo1);
		
		
		ACT_COMM_VO act_comm_vo2=new ACT_COMM_VO();
		act_comm_vo2.setCOMM_NO("C1000000010");
		act_comm_vo2.setACT_NO("A1000000005");
		act_comm_vo2.setMEM_AC("starter9244");
		act_comm_vo2.setCOMM_CONT("baBBAAbaba~~");
		act_comm_vo2.setCOMM_DATE(java.sql.Date.valueOf("2017-09-08"));
		act_comm_vo2.setCOMM_REPLY_CONT("haha~");
		act_comm_vo2.setCOMM_REPLY_DATE(java.sql.Date.valueOf("2017-09-10"));
		dao.update(act_comm_vo2);
		
//		dao.delete("C1000000011");
//		ACT_COMM_VO act_comm_vo3=dao.findByPrimaryKey("C1000000004");
//		System.out.print(act_comm_vo3.getCOMM_NO()+",");
//		System.out.print(act_comm_vo3.getACT_NO()+",");
//		System.out.print(act_comm_vo3.getMEM_AC()+",");
//		System.out.print(act_comm_vo3.getCOMM_CONT()+",");
//		System.out.print(act_comm_vo3.getCOMM_DATE()+",");
//		System.out.print(act_comm_vo3.getCOMM_REPLY_CONT()+",");
//		System.out.print(act_comm_vo3.getCOMM_REPLY_DATE()+",");
		
		List<ACT_COMM_VO> list=dao.getAll();
		for(ACT_COMM_VO act_comm_vo4:list){
		System.out.print(act_comm_vo4.getCOMM_NO()+",");
		System.out.print(act_comm_vo4.getACT_NO()+",");
		System.out.print(act_comm_vo4.getMEM_AC()+",");
		System.out.print(act_comm_vo4.getCOMM_CONT()+",");
		System.out.print(act_comm_vo4.getCOMM_DATE()+",");
		System.out.print(act_comm_vo4.getCOMM_REPLY_CONT()+",");
		System.out.print(act_comm_vo4.getCOMM_REPLY_DATE()+",");
		System.out.println();
		}
		
		
		
	}
	
	
	
	
	
}
