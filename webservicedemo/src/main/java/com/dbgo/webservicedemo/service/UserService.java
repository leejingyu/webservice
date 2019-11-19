package com.dbgo.webservicedemo.service;

import com.dbgo.webservicedemo.Model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface UserService {
    @WebMethod
    String getName(@WebParam(name = "userId") String userId);

    @WebMethod
    User getUser(String userI);

    @WebMethod
    ArrayList<User> getAlLUser();
    
    //封装Document数据，返回XML字符串  
    @WebMethod
    public  @WebResult(name="ReponseInfo") String xmlInfo(@WebParam(name = "RequestInfo") String RequestInfo) throws Exception;
}
