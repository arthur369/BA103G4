package com.act_modal;

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

import com.ad_modal.AD_DAO_interface;
import com.ad_modal.AD_VO;

public class ACT_JNDIDAO implements ACT_DAO_interface{
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
	
	private static final String INSERT_STMT ="insert into act values('A' || act_no_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from act";
	private static final String GET_ONE_STMT="select * from act where ACT_NO=?";
	private static final String DELETE = "delete from act where act_no=?";
	private static final String UPDATE ="update act set MEM_AC=?,ORG_CONT=?,ACT_NAME=?,MIN_MEM=?,MAX_MEM=?,MEM_COUNT=?,ACT_OP_DATE=?,ACT_ED_DATE=?,DL_DATE=?,FD_DATE=?,ACT_ADD=?, ACT_ADD_LAT=?,ACT_ADD_LON=?,ACT_CONT=?,ACT_TAG=?,ACT_FEE=?,PAY_WAY=?,ACT_PIC1=?,ACT_PIC2=?,ACT_PIC3=?,ACT_STAT=?,RE_CONT=?,REVIEW_ED_DATE=?where act_no=?";
	@Override
	public void insert(ACT_VO act_VO) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1,act_VO.getMEM_AC());
			pstmt.setString(2,act_VO.getORG_CONT());
			pstmt.setString(3,act_VO.getACT_NAME());
			pstmt.setInt(4,act_VO.getMIN_MEM());
			pstmt.setInt(5,act_VO.getMAX_MEM());
			pstmt.setInt(6,act_VO.getMEM_COUNT());
			pstmt.setDate(7,act_VO.getACT_OP_DATE());
			pstmt.setDate(8,act_VO.getACT_ED_DATE());
			pstmt.setDate(9,act_VO.getDL_DATE());
			pstmt.setDate(10,act_VO.getFD_DATE());
			pstmt.setString(11,act_VO.getACT_ADD());
			pstmt.setString(12,act_VO.getACT_ADD_LAT());
			pstmt.setString(13,act_VO.getACT_ADD_LON());
			pstmt.setString(14,act_VO.getACT_CONT());
			pstmt.setString(15,act_VO.getACT_TAG());
			pstmt.setInt(16,act_VO.getACT_FEE());
			pstmt.setString(17,act_VO.getPAY_WAY());
			byte[] pic1=act_VO.getACT_PIC1();
			byte[] pic2=act_VO.getACT_PIC2();
			byte[] pic3=act_VO.getACT_PIC3();
			Blob blob1=con.createBlob();
			Blob blob2=con.createBlob();
			Blob blob3=con.createBlob();
			blob1.setBytes(1, pic1);
			blob2.setBytes(1, pic2);
			blob3.setBytes(1, pic3);
			pstmt.setBlob(18,blob1);
			pstmt.setBlob(19,blob2);
			pstmt.setBlob(20,blob3);
			pstmt.setString(21,act_VO.getACT_STAT());
			pstmt.setString(22,act_VO.getRE_CONT());
			pstmt.setDate(23,act_VO.getREVIEW_ED_DATE());
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
	public void update(ACT_VO act_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1,act_VO.getMEM_AC());
			pstmt.setString(2,act_VO.getORG_CONT());
			pstmt.setString(3,act_VO.getACT_NAME());
			pstmt.setInt(4,act_VO.getMIN_MEM());
			pstmt.setInt(5,act_VO.getMAX_MEM());
			pstmt.setInt(6,act_VO.getMEM_COUNT());
			pstmt.setDate(7,act_VO.getACT_OP_DATE());
			pstmt.setDate(8,act_VO.getACT_ED_DATE());
			pstmt.setDate(9,act_VO.getDL_DATE());
			pstmt.setDate(10,act_VO.getFD_DATE());
			pstmt.setString(11,act_VO.getACT_ADD());
			pstmt.setString(12,act_VO.getACT_ADD_LAT());
			pstmt.setString(13,act_VO.getACT_ADD_LON());
			pstmt.setString(14,act_VO.getACT_CONT());
			pstmt.setString(15,act_VO.getACT_TAG());
			pstmt.setInt(16,act_VO.getACT_FEE());
			pstmt.setString(17,act_VO.getPAY_WAY());
			byte[] pic1=act_VO.getACT_PIC1();
			byte[] pic2=act_VO.getACT_PIC2();
			byte[] pic3=act_VO.getACT_PIC3();
			Blob blob1=con.createBlob();
			Blob blob2=con.createBlob();
			Blob blob3=con.createBlob();
			blob1.setBytes(1, pic1);
			blob2.setBytes(1, pic2);
			blob3.setBytes(1, pic3);	
			pstmt.setBlob(18,blob1);
			pstmt.setBlob(19,blob2);
			pstmt.setBlob(20,blob3);
			pstmt.setString(21,act_VO.getACT_STAT());
			pstmt.setString(22,act_VO.getRE_CONT());
			pstmt.setDate(23,act_VO.getREVIEW_ED_DATE());
			pstmt.setString(24,act_VO.getACT_NO());
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
	public void delete(String ACT_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE);
			pstmt.setString(1, ACT_NO);
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
	public ACT_VO findByPrimaryKey(String ACT_NO) {
		// TODO Auto-generated method stub
		ACT_VO act_vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, ACT_NO);
			rs=pstmt.executeQuery();
		while(rs.next()){
			act_vo=new ACT_VO();
			act_vo.setACT_NO(rs.getString("ACT_NO"));
			act_vo.setMEM_AC(rs.getString("MEM_AC"));
			act_vo.setORG_CONT(rs.getString("ORG_CONT"));
			act_vo.setACT_NAME(rs.getString("ACT_NAME"));
			act_vo.setMIN_MEM(rs.getInt("MIN_MEM"));
			act_vo.setMAX_MEM(rs.getInt("MAX_MEM"));
			act_vo.setMEM_COUNT(rs.getInt("MEM_COUNT"));
			act_vo.setACT_OP_DATE(rs.getDate("ACT_OP_DATE"));
			act_vo.setACT_ED_DATE(rs.getDate("ACT_ED_DATE"));
			act_vo.setDL_DATE(rs.getDate("DL_DATE"));
			act_vo.setFD_DATE(rs.getDate("FD_DATE"));
			act_vo.setACT_ADD(rs.getString("ACT_ADD"));
			act_vo.setACT_ADD_LAT(rs.getString("ACT_ADD_LAT"));
			act_vo.setACT_ADD_LON(rs.getString("ACT_ADD_LON"));
			act_vo.setACT_CONT(rs.getString("ACT_CONT"));
			act_vo.setACT_TAG(rs.getString("ACT_TAG"));
			act_vo.setACT_FEE(rs.getInt("ACT_FEE"));
			act_vo.setPAY_WAY(rs.getString("PAY_WAY"));
		
			act_vo.setACT_PIC1(rs.getBytes("ACT_PIC1"));
			act_vo.setACT_PIC2(rs.getBytes("ACT_PIC2"));
			act_vo.setACT_PIC3(rs.getBytes("ACT_PIC3"));
			act_vo.setACT_STAT(rs.getString("ACT_STAT"));
			act_vo.setRE_CONT(rs.getString("RE_CONT"));
			act_vo.setREVIEW_ED_DATE(rs.getDate("REVIEW_ED_DATE"));
			
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
		return act_vo;
		
		
	}
	@Override
	public List<ACT_VO> getAll() {
		// TODO Auto-generated method stub
		List<ACT_VO> list=new ArrayList<ACT_VO>();
		ACT_VO act_vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs=pstmt.executeQuery();
			while(rs.next()){
				act_vo=new ACT_VO();
				act_vo.setACT_NO(rs.getString("ACT_NO"));
				act_vo.setMEM_AC(rs.getString("MEM_AC"));
				act_vo.setORG_CONT(rs.getString("ORG_CONT"));
				act_vo.setACT_NAME(rs.getString("ACT_NAME"));
				act_vo.setMIN_MEM(rs.getInt("MIN_MEM"));
				act_vo.setMAX_MEM(rs.getInt("MAX_MEM"));
				act_vo.setMEM_COUNT(rs.getInt("MEM_COUNT"));
				act_vo.setACT_OP_DATE(rs.getDate("ACT_OP_DATE"));
				act_vo.setACT_ED_DATE(rs.getDate("ACT_ED_DATE"));
				act_vo.setDL_DATE(rs.getDate("DL_DATE"));
				act_vo.setFD_DATE(rs.getDate("FD_DATE"));
				act_vo.setACT_ADD(rs.getString("ACT_ADD"));
				act_vo.setACT_ADD_LAT(rs.getString("ACT_ADD_LAT"));
				act_vo.setACT_ADD_LON(rs.getString("ACT_ADD_LON"));
				act_vo.setACT_CONT(rs.getString("ACT_CONT"));
				act_vo.setACT_TAG(rs.getString("ACT_TAG"));
				act_vo.setACT_FEE(rs.getInt("ACT_FEE"));
				act_vo.setPAY_WAY(rs.getString("PAY_WAY"));
			
				act_vo.setACT_PIC1(rs.getBytes("ACT_PIC1"));
				act_vo.setACT_PIC2(rs.getBytes("ACT_PIC2"));
				act_vo.setACT_PIC3(rs.getBytes("ACT_PIC3"));
				act_vo.setACT_STAT(rs.getString("ACT_STAT"));
				act_vo.setRE_CONT(rs.getString("RE_CONT"));
				act_vo.setREVIEW_ED_DATE(rs.getDate("REVIEW_ED_DATE"));
				
				list.add(act_vo);
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
