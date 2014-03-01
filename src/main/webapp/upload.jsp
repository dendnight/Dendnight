<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String url = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<html>
<head>

<script type="text/javascript">
	$(function() {
		// 提交表单
		$(".btn-default").click(function() {
			// XXX 校验文件
			
			$(".progress-bar").css("width", "0%");
			$(".progress-bar").html("0%");
			beginUpload();
			$("#upload-form").ajaxSubmit(function(data){
				if(data.t){
					$('#login-modal').modal('show');
					return;
				}
				alert(data.m);
			});
			return false;
		});

	});
	
	function beginUpload() {
		var i = setInterval(function() {
			$.getJSON("<%=url%>gallery/upload-progress.htm", function(data) {
				if(data.t){
					clearInterval(i);
					$('#login-modal').modal('show');
					return;
				}
				var progress = data.progress;
				if(0 == progress.readedBytes){// 上传失败
					clearInterval(i);
					$(".progress-bar").css("width","0%");
					$(".progress-bar").html("0%");
					return;
				}
				var percentage = Math.floor(100 * parseInt(progress.readedBytes) / parseInt(progress.totalBytes));
				//alert(percentage);
				$(".progress-bar").css("width", percentage + "%");
				$(".progress-bar").html(percentage + "%");
				if (100 == percentage)//terminate the procedure.
				{
					clearInterval(i);
					return;
				}
			});
		}, 100);
	}
</script>
</head>

<body>
	<div class="panel panel-default">
		<div class="panel-body">
			<div style="display: none; text-align: center;" class="alert"></div>
			<h2>Hi!</h2>

			<div class="panel panel-default">
				<div class="panel-body">
					<form id="upload-form" action="<%=url%>gallery/upload.htm"
						enctype="multipart/form-data" method="post">
						<input type="file" name="uploadFile" /> <br />
						<button type="submit" data-loading-text="提交中..."
							class="btn btn-default">
							<i class="glyphicon glyphicon-cloud-upload"></i> <span>上传</span>
						</button>
					</form>
				</div>
			</div>
			<div class="progress progress-striped active">
				<div class="progress-bar" role="progressbar" aria-valuemin="0"
					aria-valuemax="100" style="width: 0%">0%</div>
			</div>


			<div style="height: 500px"></div>
		</div>
	</div>
</body>
</html>
