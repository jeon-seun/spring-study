package me.seun.springbasic.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 생성자로 Bean 을 주입받는 것이 가장 권장되는 방법
@Component
public class UserService {

//    @Autowired
    private final UserRepository userRepository;

    // 1. 생성자 주입
    // @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

//    @Autowired
//    public void inject(UserRepository userRepository) {
//        System.out.println("UserRepository 주입 받기");
//        this.userRepository = userRepository;
//    }


    public void create(String username) {
        // 사용자 만들어서 저장하기...
        userRepository.save(username);
    }

}
