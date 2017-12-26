package com.duowan.beans;

import com.duowan.leopard.commons.utility.JettyUtil;
import com.duowan.leopard.core.dns.DnsConfig;
import com.duowan.leopard.core.env.AppProperties;
import com.duowan.leopard.core.env.EnvUtil;
import com.duowan.leopard.test.jetty.ConfigFileChecker;
import com.duowan.leopard.test.jetty.JettyServer;
import com.duowan.leopard.test.jetty.configuration.EmbedAnnotionConfiguration;
import com.duowan.leopard.test.jetty.configuration.EmbedMetaInfConfiguration;
import com.duowan.leopard.test.jetty.configuration.EmbedWebInfConfiguration;
import com.duowan.leopard.test.jetty.configuration.EmbedWebXmlConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.Ignore;
import org.springframework.core.env.AbstractEnvironment;

import java.io.IOException;

/**
 * @author zhuangjiaxin@yy.com created on 2014-10-22
 */
@Ignore
public class IdeaJettyTest extends JettyServer {

    private static Log logger = LogFactory.getLog(IdeaJettyTest.class);

    public static void main(String[] args) throws Exception {

        // System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "dev");
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "jetty");

        JettyUtil.setJetty(true);
        // System.err.println("isOpened:" + port + " " + isOpened);
        String project = AppProperties.getProjectName();
        // System.err.println("project:" + project);
        // EnvUtil.setEnv(project, EnvUtil.ENV_DEV);
        EnvUtil.setProjectName(project);
        {
            new ConfigFileChecker(project).start();// 相关配置文件检查
        }
        DnsConfig.initHosts();
        // String contextPath = "/";
        useDefaultLog4jProperties();// 使用默认的log4.properties配置

        Server server = new Server(80);
        WebAppContext webContext = new WebAppContext("adcenter-mng/src/main/webapp", "/");
        webContext.setDefaultsDescriptor("leopard-test/webdefault.xml");

        // 问题点：http://stackoverflow.com/questions/13222071/spring-3-1-webapplicationinitializer-embedded-jetty-8-annotationconfiguration
        webContext.setConfigurations(new Configuration[] { //
                new EmbedWebInfConfiguration()//
                , new EmbedWebXmlConfiguration()//
                , new EmbedMetaInfConfiguration()//
                , new FragmentConfiguration()//
                , new EmbedAnnotionConfiguration() //
                // new PlusConfiguration(),
                // new EnvConfiguration()
        });

        WebAppClassLoader classLoader = null;
        try {
            // addTldLib(webContext);
            classLoader = new WebAppClassLoader(webContext);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // ClassLoader tldClassLoader = addTldLib(classLoader);
        webContext.setClassLoader(classLoader);

        webContext.setParentLoaderPriority(true);
        logger.debug(webContext.dump());
        server.setHandler(webContext);
        server.setStopAtShutdown(true);

        server.start();
    }

}
