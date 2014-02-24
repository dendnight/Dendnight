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
<script type="text/javascript" src="<%=path %>js/jquery.nested.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
            type: "POST",
			url: "<%=url%>gallery/list-oneself.htm",
			//data: {"page":page,"title":$("#title").val()},  
			dataType: 'json',
			success: function(data) {
				if(data.t){
					$('#modal-login').modal('show');
					return;
				}

				var img = "";
				$.each(data.o, function(i, item) {
					img += "<img src=\""+item.base64+"\" alt=\"...\" class=\"img-thumbnail\">";
				});
				$('.panel-body').html(img);
				$("#container").nested({
					  animate: true,
					  animationOptions: {
					    speed: 100,
					    duration: 200,
					    queue: true,
					    complete: onComplete
					  }
					});
			}
		});
	});
</script>
<style type="text/css">
.img-thumbnail{
	float: left;
}
</style>
</head>

<body>
	<div class="panel panel-default">
		<div class="panel-body">

		</div>
	</div>
</body>
</html>
