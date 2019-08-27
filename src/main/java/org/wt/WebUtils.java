package org.wt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public abstract class WebUtils {
	/**
	 * 
	 * @param url
	 * @param req
	 * @param resp
	 * @throws IOException
	 * ajax无法重定向，不仅仅是浏览器不会跳转，连响应头部Location和源不同域都直接报错。
	 * 需要前端配合
$.ajaxSetup({
	complete : function(xhr, textStatus) {
		let redirectUrl = xhr.getResponseHeader("X-Redirect-Url");
				if(redirectUrl){
			window.top.location.href = redirectUrl
		}
	}
});
	 */
	public static void redirect(String url,HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.setStatus(302);
		if("XMLHttpRequest".equalsIgnoreCase(req.getHeader("X-Requested-With"))){
			resp.addHeader("X-Redirect-Url", url);
		}else{
			resp.addHeader("Location", url);
		}
		PrintWriter pw = resp.getWriter();
		pw.close();
	}
	public static void writeJson(Object data,HttpServletResponse resp) throws IOException{
		String json = JSON.toJSONString(data);
		resp.addHeader("Content-Type", "application/json; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.write(json);
		pw.close();
	}
	
}
