package academy.learnProgramming.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String getHelloMessage(String user) {
        return "hello" + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo application";
    }
}
