package com.miniprogram.www.service;

import com.miniprogram.www.entity.Test;

import java.util.Map;

public interface TestService {

    Test getTestById(int testId);
    Map<String, Integer> getScoreAndCount(int studentId, int testId);
}
