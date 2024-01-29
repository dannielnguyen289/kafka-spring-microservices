package com.dannielnguyen.consumer.module.second;

import com.dannielnguyen.consumer.module.second.query.InsertConsumerTaskPrt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecondHandleRepository {
    int  insertConsumerTask(InsertConsumerTaskPrt params);
}
