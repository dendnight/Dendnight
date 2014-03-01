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
<link rel="stylesheet" href="<%= url %>css/image.css"/>
<style type="text/css">

.img-thumbnail{
	margin-top:20px;
}

@media screen and(min-width:540px){
	.img-thumbnail,.img-thumbnail img{
		width:100%;
	}
}
@media screen and(max-width:980px){
	.img-thumbnail img{
		width:25%;
	}
}
</style>
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
					$('#login-modal').modal('show');
					return;
				}

				var imgs = "";
				$.each(data.o, function(i, item) {
					imgs += "<div class=\"img-thumbnail\"><a href=\"#\"><img src=\""+item.base64+"\"></a></div>";
				});
				
				$("#container").html(imgs);
				$('#container')
				  // initialize Masonry
				  .masonry({
					  columnWidth: 25,
					  itemSelector: '.img-thumbnail'
					})
				  // now okay to use methods
				  .masonry( 'appended', imgs );

			}
		});

		// initialize Masonry
		setTimeout("$('#container').masonry('reload');",100);
		/*$('#container').masonry({
			  columnWidth: 25,
			  itemSelector: '.img-thumbnail'
			});
		// 改变窗口后reload瀑布流
	    $(window).load(function() {
	        $('#container').masonry('reload');
	    });
		// 改变窗口后reload瀑布流
	    $(window).resize(function() {
	        $('#container').masonry('reload');
	    });
		*/
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
