package me.seun.springbasic.injection;

import org.springframework.stereotype.Component;

@Component
public class InMemoryUserRepository implements UserRepository {
    @Override
    public void save(String username) {
        System.out.println("메모리에 사용자 저장함 " + username);
    }
}
