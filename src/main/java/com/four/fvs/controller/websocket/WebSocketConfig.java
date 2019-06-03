package com.four.fvs.controller.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * Spring websocket配置类
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {


    /**
     * 定义接收/websocket时采用wensocket连接，添加HttpSessionHandshakeInterceptor是为了websocket握手前将httpsession中的属性
     * 添加到websocket session中，withSockJS添加对sockJS的支持
     *
     * @param stompEndpointRegistry
     */
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/websocket").addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();
    }

    /**
     * 配置消息代理，以/app为头的url将会先经过MessageMapping
     * /topic直接进入消息代理
     *
     * @param registry
     */

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.setApplicationDestinationPrefixes("/app");//这句话表示客户单向服务器端发送时的主题上面需要加"/app"作为前缀。
        registry.enableSimpleBroker("/topic","/user");//这句话表示在topic这个域上可以向客户端发消息。

        registry.setUserDestinationPrefix("/user");//这句话表示给指定用户发送一对一的主题前缀是"/user"
    }
}
