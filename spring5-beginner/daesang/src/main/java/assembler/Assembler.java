package assembler;

import chap3.ChangePasswordService;
import chap3.MemberDao;
import chap3.MemberRegisterService;

public class Assembler {
	
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		this.memberDao = new MemberDao();
		this.regSvc = new MemberRegisterService(memberDao);
		this.pwdSvc = new ChangePasswordService();
		this.pwdSvc.setMemberDao(memberDao);
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
