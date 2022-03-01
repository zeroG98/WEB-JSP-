package mr.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// 모든 POJO(Plain Old Java Object)가 가지게될 메소드
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException;
}
