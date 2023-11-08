package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import web.dao.face.MemberDao;
import web.service.face.MemberService;


@Controller
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired MemberService memberService;
	@Autowired MemberDao memberDao;
	
	public void login() {}
	public void logout() {}
	public void join() {}
	public void main() {}
	
}
