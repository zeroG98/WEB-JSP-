package mr.web.frontController;

import java.util.HashMap;

import mr.web.controller.Controller;
import mr.web.controller.*;

public class HandlerMapping {
	private HashMap<String, Controller> handlerMaps;
	
	public HandlerMapping() {
		handlerMaps = new HashMap<String, Controller>();
		handlerMaps.put("/memberList.do", new MemberListController());
		handlerMaps.put("/memberInsert.do", new MemberInsertController());
		handlerMaps.put("/memberJoin.do", new MemberJoinController());
		handlerMaps.put("/memberInfo.do", new MemberInfoController());
		handlerMaps.put("/memberUpdate.do", new MemberUpdateController());
		handlerMaps.put("/memberDelete.do", new MemberDeleteController());
		handlerMaps.put("/memberLogin.do", new MemberLoginController());
		handlerMaps.put("/memberLogout.do", new MemberLogoutController());
		handlerMaps.put("/memberIdCheck.do", new MemberIdCheckController());
		
		handlerMaps.put("/memberAjaxList.do", new MemberAjaxListController());
		handlerMaps.put("/memberAjaxDelete.do", new MemberAjaxDeleteController());
		
		handlerMaps.put("/fileAttach.do", new FileAttachController());
		handlerMaps.put("/getFile.do", new GetFileController());
		handlerMaps.put("/delFile.do", new DelFileController());
		
		handlerMaps.put("/home.do", new HomeController());
	}
	
	public Controller getController(String key) {
		return handlerMaps.get(key);
	}
}
