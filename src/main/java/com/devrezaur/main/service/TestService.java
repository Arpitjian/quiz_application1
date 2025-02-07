package com.devrezaur.main.service;

import com.devrezaur.main.model.Test;
import com.devrezaur.main.repository.TestRepo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestRepo1 testRepo;

    public Test saveTest(Test test) {
        return testRepo.save(test);
    }
}
