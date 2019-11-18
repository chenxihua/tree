package cn.lingshi.tree;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;


@SpringBootTest
class TreeApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(TreeApplicationTests.class);

    @Test
    void contextLoads() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Integer sum = 0;
        for (int i = 0; i <100000 ; i++) {
            sum += i;
        }
        stopWatch.stop();
        logger.warn("==> sum: {}, 所花时间： {}", sum, stopWatch.getTotalTimeMillis());
    }

}
