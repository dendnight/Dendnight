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
<script type="text/javascript" src="<%=url %>js/jquery.masonry.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
            type: "POST",
			url: "<%=url%>gallery/list.htm",
			//data: {"page":page,"title":$("#title").val()},  
			dataType: 'json',
			success: function(data) {
				if(data.t){
					$('#modal-login').modal('show');
					return;
				}

				var imgs = [];
				var img = null;
				$.each(data.o, function(i, item) {
					img = document.createElement("img");
					img.src = item.base64;
					img.className="img-thumbnail";
					imgs.push(img);
				});
				
				$("#container").html(imgs);
				
			}
		});

		// initialize
		$('#container').masonry({
		  columnWidth: 25,
		  itemSelector: '.img-thumbnail'
		});
		setTimeout("$('#container').masonry('reload')",100);
		// 改变窗口后reload瀑布流
	    $(window).load(function() {
	        $('#container').masonry('reload');
	    });
		// 改变窗口后reload瀑布流
	    $(window).resize(function() {
	        $('#container').masonry('reload');
	    });
		
	});
</script>
<style type="text/css">
</style>
</head>

<body>
	<div id="container">
	
	</div> 
</body>
</html>
