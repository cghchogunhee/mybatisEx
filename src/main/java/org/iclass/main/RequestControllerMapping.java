package org.iclass.main;

import java.util.HashMap;
import java.util.Map;

import org.icalss.controller.Controller;
import org.icalss.controller.LoginActionController;
import org.icalss.controller.LoginViewController;
import org.icalss.controller.LogoutController;



public class RequestControllerMapping {
	//처리해야 할 RequestKeyValue와 처리할 Controller 구현체 클래스 지정하기(매핑)
	//Map<key,value> : Key를 이용해서 value를 가져오기
	private static final Map<RequestKeyValue, Controller> mapping = new HashMap<>();
	
	//매핑 설정
	public static void init() {
		//로그인 기능 : 아래 3개의 컨트롤러를 구현하기 - Action에서 Dao의 login을 활용해서 만들기
		mapping.put(new RequestKeyValue("/login.hrd","GET"),new LoginViewController());
		mapping.put(new RequestKeyValue("/login.hrd","POST"),new LoginActionController());
		mapping.put(new RequestKeyValue("/logout.hrd","GET"),new LogoutController());
	}
	
	//url,method 필드를 저장하는 key를 전달받아 HashMap에서 value(컨트롤러)를 리턴
	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
	
}
