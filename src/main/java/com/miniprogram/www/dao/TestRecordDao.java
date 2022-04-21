package com.miniprogram.www.dao;

import com.miniprogram.www.entity.TestRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestRecordDao {

    @Select("select * from test_record where student_id=#{studentId} and test_id=#{testId} order by total_score desc")
    List<TestRecord> queryTestRecord(int studentId, int testId);
}
