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
	}
	
	public Controller getController(String key) {
		return handlerMaps.get(key);
	}
}
