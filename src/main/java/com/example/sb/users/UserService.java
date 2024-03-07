package com.example.sb.users;

import java.util.List;

public interface UserService {
	// 로그인 시도에 따른 정수값
	public static final int CORRECT_LOGIN = 0; // 로그인 성공
	public static final int WRONG_PASSWORD = 1; // 잘못된 비밀번호
	public static final int USER_NOT_EXIST = 2; // 잘못된 ID
	public static final int COUNT_PER_PAGE = 10; // 페이지 당 출력할 유저의 수

	// 사용자 등록
	void registerUser(User user); 
	
	// 사용자 조회(ID)
	User getUserByUid(String uid);
	
	// 사용자 목록 조회 
	List<User> getUserList(int page);
	
	// 페이지 수 조회
	int getUserCount();
	
	// 사용자 정보 갱신
	void updateUser(User user);
	
	// 사용자 삭제
	void deleteUser(String uid);
	
	// 사용자 로그인 (정수값에 따라 다른 상태를 나타내도록)
	int login(String uid, String pwd);
}