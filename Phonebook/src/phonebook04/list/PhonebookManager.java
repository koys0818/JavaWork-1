package phonebook04.list;

import java.util.ArrayList;

// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb {

	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();

	// singleton 적용
	private PhonebookManager() {
	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}

	// 전화번호부 생성등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		
		// 매개변수 검증 : 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}
		
		PhonebookModel pbmodel = new PhonebookModel(name, phoneNum, memo);
		pbmodel.setUid(getMaxUid() + 1);

		pbList.add(pbmodel);

		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		
		PhonebookModel[] pbmodels = new PhonebookModel[pbList.size()];
		for (int i = 0; i < pbmodels.length; i++) {
			pbmodels[i] = pbList.get(i);
		}
		
//		pbList.toArray(new PhonebookModel[pbList.size()]);
		
		
		return pbmodels;


	}

	// 특정 uid의 데이터 검색 리턴
	// 못  찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		int index = findIndexByUid(uid);
		if(index >= 0)
			return pbList.get(index);		
		else
			return null; // 못 찾으면 null 리턴
	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);
			
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING); // 이름 필수

		// 특정 uid 값을 가진 데이터의 배열인덱스 찾기
		
		
		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("update() 없는 uid: " + uid, Pb.ERR_UID);
		

		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);
		

		return 1;
	}

	@Override
	public int deleteByUid(int uid) {		
		
		if(uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		int index = findIndexByUid(uid);
		if(index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid: " + uid, Pb.ERR_UID);
		
		pbList.remove(index);		
		
		return 1;
	}

	// 현재 데이터 중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;
		for (int index = 0; index < pbList.size(); index++) {
			if (maxUid < pbList.get(index).getUid()) {
				maxUid = pbList.get(index).getUid();
			}
		}

		return maxUid;
	}

	// 특정 uid 값을 가진 데이터의 배열인덱스 찾기
	private int findIndexByUid(int uid) {
		
		for (int index = 0; index < pbList.size(); index++) {

			if (pbList.get(index).getUid() == uid) {
				return index;				
			}
		}
		
		return -1;
	}
}  // end PhonebookManager

// 예외 클래스 정의
// 예외 발생하면 '에러코드' + '에러메시지'를 부여하여 관리하는게 좋다.

class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;
	
	public PhonebookException() {
		super("Phonebook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] +
				" " + super.getMessage();
		return msg;
	}
}
