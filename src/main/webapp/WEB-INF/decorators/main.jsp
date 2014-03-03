<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%  
String path = request.getContextPath();  
String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!doctype html>
<html lang="zh-CN">
	<head>
		<title><decorator:title default="Dendnight"/></title>
		<meta charset="UTF-8"/>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1"/>
	    <meta name="author" content="dendnight"/>
		<link rel="stylesheet" href="<%= url %>css/style.css"/>
	    <link rel="stylesheet" href="<%= url %>css/nprogress.css"/>
	    <link rel="stylesheet" href="<%= url %>css/bootstrap.min.css"/>
		<link rel="shortcut icon" type="image/x-icon" href="<%= url %>images/favicon.ico"/>
		<!--[if lt IE 9]>
		<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<script type="text/javascript" src="<%= url %>js/jquery.min.js"></script>
	    <script type="text/javascript" src="<%= url %>js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%= url %>js/jquery.blockUI.js"></script>
		<script type="text/javascript" src="<%= url %>js/jquery.form.min.js"></script>
		<script type="text/javascript" src="<%= url %>js/jquery.nprogress.js"></script>
		<script type="text/javascript" src="<%= url %>js/jquery.validate.min.js"></script>
		<decorator:head/>
    </head>
	<body>
		<div id="wrap">
			<page:applyDecorator name="navbar" encoding="UTF-8"></page:applyDecorator>
			<div class="container">
    			<decorator:body />
    		</div>
    	</div>
		<page:applyDecorator name="footer" encoding="UTF-8"></page:applyDecorator>
    </body>  
</html>  