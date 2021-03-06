<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.gift_data_modal.*"%>
<%
GIFT_DATA_VO gift_data_VO = (GIFT_DATA_VO) request.getAttribute("GIFT_DATA_VO");
%>




<html>
<head>
<title>員工資料新增 - addGift_data.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>員工資料新增 - addGift_data.jsp</h3>
		</td>
		<td>
		   <a href="select_page.jsp"><img src="images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>資料員工:</h3>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<FORM METHOD="post" ACTION="gift_dataServlet" name="form1" enctype="multipart/form-data">
<table border="0">

	<tr>
		<td>贈品名稱:</td>
		<td><input type="TEXT" name="GIFT_NAME" size="45" 
			value="<%= (gift_data_VO==null)? "陶杯" : gift_data_VO.getGIFT_NAME()%>" /></td>
	</tr>
	<tr>
		<td>剩餘數量:</td>
		<td><input type="TEXT" name="GIFT_REMAIN" size="45"
			value="<%= (gift_data_VO==null)? 30 : gift_data_VO.getGIFT_REMAIN()%>" /></td>
	</tr>
	<tr>
	
		<%java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());%>
		
		
		
		
		<td>贈品上架時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="GIFT_LAUNCH_DATE" value="<%= (gift_data_VO==null)? date_SQL : gift_data_VO.getGIFT_LAUNCH_DATE()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','GIFT_LAUNCH_DATE','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="開始日期"></a>
		</td>
	</tr>
	<tr>
		<td>贈品描述:</td>
		<td><input type="TEXT" name="GIFT_CONT" size="45"
			value="<%= (gift_data_VO==null)? "沒有" : gift_data_VO.getGIFT_CONT()%>" /></td>
	</tr>
	<tr>
		<td>兌換所需積分:</td>
		<td><input type="TEXT" name="GIFT_PT" size="45"
			value="<%= (gift_data_VO==null)? "100" : gift_data_VO.getGIFT_PT()%>" /></td>
	</tr>
<tr>
		<td>贈品圖片:</td>
		<td><input type="file" name="GIFT_IMG" size="45"
			value="<%= (gift_data_VO==null)? "hextoraw('b0102')" : gift_data_VO.getGIFT_IMG()%>" /></td>
	</tr>
	

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>
