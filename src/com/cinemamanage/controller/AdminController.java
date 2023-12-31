package com.cinemamanage.controller;


import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cinemamanage.dao.PaymentDAO;
import com.cinemamanage.dto.AccountRequestDTO;
import com.cinemamanage.dto.AccountResponseDTO;
import com.cinemamanage.dto.PaymentResponseDTO;
import com.cinemamanage.model.AccountBean;



@Controller
public class AdminController {
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping(value="/incomeGraph",method=RequestMethod.GET)
	public String lineGraph(ModelMap model) {

		return "lineGraph";
	}
	
	@RequestMapping(value="/income",method=RequestMethod.GET)
	public String income(ModelMap model,HttpSession session) {
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		PaymentDAO paymentDAO = new PaymentDAO();
		ArrayList<PaymentResponseDTO> list= paymentDAO.selectAllNonPending();
		int amount = 0;
		for(PaymentResponseDTO res:list) {
			amount += res.getAmount();
		}
		model.addAttribute("income", amount);

		return "totalAmount";
	}
	
	@RequestMapping (value = "/userTable" , method = RequestMethod.GET)
	  public String usertable (ModelMap model,HttpSession session) {
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
	    AccountDAO dao = new AccountDAO();
	     
	    ArrayList<AccountResponseDTO> userList = dao.selectAllNomalUsers();
	    ArrayList<AccountResponseDTO> banList =  dao.selectAllBannedUsers();
	    model.addAttribute("userlist",userList);
	    model.addAttribute("banlist",banList);
	    return "userTable";
	  }
	
	@RequestMapping(value="/adminTable",method=RequestMethod.GET)
	public String adminTable(ModelMap model,HttpSession session) {
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		else {
		ArrayList<AccountResponseDTO> list =accountDAO.selectAllAdmins();
		model.addAttribute("adminlist", list);
		return "adminTable";}
	}
	
	@RequestMapping(value="/adminTableSort",method=RequestMethod.GET)
	public String adminTableSort(ModelMap model) {
		ArrayList<AccountResponseDTO> list =accountDAO.selectAllAdmins();
		model.addAttribute("adminlist", list);
		return "adminTable";
	}
	
	
	
	@RequestMapping (value = "/toaddAdmin",method = RequestMethod.GET)
	public ModelAndView toaddAdmin(HttpSession session) {
	    if(session.getAttribute("currentEmail")==null) {
	    	return new ModelAndView("errorPage","accountBean",new AccountBean());
	       }
		return new ModelAndView("addAdmin","accountBean",new AccountBean());
	}
	
	@RequestMapping (value = "/toaddUser",method = RequestMethod.GET)
	public ModelAndView toaddUser() {
		return new ModelAndView("userSignUp","accountBean",new AccountBean());
	}
	
