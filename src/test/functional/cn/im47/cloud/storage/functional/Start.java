package cn.im47.cloud.storage.functional;

import org.eclipse.jetty.server.Server;
import org.springside.modules.test.functional.JettyFactory;

/**
 * 使用Jetty运行调试Web应用, 在Console输入回车停止服务器
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-4-25
 * Time: 下午7:16
 */
public class Start {

    public static final int PORT = 8088;
    public static final String CONTEXT = "/ct-cloud-proxy";
    public static final String BASE_URL = "http://localhost:8088/ct-cloud-proxy";

    public static void main(String[] args) throws Exception {

        //设定Spring的profile
        System.setProperty("spring.profiles.active", "development");

        //启动Jetty
        Server server = JettyFactory.createServerInSource(PORT, CONTEXT);
        server.start();

        System.out.println("Server running at " + BASE_URL);
        System.out.println("Hit Enter in console to stop server");

        //wait for close
        System.in.read();
        server.stop();
        server.join();
        System.out.println("Server stopped");
    }
}
