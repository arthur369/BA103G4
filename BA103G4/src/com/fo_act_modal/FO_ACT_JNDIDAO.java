package com.fo_act_modal;

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

public class FO_ACT_JNDIDAO implements FO_ACT_DAO_interface{

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
	private static final String INSERT_STMT ="insert into fo_act values(?,?,?)";
	private static final String GET_ALL_STMT ="select * from fo_act";
	private static final String GET_ONE_STMT="select * from fo_act where MEM_AC=? AND ACT_NO=?";
	private static final String DELETE = "delete from fo_act where MEM_AC=? AND ACT_NO=?";
	private static final String UPDATE ="update fo_act set FO_ACT_DATE=? where MEM_AC=? AND ACT_NO=?";
	@Override
	public void insert(FO_ACT_VO fo_act_VO) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, fo_act_VO.getMEM_AC());
			pstmt.setString(2, fo_act_VO.getACT_NO());
			pstmt.setDate(3, fo_act_VO.getFO_ACT_DATE());
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
	public void update(FO_ACT_VO fo_act_VO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setDate(1,fo_act_VO.getFO_ACT_DATE());
			pstmt.setString(2, fo_act_VO.getMEM_AC());
			pstmt.setString(3, fo_act_VO.getACT_NO());
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
	public void delete(String MEM_AC, String ACT_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE);
			pstmt.setString(1,MEM_AC);
			pstmt.setString(2, ACT_NO);
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
	public FO_ACT_VO findByPrimaryKey(String MEM_AC, String ACT_NO) {
		// TODO Auto-generated method stub
		 FO_ACT_VO fo_act_vo=null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		 
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);
				pstmt.setString(1, MEM_AC);
				pstmt.setString(2, ACT_NO);
				 rs=pstmt.executeQuery();
				 
				 while(rs.next()){
					 fo_act_vo=new FO_ACT_VO();
					 fo_act_vo.setMEM_AC(rs.getString("MEM_AC"));
					 fo_act_vo.setACT_NO(rs.getString("ACT_NO"));
					 fo_act_vo.setFO_ACT_DATE(rs.getDate("FO_ACT_DATE"));
					 
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
			return  fo_act_vo;
		 
	}
	@Override
	public List<FO_ACT_VO> getAll() {
		List<FO_ACT_VO> list=new ArrayList<FO_ACT_VO>();
		 FO_ACT_VO fo_act_vo=null;
		 Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					fo_act_vo=new FO_ACT_VO();
					fo_act_vo.setMEM_AC(rs.getString("MEM_AC"));
					fo_act_vo.setACT_NO(rs.getString("ACT_NO"));
					fo_act_vo.setFO_ACT_DATE(rs.getDate("FO_ACT_DATE"));
					list.add(fo_act_vo);
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
