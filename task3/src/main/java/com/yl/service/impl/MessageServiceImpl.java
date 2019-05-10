package com.yl.service.impl;

import com.yl.entity.Message;
import com.yl.mapper.MessageMapper;
import com.yl.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Message record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Message record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Message> getMessage(Long articleId, Integer state) {
        return mapper.getMessage(articleId,state);
    }
}
