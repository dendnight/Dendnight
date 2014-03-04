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
.gallery {
	margin: 5px;
	padding: 0;
	float: left;
	position: relative;
}
.gallery img {
	background: #fff;
	border: solid 1px #ccc;
	padding: 4px;
}
.gallery span {
	width: 20px;
	height: 18px;
	display: block;
	position: absolute;
	bottom: 10px;
	right: 20px;
	cursor: pointer;
}

.gallery a {
	text-decoration: none;
}
.gallery a:hover img  {
	border-color: #999;
	opacity:0.8;
}

.favorite {
	background: url(<%=url%>images/favorite.gif) no-repeat;
}
.favorite-selected {
	background: url(<%=url%>images/favorite.gif) no-repeat;
	background-position: left -22px;
}

</style>
<script type="text/javascript" src="<%=url %>js/jquery.isotope.min.js"></script>
<script type="text/javascript" src="<%=url %>js/jquery.fancybox.min.js"></script>
<script type="text/javascript" src="<%=url %>js/jquery.mousewheel.min.js"></script>
<script type="text/javascript">
	var page = 1,totalPage = 1;// 当前页、总页数
	
	$(function(){
		loadGallery(page);
		
		$('.fancybox').fancybox({openEffect : 'elastic'});

		$gallery = $("#gallery");
		$gallery.isotope({
			itemSelector : '.gallery'
		});	

		// 滚动刷新
		$(window).scroll(function () {
            //console.log($(window).height() +":"+ $(window).scrollTop() +":"+ $("#gallery").height());
            if ($(window).height() + $(window).scrollTop() >= $("#gallery").height()+100) {// XXX 计算后的
            	++page;
            	if(page > totalPage){// 当前页大于总页数，不给予loading
            		$("#loading").text("没有更多图片了..");
            		return;
            	}
            	$("#loading").show();
            	loadGallery(page);
            };
            
        });

	});

	
	function loadGallery(page){
		NProgress.start();
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
					if(null != item.imagePath){
						items.push("<div class=\"gallery\">");
						items.push("<a class=\"fancybox\" href=\""+"<%=url %>"+item.imagePath+"\" data-fancybox-group=\"gallery\">");
						items.push("<img src=\""+item.image+"\"></a><span class=\"favorite\" onclick=\"favorite(this);return false;\">1</span></div>");
					}

					if(null != item.totalPage){
						totalPage = item.totalPage
					}
				});
				var newEls = items.join('');

				var content = $(newEls);
				$gallery.append(content);
				$gallery.imagesLoaded(function(){	
					$gallery.isotope('appended', content).isotope('reLayout');
				});
			}
		});
		NProgress.done();
	}
	
	function favorite(){
		//alert(1);
		//alert($(this).html());
		$('.favorite').removeClass('favorite').addClass('favorite-selected');
	}
</script>
</head>

<body>
	<div id="gallery">
	
	</div>
	<div id="loading" style="text-align: center;display: none;">
		<img alt="正在加载" src="<%=url %>images/loading.gif"/>
	</div>
</body>
</html>
