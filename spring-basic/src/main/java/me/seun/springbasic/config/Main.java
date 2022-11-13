package me.seun.springbasic.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        KakaoMapService kakaoMapService = context.getBean("kakaoMapService", KakaoMapService.class);
        NaverMapService naverMapService = context.getBean("naverMapService", NaverMapService.class);

        kakaoMapService.printName();
        naverMapService.printName();
    }
}
