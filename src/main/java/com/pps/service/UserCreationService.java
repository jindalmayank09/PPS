package com.pps.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pps.bean.GenericResponseDTO;
import com.pps.dao.impl.UserDaoImpl;
import com.pps.model.BaseEntity;
import com.pps.model.SubUser;
import com.pps.model.User;
import com.pps.repository.UserCreationRepository;
import com.pps.util.ExcelWriter;
import com.pps.util.PdfUtil;

@Service
public class UserCreationService {

	@Autowired
	private UserCreationRepository userCreationRepo;

	@Autowired
	private UserDaoImpl userDaoImpl;

	@Autowired
	private ExcelWriter excelWriter;

	@Autowired
	private PdfUtil pdfUtil;

	private @Value("${sequence_name}") String seqName;

	public User createNewUser(User user) {

		User userObj = user;
		fillBeanBasicDtls(user, "Admin");
		String action = user.getAction() != null && !user.getAction().isEmpty() ? user.getAction() : "";
		if ("create".equalsIgnoreCase(action.trim())) {
			user.setRegNo(getUserIdPrefix() + generateUserSequence(seqName, true));
		} else if ("edit".equalsIgnoreCase(action.trim())) {
			userObj = userCreationRepo.getOne(user.getUserId());
			if (userObj != null)
				BeanUtils.copyProperties(user, userObj);
			else
				userObj = user;
		}
		return userCreationRepo.save(userObj);
	}

	public List<User> getAllUserList(User user) {

		if (user != null) {
			if (user.getRegNo() != null && !user.getRegNo().isEmpty()) {
				return userCreationRepo.findByRegNo(user.getRegNo());
			}
			if (user.getUserName() != null && !user.getUserName().isEmpty()) {
				return userCreationRepo.findByUserName(user.getUserName());
			}
			return userCreationRepo.getAllUsers();
		}
		return userCreationRepo.getAllUsers();
	}

	public String generateUserSequence(String sequenceName, Boolean isMainSeq) {
		return String.format(isMainSeq ? "%08d" : "%05d", userDaoImpl.getNextUserId(sequenceName));

	}

	public User getUserDtlsByUserId(User user) {

		return userCreationRepo.getOne(user.getUserId());

	}

	public String getUserIdPrefix() {
		return "PRGKMB2019/";
	}

	public String getUserIdSuffix(String userType) {
		return "/" + userType;
	}

	public User createSubUserDtls(User user) {
		User userObj = userCreationRepo.getOne(user.getUserId());
		if (userObj != null) {
			String regNo = userObj.getRegNo();
			String userName = userObj.getUserName() != null && !userObj.getUserName().isEmpty() ? userObj.getUserName()
					: "Admin";
			fillBeanBasicDtls(userObj, "Admin");
			String action = user.getAction() != null && !user.getAction().isEmpty() ? user.getAction() : "";
			if ("create".equalsIgnoreCase(action.trim())) {
				if (user.getSubUsersList() != null && !user.getSubUsersList().isEmpty()) {
					int i = 1;
					for (SubUser subUser : user.getSubUsersList()) {
						subUser.setRegNo(regNo + "/" + String.format("%03d", i));
						fillBeanBasicDtls(subUser, userName);
						i++;
						subUser.setUser(userObj);
					}
					userObj.setSubUsersList(user.getSubUsersList());
				}
			}
		}
		return userCreationRepo.save(userObj);
	}

	public void fillBeanBasicDtls(BaseEntity baseEntity, String userName) {
		baseEntity.setLastUpdatedTime(new Date());
		baseEntity.setCreationTime(new Date());
		baseEntity.setCreatedBy(userName);
		baseEntity.setStatus(true);

	}

	public ResponseEntity<?> getAllUsersSelectedColumns(User
	  user,HttpServletRequest request,HttpServletResponse response) { 
		List<User> userObjList = new ArrayList<User>();
	  userObjList = userDaoImpl.getAllUsersSelectedColums(user); return
	  excelWriter.writeExcelOnLoc(user, userObjList, request, response); }

	public ResponseEntity<?> getUsersDtlsInPdf(User user, HttpServletRequest request, HttpServletResponse response) { // TODO
																														// Auto-generated
																														// method
																														// stub
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatus("FAIL");
		genericResponseDTO.setResponseCode(HttpStatus.NOT_FOUND.toString());
		genericResponseDTO.setResponseMsg("DATA NOT_FOUND");

		User user2 = userCreationRepo.getOne(user.getUserId());
		if (user2 != null)
			return pdfUtil.createPdf(user2, request, response);
		else
			return new ResponseEntity<Object>(genericResponseDTO, HttpStatus.NOT_FOUND);
	}

	/*
	 * public UserMaster createUser(UserMaster user) {
	 * 
	 * List<UserAddress> userAddresses = new ArrayList<>();
	 * 
	 * userAddresses = user.getUsersAddressList(); for (UserAddress userAddress :
	 * userAddresses) { userAddress.setUserMaster(user); }
	 * user.setUsersAddressList(userAddresses); UserMaster user2 =
	 * userCreationRepo.findByContactNo(user.getContactNo()); if (user2 != null) {
	 * user.setIsUserExist(true); user.setUserExistMsg("Duplicate User Details!!");
	 * return user;
	 * 
	 * } else { user.setIsUserExist(false); return userCreationRepo.save(user); } }
	 */

}
