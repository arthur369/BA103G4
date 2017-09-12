package com.act_modal;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ACT_JDBCDAO implements ACT_DAO_interface{
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid="b0402015";
	String password="02015";
	
	private static final String INSERT_STMT ="insert into act values('A' || act_no_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from act";
	private static final String GET_ONE_STMT="select * from act where ACT_NO=?";
	private static final String DELETE = "delete from act where act_no=?";
	private static final String UPDATE ="update act set MEM_AC=?,ORG_CONT=?,ACT_NAME=?,MIN_MEM=?,MAX_MEM=?,MEM_COUNT=?,ACT_OP_DATE=?,ACT_ED_DATE=?,DL_DATE=?,FD_DATE=?,ACT_ADD=?, ACT_ADD_LAT=?,ACT_ADD_LON=?,ACT_CONT=?,ACT_TAG=?,ACT_FEE=?,PAY_WAY=?,ACT_PIC1=?,ACT_PIC2=?,ACT_PIC3=?,ACT_STAT=?,RE_CONT=?,REVIEW_ED_DATE=?where act_no=?";
	
	
	@Override
	public void insert(ACT_VO act_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
	
				con = DriverManager.getConnection(url, userid, password);
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
	public void update(ACT_VO act_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			
				con = DriverManager.getConnection(url, userid, password);
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
	public void delete(String ACT_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
		
				con = DriverManager.getConnection(url, userid, password);
				pstmt=con.prepareStatement(DELETE);
				pstmt.setString(1, ACT_NO);
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
	public ACT_VO findByPrimaryKey(String ACT_NO) {
		ACT_VO act_vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
		
				con = DriverManager.getConnection(url, userid, password);
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
		return act_vo;
		
	}

	@Override
	public List<ACT_VO> getAll() {
		List<ACT_VO> list=new ArrayList<ACT_VO>();
		ACT_VO act_vo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			
				con = DriverManager.getConnection(url, userid, password);
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
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
ACT_JDBCDAO dao=new ACT_JDBCDAO();

//ACT_VO act_vo1=new ACT_VO();
//	act_vo1.setMEM_AC("starter4244");
//	act_vo1.setORG_CONT("我是主辦人");
//	act_vo1.setACT_NAME("我是活動");
//	act_vo1.setMIN_MEM(6);
//	act_vo1.setMAX_MEM(10);
//	act_vo1.setMEM_COUNT(5);
//	act_vo1.setACT_OP_DATE(java.sql.Date.valueOf("2017-09-07"));
//	act_vo1.setACT_ED_DATE(java.sql.Date.valueOf("2017-09-09"));
//	act_vo1.setDL_DATE(java.sql.Date.valueOf("2017-09-02"));
//	act_vo1.setFD_DATE(java.sql.Date.valueOf("2017-09-01"));
//	act_vo1.setACT_ADD("台灣");
//	act_vo1.setACT_ADD_LAT("121.550537");
//	act_vo1.setACT_ADD_LON("25.032904");
//	act_vo1.setACT_CONT("bababa~~");
//	act_vo1.setACT_TAG("隨便啦~");
//	act_vo1.setACT_FEE(0);
//	act_vo1.setPAY_WAY("不需繳費");
//	byte[ ]pic1=getByteArray("C:\\Users\\Java\\Desktop\\專題照片\\act.jpg");
//	act_vo1.setACT_PIC1(pic1);
//	act_vo1.setACT_PIC2(null);
//	act_vo1.setACT_PIC3(null);
//	act_vo1.setACT_STAT("已審核");
//	act_vo1.setRE_CONT(null);
//	act_vo1.setREVIEW_ED_DATE(java.sql.Date.valueOf("2017-09-01"));
//	dao.insert(act_vo1);
	
//	ACT_VO act_vo2=new ACT_VO();
//	act_vo2.setMEM_AC("starter4244");
//	act_vo2.setORG_CONT("我不是主辦人");
//	act_vo2.setACT_NAME("我是活動");
//	act_vo2.setMIN_MEM(6);
//	act_vo2.setMAX_MEM(10);
//	act_vo2.setMEM_COUNT(5);
//	act_vo2.setACT_OP_DATE(java.sql.Date.valueOf("2017-09-07"));
//	act_vo2.setACT_ED_DATE(java.sql.Date.valueOf("2017-09-09"));
//	act_vo2.setDL_DATE(java.sql.Date.valueOf("2017-09-02"));
//	act_vo2.setFD_DATE(java.sql.Date.valueOf("2017-09-01"));
//	act_vo2.setACT_ADD("台灣");
//	act_vo2.setACT_ADD_LAT("121.550537");
//	act_vo2.setACT_ADD_LON("25.032904");
//	act_vo2.setACT_CONT("bababa~~");
//	act_vo2.setACT_TAG("隨便啦~");
//	act_vo2.setACT_FEE(0);
//	act_vo2.setPAY_WAY("不需繳費");
//	byte[ ]pic2=getByteArray("C:\\Users\\Java\\Desktop\\專題照片\\act.jpg");
//	act_vo2.setACT_PIC1(pic2);
//	act_vo2.setACT_PIC2(null);
//	act_vo2.setACT_PIC3(null);
//	act_vo2.setACT_STAT("已審核");
//	act_vo2.setRE_CONT(null);
//	act_vo2.setREVIEW_ED_DATE(java.sql.Date.valueOf("2017-09-01"));
//	act_vo2.setACT_NO("A1000000012");
//	dao.update(act_vo2);
//	
//	dao.delete("A1000000012");
	
//ACT_VO act_vo3=dao.findByPrimaryKey("A1000000005");
//System.out.print(act_vo3.getMEM_AC());
//System.out.print(act_vo3.getORG_CONT());

	List<ACT_VO>list=dao.getAll();
	for(ACT_VO act_vo4:list){
		System.out.print(act_vo4.getMEM_AC()+",");
		System.out.print(act_vo4.getORG_CONT()+",");
		System.out.println();
		
	}


	}
	
	public static byte[] getByteArray(String path) throws IOException{
		FileInputStream fis=new FileInputStream(new File(path));
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		int i;
		byte [] buffer=new byte [8193];
		if((i=fis.read(buffer))!=-1){
			baos.write(buffer,0,i);
		}
		return baos.toByteArray();
	}
	
}
