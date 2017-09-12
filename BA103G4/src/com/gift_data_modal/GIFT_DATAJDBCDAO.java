package com.gift_data_modal;

import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;


public class GIFT_DATAJDBCDAO implements GIFT_DATA_DAO_interface{
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid="b0402015";
	String password="02015";
	
	private static final String INSERT_STMT ="insert into gift_data values('G' || gift_no_seq.nextval,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from gift_data";
	private static final String GET_ONE_STMT="select * from gift_data where GIFT_NO=?";
	private static final String DELETE = "delete from gift_data where gift_no=?";
	private static final String UPDATE ="update gift_data set GIFT_NAME=?,GIFT_REMAIN=?,GIFT_CONT=?,GIFT_IMG=?,GIFT_PT=?,GIFT_LAUNCH_DATE=? where gift_no=?";
	

	@Override
	public void insert(GIFT_DATA_VO gift_data_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
		
			
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
			Class.forName(driver);
			
				con = DriverManager.getConnection(url, userid, password);
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
	public void delete(String GIFT_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);

			pstmt=con.prepareStatement(DELETE);
			pstmt.setString(1,GIFT_NO);
			
			
			pstmt.executeUpdate();
		

			} catch (SQLException se) {
				
				if (con != null) {
					try {
						
						// 3●設定於當有exception發生時之catch區塊內
						con.rollback();
					} catch (SQLException excep) {
						throw new RuntimeException("rollback error occured. "
								+ excep.getMessage());
					}
				}
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
			} catch (ClassNotFoundException e) {
				
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			}catch(Exception a){
				
				System.out.println("something wrong");
				a.printStackTrace();
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
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
			Class.forName(driver);
	
				con = DriverManager.getConnection(url, userid, password);
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
	
		GIFT_DATAJDBCDAO dao=new GIFT_DATAJDBCDAO();
		
		GIFT_DATA_VO gift_data_vo1=new GIFT_DATA_VO();
		gift_data_vo1.setGIFT_NAME("鋼杯");
		gift_data_vo1.setGIFT_REMAIN(100);
		gift_data_vo1.setGIFT_CONT("當兵喝咖啡的好幫手");
		byte[ ]pic1=getByteArray("C:\\Users\\Java\\Desktop\\專題照片\\forcoffee.jpg");
		gift_data_vo1.setGIFT_IMG(pic1);
		gift_data_vo1.setGIFT_PT(5);
		gift_data_vo1.setGIFT_LAUNCH_DATE(java.sql.Date.valueOf("2017-09-07"));
		dao.insert(gift_data_vo1);
		System.out.println("ee");
		
//		GIFT_DATA_VO gift_data_vo2=new GIFT_DATA_VO();
//		gift_data_vo2.setGIFT_NAME("小小鋼杯");
//		gift_data_vo2.setGIFT_REMAIN(77);
//		gift_data_vo2.setGIFT_CONT("小鋼杯 大享受");
//		byte[]pic2=getByteArray("C:\\Users\\Java\\Desktop\\專題照片\\a101.jpg");
//		gift_data_vo2.setGIFT_IMG(pic2);
//		gift_data_vo2.setGIFT_PT(5);
//		gift_data_vo2.setGIFT_LAUNCH_DATE(java.sql.Date.valueOf("2017-04-01"));
//		gift_data_vo2.setGIFT_NO("G1000000006");
//		dao.update(gift_data_vo2);
		
//		dao.delete("G1000000007");
		
		
//		GIFT_DATA_VO gift_data_vo3=dao.findByPrimaryKey("G1000000005");
//		System.out.println(gift_data_vo3.getGIFT_NO());
//		System.out.println(gift_data_vo3.getGIFT_NAME());
//		System.out.println(gift_data_vo3.getGIFT_REMAIN());
//		System.out.println(gift_data_vo3.getGIFT_CONT());
//		System.out.println(gift_data_vo3.getGIFT_IMG());
//		System.out.println(gift_data_vo3.getGIFT_PT());
//		System.out.println(gift_data_vo3.getGIFT_LAUNCH_DATE());
		
//		List<GIFT_DATA_VO> list=dao.getAll();
//		for(GIFT_DATA_VO gift:list){
//			System.out.print(gift.getGIFT_NO()+",");
//			System.out.print(gift.getGIFT_NAME()+",");
//			System.out.print(gift.getGIFT_REMAIN()+",");
//			System.out.print(gift.getGIFT_CONT()+",");
//			System.out.print(gift.getGIFT_IMG()+",");
//			System.out.print(gift.getGIFT_PT()+",");
//			System.out.print(gift.getGIFT_LAUNCH_DATE()+",");
//			System.out.println();
//		}
		
		
		
		
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
