<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="java.util.*" %>
<%@ page import="com.gift_data_modal.GIFT_DATA_VO" %>

<!DOCTYPE html>
<html>
  <head>
  <% List<GIFT_DATA_VO>gift_data_list =(List<GIFT_DATA_VO>) request.getAttribute("gift_data_list"); %>
  <%  if(gift_data_list==null){ %>
  <% System.out.print(request.getContextPath()+"/gift_dataServlet"); %>
  <jsp:forward page="gift_dataServlet"  />
  <% } %>
  
    <meta charset="UTF-8">
    <title>後端贈品上下架</title>
    <link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/gift_data.css">
  </head>
  <body>
    <div class="container_fluid titlebar"><a class="form-inline titlebarForm" href="main.html"><img class="icon" src="images/BeanLifeLogo2.png" alt="">
        <h1>Bean-Life</h1></a></div>
    <div class="container card">
      <div class="row composing">
        <div class="col-xs-2 left"><a class="h3 title" href="#action" aria-expanded="false" aria-controls="action" data-toggle="collapse" style="text-decoration: none;">
            <div class="fa fa-futbol-o"></div><a class="h3 act" href="act.html"> 活動審核</a></a><a class="h3 title" href="#check" aria-expanded="false" aria-controls="check" data-toggle="collapse" style="text-decoration: none;">
            <div class="fa fa-check-circle"></div><span class="h3">檢舉管理</span>
            <ul class="collapse" id="check"><a>評論檢舉</a><a>商品檢舉</a><a>討論區檢舉</a></ul></a><a class="h3 title" href="#mem" aria-expanded="false" aria-controls="mem" data-toggle="collapse" style="text-decoration: none;">
            <div class="fa fa-address-card-o"></div><span class="h3">會員管理</span>
            <ul class="collapse" id="mem"><a>會員資料管理</a><a>廠商店家授權</a><a>積分管理</a></ul></a><a class="h3 title" href="#admin" aria-expanded="false" aria-controls="admin" data-toggle="collapse" style="text-decoration: none;">
            <div class="fa fa-user-o"> </div><span class="h3">管理員管理</span>
            <ul class="collapse" id="admin"><a>管理帳戶授權</a><a>帳戶管理</a></ul></a><a class="h3 title" href="#gift" aria-expanded="false" aria-controls="gift" data-toggle="collapse" style="text-decoration: none;">
            <div class="fa fa-gift"> </div><span class="h3">平台業務管理</span>
            <ul class="collapse" id="gift"><a>廣告管理</a><a>兌換贈品管理</a><a href="gift_data.html">兌換贈品業務管理</a></ul></a></div>
        <div class="right col-xs-10">
          <div class="col-xs-12 right_top"><img src="images/bear.jpg" alt="">
            <h2>你好</h2><a class="fa fa-bell dropdown-toggle" href="#" data-toggle="dropdown"></a>
            <ul class="dropdown-menu">
              <li><a>10項檢舉未處理</a></li>
              <li><a>10項活動未審核</a></li>
              <li><a>10項廠商會員申請未審核</a></li>
              <li><a>10項兌換贈品申請</a></li>
            </ul>
          </div>
          <div class="col-xs-12 right_middle">
            <div class="col-xs-12 middle">
              <h2 class="check">兌換贈品管理</h2>
              <button class="btn btn-success">上架</button>
            </div>
          </div>
          <div class="col-xs-12 right_bottom">
            <div class="row">
              <div class="col-xs-4 col-sm-4">
                <div class="giftcard"><img src="images/cup.jpg" alt="">
                  <div class="info">
                    <h3>高級咖啡杯</h3>
                    <p>精美的咖啡杯，純手工打造</p>
                    <h3>所需積分50</h3>
                    <div class="getitem">
                      <button class="btn-danger">下架</button>
                      <h3>剩下10個</h3>
                    </div>
                    <div class="upTime">
                      <h4>上架時間</h4>
                      <h4>2017/08/28</h4>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-xs-4 col-sm-4">
                <div class="giftcard"><img src="images/cup.jpg" alt="">
                  <div class="info">
                    <h3>頂級咖啡杯</h3>
                    <p>頂級，獨一無二</p>
                    <h3>所需積分50</h3>
                    <div class="getitem">
                      <button class="btn-danger">下架</button>
                      <h3>剩下5個</h3>
                    </div>
                    <div class="upTime">
                      <h4>上架時間</h4>
                      <h4>2017/08/28        </h4>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-xs-4 col-sm-4">
                <div class="giftcard"><img src="images/cup.jpg" alt="">
                  <div class="info">
                    <h3>極品咖啡杯</h3>
                    <p>品嘗極品咖啡專用</p>
                    <h3>所需積分50</h3>
                    <div class="getitem">
                      <button class="btn-danger">下架</button>
                      <h3>剩下1個</h3>
                    </div>
                    <div class="upTime">
                      <h4>上架時間</h4>
                      <h4>2017/08/28     </h4>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <ul class="pager">
              <li class="previous"><a href="#">← 上一頁</a></li>
              <li class="next"><a href="#">下一頁 →    </a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>