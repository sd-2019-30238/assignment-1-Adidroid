package com.a2.springboot.web.Assignment2;

import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Request.RequestType;
import com.a2.springboot.web.Assignment2.RequestHandlers.Command.BookCommandHandler;
import com.a2.springboot.web.Assignment2.RequestHandlers.Command.RegisterCommandHandler;
import com.a2.springboot.web.Assignment2.RequestHandlers.Command.UserCommandHandler;
import com.a2.springboot.web.Assignment2.RequestHandlers.Query.BookQueryHandler;
import com.a2.springboot.web.Assignment2.RequestHandlers.Query.UserQueryHandler;
import com.a2.springboot.web.Assignment2.RequestHandlers.RequestHandlerInterface;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Assignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
		Session session= SessionUtil.getSessionFactory().getCurrentSession();

	}


	public static Map<RequestType, RequestHandlerInterface> initMap(){
		Map<RequestType, RequestHandlerInterface> typesMap=new HashMap<>();
		typesMap.put(RequestType.USER_COMMAND,new UserCommandHandler());
		typesMap.put(RequestType.USER_QUERY,new UserQueryHandler());
		typesMap.put(RequestType.BOOK_COMMAND,new BookCommandHandler());
		typesMap.put(RequestType.BOOK_QUERY,new BookQueryHandler());
		typesMap.put(RequestType.REGISTER_COMMAND,new RegisterCommandHandler());

		return typesMap;

	}

}
