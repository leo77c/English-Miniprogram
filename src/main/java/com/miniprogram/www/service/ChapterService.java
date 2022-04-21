package com.miniprogram.www.service;

import com.miniprogram.www.entity.Chapter;

import java.util.List;

public interface ChapterService {

    List<Chapter> getChapterListForCourse(int courseId);
}
