package eu.company.hosel.bsl.test.dao;

//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import eu.company.hosel.bsl.test.IntegrationTestContext;

@ContextConfiguration(classes = IntegrationTestContext.class)
public class UserDaoImpl implements UserDao {
	/*@Autowired
	private JdbcTemplate bslJdbcTemplate;

	@Override
	public String getVerificationCodeByPhoneNo(String PhoneNo) {
		StringBuilder sb = new StringBuilder("SELECT VERIFICATIONCODE FROM CS_USER_CONTACT");
		sb.append(" WHERE VALUE = '").append("+84").append(PhoneNo).append("'");
		String verificationCode = bslJdbcTemplate.queryForObject(sb.toString(), String.class);
		return verificationCode;
	}
	
	@Override
	public String getStatusByPhoneNo(String PhoneNo) {
		StringBuilder sb = new StringBuilder("select u.idstatus from CS_USER u inner join CS_USER_CONTACT c on u.id = c.iduser");
		sb.append(" WHERE VALUE = '").append("+84").append(PhoneNo).append("'");
		String statusCode = bslJdbcTemplate.queryForObject(sb.toString(), String.class);
		return statusCode;
	}

	@Override
	public boolean isVerified(String PhoneNo) {
		StringBuilder sb = new StringBuilder("SELECT VERIFIED FROM CS_USER_CONTACT");
		sb.append(" WHERE VALUE = '").append("+84").append(PhoneNo).append("'");
		String verified = bslJdbcTemplate.queryForObject(sb.toString(), String.class);
		return verified != null;
	}

	@Override
	public void deleteUsername(String username) {
		try {
			StringBuilder sb = new StringBuilder("SELECT id FROM CS_USER");
			sb.append(" WHERE username = '").append(username).append("'");
			//System.out.println(sb.toString());
			String userid = bslJdbcTemplate.queryForObject(sb.toString(), String.class);
			
			if (!userid.isEmpty()) {
				sb = new StringBuilder("delete from cs_user_contact");
				sb.append(" where iduser='").append(userid).append("'");
				//System.out.println(sb.toString());
				bslJdbcTemplate.execute(sb.toString());
				sb = new StringBuilder("delete from cs_user");
				sb.append(" where id='").append(userid).append("'");
				//System.out.println(sb.toString());
				bslJdbcTemplate.execute(sb.toString());
			}
		} catch (Exception e) {
		}
	}*/

}
