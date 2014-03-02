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
	margin:20px 5px 0px 5px;
}

.img-thumbnail img{
	width:100%;
}

</style>
<script type="text/javascript" src="<%=url %>js/jquery.isotope.min.js"></script>
<script type="text/javascript" src="<%=url %>js/jquery.fancybox.min.js"></script>
<script type="text/javascript" src="<%=url %>js/jquery.mousewheel.min.js"></script>
<script type="text/javascript">
	var page = 1;
	
	$(function(){
		$('.fancybox').fancybox({openEffect : 'elastic'});

		$gallery = $("#gallery");
		
		$gallery.isotope({
			itemSelector : '.img-thumbnail'
		});	
		
		loadGallery(page);
		
		// 滚动刷新
		$(window).scroll(function () {
            console.log($(window).height() +":"+ $(window).scrollTop() +":"+ $("#gallery").height());
            if ($(window).height() + $(window).scrollTop() >= $("#gallery").height()) {
            	$("#lodding").show();
            	loadGallery(++page);
            };
        });

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
				var items = [];
				$.each(data.o, function(i, item) {
					items.push("<div class=\"img-thumbnail\">");
					items.push("<a class=\"fancybox\" href=\""+"<%=url %>"+item.imagePath+"\" data-fancybox-group=\"gallery\">");
					items.push("<img src=\""+item.image+"\"></a></div>");
				});
				var newEls = items.join('');

				var content = $(newEls);
				$gallery.append(content);
				$gallery.imagesLoaded(function(){	
					$gallery.isotope('appended', content).isotope('reLayout');
				});
				
				$("#lodding").hide();
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
	<div id="lodding" style="text-align: center;display: none;">
		正在加载...
	</div>
</body>
</html>
