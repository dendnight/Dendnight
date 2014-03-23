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
<link rel="stylesheet" href="<%= url %>css/highslide/highslide.css"/>
<style type="text/css">

.highslide-gallery{
	height:100%;
}

.item {
	margin: 5px 5px;
	padding: 0;
	float: left;
	position: relative;
}
.item img {
	background: #fff;
	border: solid 1px #ccc;
	padding: 4px;
	opacity:0.9;
}
.item span {
	width: 20px;
	height: 18px;
	display: block;
	position: absolute;
	bottom: 10px;
	right: 20px;
	cursor: pointer;
}

.item a {
	text-decoration: none;
}
.item a:hover img  {
	border-color: #999;
	opacity:1;
}

.favorite {
	background: url(<%=url%>images/favorite.gif) no-repeat;
}
.favorite-selected {
	background: url(<%=url%>images/favorite.gif) no-repeat;
	background-position: left -22px;
}

</style>
<script type="text/javascript" src="<%=url %>js/jquery.masonry.min.js"></script>
<script type="text/javascript" src="<%=url %>js/highslide-with-gallery.min.js"></script>
<script type="text/javascript">
hs.graphicsDir = '<%=url %>css/highslide/graphics/';
hs.align = 'center';
hs.transitions = ['expand', 'crossfade'];
hs.outlineType = 'rounded-white';
hs.fadeInOut = true;
//hs.dimmingOpacity = 0.75;

// Add the controlbar
hs.addSlideshow({
	//slideshowGroup: 'group1',
	interval: 5000,
	repeat: false,
	useControls: true,
	fixedControls: 'fit',
	overlayOptions: {
		opacity: 0.75,
		position: 'bottom center',
		hideOnMouseOut: true
	}
});
</script>
<script type="text/javascript">
	var page = 1,totalPage = 1;// 当前页、总页数
	
	$(function(){
		loadGallery(page);

		$gallery = $(".highslide-gallery");
		$gallery.masonry({
			itemSelector:'.item',
			columnWidth:210,
			gutterWidth:10,
			isFitWidth:true,
			animationOptions:{ queue: false, duration: 5000 ,speed:100}
		});

		// 滚动刷新
		$(window).scroll(function () {
            //console.log($(window).height() +":"+ $(window).scrollTop() +":"+ $("#gallery").height());
            if ($(window).height() + $(window).scrollTop() >= $(".highslide-gallery").height()+100) {// XXX 计算后的
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
						items.push("<div class=\"item\"><a class=\"\" class=\"highslide\" ");
						items.push("onclick=\"return hs.expand(this);\" href='<%=url %>"+item.imagePath+"' >");
						items.push("<img src=\""+item.image+"\"></a></div>");
					}

					if(null != item.totalPage){
						totalPage = item.totalPage;
					}
				});

				var newEls = items.join('');
				var content = $(newEls);
				$gallery.append(content);
				$gallery.imagesLoaded(function(){		
					$gallery.masonry('appended', content).masonry('resize');
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
	<div class="highslide-gallery">
	
	</div>
	<div id="loading" style="text-align: center;display: none;">
		<img alt="正在加载" src="<%=url %>images/loading.gif"/>
	</div>
</body>
</html>
