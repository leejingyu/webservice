package com.dbgo.webservicedemo.util;

import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileWriter;  
import java.io.StringReader;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;  
 
public class DocUtil {
	/**
	* Document转换为字符串   
	* @param  doc    Document
	* @return xmlStr 字符串   
	* @throws Exception
	*/
	public static String doc2String(Document doc) throws Exception {
	Format format = Format.getPrettyFormat();
	format.setEncoding("UTF-8");// 设置xml文件的字符为UTF-8，解决中文问题
	XMLOutputter xmlout = new XMLOutputter(format);
	ByteArrayOutputStream bo = new ByteArrayOutputStream();
	xmlout.output(doc, bo);
	return bo.toString();
	}
}
