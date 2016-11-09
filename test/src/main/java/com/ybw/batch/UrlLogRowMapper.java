package com.ybw.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * ledger––µƒ”≥…‰¿‡
 * @author Administrator
 *
 */
@Component("urlLogRowMapper")
public class UrlLogRowMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		TestBean ledger = new TestBean();
		ledger.setDay(rs.getString("id"));
		ledger.setMsisdn(rs.getString("log_date"));
		return ledger;
	}
}
