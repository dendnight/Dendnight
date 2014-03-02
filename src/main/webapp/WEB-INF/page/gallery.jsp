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
<link rel="stylesheet" href="<%= url %>css/fancybox/jquery.fancybox.css"/>
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
<script type="text/javascript" src="<%=url %>js/jquery.fancybox.min.js"></script>
<script type="text/javascript" src="<%=url %>js/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="<%=url %>js/jquery.masonry.min.js"></script>
<script type="text/javascript">
	var page = 1;
	
	$(function(){
		$('.fancybox').fancybox({openEffect : 'elastic'});
		
		loadGallery(page);
		
		var orig_scroll_height = $("#footer").position().top - jQuery(window).height() - 200;
		$(window).scroll(function() {
			alert(jQuery(window).scrollTop()+":"+jQuery(window).height()+":"+$("body").height());
		});
		/*
		jQuery(window).scroll(function () {
			//console.log(jQuery(this).scrollTop());
			if (jQuery(this).scrollTop() > 100) {
				jQuery('#footer').addClass('showme');
			} else {
				jQuery('#footer').removeClass('showme');
			}
		});
		//alert($(window).height() +":"+ $(window).scrollTop()  +":"+  ($(document).height() - 200));
		//if (0 != $(window).scrollTop() && ($(window).height() + $(window).scrollTop()) >= $(document).height() - 100){
		//loading(); //加载数据函数
			alert(1);
			loadGallery(page++);
		//}
			*/

	});

	
	function loadGallery(page){
		$.ajax({
	        type: "POST",
			url: "<%=url%>gallery/list.htm",
			data:{'page':page},
			dataType: 'json',
			success: function(data) {
				if(data.t){
					$('#login-modal').modal('show');
					return;
				}
				var imgs = "";
				$.each(data.o, function(i, item) {
					imgs = "<div class=\"img-thumbnail\">";
					imgs += "<a class=\"fancybox\" href=\""+"<%=url %>"+item.imagePath+"\" data-fancybox-group=\"gallery\">";
					imgs += "<img src=\""+item.image+"\"></a></div>";
					$("#gallery").append(imgs);
				});
					
				//$("#gallery").html(imgs);
				$('#gallery').masonry({
					 columnWidth: 25,
					 itemSelector: '.img-thumbnail'
				}).masonry( 'appended', imgs );
				setInterval("$('#gallery').masonry('reload');",100);
			}
		});
	}
		
</script>
<style type="text/css">
</style>
</head>

<body>
	<div id="gallery">
	
	</div> 
</body>
</html>
