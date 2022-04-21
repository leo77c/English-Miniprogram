package com.miniprogram.www.service.impl;

import com.miniprogram.www.dao.ChapterDao;
import com.miniprogram.www.entity.Chapter;
import com.miniprogram.www.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    /**
     * @description 得到某门课程的章节信息
     * @param courseId
     * @return
     */
    @Override
    public List<Chapter> getChapterListForCourse(int courseId) {
        List<Chapter> list = chapterDao.queryChaptersByCourse(courseId);
        if (list.size() == 0) throw new RuntimeException("当前课程暂无内容！");
        return list;
    }
}
