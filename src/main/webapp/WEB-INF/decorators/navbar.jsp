<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
%>
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
				<li class="active"><a href="#">gallery</a></li>
				<li class="active"><a href="#">gallery</a></li>
				<li class="active"><a href="#">gallery</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%-- 判断是否登录，未登录的只有登录 --%>
				<s:if test="null == #session.loginInfo || null == #session.loginInfo.nickname">
				<li><a href="#" data-toggle="modal" data-target="#modal-login">登录</a></li>
				<li class="dropdown" style="visibility: hidden;">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span>
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="<%=url%>logout.htm">安全退出</a></li>
					</ul>
				</li>
				<script>
				$(function() {
					// 提交表单
					$("#login-submit").click(function() {
						var btn = $(this);
					    btn.button('loading');
						if($('#login-form').valid()){
							$("#login-form").ajaxSubmit(function(data) {
								if (data.s) {
									alert(data.m);//window.location.href="<%= url %>upload.jsp";
									return;
								}else{
									$(".alert").show();
									$(".alert").addClass("alert-danger");
									$(".alert-danger").text(data.m);
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
							username:{required:'<span style=\'color:#a94442\'>帐号不能为空</span>',minlength:'<span style=\'color:#a94442\'>帐号最少为{0}个字符</span>'},
							password:{required:'<span style=\'color:#a94442\'>密码不能为空</span>',minlength:'<span style=\'color:#a94442\'>密码最少为{0}个字符</span>'}
						},highlight: function(element) {
								$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
						},success: function(element) {
								$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
						}
					  });
				});
				</script>
				<!-- Modal -->
				<div class="modal fade" id="modal-login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog" style="max-width:350px">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				        <h3 class="modal-title" id="myModalLabel">欢迎登录“Dendnight”</h3>
				      </div>
				       <form id="login-form" action="<%= url %>login.htm" method="post">
				        <div class="modal-body">
							<div style="display: none;" class="alert">
								<a class="close" data-dismiss="alert" href="#" aria-hidden="true">&times;</a>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" maxlength="20" required name="username" autocomplete="off" placeholder="帐号" autofocus/>
							</div>
							<div class="form-group">
								<input type="password" class="form-control has-error" required maxlength="16" name="password" autocomplete="off" placeholder="密码" />
							</div>
				       </div>
				       <div class="modal-footer">
				        <button type="button" class="btn btn-default" style="width:45%" data-dismiss="modal">取消</button>
				        <button id="login-submit" type="submit" class="btn btn-primary" style="width:45%" data-loading-text="验证中...">登录</button>
				       </div>
					  </form>
				    </div><!-- /.modal-content -->
				  </div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
				</s:if>
				<s:else>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span>
						<s:property value="#session.loginInfo.nickname" />
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="<%=url%>logout.htm">安全退出</a></li>
					</ul>
				</li>
				</s:else>
			</ul>
		</div>
	</div>
</div>