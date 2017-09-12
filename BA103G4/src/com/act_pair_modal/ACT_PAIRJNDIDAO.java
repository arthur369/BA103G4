package com.act_pair_modal;

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

public class ACT_PAIRJNDIDAO implements ACT_PAIR_DAO_interface{
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
	private static final String INSERT_STMT ="insert into act_pair values(?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from act_pair";
	private static final String GET_ONE_STMT="select * from act_pair where ACT_NO=? AND MEM_AC=?";
	private static final String DELETE = "delete from act_pair where ACT_NO=? AND MEM_AC=?";
	private static final String UPDATE ="update act_pair set APPLY_DATE=?,PAY_STATE=?,CHK_STATE=? where ACT_NO=? AND MEM_AC=?";
	@Override
	public void insert(ACT_PAIR_VO act_pair_VO) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ds.getConnection();
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
			con = ds.getConnection();
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
	public void delete(String ACT_NO, String MEM_AC) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE);
			pstmt.setString(1, ACT_NO);
			pstmt.setString(2, MEM_AC);
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
	public ACT_PAIR_VO findByPrimaryKey(String ACT_NO, String MEM_AC) {
		// TODO Auto-generated method stub
		ACT_PAIR_VO act_pair_vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
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
				con = ds.getConnection();
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
