package com.mq.web;

import com.mq.productor.Productor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MyServlet extends HttpServlet {

   /* private Productor productor;

    public void setProductor(Productor productor) {
        this.productor = productor;
    }
*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Productor productor = (Productor) ac.getBean("productor");
        Map<String,String> map = new HashMap<>();
        map.put("product", UUID.randomUUID().toString());
        productor.sendMessage(map);
    }
}
