package chap3_6;

import java.util.Collection;

public class MemberListPrinter {

	private final MemberDao memberDao;
	private final MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(member -> printer.print(member));
	}
}
