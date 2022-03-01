package mr.web.model;

import java.sql.*;
import java.util.ArrayList;

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
			
			cnt = ps.executeUpdate(); // 실행에 성공하면 0보다 큰값을 반환(전송)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	// 회원 전체 리스트 가져오기
	public ArrayList<MemberDTO> memberList() {
		String sql = "select * from member";
		getConnect();
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>(); 
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); //ResultSet를 리턴(커서 : 결과집합을 가리키고 있는 객체)
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("id");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				
				// dto로 모아준다.
				MemberDTO dto = new MemberDTO(num, id, pw, name, age, email,tel);
				// List에 담기
				memberList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return memberList;
	}
	
	// 회원 삭제
	public int memberDelete(int num) {
		String sql = "delete from member where num=?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			cnt = ps.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	// 회원정보 가져오기
	public MemberDTO memberInfo(int num) {
		String sql = "select * from member where num=?";
		getConnect();
		MemberDTO dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,  num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				num =rs.getInt("num");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age  = rs.getInt("age");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				
				dto = new MemberDTO(num, id, pw, name, age, email, tel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return dto;
	}
	
	// 회원정보 수정하기
	public int memberUpdate(MemberDTO dto) {
		String sql = "update member set age=?, email=?, tel=? where num=?";
		getConnect();
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getAge());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getTel());
			ps.setInt(4, dto.getNum());
			
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	}
	
	// 데이터베이스 접속 종료
	public void dbClose() {
		try {
//			rs는 select할 때 만 사용된다.
			if(rs !=null) rs.close();
			if(ps !=null)ps.close();
			if(conn !=null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
