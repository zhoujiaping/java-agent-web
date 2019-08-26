package org.wt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EchoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		throw new RuntimeException("post method is not supported!");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		printHello(resp);
	}

	private void printHello(HttpServletResponse resp) throws IOException {
		PrintWriter pw = resp.getWriter();
		pw.print("get "+this.getClass().getName());
		pw.flush();
	}

}
