package mr.web.frontController;

public class ViewResolver {
	public static String getPath(String nextPage) {
		return "WEB-INF/member/"+nextPage+".jsp";
	}
}
