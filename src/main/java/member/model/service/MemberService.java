package member.model.service;

import java.sql.*;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;
	
	public MemberService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	
	// 연결생성
	// DAO 호출
	// 커밋/롤백
	
	
	public int insertMember(Member member) {
		// 연결생성
		Connection conn = jdbcTemplate.createConnection();
		// DAO 호출
		
		int result = mDao.insertMember(conn, member);
		// 커밋/롤백
		if(result>0) {
			// 성공 - 커밋
			jdbcTemplate.commit(conn);
		}else {
			// 실패 - 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
	

	

	public int updateMember(Member member) {
		// 연결생성
		Connection conn = jdbcTemplate.createConnection();
		// DAO 호출
		int result = mDao.updateMember(conn, member);
		// 커밋/롤백
		if(result>0) {
			// 성공 - 커밋
			jdbcTemplate.commit(conn);
		}else {
			// 실패 - 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}

	public int deleteMember(String memberId) {
		// 연결생성
		Connection conn = jdbcTemplate.createConnection();
		// DAO 호출
		int result = mDao.deleteMember(conn, memberId);
		// 커밋/롤백
		if(result>0) {
			// 성공 - 커밋
			jdbcTemplate.commit(conn);
		}else {
			// 실패 - 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}

	public Member selectCheckLogin(Member member) {
		// 연결생성
		Connection conn = jdbcTemplate.createConnection();
		// DAO 호출
		Member mOne = mDao.selectCheckLogin(conn, member);
		jdbcTemplate.close(conn);
		return mOne;
	}

	public Member selectOneById(String memberId) {
		// 연결생성
		Connection conn = jdbcTemplate.createConnection();
		// DAO 호출(연결도 넘겨줘야 함)
		Member member = mDao.selectOneById(conn, memberId);
		jdbcTemplate.close(conn);
		return member;
	}
	
}
