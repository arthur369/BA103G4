package com.convert_gift_modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gift_data_modal.GIFT_DATA_VO;

public class CONVERT_GIFTJDBCDAO implements CONVERT_GIFT_DAO_interface{
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid="b0402015";
	String password="02015";
	
	private static final String INSERT_STMT ="insert into convert_gift values('V' || apply_no_seq.nextval,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT ="select * from convert_gift";
	private static final String GET_ONE_STMT="select * from convert_gift where APPLY_NO=?";
	private static final String DELETE = "delete from convert_gift where APPLY_NO=?";
	private static final String UPDATE ="update convert_gift set MEM_AC=?,APPLY_NAME=?,APPLY_PHONE=?,GIFT_NO=?,APPLY_DATE=?,APPLY_STAT=?,APPLY_ADD=?,SEND_DATE=?,SEND_NO=? where APPLY_NO=?";
	
	
	


	@Override
	public void insert(CONVERT_GIFT_VO convert_gift_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
		
			con = DriverManager.getConnection(url, userid, password);
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
	public void update(CONVERT_GIFT_VO convert_gift_VO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
	
				con = DriverManager.getConnection(url, userid, password);
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
	public void delete(String APPLY_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			
				con = DriverManager.getConnection(url, userid, password);
				pstmt=con.prepareStatement(DELETE);
				pstmt.setString(1, APPLY_NO);
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
	public CONVERT_GIFT_VO findByPrimaryKey(String APPLY_NO) {
		// TODO Auto-generated method stub
		CONVERT_GIFT_VO convert_gift_vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
		
				con = DriverManager.getConnection(url, userid, password);
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
		return convert_gift_vo;
	
	}



















	@Override
	public List<CONVERT_GIFT_VO> getAll() {
		List<CONVERT_GIFT_VO> list=new ArrayList<CONVERT_GIFT_VO>();
		CONVERT_GIFT_VO convert_gift_vo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
	
				con = DriverManager.getConnection(url, userid, password);
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

	
	public static void main(String[] args) {
		CONVERT_GIFTJDBCDAO dao=new CONVERT_GIFTJDBCDAO();

//		CONVERT_GIFT_VO convert_gift1=new CONVERT_GIFT_VO();
//		convert_gift1.setMEM_AC("producter71");
//		convert_gift1.setAPPLY_NAME("陳智遠");
//		convert_gift1.setAPPLY_PHONE("0925359524");
//		convert_gift1.setGIFT_NO("G1000000004");
//		convert_gift1.setAPPLY_DATE(java.sql.Date.valueOf("2017-09-07"));
//		convert_gift1.setAPPLY_STAT("待出貨");
//		convert_gift1.setAPPLY_ADD("彰化縣埔鹽鄉角樹村一號");
//		convert_gift1.setSEND_DATE(null);
//		convert_gift1.setSEND_NO(null);
//		dao.insert(convert_gift1);
		
//		CONVERT_GIFT_VO convert_gift2=new CONVERT_GIFT_VO();
//		convert_gift2.setMEM_AC("producter71");
//		convert_gift2.setAPPLY_NAME("陳xx");
//		convert_gift2.setAPPLY_PHONE("0925359524");
//		convert_gift2.setGIFT_NO("G1000000004");
//		convert_gift2.setAPPLY_DATE(java.sql.Date.valueOf("2017-09-07"));
//		convert_gift2.setAPPLY_STAT("已出貨");
//		convert_gift2.setAPPLY_ADD("彰化縣埔鹽鄉角樹村一號");
//		convert_gift2.setSEND_DATE(null);
//		convert_gift2.setSEND_NO(null);
//		convert_gift2.setAPPLY_NO("V1000000007");
//		dao.update(convert_gift2);
		
		
//		dao.delete("V1000000007");
		
//		CONVERT_GIFT_VO convert_gift3=dao.findByPrimaryKey("V1000000002");
//		System.out.println(convert_gift3.getAPPLY_NO());
//		System.out.println(convert_gift3.getMEM_AC());
//		System.out.println(convert_gift3.getAPPLY_NAME());
//		System.out.println(convert_gift3.getAPPLY_PHONE());
//		System.out.println(convert_gift3.getGIFT_NO());
//		System.out.println(convert_gift3.getAPPLY_DATE());
//		System.out.println(convert_gift3.getAPPLY_STAT());
//		System.out.println(convert_gift3.getAPPLY_ADD());
//		System.out.println(convert_gift3.getSEND_DATE());
//		System.out.println(convert_gift3.getSEND_NO());
		
		List<CONVERT_GIFT_VO> list=dao.getAll();
		for(CONVERT_GIFT_VO convert: list){
			System.out.print(convert.getAPPLY_NO());
			System.out.print(convert.getMEM_AC());
			System.out.print(convert.getAPPLY_NAME());
			System.out.print(convert.getAPPLY_PHONE());
			System.out.print(convert.getGIFT_NO());
			System.out.print(convert.getAPPLY_DATE());
			System.out.print(convert.getAPPLY_STAT());
			System.out.print(convert.getAPPLY_ADD());
			System.out.print(convert.getSEND_DATE());
			System.out.print(convert.getSEND_NO());
			System.out.println();
		}
	}
}
