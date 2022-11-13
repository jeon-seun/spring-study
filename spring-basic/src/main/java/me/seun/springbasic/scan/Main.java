package me.seun.springbasic.scan;

import me.seun.springbasic.config.NaverMapService;
import me.seun.springbasic.scan.child.ChildBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        KakaoCrawler kakaoCrawler = context.getBean("kakaoCrawler", KakaoCrawler.class);
        NaverCrawler naverCrawler = context.getBean("naverCrawler", NaverCrawler.class);
        ChildBean childBean = context.getBean("childBean", ChildBean.class);
        NaverMapService naverMapService = context.getBean("naverMapService", NaverMapService.class);

        System.out.println("-----------------");
        System.out.println(kakaoCrawler);
        System.out.println(naverCrawler);
        System.out.println(childBean);
        System.out.println(naverMapService);
        System.out.println("-----------------");
    }
}
