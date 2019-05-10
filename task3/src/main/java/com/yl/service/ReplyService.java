package com.yl.service;

import com.yl.entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyService {
    int deleteByPrimaryKey(Long id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List<Reply> getReply(@Param("messageId")Long messageId);
}
