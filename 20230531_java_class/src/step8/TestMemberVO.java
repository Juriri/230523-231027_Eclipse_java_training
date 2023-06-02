package step8;

public class TestMemberVO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberVO vo = new MemberVO("id","password",1000);
		System.out.println(vo.getId());
		vo.setId("hjlee"); //생성자 "id" 초기화 값에서 "hjlee"로 변경시
		System.out.println(vo.getId());
	}

}
