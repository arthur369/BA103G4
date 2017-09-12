package com.ad_modal;

import java.sql.Blob;
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

public class AD_JNDIDAO implements AD_DAO_interface{
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
	private static final String INSERT_STMT ="insert into ad values('D' || ad_no_seq.nextval,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from ad";
	private static final String GET_ONE_STMT="select * from ad where AD_NO=?";
	private static final String DELETE = "delete from ad where ad_no=?";
	private static final String UPDATE ="update ad set PROD_NO=?,AD_TITLE=?,AD_IMG=?,AD_OP_DATE=?,AD_ED_DATE=? where AD_NO=?";
	
	
	
	@Override
	public void insert(AD_VO ad_VO) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1,ad_VO.getPROD_NO());
			pstmt.setString(2, ad_VO.getAD_TITLE());
			byte[] pic=ad_VO.getAD_IMG();
			Blob blobpic=con.createBlob();
			blobpic.setBytes(1, pic);
			pstmt.setBlob(3,blobpic);
			pstmt.setDate(4,ad_VO.getAD_OP_DATE());
			pstmt.setDate(5, ad_VO.getAD_ED_DATE());
		
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
	public void update(AD_VO ad_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1,ad_VO.getPROD_NO());
			pstmt.setString(2, ad_VO.getAD_TITLE());
			byte[] pic=ad_VO.getAD_IMG();
			Blob blobpic=con.createBlob();
			blobpic.setBytes(1, pic);
			pstmt.setBlob(3,blobpic);
			pstmt.setDate(4,ad_VO.getAD_OP_DATE());
			pstmt.setDate(5, ad_VO.getAD_ED_DATE());
			pstmt.setString(6, ad_VO.getAD_NO());
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
	public void delete(String AD_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE);
			pstmt.setString(1, AD_NO);
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
	public AD_VO findByPrimaryKey(String AD_NO) {
		// TODO Auto-generated method stub
		AD_VO ad_vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, AD_NO);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
			 ad_vo=new AD_VO();
			 ad_vo.setAD_NO(rs.getString("AD_NO"));
			 ad_vo.setPROD_NO(rs.getString("PROD_NO"));
			 ad_vo.setAD_TITLE(rs.getString("AD_TITLE"));
			 ad_vo.setAD_IMG(rs.getBytes("AD_IMG"));
			 ad_vo.setAD_OP_DATE(rs.getDate("AD_OP_DATE"));
			 ad_vo.setAD_ED_DATE(rs.getDate("AD_ED_DATE"));
				
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
		return ad_vo;
		
	}

	@Override
	public List<AD_VO> getAll() {
		// TODO Auto-generated method stub
		List<AD_VO> list=new ArrayList<AD_VO>();
		AD_VO ad_vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ad_vo=new AD_VO();
				 ad_vo.setAD_NO(rs.getString("AD_NO"));
				 ad_vo.setPROD_NO(rs.getString("PROD_NO"));
				 ad_vo.setAD_TITLE(rs.getString("AD_TITLE"));
				 ad_vo.setAD_IMG(rs.getBytes("AD_IMG"));
				 ad_vo.setAD_OP_DATE(rs.getDate("AD_OP_DATE"));
				 ad_vo.setAD_ED_DATE(rs.getDate("AD_ED_DATE"));
				 list.add(ad_vo);
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
