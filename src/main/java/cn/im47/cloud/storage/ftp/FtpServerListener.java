/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package cn.im47.cloud.storage.ftp;

import org.apache.ftpserver.FtpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class FtpServerListener implements ServletContextListener {

    private final Logger logger = LoggerFactory.getLogger(FtpServerListener.class);

    public static final String FTPSERVER_CONTEXT_NAME = "org.apache.ftpserver";

    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("Stopping FtpServer");

        FtpServer server = (FtpServer) sce.getServletContext().getAttribute(FTPSERVER_CONTEXT_NAME);

        if (server != null) {
            server.stop();
            sce.getServletContext().removeAttribute(FTPSERVER_CONTEXT_NAME);
            logger.debug("FtpServer stopped");
        } else {
            logger.warn("No running FtpServer found");
        }

    }

    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("Starting FtpServer");

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        FtpServer server = (FtpServer) ctx.getBean("myFtpServer");
        sce.getServletContext().setAttribute(FTPSERVER_CONTEXT_NAME, server);

        try {
            server.start();
            logger.debug("FtpServer started");
        } catch (Exception e) {
            logger.error("Failed to start FtpServer", e);
            throw new RuntimeException("Failed to start FtpServer", e);
        }
    }

}
