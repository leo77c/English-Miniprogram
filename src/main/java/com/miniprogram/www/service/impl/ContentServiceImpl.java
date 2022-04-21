package com.miniprogram.www.service.impl;

import com.miniprogram.www.dao.*;
import com.miniprogram.www.entity.Chapter;
import com.miniprogram.www.entity.Test;
import com.miniprogram.www.entity.Video;
import com.miniprogram.www.entity.VideoRecord;
import com.miniprogram.www.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private VideoDao videoDao;
    @Autowired
    private VideoRecordDao videoRecordDao;
    @Autowired
    private TestDao testDao;
    @Autowired
    private TestRecordDao testRecordDao;

    /**
     * @description 得到课程的具体内容，result中第一个元素为章节信息，后面为按章节排序的视频和作业，每一章视频在前作业在后，同时带有类型和访问记录信息
     * @param studentId
     * @param courseId
     * @return
     */
    @Override
    public List<Map<String, Object>> getCourseContent(int studentId, int courseId) {
        List<Map<String, Object>> result = new ArrayList<>();

        List<Chapter> chapterList = chapterDao.queryChaptersByCourse(courseId);
        if (chapterList.size() == 0) throw new RuntimeException("无章节目录");
        Map<String, Object> temp = new HashMap<>();
        temp.put("chapterList", chapterList);
        result.add(temp);

        List<Video> videoList = videoDao.queryVideosByCourse(courseId);
        List<Test> assignmentList = testDao.queryAssignmentsByCourse(courseId);

        int size1 = videoList.size();
        int size2 = assignmentList.size();
        int index1 = 0, index2 = 0;
        do {
            //将视频和作业按章节顺序放入result，并带上类型、是否访问过的记录
            for ( ; index1 < size1; index1++) {
                temp = new HashMap<>();
                Video tempVideo = videoList.get(index1);
                //temp.put("resource", tempVideo);
                temp.put("id", tempVideo.getId());
                temp.put("title", tempVideo.getTitle());
                temp.put("chapter", tempVideo.getChapter());
                temp.put("type", "视频");
                if (videoRecordDao.queryVideoRecord(studentId, tempVideo.getId()) != null) {
                    temp.put("hasRecord", true);
                } else temp.put("hasRecord", false);
                result.add(temp);

                if (index1 + 1 < size1 && videoList.get(index1).getChapter() != videoList.get(index1 + 1).getChapter()) {
                    index1++;
                    break;
                }
            }

            for ( ; index2 < size2; index2++) {
                temp = new HashMap<>();
                Test tempTest = assignmentList.get(index2);
                //temp.put("resource", tempTest);
                temp.put("id", tempTest.getId());
                temp.put("title", tempTest.getTitle());
                temp.put("chapter", tempTest.getChapter());
                temp.put("type", "作业");
                if (testRecordDao.queryTestRecord(studentId, tempTest.getId()).size() > 0) {
                    temp.put("hasRecord", true);
                } else temp.put("hasRecord", false);
                result.add(temp);

                if (index2 + 1 < size2 && assignmentList.get(index2).getChapter() != assignmentList.get(index2 + 1).getChapter()) {
                    index2++;
                    break;
                }
            }

        } while (index1 < size1 || index2 < size2);

        return result;
    }
}
