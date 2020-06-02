package com.friend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friend.dto.ContactDTO;
import com.friend.dto.FriendDTO;
import com.friend.entity.Friend;
import com.friend.repository.FriendRepository;
import com.friend.service.IFriendService;

@Service
public class FriendServiceImpl implements IFriendService {

	@Autowired
	private FriendRepository repository;
	
	@Override
	public String addFriend(FriendDTO friendDto) {
		Integer count = repository.isFriendExist(friendDto.getPhoneNumber(), friendDto.getFriendNumber());
		if(count==0) {
		Friend friend=new Friend();
		BeanUtils.copyProperties(friendDto, friend);
		repository.save(friend);
		return "Your Friend contact saved successfully";
		}
		else {
			return "Already your friend contact is Exist";
		}
		
	}

	@Override
	public List<Long> getFriendsContactNumbers(Long phoneNumber) {
		List<Long> contactNumbers = repository.getFriendContactNumbers(phoneNumber);
		return contactNumbers;
	}

	@Override
	public List<ContactDTO> getContacts(Long phoneNumber) {
		List<Object[]> contactsInfo = repository.getContacts(phoneNumber);
		List<ContactDTO> contactDtoList=new ArrayList<ContactDTO>();
		ContactDTO contactDTO=new ContactDTO();
		for(Object[] ob: contactsInfo) {
			System.out.println("name is "+ob[0]+" number "+ob[1]);
			contactDTO.setFriendName(ob[0].toString());
			Long number=(Long)(ob[1]);
			contactDTO.setFriendNumber(number);
			contactDtoList.add(contactDTO);
		}
		return contactDtoList;
	}

}
