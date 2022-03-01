package mr.web.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	// 초기화 블럭(static블럭) : application 실행시 한번만 실행되는 코드 영역
	static {
		try {  
			String resource = "mr/web/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			// build()는 config.xml을 이용해서 커넥션 풀을 만든다.
			// sqlSessionFactory 커넥션 풀(Connection Pool)을 가리키는 객체
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원 전체리스트 가져오기
	public List<MemberDTO> memberList() {
		// Connection + Statement(데이터접속객체 + 데이터전송객체) 
		//  => 두기능을 합쳐놓은 객체가 바로 SqlSession
		SqlSession session =sqlSessionFactory.openSession();
		
		List<MemberDTO> list =session.selectList("memberList");
		session.close(); //Connection Pool에 반납
		return list;
	}
	
	// 회원 저장
	public int memberInsert(MemberDTO dto) {
		SqlSession session =sqlSessionFactory.openSession();
//		session.insert("sql_id", dto);
		int cnt = session.insert("memberInsert", dto);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	// 회원 저장(사진 첨부)
	public int memberInsertFile(MemberDTO dto) {
		SqlSession session =sqlSessionFactory.openSession();
		int cnt = session.insert("memberInsertFile", dto);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	
	// 회원 삭제
	public int memberDelete(int num) {
		SqlSession session =sqlSessionFactory.openSession();
		int cnt = session.delete("memberDelete", num);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	// 파일명 삭제
	public int memberDeleteFile(int num) {
		SqlSession session =sqlSessionFactory.openSession();
		int cnt = session.delete("memberDeleteFile", num);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	// 회원정보 보기
	public MemberDTO memberInfo(int num) {
		SqlSession session =sqlSessionFactory.openSession();
		MemberDTO dto = session.selectOne("memberInfo", num);
		session.close();
		return dto;
	}
	
	// 회원정보 수정
	public int memberUpdate(MemberDTO dto) {
		SqlSession session =sqlSessionFactory.openSession();
		int cnt = session.update("memberUpdate", dto);
		session.commit();
		session.close();
		return cnt;
	}
	// 회원정보 수정(사진첨부)
	public int memberUpdateFile(MemberDTO dto) {
		SqlSession session =sqlSessionFactory.openSession();
		int cnt = session.update("memberUpdateFile", dto);
		session.commit();
		session.close();
		return cnt;
	}
	
	
	// 회원로그인
	public String memberLogin(MemberDTO dto) {
		SqlSession session =sqlSessionFactory.openSession();
		String userName = session.selectOne("memberLogin", dto);
		session.close();
		return userName;
	}
	
	public String memberIdChk(String id) {
		SqlSession session =sqlSessionFactory.openSession();
		String dbId = session.selectOne("memberIdChk", id); //id or null
		String resultChk = "N";//N(중복X)
		if(dbId !=null) {
			resultChk = "Y"; //Y(중복O)
		}
		System.out.println("dbId : "+dbId);
		System.out.println(resultChk);
		
		session.close();
		return resultChk;
	}
	
}
