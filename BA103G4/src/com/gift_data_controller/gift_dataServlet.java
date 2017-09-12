package com.gift_data_controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gift_data_modal.GIFT_DATAJDBCDAO;
import com.gift_data_modal.GIFT_DATAJNDIDAO;
import com.gift_data_modal.GIFT_DATA_Service;
import com.gift_data_modal.GIFT_DATA_VO;
import com.google.gson.Gson;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 50 * 1024 * 1024, maxRequestSize = 50* 5 * 1024 * 1024)
public class gift_dataServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action");
		
		if ("getOne_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);
		try{	
			String str = req.getParameter("GIFT_NO");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入贈品編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/gift_data/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			String gift_no=str;
			GIFT_DATA_Service gift_dataSvc=new GIFT_DATA_Service();
			GIFT_DATA_VO gift_data_vo=gift_dataSvc.getOneGift_data(gift_no);
			if ( gift_data_vo == null) {
				errorMsgs.add("查無資料");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/gift_data/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			req.setAttribute("gift_data_vo", gift_data_vo);
			String url = "/emp/listOneGift_data.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
			
		}catch (Exception e) {
			errorMsgs.add("無法取得資料:" + e.getMessage());
			RequestDispatcher failureView = req
					.getRequestDispatcher("/gift_data/select_page.jsp");
			failureView.forward(req, res);
		}
			
		}
		
		  if ("insert".equals(action)) { 
			  
			  List<String> errorMsgs = new LinkedList<String>();
			  req.setAttribute("errorMsgs", errorMsgs);
			
			  try{
				  String gift_name=req.getParameter("GIFT_NAME").trim();
				  String gift_cont=req.getParameter("GIFT_CONT").trim();
				 
				  java.sql.Date gift_launch_date=null;
				 
				  try{
					  gift_launch_date=java.sql.Date.valueOf(req.getParameter("GIFT_LAUNCH_DATE").trim());
					 
				  }catch (IllegalArgumentException e) {
					 
					  gift_launch_date=new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請輸入日期!");
					}
				 
				  Integer gift_remain=null;
				 
				  try{
				  gift_remain=new Integer(req.getParameter("GIFT_REMAIN").trim());
				
				  }catch (NumberFormatException e) {
						gift_remain = 0;
						errorMsgs.add("數量請填數字.");
					}
				  Integer gift_pt=null;
				  try{
					  gift_pt=new Integer(req.getParameter("GIFT_PT").trim());
				  }catch (NumberFormatException e) {
					  gift_pt = 0;
						errorMsgs.add("積分請填數字.");
					}
				 
				 InputStream  is= req.getPart("GIFT_IMG").getInputStream(); 
				 ByteArrayOutputStream buffer = new ByteArrayOutputStream();

				 int nRead;
				 byte[] gift_img = new byte[16384];

				 while ((nRead = is.read(gift_img, 0, gift_img.length)) != -1) {
				   buffer.write(gift_img, 0, nRead);
				 }

				 buffer.flush();
				  
//				  GIFT_DATA_VO gift_data_VO=new GIFT_DATA_VO();
//				  gift_data_VO.setGIFT_NAME(gift_name);
//				  gift_data_VO.setGIFT_CONT(gift_cont);
//				  gift_data_VO.setGIFT_LAUNCH_DATE(gift_launch_date);
//				  gift_data_VO.setGIFT_REMAIN(gift_remain);
//				  gift_data_VO.setGIFT_PT(gift_pt);
//				  gift_data_VO.setGIFT_IMG(gift_img);
				  
				  GIFT_DATA_Service gift_data_service=new GIFT_DATA_Service();
				  GIFT_DATA_VO gift_data_VO=gift_data_service.addGift_data(gift_name,gift_remain,gift_cont,gift_img,gift_pt,gift_launch_date);
				  
				  req.setAttribute("gift_data_VO",gift_data_VO);
				  String url ="/gift_data/listOneGift_data.jsp";
				  RequestDispatcher successView=req.getRequestDispatcher(url);
				  successView.forward(req,res);
				  
			  }catch (Exception e) {
				  
				  errorMsgs.add(e.getMessage());
					errorMsgs.add("反正就是有錯誤");
					RequestDispatcher failureView = req
							.getRequestDispatcher("/gift_data/addGift_data.jsp");
					failureView.forward(req, res);
				}
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
		  }
		
		
	}
	
	
	
	
	
	
	
	
}
