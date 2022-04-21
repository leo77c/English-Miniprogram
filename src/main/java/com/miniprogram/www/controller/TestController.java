package com.miniprogram.www.controller;

import com.miniprogram.www.annotation.CurrentUser;
import com.miniprogram.www.dao.StudentDao;
import com.miniprogram.www.entity.Course;
import com.miniprogram.www.entity.Student;
import com.miniprogram.www.entity.Test;
import com.miniprogram.www.entity.WebUser;
import com.miniprogram.www.service.ContentService;
import com.miniprogram.www.service.CourseService;
import com.miniprogram.www.service.TestService;
import com.miniprogram.www.service.WebUserService;
import com.miniprogram.www.util.FileUtils;
import com.miniprogram.www.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private TestService testService;

    @RequestMapping("/getProfile")
    public Map<String, Object> getTestProfile(@RequestParam(value="id", required=true) int testId,
                                              @CurrentUser Integer currentUserId) {
        Map<String, Object> response = new HashMap<>();
        Test test = testService.getTestById(testId);
        Map<String, Integer> map = testService.getScoreAndCount(currentUserId, testId);
        response.put("testProfile", test);
        response.put("submitCount", map.get("submitCount"));
        response.put("highestScore", map.get("highestScore"));
        response.put("success", true);
        return response;
    }


}
