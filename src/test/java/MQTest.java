import com.mq.service.productor.QueueProductor;
import com.mq.service.productor.TopicProductor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MQTest {
    @Resource
    private QueueProductor queueProductor;
    @Resource
    private TopicProductor topicProductor;

    @Test
    public void test() {
        queueProductor.product();
    }

    @Test
    public void test1(){
        topicProductor.createMessage();
    }
}
