package com.friend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.friend.entity.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer> {

	@Query(value = "select count(*) from friend where phone_no=? and friend_no=? ", nativeQuery = true)
	Integer isFriendExist(Long phoneNumber, Long friendNumber);
	
	@Query(value = "select friend_name, friend_no from friend where phone_no=? ", nativeQuery = true)
	List<Object[]> getContacts(Long phoneNumber);
	
	@Query(value = "select friend_no from friend where phone_no=? ", nativeQuery = true)
	List<Long> getFriendContactNumbers(Long phoneNumber);
}
