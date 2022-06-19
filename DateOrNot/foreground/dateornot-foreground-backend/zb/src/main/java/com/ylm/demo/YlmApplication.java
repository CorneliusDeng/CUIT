package com.ylm.demo;

import com.ylm.demo.nettyServer.NettyServer;
import io.netty.channel.ChannelFuture;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages={"com.ylm.demo.dao"})
public class YlmApplication implements CommandLineRunner {
	@Value("${server.port.http}")
	private int serverPortHttp;	//http端口
	@Value("${server.port}")
	private int serverPortHttps;	//https端口
	@Value("${ws.websocket.port}")
	private int port;	//wss端口
	@Value("${ws.websocket.url}")
	private String url;
	@Autowired
	private NettyServer Server;
	public static void main(String[] args) {
		SpringApplication.run(YlmApplication.class, args);
	}

	/**
	 * 启动netty服务器
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		ChannelFuture future = Server.start(url,port);
		Runtime.getRuntime().addShutdownHook(new Thread(() -> Server.destroy()));
		//服务端管道关闭的监听器并同步阻塞,直到channel关闭
		future.channel().closeFuture().syncUninterruptibly();
	}

	/**
	 * 设置自动重定向http到https（80端口->443端口）
	 * @return
	 */
	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(redirectConnector());
		return tomcat;
	}

	/**
	 * 设置自动重定向http到https（80端口->443端口）
	 * @return
	 */
	private Connector redirectConnector() {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		connector.setPort(serverPortHttp);
		connector.setSecure(false);
		connector.setRedirectPort(serverPortHttps);
		return connector;
	}

}
