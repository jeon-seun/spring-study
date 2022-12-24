package study.spring.springweb.thymeleaf;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO -> Data Transfer Object
@ToString
@Setter
@Getter
public class EventCreate {

    private String name;

    private boolean open;

    private String status; // 시작전, 진행중, 마감
    // pre, ongoing, finish
}
