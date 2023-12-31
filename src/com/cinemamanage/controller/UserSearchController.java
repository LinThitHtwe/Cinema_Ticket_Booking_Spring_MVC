package com.cinemamanage.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinemamanage.dao.AccountDAO;
import com.cinemamanage.dto.AccountRequestDTO;
import com.cinemamanage.dto.AccountResponseDTO;

@Controller
public class UserSearchController {
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping(value="/searchByUserID/{adminCode}",method=RequestMethod.GET)
	public String searchByID(@PathVariable String adminCode,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		AccountRequestDTO req = new AccountRequestDTO();
		req.setAccountID(Integer.parseInt(adminCode));
		ArrayList<AccountResponseDTO> list = accountDAO.searchByUnBanUserId(req);
		model.addAttribute("userlist", list);
		ArrayList<AccountResponseDTO> banList =  accountDAO.searchByBanUserId(req);
		model.addAttribute("banlist",banList);
		
		return "searchedUserTable";
	}
	
	@RequestMapping(value="/searchByUserName/{accountName}",method=RequestMethod.GET)
	public String searchByName(@PathVariable String accountName,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		AccountRequestDTO req = new AccountRequestDTO();
		req.setAccountName(accountName);
		ArrayList<AccountResponseDTO> list = accountDAO.selectByUnbanUserName(req);;
		ArrayList<AccountResponseDTO> banList =  accountDAO.selectByBanUserName(req);
		model.addAttribute("banlist",banList);
		model.addAttribute("userlist", list);
		
		return "searchedUserTable";
	}
	
	@RequestMapping(value="/searchByUserEmail/{accountEmail}",method=RequestMethod.GET)
	public String searchByEmail(@PathVariable String accountEmail,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		AccountRequestDTO req = new AccountRequestDTO();
		req.setAccountEmail(accountEmail);
		ArrayList<AccountResponseDTO> list = accountDAO.selectByUnbanUserEmail(req);
		model.addAttribute("userlist", list);
		ArrayList<AccountResponseDTO> banList =  accountDAO.selectByBanUserEmail(req);
		model.addAttribute("banlist",banList);
		
		return "searchedUserTable";
	}
	
	@RequestMapping(value="/searchByUserAll/{accountId}/{accountName}/{accountEmail}",method=RequestMethod.GET)
	public String searchByAll(@PathVariable String accountId,@PathVariable String accountName,@PathVariable String accountEmail,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		AccountRequestDTO req = new AccountRequestDTO();
		req.setAccountID(Integer.parseInt(accountId));
		req.setAccountName(accountName);
		req.setAccountEmail(accountEmail);
		ArrayList<AccountResponseDTO> list = accountDAO.selectByUnbanUserAll(req);
		model.addAttribute("userlist", list);
		ArrayList<AccountResponseDTO> banList =  accountDAO.selectByBanUserAll(req);
		model.addAttribute("banlist",banList);
		
		return "searchedUserTable";
	}
}
