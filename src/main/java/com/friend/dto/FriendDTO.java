package com.friend.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
public class FriendDTO {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Long phoneNumber;
	
	private String friendName;
	
	private Long friendNumber;
}
