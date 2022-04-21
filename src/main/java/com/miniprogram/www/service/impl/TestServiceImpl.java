package com.miniprogram.www.service.impl;

import com.miniprogram.www.dao.TestDao;
import com.miniprogram.www.dao.TestRecordDao;
import com.miniprogram.www.entity.Test;
import com.miniprogram.www.entity.TestRecord;
import com.miniprogram.www.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;
    @Autowired
    private TestRecordDao testRecordDao;

    /**
     * @description 通过testId查找测试
     * @param testId
     * @return
     */
    @Override
    public Test getTestById(int testId) {
        Test test = testDao.queryTestById(testId);
        if (test == null) throw new RuntimeException("当前测试不存在！");
        return test;
    }

    /**
     * @description 查找学生提交某次测试的次数和成绩，若次数为0则成绩取-1，否则取最高分
     * @param studentId
     * @param testId
     * @return
     */
    @Override
    public Map<String, Integer> getScoreAndCount(int studentId, int testId) {
        Map<String, Integer> map = new HashMap<>();
        List<TestRecord> list = testRecordDao.queryTestRecord(studentId, testId);
        map.put("submitCount", list.size());
        if (list.size() > 0) {
            int max = -1;
            for (int i = 0; i < list.size(); i++) {
                if (max < list.get(i).getTotalScore()) max = list.get(i).getTotalScore();
            }
            map.put("highestScore", max);
        }else map.put("highestScore", -1);
        return map;
    }
}
