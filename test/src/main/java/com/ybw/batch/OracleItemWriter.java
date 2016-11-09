package com.ybw.batch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.StringUtils;


/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
public class OracleItemWriter implements ItemWriter<TestBean>{

private static final Log log = LogFactory.getLog(OracleItemWriter.class);
	
	@Autowired  
	private JdbcTemplate jdbcTemplate; 

	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private static final String SAVE_SQL = "insert into BATCH_TEST(day,msisdn) VALUES(?,?)";  
	/**
	 * @see ItemWriter#write(Object)
	 */
	public void write1(List<? extends TestBean> data) throws Exception {
		for(TestBean line : data){
			this.save(line);
		}
		
	}
	
	 public void save(final TestBean item) {  
	        jdbcTemplate.update(SAVE_SQL, new PreparedStatementSetter() {  
	            public void setValues(PreparedStatement stmt) throws SQLException {  
	                stmt.setString(1, item.getDay());  
	                stmt.setString(2, item.getMsisdn());
	            }  
	        });  
	    }  
	  
	 
	 @Transactional("dbTransaction")  
	 public void write2(List<? extends TestBean> data) throws Exception {  
	     StringBuffer sqlbuf = new StringBuffer()  
	         .append("insert into BATCH_TEST(day,msisdn) values ");  
	     MessageFormat form = new MessageFormat("(''{0}'',''{1}''),");
	     for (TestBean poi : data) {  
	         Object[] args = {poi.getDay(), poi.getMsisdn()};  
	         sqlbuf.append(form.format(args));  
	     }  
	     String sql = sqlbuf.toString();  
	     sql = sql.substring(0, sql.length()-1);  
	     jdbcTemplate.update(sql);  
	 }  
	 
	 @Transactional("dbTransaction")  
	 public void write(List<? extends TestBean> data) throws Exception {
		 final Object[] params=new Object[2];
			for(TestBean line : data){
				params[0]=line.getDay();
				params[1]=line.getMsisdn();
				//log.info(line.getMsisdn());
				jdbcTemplate.update("insert into BATCH_TEST(day,msisdn) VALUES(?,?)",params);
			}
			
		}

}
