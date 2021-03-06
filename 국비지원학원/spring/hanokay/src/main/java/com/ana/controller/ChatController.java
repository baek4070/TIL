package com.ana.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ana.domain.ChatRomVO;
import com.ana.domain.MsgVO;
import com.ana.domain.UserVO;
import com.ana.service.ChatRomService;
import com.ana.service.MsgService;
import com.ana.service.RevService;
import com.ana.service.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class ChatController {
	private UserVO user;
	private String userNum;

	@Autowired
	private MsgService service;
	@Autowired
	private UserService uService;
	@Autowired
	private ChatRomService chService;

	@RequestMapping(value = "chat/chattingView", method = RequestMethod.GET)
	public ModelAndView chat(ModelAndView mv, HttpSession session) {
		user = (UserVO) session.getAttribute("user");

		if (user != null) {
			System.out.println("<D<D<F>D<D>D<D>" + user.getUserEmail());

			mv.setViewName("chat/chattingView");
			mv.addObject("Userid", user.getUserEmail());
		} else {
			mv.setViewName("acm/list");
		}
		return mv;
	}

	@PostMapping({ "chat/chatRoom", "chat/chatRoom2", "chat/chatRoom3" })
	public ModelAndView chatRoom(@RequestParam("chatromnum") String chatromnum,
			@RequestParam("requestURL") String requestURL, ModelAndView mv, HttpSession session) {

		String otherUser = "";
		user = (UserVO) session.getAttribute("user");
		// ?????????????????????
		System.out.println("??????????????? >> " + requestURL);
		if (user != null) {

			// ?????? ???????????? ????????? ????????????????????????
			if (chatromnum.split("::")[0].equals("newChatr")) {
				System.out.println(">>> ????????? ??????????????? ????????? ?????????");
				String[] chatInfoArr = chatromnum.split("::");

				// ?????? ??? ???????????? ????????????

				if (chService.findChatRom(chatInfoArr[1], user.getUserNum()).size() != 0) {

					System.out.println(">>>?????? ??????");

					chatromnum = chService.findChatRom(chatInfoArr[1], user.getUserNum()).get(0).getChatromnum();

					ChatRomVO vo = chService.readChat(chatromnum);

					// ????????????
					if (vo.getParticipant1().equals(user.getUserNum())) {
						otherUser = vo.getParticipant2();
					} else {
						otherUser = vo.getParticipant1();
					}

				} else {
					System.out.println(">>> ????????? ???????????????");
					ChatRomVO chatRoom = new ChatRomVO();

					// ?????? ??????
					chatRoom.setParticipant1(user.getUserNum());
					chatRoom.setParticipant2(chatInfoArr[1]);
					chatRoom.setLstaccessor(user.getUserNum());
					chatRoom.setLastchat(user.getUserFstName() + "?????? ?????????????????????.");

					System.out.println(chatInfoArr[1] + "");
					chatromnum = chService.startChat(chatRoom);

					otherUser = chatInfoArr[1];
				}

			} else {

				System.out.println(">>> ?????????????????? ???????????????");
				ChatRomVO vo = chService.readChat(chatromnum);

				// ????????????
				if (vo.getParticipant1().equals(user.getUserNum())) {
					otherUser = vo.getParticipant2();
				} else {
					otherUser = vo.getParticipant1();
				}

			}

			// ?????? ????????????
			List<MsgVO> conversation = service.readConversation(user.getUserNum(), otherUser);

			// ?????? ???????????? ????????? ?????? ????????? ?????????

			if (conversation.size() != 0) {

				for (MsgVO msg : conversation) {
					if (msg.getUnumTo().contentEquals(user.getUserNum())) {
						// ???????????? ????????????
						service.marksRead(msg.getMsgNum());
					}
				}

			}

			System.out.println("????????? ?????????  ?????????>" + otherUser + "???>" + user.getUserFstName());

			// ????????????
			mv.addObject("user", user);
			mv.addObject("chatromnum", chatromnum);
			mv.addObject("toUser", uService.get(otherUser));
			mv.addObject("conversation", conversation);

		} else {
			// ???????????? ??????????????????
			mv.setViewName("/user/login");
		}
		return mv;
	}

	@GetMapping({ "chat/chatList", "chat/chatList2", "chat/chatList3" })
	public ModelAndView chatList(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		log.info("__");
		user = (UserVO) session.getAttribute("user");
		if (user != null) {

			// ????????? ?????? ????????????
			String url = request.getHeader("referer").split("/")[3]; // => acm/list

			// ?????????????????????

			if (null != chService.readChatlist(user.getUserNum())) {

				List<ChatRomVO> chattingRoomList = chService.readChatlist(user.getUserNum());

				for (ChatRomVO vo : chattingRoomList) {
					// ?????? ??? ?????????????????????

					if (vo.getParticipant1().equals(user.getUserNum())) {
						vo.setOtherUser(uService.get(vo.getParticipant2()));
					} else {
						vo.setOtherUser(uService.get(vo.getParticipant1()));
					}

					// ????????? ????????? ???????????? ????????????

					List<MsgVO> conversation = service.readConversation(user.getUserNum(),
							vo.getOtherUser().getUserNum());

					int count = 0;
					if (conversation.size() != 0) {

						for (MsgVO msg : conversation) {
							if (msg.getUnumTo().contentEquals(user.getUserNum())) {
								if (msg.getReadStatus().trim().equals("F")) {
									count++;
								}
							}
						}
					}
					// ?????? ???????????? ????????? ?????? ????????? ?????????

					log.info("4");
					log.info(vo.getOtherUser().getUserFstName() + ":unread::" + count);
					vo.setUnread("" + count);
				}
				mv.addObject("requestURL", url);
				mv.addObject("chatList", chattingRoomList);

				return mv;

			} else {
				mv.setViewName("/user/login");
				return mv;
			}

		} else {
			mv.setViewName("/user/login");
			return mv;
		}
	}

	@PostMapping(value = "chat/sendMsg")
	@ResponseBody
	public ResponseEntity<List<MsgVO>> sendMsg(MsgVO vo, HttpSession session) {

		user = (UserVO) session.getAttribute("user");
		// ????????? ??????????????????
		if (user != null) {

			// ???????????? ???????????? ????????????
			if (vo.getMsgContent() != "" && vo.getMsgContent() != null) {

				// ????????? ????????????-????????????
				service.sendMsg(vo);

				System.out.println("?????? Msg : " + vo.getMsgContent() + "::" + vo.getUnumFrom() + ">>>>" + vo.getUnumTo()
						+ "::" + vo.getChatromnum());

				// ??????????????????????????????
				chService.updateChatrom(vo.getMsgContent(), user.getUserNum(), vo.getChatromnum());
			}

			List<MsgVO> conversation = service.readConversation(user.getUserNum(), vo.getUnumTo());
			if (conversation.size() != 0) {

				for (MsgVO msg : conversation) {
					if (msg.getUnumTo().contentEquals(user.getUserNum())) {
						service.marksRead(msg.getMsgNum());
					}
				}
			}
			ResponseEntity<List<MsgVO>> result = new ResponseEntity<List<MsgVO>>(conversation, HttpStatus.OK);
			return result;
		}
		return null;
	}

	@PostMapping(value = "/unreadMsg")
	@ResponseBody
	public ResponseEntity<String> unreadMsg(HttpSession session) {

		user = (UserVO) session.getAttribute("user");
		// ????????? ??????????????????
		if (user != null) {
			service.unreadMsg(user.getUserNum());
			return new ResponseEntity<String>("" + (service.unreadMsg(user.getUserNum())), HttpStatus.OK);
		}
		return null;

	}

}