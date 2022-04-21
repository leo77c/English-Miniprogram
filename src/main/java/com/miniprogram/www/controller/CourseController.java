package com.miniprogram.www.controller;

import com.miniprogram.www.annotation.CurrentUser;
import com.miniprogram.www.entity.Chapter;
import com.miniprogram.www.entity.Course;
import com.miniprogram.www.entity.CourseRecord;
import com.miniprogram.www.service.ChapterService;
import com.miniprogram.www.service.ContentService;
import com.miniprogram.www.service.CourseService;
import com.miniprogram.www.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private WebUserService webUserService;
    @Autowired
    private ContentService contentService;

    /**
     * @description 得到所有课程信息的列表，以参加人数降序排序，同时得到对应教师名称
     * @return
     */
    @RequestMapping("/getAll")
    public Map<String, Object> getAllCourses() {
        Map<String, Object> response = new HashMap<String, Object>();
        List<Course> courseList = courseService.getAllCourses();
        List<String> teacherList = webUserService.getTeacherNameForCourse(courseList);
        response.put("courseList", courseList);
        response.put("teacherList", teacherList);
        response.put("success", true);
        return response;
    }

    /**
     * @description 学生加入课程，先查找是否已有参加记录，若没有再新添课程参加记录
     * @param courseId
     * @param currentUserId
     * @return
     */
    @RequestMapping("/join")
    public Map<String, Object> joinCourse(@RequestParam(value="courseId", required=true) int courseId,
                                          @CurrentUser Integer currentUserId) {
        Map<String, Object> response = new HashMap<String, Object>();
        if (courseService.findCourseRecord(currentUserId, courseId)) {
            response.put("hasJoined", true);
        }else {
            CourseRecord courseRecord = new CourseRecord();
            courseRecord.setStudentId(currentUserId);
            courseRecord.setCourseId(courseId);
            courseRecord.setStartTime(new Date(System.currentTimeMillis()));

            courseService.addCourseRecord(courseRecord);
            response.put("hasJoined", false);
        }
        response.put("success", true);
        return response;
    }

    /**
     * @description 学生得到"我的课程"，返回参加过的课程信息和对应课程名称
     * @param currentUserId
     * @return
     */
    @RequestMapping("/getMine")
    public Map<String, Object> getMyCourse(@CurrentUser Integer currentUserId) {
        Map<String, Object> response = new HashMap<String, Object>();
        List<Course> courseList = courseService.getCourseForStudent(currentUserId);
        List<String> teacherList = webUserService.getTeacherNameForCourse(courseList);
        response.put("courseList", courseList);
        response.put("teacherList", teacherList);
        response.put("success", true);
        return response;
    }


    /**
     * @description 得到课程的具体学习内容，包括视频和作业，以及对应访问记录
     * @param courseId
     * @param currentUserId
     * @return
     */
    @RequestMapping("/getContent")
    public Map<String, Object> getCourseContent(@RequestParam(value="courseId", required=true) int courseId,
                                                @CurrentUser Integer currentUserId) {
        Map<String, Object> response = new HashMap<String, Object>();
        List<Map<String, Object>> content = contentService.getCourseContent(currentUserId, courseId);
        response.put("success", true);
        response.put("content", content);

        return response;
    }


}
