package com.a2.springboot.web.Assignment2.Mediator;

import com.a2.springboot.web.Assignment2.Assignment2Application;
import com.a2.springboot.web.Assignment2.Request.Request;
import com.a2.springboot.web.Assignment2.Request.RequestType;
import com.a2.springboot.web.Assignment2.RequestHandlers.RequestHandlerInterface;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Mediator implements MediatorInterface {

   private Map<RequestType, RequestHandlerInterface> typesMap;



   public Mediator(){
       this.typesMap= Assignment2Application.initMap();
   }

    @Override
    public void handle(Request request) {
       typesMap.get(request.getType()).handle(request);

    }


}
