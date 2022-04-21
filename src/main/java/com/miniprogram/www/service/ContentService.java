package com.miniprogram.www.service;

import java.util.List;
import java.util.Map;

public interface ContentService {

    List< Map<String, Object> > getCourseContent(int studentId, int courseId);
}
