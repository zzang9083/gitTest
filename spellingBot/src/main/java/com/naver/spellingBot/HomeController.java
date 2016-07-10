package com.naver.spellingBot;

import java.io.BufferedReader;

import com.naver.spellingBot.jniTest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.naver.bo.urlBO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private urlBO urlBO;
		
	
	static{
		System.loadLibrary("HelloWorld");
	}
 public native void print();
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	
	//public native void print();

	@RequestMapping(value = "input", method =  {RequestMethod.POST,RequestMethod.GET})
	public String home(HttpServletRequest request,jniTest jniTest) throws IOException {
		ModelAndView mav = new ModelAndView();
		String result=jniTest.Mul("bang",3);
		System.out.println(result);
		String clientId="ZY82OUnGewLZ0W69xQwt";
		String clientSecret="LYr_I535TE";
		String surl = "https://openapi.naver.com/v1/util/shorturl";
		String real=request.getParameter("real");
		System.out.println(real);
		String inputUrl=request.getParameter("url");
		HttpPost requestSet = new HttpPost(surl);
		urlBO.urlAdd(inputUrl,"short"); 
//		PostMethod method = new PostMethod(url); 
//		method.setRequestHeader("consumerKey", "LQwDde6x8eV4ROOCOdSW");
		 ArrayList postParameters = new ArrayList();
		 try {

		        CloseableHttpClient client = HttpClientBuilder.create().build();
		       // 단축 URL은 POST로 호출
		       HttpPost requestPost = new HttpPost(surl);
		        postParameters.add(new BasicNameValuePair("url",inputUrl));
		        requestPost.setEntity(new UrlEncodedFormEntity(postParameters));
		        // HTTP 헤더에 클라이언트 아이디와 시크릿을 추가
		        requestPost.addHeader("X-Naver-Client-Id", clientId);
		        requestPost.addHeader("X-Naver-Client-Secret", clientSecret);
		        HttpResponse response = client.execute(requestPost);
		        String results = null;
		        HttpEntity responseEntity = response.getEntity();
		        if(responseEntity!=null) {
		            results = EntityUtils.toString(responseEntity);
		        }
		        System.out.println("results: " + results);
		      

		    } catch (Exception e) {
		        System.out.println(e);
		    }
		 
		 	
		
		  return "results";
	}	
	
	
//	@RequestMapping(value = "input", method =  {RequestMethod.POST})
//	@ResponseBody
//	public String home(HttpServletRequest request,jniTest jniTest) throws IOException {
//		ModelAndView mav = new ModelAndView();
//		String result=jniTest.Mul("bang",3);
//		System.out.println(result);
//		String clientId="ZY82OUnGewLZ0W69xQwt";
//		String clientSecret="LYr_I535TE";
//		String surl = "https://openapi.naver.com/v1/util/shorturl";
//		String inputUrl=request.getParameter("url");
//		HttpPost requestSet = new HttpPost(surl);
//		urlBO.urlAdd(inputUrl,"short"); 
////		PostMethod method = new PostMethod(url); 
////		method.setRequestHeader("consumerKey", "LQwDde6x8eV4ROOCOdSW");
//		 ArrayList postParameters = new ArrayList();
//		 try {
//
//		        CloseableHttpClient client = HttpClientBuilder.create().build();
//		       // 단축 URL은 POST로 호출
//		       HttpPost requestPost = new HttpPost(surl);
//		        postParameters.add(new BasicNameValuePair("url",inputUrl));
//		        requestPost.setEntity(new UrlEncodedFormEntity(postParameters));
//		        // HTTP 헤더에 클라이언트 아이디와 시크릿을 추가
//		        requestPost.addHeader("X-Naver-Client-Id", clientId);
//		        requestPost.addHeader("X-Naver-Client-Secret", clientSecret);
//		        HttpResponse response = client.execute(requestPost);
//		        String results = null;
//		        HttpEntity responseEntity = response.getEntity();
//		        if(responseEntity!=null) {
//		            results = EntityUtils.toString(responseEntity);
//		        }
//		        System.out.println("results: " + results);
//		      
//
//		    } catch (Exception e) {
//		        System.out.println(e);
//		    }
//		 
//		 	
//		
//		  return "results";
//	}   
}


