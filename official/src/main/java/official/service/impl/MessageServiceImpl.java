package official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import official.dal.mapper.MessageMapper;
import official.dal.po.Message;
import official.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public int addMessage(Message message) {
		return messageMapper.insertSelective(message);
	}

	@Override
	public int queryMessageListCount() {
		return messageMapper.selectMessageListCount();
	}

	@Override
	public List<Message> queryMessageList(int pageIndex, int pageSize) {
		return messageMapper.selectMessageList((pageIndex - 1) * pageSize, pageSize);
	}

}
