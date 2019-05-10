package com.yl.service.impl;

import com.yl.entity.Reply;
import com.yl.mapper.ReplyMapper;
import com.yl.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Reply record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Reply record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Reply selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Reply record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Reply record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Reply> getReply(Long messageId) {
        return mapper.getReply(messageId);
    }
}
