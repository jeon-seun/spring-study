package me.seun.springbasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration // 이 어노테이션이 붙은 자바 클래스는 설정 클래스가 된다.
public class AppConfig {

    // 해당 메소드의 반환값은 스프링의 IoC 컨테이너가 관리하는 Bean 이 된다.
    @Bean
    public KakaoMapService kakaoMapService() {
        return new KakaoMapService();
    }

    @Bean
    public NaverMapService naverMapService() {
        return new NaverMapService();
    }
}