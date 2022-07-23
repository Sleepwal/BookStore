package com.me.controller.Admin;

import com.me.dao.UserDao;
import com.me.domain.User;
import com.me.factory.DaoFactory;
import com.me.util.PageHelp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class QueryUserByPage
 */
@WebServlet("/QueryUserByPage")
public class UserQueryByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserQueryByPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String curPage = request.getParameter("curPage");
	    //默认显示首页
		if(curPage == null) {
			curPage = "0" ;
		}

		int currentPage = Integer.parseInt( curPage );
		currentPage = Math.max(currentPage, 0);
		//将分页所需的5个字段（其中有1个自动计算，因此实际只需要封装4个即可），封装到pageHelp对象之中
		PageHelp<User> pageHelp = new PageHelp<User>();
		//1、封装当前页currentPage到pageHelp对象中
		pageHelp.setCurrentPage(currentPage);

		//注意 封装顺序
		UserDao usersDao  = DaoFactory.getUserDAOInstance();
		int totalCount = usersDao.getTotalCount() ;//总数据
		//2、封装总数据数totalCount到pageHelp对象中
		pageHelp.setTotalCount(totalCount);

		//每页显示2条数据，用户自己定义
		int pageSize = 2;
		//3、封装页面大小pageSize到pageHelp对象中
		pageHelp.setPageSize(pageSize);

		if(currentPage > pageHelp.getTotalPage() - 1){
			currentPage = pageHelp.getTotalPage() - 1;
			pageHelp.setCurrentPage(pageHelp.getTotalPage() - 1);
		}
		/* currentPage：当前页（页码） ，pageSize：页面大小
	  	 users :当前页的数据集合（当前页的所有用户）
		*/
		List<User>  users  = usersDao.queryUsersByPage(currentPage, pageSize);

		//4、封装当前页的数据集合  users到pageHelp对象中
		pageHelp.setList(users);

		//请求转发
		request.setAttribute("pageHelp", pageHelp);
		request.getRequestDispatcher("/admin/login/home.jsp?item=user_list").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
