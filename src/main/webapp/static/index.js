$.ajaxSetup({
	/** 解决未登录情况下ajax无法重定向到登录页面的问题 */
	complete : function(xhr, textStatus) {
		let redirectUrl = xhr.getResponseHeader("X-Redirect-Url");
		if(redirectUrl){
			window.top.location.href = redirectUrl
		}
	}
});
$.get('http://localhost:8083/world', {}, null, 'json');