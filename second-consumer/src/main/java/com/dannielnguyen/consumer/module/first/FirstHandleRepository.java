package com.dannielnguyen.consumer.module.first;

import com.dannielnguyen.consumer.module.first.query.InsertConsumerTaskPrt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FirstHandleRepository {
    int  insertConsumerTask(InsertConsumerTaskPrt params);
}
