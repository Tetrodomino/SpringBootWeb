package com.example.sb.users;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

// Mapper가 있어야 select 등을 사용 가능
@Mapper
public interface UserDao {

	// sql 문구를 스프링에서 사용하는 방법
	@Select("select * from users where uid=#{uid}") // #{uid} 자리에 매개변수 uid가 들어감
	User getUser(String uid);
	
	@Select("select * from users where isDeleted=0"
			+ " order by regDate desc"
			+ " limit #{count} offset #{offset}")
	List<User> getUserList(int count, int offset);
	
	@Insert("insert into users values (#{uid}, #{pwd}, #{uname}"
			+ ", #{email}, default, default)")
	void insertUser(User user);
	
	@Update("update users set pwd=#{pwd}, uname=#{uname}, email=#{email} where uid=#{uid}")
	void updateUser(User user);
	
	@Update("update users set isDeleted=1 where uid=#{uid}")
	void deleteUser(String uid);
	
	@Select("Select count(uid) from users where isDeleted=0")
	int getUserCount();
}
