<%@page import="databaseConnect.Connect"%>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_component/all_css.jsp" %>
<style type="text/css">
            .back-img{
                background: url("img/image1.jpg");
                width:100%;
                height: 80vh;
                background-repeat: no-repeat;
                background-size: contain;
                background-position: center center;
            }
        </style>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>

<div class="container-fluid back-img">
            <div class="text-center">
                <h1 class="text-grey p-4">
                     Job Posting Portal
                </h1>
            </div>
            
        </div>
        
<%@include file="all_component/footer.jsp"%>
</body>
</html>

