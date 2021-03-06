<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.gift_data_modal.*"%>
<html>
<head><title>IBM Emp: Home</title></head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>IBM Emp: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>


<p>This is the Home page for IBM Emp: Home</p>

<h3>資料查詢:</h3>
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

<ul>
  <li><a href='listAllEmp.jsp'>List</a> all Emps. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="gift_dataServlet" >
        <b>兌換贈品編號 (如G1000000001):</b>
        <input type="text" name="GIFT_NO">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="gift_dataSvc" scope="page" class="com.gift_data_modal.GIFT_DATA_Service" />
   
  <li>
     <FORM METHOD="post" ACTION="gift_dataServlet" >
       <b>兌換贈品編號:</b>
       <select size="1" name="GIFT_NO">
         <c:forEach var="gift_data_VO" items="${gift_dataSvc.all}" > 
          <option value="${gift_data_VO.GIFT_NO}">${gift_data_VO.GIFT_NO}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="gift_dataServlet" >
       <b>選擇贈品名稱:</b>
       <select size="1" name="GIFT_NO">
         <c:forEach var="gift_data_VO" items="${gift_dataSvc.all}" > 
          <option value="${gift_data_VO.GIFT_NO}">${gift_data_VO.GIFT_NAME}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
     </FORM>
  </li>
</ul>


<h3>贈品管理</h3>

<ul>
  <li><a href='addGift_data.jsp'>Add</a> a new Gift_Data.</li>
</ul>

</body>

</html>
