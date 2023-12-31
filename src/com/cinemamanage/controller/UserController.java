package com.cinemamanage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemamanage.dao.AccountDAO;
import com.cinemamanage.dto.AccountRequestDTO;
import com.cinemamanage.dto.AccountResponseDTO;
import com.cinemamanage.model.AccountBean;

@Controller
public class UserController {

	@RequestMapping(value = "/touserUpdate/{userId}",method = RequestMethod.GET)
	public ModelAndView touserUpdate(@PathVariable String userId,HttpSession session) {
	    if(session.getAttribute("currentUser")==null) {
	        return new ModelAndView("errorPage","bean",new AccountBean());
	       }
		AccountDAO dao = new AccountDAO();
		AccountRequestDTO dto = new AccountRequestDTO();
		dto.setAccountID(Integer.valueOf(userId));
		AccountResponseDTO data = dao.selectOne(dto);
		
		return new ModelAndView("userUpdate","accountBean",data);
	}
	
	@RequestMapping(value = "/userUpdate",method = RequestMethod.POST)
	public String userUpdate(@ModelAttribute("accountBean")@Validated AccountBean bean,BindingResult rs,ModelMap model,HttpSession session) {
	    if(session.getAttribute("currentUser")==null) {
	        return  "errorPage";
	       }
		if(rs.hasErrors()) {
			model.addAttribute("error","Data can't be blank!");
			return "userUpdate";
		}
		if(!bean.getAccountEmail().endsWith("@gmail.com")) {
			model.addAttribute("error","Email Should Contain @gmail.com");
			return "userUpdate";
		}
	    char[] nameA = bean.getAccountName().toCharArray();
	    if(nameA.length <= 4) {
	      model.addAttribute("error","Name should be more than 4 letter!");
	      return "userUpdate";
	    }
	    
	    for(int i=0;i<nameA.length;i++) {
	      int ascii=nameA[i];
	      
	      if(!(ascii > 64 && ascii < 91  || ascii > 96 && ascii < 123||ascii == 32)) {
	        model.addAttribute("error","Name can't contain special character or Number!");
	        return "userUpdate";
	      }
	    }
		
		boolean error = false;
		AccountRequestDTO dto = new AccountRequestDTO();
		AccountDAO dao = new AccountDAO();
		
		if(!bean.getAccountPassword().equals(bean.getConfirmPassword())) {
			model.addAttribute("error","Error!!The Passwords should be the same!!");
			error = true;
		}
		
		dto.setAccountID(Integer.valueOf(bean.getAccountID()));
		dto.setAccountName(bean.getAccountName());
		dto.setAccountEmail(bean.getAccountEmail());
		dto.setAccountPassword(bean.getAccountPassword());
		dto.setAccountRole("user");
		dto.setAccountStatus("unban");
		
		int result = dao.updateData(dto);
		if(result==0) {
			model.addAttribute("error","Update Failed! Something went wrong!");
			error = true;
		}
		
		if(error == false) {
			return "redirect:/";
		}
		else {
			return "userUpdate";
		}
	}
}
