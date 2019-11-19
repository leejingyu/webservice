package com.dbgo.webservicedemo.service;

import com.dbgo.webservicedemo.Model.User;
import com.dbgo.webservicedemo.util.DocUtil;

import javax.jws.WebService;

import org.jdom2.Document;
import org.jdom2.Element;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
 
 
 
@WebService(
		targetNamespace="http://service.webservicedemo.dbgo.com/",
		endpointInterface = "com.dbgo.webservicedemo.service.UserService",
		serviceName="UserService")
public class UserServiceImpl implements UserService {
    private Map<String, User> userMap = new HashMap<String, User>();
    public UserServiceImpl() {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId("411001");
        user.setUsername("zhansan");
        user.setAge("20");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411002");
        user.setUsername("lisi");
        user.setAge("30");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411003");
        user.setUsername("wangwu");
        user.setAge("40");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);
    }
    @Override
    public String getName(String userId) {
        return "liyd-" + userId;
    }
    @Override
    public User getUser(String userId) {
        User user= userMap.get(userId);
        return user;
    }

    @Override
    public ArrayList<User> getAlLUser() {
        ArrayList<User> users=new ArrayList<>();
        userMap.forEach((key,value)->{users.add(value);});
        return users;
    }
	@Override
	public String xmlInfo(String RequestInfo) throws Exception {
		 // 创建根节点 list;
        Element root = new Element("userreq");  

        // 根节点添加到文档中；  

        Document doc = new Document(root);  

        // 此处 for 循环可替换成 遍历 数据库表的结果集操作;  

     // 创建节点 user;  

        Element elementHead = new Element("head");  

        // 给 user 节点添加属性 id;  

        //elements.setAttribute("id", "" + i);  

        // 给 user 节点添加子节点并赋值；  

        // new Element("name")中的 "name" 替换成表中相应字段，setText("xuehui")中 "xuehui  

        // 替换成表中记录值；  

        elementHead.addContent(new Element("code").setText("xuehui"));  

        elementHead.addContent(new Element("sid").setText("28"));  

        elementHead.addContent(new Element("timestamp").setText("Male"));
        
        elementHead.addContent(new Element("serviceid").setText("Male"));

        // 给父节点list添加user子节点;  
        Element elementBody = new Element("Body"); 
        elementBody.addContent(new Element("appacctid").setText("Male"));
        elementBody.addContent(new Element("token").setText("Male"));
        
        
        root.addContent(elementHead); 
        root.addContent(elementBody); 
        return DocUtil.doc2String(doc); 
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println( new UserServiceImpl().xmlInfo(""));
	}
	 
}
