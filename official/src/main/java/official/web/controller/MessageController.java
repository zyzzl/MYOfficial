package official.web.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import official.common.util.Page;
import official.common.util.RexTool;
import official.dal.po.Message;
import official.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	/**
	 * 添加消息
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "addmessage", method = RequestMethod.POST)
	public String addMessage(Message message){
		if (!StringUtils.isNoneBlank(message.getName(), message.getTel(), message.getDetail())) {
			return "";
		}
		if (!RexTool.isHanZi(message.getName()) || !RexTool.isMobileNO(message.getTel()) || message.getDetail().length() > 100) {
			return "";
		}
		if (messageService.addMessage(message) != 1) {
			return "";
		}
		return null;
	}
	
	/**
	 * 查询消息列表 
	 * 
	 * @param map
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "messagelist", method = RequestMethod.POST)
	public String messageList(ModelMap map, Integer pageIndex, Integer pageSize){
		if (!StringUtils.isNoneBlank(pageIndex.toString(), pageSize.toString())) {
			return "";
		}
		int totalCount = messageService.queryMessageListCount();
		if (totalCount == 0) {
			return "";
		}
		Page page = new Page(pageIndex, pageSize, totalCount);
		List<Message> list = messageService.queryMessageList(pageIndex, pageSize);
		page.setT(list);
		map.put("userList", list);
		return null;
	}
	
	@RequestMapping("test")
	public String test(){
		return "news";
	}
}
