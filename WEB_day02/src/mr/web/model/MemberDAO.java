package mr.web.model;

import java.sql.*;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// DB에 연결하기위한 Connection 객체생성
	public void getConnect() {
		// Database 접속 URL은 벤더마다 각각 다르다.
		String url ="jdbc:mysql://localhost:3306/sample?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user ="root";
		String pw = "test1234";
		
		// MySQL Driver Loading
		// Driver 클래스가 없을지도 모르기 때문에 예외처리
		try {
			// Driver찾아와서 메모리에 로딩(동적로딩)
			Class.forName("com.mysql.jdbc.Driver");
			
			// 로딩이 끝나면 접속을 시도
			// getConnection은 MySQL에서 구현한 메소드
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원정보 insert
	public int memberInsert(MemberDTO dto) {
		String sql = "insert into member(id, pw, name, age, email, tel) values(?,?,?,?,?,?)";
		getConnect();
		
		int cnt = -1;
		
		try {
			// 미리 컴파일을 시켜서 ?을 제외한 나머지 문장이 잘못되었는지 확인
			// PreparedStatement는 이미 컴파일된 정보를 갖고 있는 객체
			// 속도면에서 빠르게 처리됨.
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getEmail());
			ps.setString(6, dto.getTel());
			
			cnt = ps.executeUpdate(); // 실행에 성공하면 0보다 큰값을 반환
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	
}
