package com.miniprogram.www.service.impl;

import com.miniprogram.www.dao.CourseDao;
import com.miniprogram.www.dao.CourseRecordDao;
import com.miniprogram.www.entity.Course;
import com.miniprogram.www.entity.CourseRecord;
import com.miniprogram.www.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseRecordDao courseRecordDao;

    /**
     * @description 得到所有课程信息
     * @return
     */
    @Override
    public List<Course> getAllCourses() {
        List<Course> list = courseDao.queryAllCourses();
        if (list.size() == 0) throw new RuntimeException("课程列表为空");
        return list;
    }

    /**
     * @description 查询数据库中是否有学生参加某门课程的记录
     * @param studentId
     * @param courseId
     * @return
     */
    @Override
    public boolean findCourseRecord(int studentId, int courseId) {
        if (courseRecordDao.queryCourseRecord(studentId, courseId) != null) return true;
        else return false;
    }

    /**
     * @description 添加课程学习记录
     * @param courseRecord
     * @return
     */
    @Override
    public boolean addCourseRecord(CourseRecord courseRecord) {
        int effectNum = courseRecordDao.insertCourseRecord(courseRecord);
        if (effectNum > 0) {
            System.out.println("添加课程学习记录成功！");
            return true;
        }else {
            throw new RuntimeException("添加课程学习记录失败！");
        }
    }

    /**
     * @description 得到学生学习的课程记录
     * @param studentId
     * @return
     */
    @Override
    public List<Course> getCourseForStudent(int studentId) {
        List<Integer> list = courseRecordDao.queryCourseIdlist(studentId);
        if (list.size() != 0) {
            return courseDao.queryCourseListById(list);
        }else {
            System.out.println("该学生没有课程学习记录！");
            return null;
        }
    }

}
