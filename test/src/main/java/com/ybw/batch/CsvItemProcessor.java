package com.ybw.batch;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * ItemProcessor�ࡣ
 */
@Component("csvItemProcessor")
public class CsvItemProcessor implements ItemProcessor<TestBean, TestBean> {

	private static final Log log = LogFactory.getLog(CsvItemProcessor.class);
    /**
     * ��ȡ�������ݽ��м򵥵Ĵ���
     * 
     * @param student
     *            ����ǰ�����ݡ�
     * @return ���������ݡ�
     * @exception Exception
     *                �����Ƿ������κ��쳣��
     */
    @Override
    public TestBean process(TestBean student) throws Exception {
    	log.info(student.toString());
        return student;
    }
}