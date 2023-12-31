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
public class AdminSearchController {
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping(value="/searchByAdminID/{adminCode}",method=RequestMethod.GET)
	public String searchByID(@PathVariable String adminCode,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		AccountRequestDTO req = new AccountRequestDTO();
		req.setAccountID(Integer.parseInt(adminCode));
		ArrayList<AccountResponseDTO> list = accountDAO.searchByAdminId(req);
		model.addAttribute("adminlist", list);
		
		return "searchedAdminTable";
	}
	
	@RequestMapping(value="/searchByAdminName/{accountName}",method=RequestMethod.GET)
	public String searchByName(@PathVariable String accountName,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		AccountRequestDTO req = new AccountRequestDTO();
		req.setAccountName(accountName);
		ArrayList<AccountResponseDTO> list = accountDAO.selectByAdminName(req);
		System.out.print(list.size());

		model.addAttribute("adminlist", list);
		
		return "searchedAdminTable";
	}
	
	@RequestMapping(value="/searchByAdminEmail/{accountEmail}",method=RequestMethod.GET)
	public String searchByEmail(@PathVariable String accountEmail,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		AccountRequestDTO req = new AccountRequestDTO();
		req.setAccountEmail(accountEmail);
		ArrayList<AccountResponseDTO> list = accountDAO.selectByAdminEmail(req);
		model.addAttribute("adminlist", list);
		
		return "searchedAdminTable";
	}
	
	@RequestMapping(value="/searchByAdminAll/{accountId}/{accountName}/{accountEmail}",method=RequestMethod.GET)
	public String searchByAll(@PathVariable String accountId,@PathVariable String accountName,@PathVariable String accountEmail,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		AccountRequestDTO req = new AccountRequestDTO();
		req.setAccountID(Integer.parseInt(accountId));
		req.setAccountName(accountName);
		req.setAccountEmail(accountEmail);
		ArrayList<AccountResponseDTO> list = accountDAO.selectByAdminAll(req);
		model.addAttribute("adminlist", list);
		
		return "searchedAdminTable";
	}
}
