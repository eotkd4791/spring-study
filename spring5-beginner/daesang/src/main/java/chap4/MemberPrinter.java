package chap4;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {
	
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter()  {
		this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}

	// dateTimeFormatter 값이 null인 경우와 null이 아닌 경우의 동작을 다르게하여 작성하면
	// 아래의 Autowired를 통한 자동 주입시 매칭되는 빈이 없으면 예외 발생함
	public void print(Member member) {
		if(dateTimeFormatter == null) {
			System.out.printf(
				"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
				member.getId(),
				member.getEmail(),
				member.getName(),
				member.getRegisterDateTime()
			);
		} else {
			System.out.printf(
				"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
				member.getId(),
				member.getEmail(),
				member.getName(),
				dateTimeFormatter.format(member.getRegisterDateTime())
			);			
		}
	}
	
	// 매칭되는 빈이 없으면 예외가 발생함. 
	// 의도한 동작은 null로 할당되어 있는대로 동작을 하면 되는데 예외가 발생해서 멈춰버림.
	// 자동 주입 대상이 필수가 아님을 지정해준다.
	
//  #1
	@Autowired(required = false)
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) { 
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
	
//  #2
//	@Autowired
//	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) { 
//		if(formatterOpt.isPresent()) {
//			this.dateTimeFormatter = formatterOpt.get();
//		} else {
//			this.dateTimeFormatter = null;
//		}
//	}
	
//	#3
//	@Autowired
//	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}
}
