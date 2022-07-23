package com.me.controller.Client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.domain.User;
import com.me.exception.UserExistException;
import com.me.factory.ServiceFactory;
import com.me.service.IUserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "注册Servlet", urlPatterns = { "/Register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 封装模型对象user
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setTelephone(request.getParameter("telephone"));
		user.setGender(request.getParameter("sex"));
		user.setIntroduce(request.getParameter("introduction"));

		IUserService service = ServiceFactory.getUserServicenstance();
		// 调用service层提供的注册用户服务实现用户注册
		try {
			service.register(user);
			response.sendRedirect(request.getContextPath() + "/client/registersuccess.jsp");
		} catch (UserExistException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("RegisterUI").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
