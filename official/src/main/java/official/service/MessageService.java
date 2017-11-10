package official.service;

import java.util.List;

import official.dal.po.Message;

public interface MessageService {

	/**
	 * 添加消息
	 * 
	 * @param message
	 * @return
	 */
	int addMessage(Message message);
	
	/**
	 * 查询消息数量
	 * 
	 * @return
	 */
	int queryMessageListCount();
	
	/**
	 * 查询消息列表
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<Message> queryMessageList(int pageIndex, int pageSize);
}
