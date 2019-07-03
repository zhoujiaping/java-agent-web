package org.sirenia;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EchoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static{
		copy(new EchoServlet());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		printHello(resp);
	}
	private static EchoServlet copy(EchoServlet echo){
		return echo;
	}
	private void printHello(HttpServletResponse resp) throws IOException {
		ClassLoader cl = this.getClass().getClassLoader();
		Class<?> clClazz = cl.getClass();
		Deprecated dep = clClazz.getAnnotation(Deprecated.class);
		System.out.println(dep);
		PrintWriter pw = resp.getWriter();
		pw.print("hello");
		//pw.print("groovy");
		pw.flush();
	}

}
