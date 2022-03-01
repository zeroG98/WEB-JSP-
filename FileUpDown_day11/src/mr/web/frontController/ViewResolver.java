package mr.web.frontController;

public class ViewResolver {
	public static String getPath(String nextPage) {
		
		if(nextPage.equals("index")) {
			return nextPage+".jsp";
		}else {
			return "WEB-INF/member/"+nextPage+".jsp";
		}
	}
}
