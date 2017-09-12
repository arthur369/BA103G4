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
    <title>����ث~�W�U�[</title>
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
            <div class="fa fa-futbol-o"></div><a class="h3 act" href="act.html"> ���ʼf��</a></a><a class="h3 title" href="#check" aria-expanded="false" aria-controls="check" data-toggle="collapse" style="text-decoration: none;">
            <div class="fa fa-check-circle"></div><span class="h3">���|�޲z</span>
            <ul class="collapse" id="check"><a>�������|</a><a>�ӫ~���|</a><a>�Q�װ����|</a></ul></a><a class="h3 title" href="#mem" aria-expanded="false" aria-controls="mem" data-toggle="collapse" style="text-decoration: none;">
            <div class="fa fa-address-card-o"></div><span class="h3">�|���޲z</span>
            <ul class="collapse" id="mem"><a>�|����ƺ޲z</a><a>�t�ө��a���v</a><a>�n���޲z</a></ul></a><a class="h3 title" href="#admin" aria-expanded="false" aria-controls="admin" data-toggle="collapse" style="text-decoration: none;">
            <div class="fa fa-user-o"> </div><span class="h3">�޲z���޲z</span>
            <ul class="collapse" id="admin"><a>�޲z�b����v</a><a>�b��޲z</a></ul></a><a class="h3 title" href="#gift" aria-expanded="false" aria-controls="gift" data-toggle="collapse" style="text-decoration: none;">
            <div class="fa fa-gift"> </div><span class="h3">���x�~�Ⱥ޲z</span>
            <ul class="collapse" id="gift"><a>�s�i�޲z</a><a>�I���ث~�޲z</a><a href="gift_data.html">�I���ث~�~�Ⱥ޲z</a></ul></a></div>
        <div class="right col-xs-10">
          <div class="col-xs-12 right_top"><img src="images/bear.jpg" alt="">
            <h2>�A�n</h2><a class="fa fa-bell dropdown-toggle" href="#" data-toggle="dropdown"></a>
            <ul class="dropdown-menu">
              <li><a>10�����|���B�z</a></li>
              <li><a>10�����ʥ��f��</a></li>
              <li><a>10���t�ӷ|���ӽХ��f��</a></li>
              <li><a>10���I���ث~�ӽ�</a></li>
            </ul>
          </div>
          <div class="col-xs-12 right_middle">
            <div class="col-xs-12 middle">
              <h2 class="check">�I���ث~�޲z</h2>
              <button class="btn btn-success">�W�[</button>
            </div>
          </div>
          <div class="col-xs-12 right_bottom">
            <div class="row">
              <div class="col-xs-4 col-sm-4">
                <div class="giftcard"><img src="images/cup.jpg" alt="">
                  <div class="info">
                    <h3>���ũ@�تM</h3>
                    <p>������@�تM�A�¤�u���y</p>
                    <h3>�һݿn��50</h3>
                    <div class="getitem">
                      <button class="btn-danger">�U�[</button>
                      <h3>�ѤU10��</h3>
                    </div>
                    <div class="upTime">
                      <h4>�W�[�ɶ�</h4>
                      <h4>2017/08/28</h4>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-xs-4 col-sm-4">
                <div class="giftcard"><img src="images/cup.jpg" alt="">
                  <div class="info">
                    <h3>���ũ@�تM</h3>
                    <p>���šA�W�@�L�G</p>
                    <h3>�һݿn��50</h3>
                    <div class="getitem">
                      <button class="btn-danger">�U�[</button>
                      <h3>�ѤU5��</h3>
                    </div>
                    <div class="upTime">
                      <h4>�W�[�ɶ�</h4>
                      <h4>2017/08/28        </h4>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-xs-4 col-sm-4">
                <div class="giftcard"><img src="images/cup.jpg" alt="">
                  <div class="info">
                    <h3>���~�@�تM</h3>
                    <p>�~�����~�@�رM��</p>
                    <h3>�һݿn��50</h3>
                    <div class="getitem">
                      <button class="btn-danger">�U�[</button>
                      <h3>�ѤU1��</h3>
                    </div>
                    <div class="upTime">
                      <h4>�W�[�ɶ�</h4>
                      <h4>2017/08/28     </h4>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <ul class="pager">
              <li class="previous"><a href="#">�� �W�@��</a></li>
              <li class="next"><a href="#">�U�@�� ��    </a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>