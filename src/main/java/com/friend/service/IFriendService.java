package com.friend.service;

import java.util.List;

import com.friend.dto.ContactDTO;
import com.friend.dto.FriendDTO;

public interface IFriendService {

	public String addFriend(FriendDTO friendDto);
	public List<Long> getFriendsContactNumbers(Long phoneNumber);
	public List<ContactDTO> getContacts(Long phoneNumber);
}