	@RequestMapping (value = "/addAdmin",method = RequestMethod.POST)
	public String addAdmin(@ModelAttribute("accountBean")@Validated AccountBean bean,BindingResult result,ModelMap model,HttpSession session) {
		if(result.hasErrors()) {
		    if(session.getAttribute("currentEmail")==null) {
		        return  "errorPage";
		       }
			model.addAttribute("error","Name,Email and Password required!");
			return "addAdmin";
		}
		if(!bean.getAccountEmail().endsWith("@gmail.com")) {
			model.addAttribute("error","Email Should Contain @gmail.com");
			return "addAdmin";
		}
	    char[] nameA = bean.getAccountName().toCharArray();
	    if(nameA.length <= 4) {
	      model.addAttribute("error","Name should be more than 4 letter!");
	      return "addAdmin";
	    }
	    
	    for(int i=0;i<nameA.length;i++) {
	      int ascii=nameA[i];
	      
	      if(!(ascii > 64 && ascii < 91  || ascii > 96 && ascii < 123|| ascii == 32)) {
	        model.addAttribute("error","Name can't contain special character or Number!");
	        return "addAdmin";
	      }
	    }
		
        boolean error1 = false;
		
		ArrayList<AccountResponseDTO> datalist = accountDAO.selectAllAdmins();
		Iterator<AccountResponseDTO> it=datalist.iterator();
		
		while(it.hasNext()) {
              AccountResponseDTO dto=it.next();
              System.out.println(bean.getAccountEmail()+" ,"+ dto.getAccountEmail());
			if(bean.getAccountEmail().equals(dto.getAccountEmail())) {
				error1 = true;
				model.addAttribute("error","This email is already registered!");
				return "addAdmin";
			}
		}
		
		if(bean.getAccountPassword().equals(bean.getConfirmPassword())) {
			error1=false;
		}
		else  {
			error1=true;
			model.addAttribute("error","Password must be the same!");
		}
		
		char[] password=bean.getAccountPassword().toCharArray();
		for(int i=0;i<password.length;i++) {
			int space=password[i];
			
			if(space == 32) {
				error1 = true;
				model.addAttribute("error","Password must not be contain space!");
			}
		}
		if(password.length < 7) {
			error1 = true;
			model.addAttribute("error","Password must be 8-20!!");
		}
		else if(password.length > 20){
			error1 = true;
			model.addAttribute("error","Password must be 8-20!!");
		}
		
		if(bean.getAccountPassword().equals("12345678")) {
			error1 = true;
			model.addAttribute("error","Password too weak!");
		}
		
		if(error1 == true) {
			
			System.out.println("if error ture");
			return "addAdmin";
		}
		else {
			AccountRequestDTO dto = new AccountRequestDTO();
			dto.setAccountName(bean.getAccountName());
			dto.setAccountEmail(bean.getAccountEmail());
			dto.setAccountPassword(bean.getAccountPassword());
			dto.setAccountRole(bean.getAccountRole());
			int rs = accountDAO.insertData(dto);
			if(rs==0) {
				
				model.addAttribute("error","Insert Failed");
				return"addAdmin";
			}
			return "redirect:/adminTable";
		}
	}
	

	
	@RequestMapping(value="/setupUpdateAdmin/{adminCode}",method=RequestMethod.GET)
	public ModelAndView setupUpdateAdmin(@PathVariable String adminCode,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  new ModelAndView("errorPage","bean",new AccountBean());
	       }
		AccountRequestDTO req = new AccountRequestDTO();
		req.setAccountID(Integer.parseInt(adminCode));
		
		return new ModelAndView("adminUpdate","accountBean",accountDAO.selectOne(req));
	}
	
	@RequestMapping(value="/updateAdmin", method= RequestMethod.POST)
	public String updateAdmin(@ModelAttribute("accountBean") @Validated AccountBean bean, 
			BindingResult bs,ModelMap model,HttpSession session) {
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		if(bs.hasErrors()) {
			model.addAttribute("error","Field must be filed out!");
			return "adminUpdate";
		}
		
		if(!bean.getAccountEmail().endsWith("@gmail.com")) {
			model.addAttribute("error","Email Should Contain @gmail.com");
			return "addAdmin";
		}
	    char[] nameA = bean.getAccountName().toCharArray();
	    if(nameA.length <= 4) {
	      model.addAttribute("error","Name should be more than 4 letter!");
	      return "adminUpdate";
	    }
	    
	    for(int i=0;i<nameA.length;i++) {
	      int ascii=nameA[i];
	      
	      if(!(ascii > 64 && ascii < 91  || ascii > 96 && ascii < 123||ascii == 32)) {
	        model.addAttribute("error","Name can't contain special character or Number!");
	        return "adminUpdate";
	      }
	    }
		
		if(!bean.getAccountPassword().equals(bean.getConfirmPassword())) {
			 
			model.addAttribute("error","Error!!The Passwords should be the same!!");
			return"adminUpdate";
		}
		else {
			AccountRequestDTO dto = new AccountRequestDTO();
			dto.setAccountID(Integer.parseInt(bean.getAccountID()));
			dto.setAccountName(bean.getAccountName());
			dto.setAccountEmail(bean.getAccountEmail());
			dto.setAccountPassword(bean.getAccountPassword());
			dto.setAccountRole(bean.getAccountRole());
			session.setAttribute("currentEmail", bean.getAccountEmail());
			session.setAttribute("adminId",bean.getAccountID());
			session.setAttribute("currentAdminName", bean.getAccountName());
			int rs = accountDAO.updateData(dto);
			if(rs==0) {
				model.addAttribute("error","Update Failed");
				return"adminUpdate";
			}else {
				return "redirect:/adminTable";
			}
		}	
	}
	
	
	@RequestMapping(value="/deleteAdmin/{adminCode}", method= RequestMethod.GET)
	public String deleteAdmin(@PathVariable String adminCode,HttpSession session) {
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		AccountRequestDTO dto = new AccountRequestDTO();
		
		dto.setAccountID(Integer.parseInt(adminCode));
		accountDAO.deleteData(dto);
		
		
		return "redirect:/adminTable";
	}


	
	
	
}
