package cn.im47.cloud.storage.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 被Spring各种Scheduler反射调用的Service POJO
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-26
 * Time: 上午11:06
 */
@Component
public class QuartzJob {

    private static final Logger logger = LoggerFactory.getLogger(QuartzJob.class);

    /**
     * 定时打印当前用户数到日志.
     */
    public void execute() {
        // 查询当前系统用户数
        logger.info("######### There are {} user in database. #########", 1);

    }

}
