package com.friend.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.friend.dto.ContactDTO;
import com.friend.dto.FriendDTO;
import com.friend.service.IFriendService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class FriendRestController {

	@Autowired
	private IFriendService service;
	
	@PostMapping("/addFriend")
	@ApiOperation(value = "this end point for adding Friend contact")
	public String addFriend(@ApiParam(value = "this handler need Friend json object of data " )@RequestBody FriendDTO friendDto) {
		FriendDTO fdto=new FriendDTO();
		friendDto.setId(fdto.getId());
		try {
		return service.addFriend(friendDto);
		}catch (Exception e) {
			e.printStackTrace();
		return "Some thing in server please check once";
		}
	}
	
	@GetMapping("friend/{phoneNumber}")
	@ApiOperation(value = "this is endpoint for getting friend contact number")
	public ResponseEntity<?> getFriendContactNumbers(@ApiParam(value = "it takes phone number " )@PathVariable Long phoneNumber){
		ResponseEntity<?> resp=null;
		try {
			List<Long> contactNumbers = service.getFriendsContactNumbers(phoneNumber);
			resp=new ResponseEntity<List<Long>>(contactNumbers,HttpStatus.OK);
			return resp;
		}catch (Exception e) {
					e.printStackTrace();
					resp=new ResponseEntity<String>("Some thing wrong please Check once", HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
		}
	}
	
	
	@GetMapping("contacts/{phoneNumber}")
	@ApiOperation(value = "this is endpoint for getting friend contact details ")
	public ResponseEntity<?> getFriendContactInfo(@ApiParam(value = "it takes phone number " )@PathVariable Long phoneNumber){
		ResponseEntity<?> resp=null;
		try {
			List<ContactDTO> conatactsInfo = service.getContacts(phoneNumber);
			resp=new ResponseEntity<List<ContactDTO>>(conatactsInfo ,HttpStatus.OK);
			return resp;
		}catch (Exception e) {
					e.printStackTrace();
					resp=new ResponseEntity<String>("Some thing wrong please Check once", HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
		}
	}
	
	
	
}
