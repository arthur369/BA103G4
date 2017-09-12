package com.ad_modal;

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

import com.gift_data_modal.GIFT_DATAJDBCDAO;

public class AD_JDBCDAO implements AD_DAO_interface{
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid="b0402015";
	String password="02015";
	
	private static final String INSERT_STMT ="insert into ad values('D' || ad_no_seq.nextval,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from ad";
	private static final String GET_ONE_STMT="select * from ad where AD_NO=?";
	private static final String DELETE = "delete from ad where ad_no=?";
	private static final String UPDATE ="update ad set PROD_NO=?,AD_TITLE=?,AD_IMG=?,AD_OP_DATE=?,AD_ED_DATE=? where AD_NO=?";
	

	

	@Override
	public void insert(AD_VO ad_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			
				con = DriverManager.getConnection(url, userid, password);
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
	public void update(AD_VO ad_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
	
				con = DriverManager.getConnection(url, userid, password);
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
	public void delete(String AD_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
		
				con = DriverManager.getConnection(url, userid, password);
				pstmt=con.prepareStatement(DELETE);
				pstmt.setString(1, AD_NO);
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
	public AD_VO findByPrimaryKey(String AD_NO) {
		
		AD_VO ad_vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);

				con = DriverManager.getConnection(url, userid, password);
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
			Class.forName(driver);
	
				con = DriverManager.getConnection(url, userid, password);
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
		AD_JDBCDAO dao=new AD_JDBCDAO();
		
//		AD_VO ad_vo1=new AD_VO();
//		ad_vo1.setPROD_NO("P1000000003");
//		ad_vo1.setAD_TITLE("跳樓大拍賣");
//		byte[] pic=getByteArray("C:\\Users\\Java\\Desktop\\專題照片\\coffee bean.jpg");
//		ad_vo1.setAD_IMG(pic);
//		ad_vo1.setAD_OP_DATE(java.sql.Date.valueOf("2017-09-05"));
//		ad_vo1.setAD_ED_DATE(java.sql.Date.valueOf("2017-09-07"));
//		dao.insert(ad_vo1);
		
//		AD_VO ad_vo2=new AD_VO();
//		ad_vo2.setAD_NO("D1000000004");
//		ad_vo2.setPROD_NO("P1000000003");
//		ad_vo2.setAD_TITLE("跳樓");
//		byte[] pic=getByteArray("C:\\Users\\Java\\Desktop\\專題照片\\coffee bean.jpg");
//		ad_vo2.setAD_IMG(pic);
//		ad_vo2.setAD_OP_DATE(java.sql.Date.valueOf("2017-09-15"));
//		ad_vo2.setAD_ED_DATE(java.sql.Date.valueOf("2017-09-17"));
//		dao.update(ad_vo2);
		
//		dao.delete("D1000000004");
		
		AD_VO ad_vo3=dao.findByPrimaryKey("D1000000003");
		System.out.println(ad_vo3.getAD_NO());
		System.out.println(ad_vo3.getPROD_NO());
		System.out.println(ad_vo3.getAD_TITLE());
		System.out.println(ad_vo3.getAD_IMG());
		System.out.println(ad_vo3.getAD_OP_DATE());
		System.out.println(ad_vo3.getAD_ED_DATE());
		
		
		
		List<AD_VO> list=dao.getAll();
		for(AD_VO ad_vo4:list){
			System.out.print(ad_vo4.getAD_NO());
			System.out.print(ad_vo4.getPROD_NO());
			System.out.print(ad_vo4.getAD_TITLE());
			System.out.print(ad_vo4.getAD_IMG());
			System.out.print(ad_vo4.getAD_OP_DATE());
			System.out.print(ad_vo4.getAD_ED_DATE());
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
