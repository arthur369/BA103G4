package com.act_pair_modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ACT_PAIRJDBCDAO implements ACT_PAIR_DAO_interface{
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid="b0402015";
	String password="02015";
	
	private static final String INSERT_STMT ="insert into act_pair values(?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from act_pair";
	private static final String GET_ONE_STMT="select * from act_pair where ACT_NO=? AND MEM_AC=?";
	private static final String DELETE = "delete from act_pair where ACT_NO=? AND MEM_AC=?";
	private static final String UPDATE ="update act_pair set APPLY_DATE=?,PAY_STATE=?,CHK_STATE=? where ACT_NO=? AND MEM_AC=?";
	
	@Override
	public void insert(ACT_PAIR_VO act_pair_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			
				con = DriverManager.getConnection(url, userid, password);
				pstmt = con.prepareStatement(INSERT_STMT);
				pstmt.setString(1,act_pair_VO.getACT_NO());
				pstmt.setString(2, act_pair_VO.getMEM_AC());
				pstmt.setDate(3,act_pair_VO.getAPPLY_DATE());
				pstmt.setString(4,act_pair_VO.getPAY_STATE());
				pstmt.setString(5,act_pair_VO.getCHK_STATE());
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
	public void update(ACT_PAIR_VO act_pair_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
		
				con = DriverManager.getConnection(url, userid, password);
				pstmt = con.prepareStatement(UPDATE);
				
				pstmt.setDate(1, act_pair_VO.getAPPLY_DATE());
				pstmt.setString(2, act_pair_VO.getPAY_STATE());
				pstmt.setString(3, act_pair_VO.getCHK_STATE());
				pstmt.setString(4, act_pair_VO.getACT_NO());
				pstmt.setString(5, act_pair_VO.getMEM_AC());
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
	public void delete(String ACT_NO,String MEM_AC) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
	
				con = DriverManager.getConnection(url, userid, password);
				pstmt=con.prepareStatement(DELETE);
				pstmt.setString(1, ACT_NO);
				pstmt.setString(2, MEM_AC);
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
	public ACT_PAIR_VO findByPrimaryKey(String ACT_NO,String MEM_AC) {
		// TODO Auto-generated method stub
		ACT_PAIR_VO act_pair_vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);

				con = DriverManager.getConnection(url, userid, password);
				pstmt = con.prepareStatement(GET_ONE_STMT);
				pstmt.setString(1, ACT_NO);
				pstmt.setString(2, MEM_AC);
				rs=pstmt.executeQuery();
				 while(rs.next()){
					 act_pair_vo=new ACT_PAIR_VO();
					 act_pair_vo.setACT_NO(rs.getString("ACT_NO"));
					 act_pair_vo.setMEM_AC(rs.getString("MEM_AC"));
					 act_pair_vo.setAPPLY_DATE(rs.getDate("APPLY_DATE"));
					 act_pair_vo.setPAY_STATE(rs.getString("PAY_STATE"));
					 act_pair_vo.setCHK_STATE(rs.getString("CHK_STATE"));
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
		return  act_pair_vo;
		
		
		
	}
	@Override
	public List<ACT_PAIR_VO> getAll() {
		// TODO Auto-generated method stub
		 List<ACT_PAIR_VO> list=new ArrayList<ACT_PAIR_VO>();
		 ACT_PAIR_VO act_pair_vo=new ACT_PAIR_VO();
		 Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				Class.forName(driver);
	
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(GET_ALL_STMT);
					rs=pstmt.executeQuery();
					while(rs.next()){
						 act_pair_vo=new ACT_PAIR_VO();
						 act_pair_vo.setACT_NO(rs.getString("ACT_NO"));
						 act_pair_vo.setMEM_AC(rs.getString("MEM_AC"));
						 act_pair_vo.setAPPLY_DATE(rs.getDate("APPLY_DATE"));
						 act_pair_vo.setPAY_STATE(rs.getString("PAY_STATE"));
						 act_pair_vo.setCHK_STATE(rs.getString("CHK_STATE"));
						list.add(act_pair_vo);
						
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
		ACT_PAIRJDBCDAO dao=new ACT_PAIRJDBCDAO();
		
//		ACT_PAIR_VO act_pair_vo1=new ACT_PAIR_VO();
//		act_pair_vo1.setACT_NO("A1000000002");
//		act_pair_vo1.setMEM_AC("tony141");
//		act_pair_vo1.setAPPLY_DATE(java.sql.Date.valueOf("2017-09-08"));
//		act_pair_vo1.setPAY_STATE("已繳費");
//		act_pair_vo1.setCHK_STATE("未報到");
//		dao.insert(act_pair_vo1);
		
//		ACT_PAIR_VO act_pair_vo2=new ACT_PAIR_VO();
//		act_pair_vo2.setACT_NO("A1000000001");
//		act_pair_vo2.setMEM_AC("tony141");
//		act_pair_vo2.setAPPLY_DATE(java.sql.Date.valueOf("2017-09-08"));
//		act_pair_vo2.setPAY_STATE("不爽繳費");
//		act_pair_vo2.setCHK_STATE("未報到");
//		dao.update(act_pair_vo2);
		
//		dao.delete("A1000000002", "tony141");
		
//		ACT_PAIR_VO act_pair_vo3=dao.findByPrimaryKey("A1000000001","tony141");
//		System.out.print(act_pair_vo3.getACT_NO()+",");
//		System.out.print(act_pair_vo3.getMEM_AC()+",");
//		System.out.print(act_pair_vo3.getAPPLY_DATE()+",");
//		System.out.print(act_pair_vo3.getPAY_STATE()+",");
//		System.out.print(act_pair_vo3.getCHK_STATE()+",");
		
		 List<ACT_PAIR_VO> list=dao.getAll();
		 for(ACT_PAIR_VO act_pair_vo4:list){
			 System.out.print(act_pair_vo4.getACT_NO()+",");
				System.out.print(act_pair_vo4.getMEM_AC()+",");
				System.out.print(act_pair_vo4.getAPPLY_DATE()+",");
				System.out.print(act_pair_vo4.getPAY_STATE()+",");
				System.out.print(act_pair_vo4.getCHK_STATE()+",");
				System.out.println();
			 
			 
			 
		 }
		
		
		
		
	}
	
	
	
	
	
}
