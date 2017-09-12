package com.convert_gift_modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.gift_data_modal.GIFT_DATA_VO;

public class CONVERT_GIFTJNDIDAO implements CONVERT_GIFT_DAO_interface{

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
	
	private static final String INSERT_STMT ="insert into convert_gift values('V' || apply_no_seq.nextval,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from convert_gift";
	private static final String GET_ONE_STMT="select * from convert_gift where APPLY_NO=?";
	private static final String DELETE = "delete from convert_gift where APPLY_NO=?";
	private static final String UPDATE ="update convert_gift set MEM_AC=?,APPLY_NAME=?,APPLY_PHONE=?,GIFT_NO=?,APPLY_DATE=?,APPLY_STAT=?,APPLY_ADD=?,SEND_DATE=?,SEND_NO=? where APPLY_NO=?";
	
	
	
	@Override
	public void insert(CONVERT_GIFT_VO convert_gift_VO) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, convert_gift_VO.getMEM_AC());
			pstmt.setString(2, convert_gift_VO.getAPPLY_NAME());
			pstmt.setString(3, convert_gift_VO.getAPPLY_PHONE());
			pstmt.setString(4, convert_gift_VO.getGIFT_NO());
			pstmt.setDate(5, convert_gift_VO.getAPPLY_DATE());
			pstmt.setString(6, convert_gift_VO.getAPPLY_STAT());
			pstmt.setString(7, convert_gift_VO.getAPPLY_ADD());
			pstmt.setDate(8, convert_gift_VO.getSEND_DATE());
			pstmt.setString(9, convert_gift_VO.getSEND_NO());
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
	public void update(CONVERT_GIFT_VO convert_gift_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, convert_gift_VO.getMEM_AC());
			pstmt.setString(2, convert_gift_VO.getAPPLY_NAME());
			pstmt.setString(3, convert_gift_VO.getAPPLY_PHONE());
			pstmt.setString(4, convert_gift_VO.getGIFT_NO());
			pstmt.setDate(5, convert_gift_VO.getAPPLY_DATE());
			pstmt.setString(6, convert_gift_VO.getAPPLY_STAT());
			pstmt.setString(7, convert_gift_VO.getAPPLY_ADD());
			pstmt.setDate(8, convert_gift_VO.getSEND_DATE());
			pstmt.setString(9, convert_gift_VO.getSEND_NO());
			pstmt.setString(10, convert_gift_VO.getAPPLY_NO());
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
	public void delete(String APPLY_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE);
			pstmt.setString(1, APPLY_NO);
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
	public CONVERT_GIFT_VO findByPrimaryKey(String APPLY_NO) {
		// TODO Auto-generated method stub
		CONVERT_GIFT_VO convert_gift_vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, APPLY_NO);
			 rs=pstmt.executeQuery();
			 while(rs.next()){
				 convert_gift_vo=new CONVERT_GIFT_VO();
				 convert_gift_vo.setAPPLY_NO(rs.getString("APPLY_NO"));
				 convert_gift_vo.setMEM_AC(rs.getString("MEM_AC"));
				 convert_gift_vo.setAPPLY_NAME(rs.getString("APPLY_NAME"));
				 convert_gift_vo.setAPPLY_PHONE(rs.getString("APPLY_PHONE"));
				 convert_gift_vo.setGIFT_NO(rs.getString("GIFT_NO"));
				 convert_gift_vo.setAPPLY_DATE(rs.getDate("APPLY_DATE"));
				 convert_gift_vo.setAPPLY_STAT(rs.getString("APPLY_STAT"));
				 convert_gift_vo.setAPPLY_ADD(rs.getString("APPLY_ADD"));
				 convert_gift_vo.setSEND_DATE(rs.getDate("SEND_DATE"));
				 convert_gift_vo.setSEND_NO(rs.getString("SEND_NO"));
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
		return convert_gift_vo;
		
		
		
		
		
	}

	@Override
	public List<CONVERT_GIFT_VO> getAll() {
		// TODO Auto-generated method stub
		List<CONVERT_GIFT_VO> list=new ArrayList<CONVERT_GIFT_VO>();
		CONVERT_GIFT_VO convert_gift_vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		try {
			
	
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs=pstmt.executeQuery();
				 while(rs.next()){
					 convert_gift_vo=new CONVERT_GIFT_VO();
					 convert_gift_vo.setAPPLY_NO(rs.getString("APPLY_NO"));
					 convert_gift_vo.setMEM_AC(rs.getString("MEM_AC"));
					 convert_gift_vo.setAPPLY_NAME(rs.getString("APPLY_NAME"));
					 convert_gift_vo.setAPPLY_PHONE(rs.getString("APPLY_PHONE"));
					 convert_gift_vo.setGIFT_NO(rs.getString("GIFT_NO"));
					 convert_gift_vo.setAPPLY_DATE(rs.getDate("APPLY_DATE"));
					 convert_gift_vo.setAPPLY_STAT(rs.getString("APPLY_STAT"));
					 convert_gift_vo.setAPPLY_ADD(rs.getString("APPLY_ADD"));
					 convert_gift_vo.setSEND_DATE(rs.getDate("SEND_DATE"));
					 convert_gift_vo.setSEND_NO(rs.getString("SEND_NO"));
					 list.add(convert_gift_vo);
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
