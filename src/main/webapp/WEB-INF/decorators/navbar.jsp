<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
%>

				<script>
				$(function() {
					// 提交表单
					$('#login-submit').click(function() {
						var btn = $(this);
						btn.button('loading');
						if($('#login-form').valid()){
							$("#login-form").ajaxSubmit(function(data) {
								if (data.s) {
									$('#nickname').text(data.o);
									$('#login-li').hide();
									$('#login-li').next('li').show();
									$('#login-modal').modal('hide');
								}else{
									$('.alert').show();
									$('#login-msg').text(data.m);
								}
							});							
						}
						btn.button('reset');
						return false;
					});
			
					$('#login-form').validate({
					    rules: {
					      username: {minlength: 6,required: true},
					      password: {required: true}
					  	},
						messages : {
							username:{required:'帐号不能为空',minlength:'帐号最少为{0}个字符'},
							password:{required:'密码不能为空',minlength:'密码最少为{0}个字符'}
						},highlight: function(element) {
								$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
						},success: function(element) {
								$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
						}
					  });
					
					$('#logout').click(function(){
						$.ajax({
							url: "<%=url%>logout.htm",
							dataType: 'json',
							success: function(data) {
								if(data.s){
									$('#login-li').show();
									$('#login-li').next().hide();
								}
							}
						});
						
					});
				});
				</script>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">切换导航</span> 
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#logo">Dendnight</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">gallery</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%-- 判断是否登录，未登录的只有登录 --%>
				<s:if test="null == #session.loginInfo || null == #session.loginInfo.nickname">
				<li id="login-li"><a href="#" data-toggle="modal" data-target="#login-modal">登录</a></li>
				<li class="dropdown" style="display: none;">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span>
						<span id="nickname"></span>
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li  id="logout"><a href="#logout">安全退出</a></li>
					</ul>
				</li>
				</s:if>
				<s:else>
				<li id="login-li" style="display: none;"><a href="#" data-toggle="modal" data-target="#login-modal">登录</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span>
						<span id="nickname"><s:property value="#session.loginInfo.nickname" /></span>
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li id="logout"><a href="#logout">安全退出</a></li>
					</ul>
				</li>
				</s:else>
			</ul>
		</div>
	</div>
</div>
<%-- Login Model --%>
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" style="max-width:350px">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3 class="modal-title" id="myModalLabel">欢迎登录“Dendnight”</h3>
      </div>
       <form id="login-form" action="<%= url %>login.htm" method="post">
        <div class="modal-body">
  		 <div style="display: none;" class="alert alert-danger">
			<span id="login-msg"></span>
		 </div>
		<div class="form-group">
			<label for="login-username">帐号</label>
			<input id="login-username" type="text" class="form-control" maxlength="16" name="username" autocomplete="off" placeholder="请输入帐号" autofocus/>
		</div>
		<div class="form-group">
		 	<label for="login-password">密码</label>
			<input id="login-password" type="password" class="form-control" maxlength="16" name="password" autocomplete="off" placeholder="请输入密码" />
		</div>
	   </div>
	   <div class="modal-footer">
	       <button type="reset" class="btn btn-default" style="width:45%" data-dismiss="modal">取消</button>
	       <button id="login-submit" type="submit" class="btn btn-primary" style="width:45%" data-loading-text="验证中...">登录</button>
	   </div>
	   </form>
	  </div>
  </div>
</div>