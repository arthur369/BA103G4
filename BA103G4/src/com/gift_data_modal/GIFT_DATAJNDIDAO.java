package com.gift_data_modal;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GIFT_DATAJNDIDAO implements GIFT_DATA_DAO_interface{

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
	private static final String INSERT_STMT ="insert into gift_data values('G' || gift_no_seq.nextval,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from gift_data";
	private static final String GET_ONE_STMT="select * from gift_data where GIFT_NO=?";
	private static final String DELETE = "delete from gift_data where gift_no=?";
	private static final String UPDATE ="update gift_data set GIFT_NAME=?,GIFT_REMAIN=?,GIFT_CONT=?,GIFT_IMG=?,GIFT_PT=?,GIFT_LAUNCH_DATE=? where gift_no=?";
	
	
	@Override
	public void insert(GIFT_DATA_VO gift_data_VO) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			

			pstmt.setString(1,gift_data_VO.getGIFT_NAME());
			pstmt.setInt(2,gift_data_VO.getGIFT_REMAIN());
			pstmt.setString(3,gift_data_VO.getGIFT_CONT());
			byte[] pic=gift_data_VO.getGIFT_IMG();
			Blob blobpic=con.createBlob();
			
			pstmt.setBlob(4,blobpic);
			blobpic.setBytes(1, pic);
			pstmt.setInt(5,gift_data_VO.getGIFT_PT());
			pstmt.setDate(6,gift_data_VO.getGIFT_LAUNCH_DATE());
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
	public void update(GIFT_DATA_VO gift_data_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1,gift_data_VO.getGIFT_NAME());
			pstmt.setInt(2, gift_data_VO.getGIFT_REMAIN());
			pstmt.setString(3, gift_data_VO.getGIFT_CONT());
			byte[] img=gift_data_VO.getGIFT_IMG();
			Blob blobChange=con.createBlob();
			blobChange.setBytes(1,img);
			pstmt.setBlob(4,blobChange);
			pstmt.setInt(5,gift_data_VO.getGIFT_PT());
			pstmt.setDate(6,gift_data_VO.getGIFT_LAUNCH_DATE());
			pstmt.setString(7,gift_data_VO.getGIFT_NO());
			pstmt.executeUpdate();
			con.commit();
			
			
			
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
	public void delete(String GIFT_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE);
			pstmt.setString(1,GIFT_NO);
			
			
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
	public GIFT_DATA_VO findByPrimaryKey(String GIFT_NO) {
		// TODO Auto-generated method stub
		GIFT_DATA_VO gift_data_vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, GIFT_NO);
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 gift_data_vo=new GIFT_DATA_VO();
				 gift_data_vo.setGIFT_NO(rs.getString("GIFT_NO"));
				 gift_data_vo.setGIFT_NAME(rs.getString("GIFT_NAME"));
				 gift_data_vo.setGIFT_REMAIN(rs.getInt("GIFT_REMAIN"));
				 gift_data_vo.setGIFT_CONT(rs.getString("GIFT_CONT"));
				 gift_data_vo.setGIFT_IMG(rs.getBytes("GIFT_IMG"));
				 gift_data_vo.setGIFT_PT(rs.getInt("GIFT_PT"));
				 gift_data_vo.setGIFT_LAUNCH_DATE(rs.getDate("GIFT_LAUNCH_DATE"));
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
		return gift_data_vo;
		
		
	}

	@Override
	public List<GIFT_DATA_VO> getAll() {
		// TODO Auto-generated method stub
		List<GIFT_DATA_VO> list=new ArrayList<GIFT_DATA_VO>();
		GIFT_DATA_VO gift_data_vo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				gift_data_vo=new GIFT_DATA_VO();
				gift_data_vo.setGIFT_NO(rs.getString("GIFT_NO"));
				gift_data_vo.setGIFT_NAME(rs.getString("GIFT_NAME"));
				gift_data_vo.setGIFT_REMAIN(rs.getInt("GIFT_REMAIN"));
				gift_data_vo.setGIFT_CONT(rs.getString("GIFT_CONT"));
				gift_data_vo.setGIFT_IMG(rs.getBytes("GIFT_IMG"));
				gift_data_vo.setGIFT_PT(rs.getInt("GIFT_PT"));
				gift_data_vo.setGIFT_LAUNCH_DATE(rs.getDate("GIFT_LAUNCH_DATE"));
				list.add(gift_data_vo);
				
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
