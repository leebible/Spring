package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.utils.NamingUtils;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int insertMember(MemberVO member) {
		StringBuffer sql = new StringBuffer();
			sql.append(" INSERT INTO MEMBER (");
			sql.append(" mem_id,          ");
		    sql.append(" mem_pass,        ");
		    sql.append(" mem_name,        ");
		    sql.append(" mem_regno1,      ");
		    sql.append(" mem_regno2,      ");
		    sql.append(" mem_bir,         ");
		    sql.append(" mem_zip,         ");
		    sql.append(" mem_add1,        ");
		    sql.append(" mem_add2,        ");
		    sql.append(" mem_hometel,     ");
		    sql.append(" mem_comtel,      ");
		    sql.append(" mem_hp,          ");
		    sql.append(" mem_mail,        ");
		    sql.append(" mem_job,         ");
		    sql.append(" mem_like,        ");
		    sql.append(" mem_memorial,    ");
		    sql.append(" mem_memorialday, ");
		    sql.append(" mem_mileage,     ");
		    sql.append(" mem_delete       ");
		    sql.append(" ) VALUES (		  ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" TO_DATE(?, 'yyyy-mm-dd'),                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" ?,                ");
		    sql.append(" TO_DATE(?, 'yyyy-mm-dd'),                 ");
		    sql.append(" ?,                ");
		    sql.append(" ?				)   ");
//		1.
		try (
				Connection conn = ConnectionFactory.getConnection(); 
//				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
//				3.
				int idx = 1;
				pstmt.setString(idx++, member.getMemId());
				pstmt.setString(idx++, member.getMemPass());
				pstmt.setString(idx++, member.getMemName());
				pstmt.setString(idx++, member.getMemRegno1());
				pstmt.setString(idx++, member.getMemRegno2());
				pstmt.setString(idx++, member.getMemBir());
				pstmt.setString(idx++, member.getMemZip());
				pstmt.setString(idx++, member.getMemAdd1());
				pstmt.setString(idx++, member.getMemAdd2());
				pstmt.setString(idx++, member.getMemHometel());
				pstmt.setString(idx++, member.getMemComtel());
				pstmt.setString(idx++, member.getMemHp());
				pstmt.setString(idx++, member.getMemMail());
				pstmt.setString(idx++, member.getMemJob());
				pstmt.setString(idx++, member.getMemLike());
				pstmt.setString(idx++, member.getMemMemorial());
				pstmt.setString(idx++, member.getMemMemorialday());
				if(member.getMemMileage()==null) {
					pstmt.setNull(idx++, JDBCType.NUMERIC.ordinal());
				}else {
					pstmt.setLong(idx++, member.getMemMileage());
				}
				pstmt.setString(idx++, member.getMemDelete());
				int rowcnt = pstmt.executeUpdate(); //그대로 쓰면 runtime exception 뜸
				return rowcnt;
			} catch (SQLException e) {
				throw new PersistenceException(e); 
			}
	}

	@Override
	public List<MemberVO> selectMemberList() {
		StringBuffer sql = new StringBuffer();
		sql.append("select                                                ");
		sql.append("MEM_ID, MEM_NAME,                           ");
		sql.append("MEM_ADD1, MEM_ADD2,             ");
		sql.append("MEM_HP, MEM_MAIL,      ");
		sql.append(" MEM_MILEAGE");
		sql.append("FROM MEMBER                                           ");
		try (
				Connection conn = ConnectionFactory.getConnection(); 
//				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
//				3
				ResultSet rs = pstmt.executeQuery(); //그대로 쓰면 runtime exception 뜸
//				5
				List<MemberVO> memberList = new ArrayList<>();
				while(rs.next()) {
					MemberVO mvo = new MemberVO();
					memberList.add(mvo);
					mvo.setMemId(rs.getString("MEM_ID"));
					mvo.setMemName(rs.getString("MEM_NAME"));
					mvo.setMemAdd1(rs.getString("MEM_ADD1"));
					mvo.setMemAdd2(rs.getString("MEM_ADD2"));
					mvo.setMemHp(rs.getString("MEM_HP"));
					mvo.setMemMail(rs.getString("MEM_MAIL"));
					mvo.setMemMileage(rs.getLong("MEM_MILEAGE"));
				}
				rs.close();
				return memberList;
			} catch (SQLException e) {
				throw new PersistenceException(e); 
			}
	}

	@Override
	public MemberVO selectMember(String mem_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select                                                ");
		sql.append("MEM_ID, MEM_PASS, MEM_NAME,                           ");
		sql.append("MEM_REGNO1, MEM_REGNO2, TO_CHAR(MEM_BIR, 'YYYY-MM-DD') MEM_BIR, ");
		sql.append("MEM_ZIP, MEM_ADD1, MEM_ADD2, MEM_HOMETEL,             ");
		sql.append("MEM_COMTEL, MEM_HP, MEM_MAIL, MEM_JOB, MEM_LIKE,      ");
		sql.append("MEM_MEMORIAL, TO_CHAR(MEM_MEMORIALDAY, 'YYYY-MM-DD') MEM_MEMORIALDAY, MEM_MILEAGE, MEM_DELETE");
		sql.append("FROM MEMBER                                           ");
		sql.append("WHERE MEM_ID= ? ");   // ? : 쿼리 파라미터                     
		try (
				Connection conn = ConnectionFactory.getConnection(); 
//				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, mem_id);
				pstmt.executeQuery(); //동적으로 쿼리문을 바꿀수 없음.
				ResultSet rs = pstmt.executeQuery(); 
				MemberVO member = null;
				if(rs.next()) {
					member = new MemberVO();
					member.setMemId(rs.getString("MEM_ID"));
					member.setMemPass(rs.getString("MEM_PASS"));
					member.setMemName(rs.getString("MEM_NAME"));
					member.setMemRegno1(rs.getString("MEM_REGNO1"));
					member.setMemRegno2(rs.getString("MEM_REGNO2"));
					member.setMemBir(rs.getString("MEM_BIR"));
					member.setMemZip(rs.getString("MEM_ZIP"));
					member.setMemAdd1(rs.getString("MEM_ADD1"));
					member.setMemAdd2(rs.getString("MEM_ADD2"));
					member.setMemHometel(rs.getString("MEM_HOMETEL"));
					member.setMemComtel(rs.getString("MEM_COMTEL"));
					member.setMemHp(rs.getString("MEM_HP"));
					member.setMemMail(rs.getString("MEM_MAIL"));
					member.setMemJob(rs.getString("MEM_JOB"));
					member.setMemLike(rs.getString("MEM_LIKE"));
					member.setMemMemorial(rs.getString("MEM_MEMORIAL"));
					member.setMemMemorialday(rs.getString("MEM_MEMORIALDAY"));
					member.setMemMileage(rs.getLong("MEM_MILEAGE"));
					member.setMemDelete(rs.getString("MEM_DELETE"));
				}
				rs.close();
				return member;
			} catch (SQLException e) {
				throw new PersistenceException(e); 
			}
	}

}
