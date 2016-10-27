package com.ybw.batch;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * ItemProcessor类。
 */
@Component("csvItemProcessor")
public class CsvItemProcessor implements ItemProcessor<TestBean, TestBean> {

	private static final Log log = LogFactory.getLog(CsvItemProcessor.class);
    /**
     * 对取到的数据进行简单的处理。
     * 
     * @param student
     *            处理前的数据。
     * @return 处理后的数据。
     * @exception Exception
     *                处理是发生的任何异常。
     */
    @Override
    public TestBean process(TestBean student) throws Exception {
    	log.info(student.toString());
        return student;
    }
}