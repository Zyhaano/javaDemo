package test.com.bangcle.utils;

import com.bangcle.Application;
import com.bangcle.utils.FuncUtil;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class FuncUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getRootPath()
     */
    @Test
    public void testGetRootPath() throws Exception {
        log.info("root path:{}", FuncUtil.getRootPath());
    }
    @Test
    public void testDom4j(){

    }


} 
