$(function() {

	// 滚动刷新
	$(window).scroll(function() {
		// top按钮
		if ($(window).scrollTop() > 100) {
			$("#gotop-div").fadeIn(1000);// 以1秒的间隔渐显id=gotop的元素
		} else {
			$("#gotop-div").fadeOut(1000);// 以1秒的间隔渐隐id=gotop的元素
		}
	});

	// top点击
	$('#gotop-btn').click(function() {
		$('body,html').animate({
			scrollTop : 0
		}, 1000);
	});

	// 提交表单
	$('#login-submit').click(function() {
		var btn = $(this);
		btn.button('loading');
		if ($('#login-form').valid()) {
			NProgress.start();
			$("#login-form").ajaxSubmit(function(data) {
				if (data.s) {
					$.growlUI(data.m);
					$('#nickname').text(data.o);
					$('#login-li').hide();
					$('#login-li').next('li').show();
					$('#login-modal').modal('hide');
				} else {
					$('.alert').show();
					$('#login-msg').text(data.m);
				}
			});
			NProgress.done();
		}
		btn.button('reset');
		return false;
	});

	// 表单验证
	$('#login-form').validate(
			{
				rules : {
					username : {
						minlength : 6,
						required : true
					},
					password : {
						required : true
					}
				},
				messages : {
					username : {
						required : '帐号不能为空',
						minlength : '帐号最少为{0}个字符'
					},
					password : {
						required : '密码不能为空',
						minlength : '密码最少为{0}个字符'
					}
				},
				highlight : function(element) {
					$(element).closest('.form-group')
							.removeClass('has-success').addClass('has-error');
				},
				success : function(element) {
					$(element).closest('.form-group').removeClass('has-error')
							.addClass('has-success');
				}
			});

	$('#logout').click(function() {
		NProgress.start();
		$.ajax({
			url : "logout.htm",
			dataType : 'json',
			success : function(data) {
				if (data.s) {
					$('#login-li').show();
					$('#login-li').next().hide();
					$.growlUI(data.m);
				}
			}
		});
		NProgress.done();
	});

});