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
import com.cinemamanage.dao.PaymentMethodDAO;
import com.cinemamanage.dto.AccountRequestDTO;
import com.cinemamanage.dto.AccountResponseDTO;
import com.cinemamanage.dto.PaymentMethodRequestDTO;
import com.cinemamanage.dto.PaymentMethodResponseDTO;

@Controller
public class PaymentMethodSearchController {
	@Autowired
	private PaymentMethodDAO paymentMethodDAO;
	
	@RequestMapping(value="/searchByPaymentMethodID/{paymentMethodID}",method=RequestMethod.GET)
	public String searchByID(@PathVariable String paymentMethodID,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		PaymentMethodRequestDTO req = new PaymentMethodRequestDTO();
		req.setPaymentMethodID(Integer.parseInt(paymentMethodID));
		ArrayList<PaymentMethodResponseDTO> list = paymentMethodDAO.searchByPaymentMethodId(req);
		model.addAttribute("paymentmethodlist", list);
		
		return "searchedPaymentMethodTable";
	}
	
	@RequestMapping(value="/searchByPaymentMethodName/{paymentMethodName}",method=RequestMethod.GET)
	public String searchByName(@PathVariable String paymentMethodName,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		PaymentMethodRequestDTO req = new PaymentMethodRequestDTO();
		req.setPaymentMethodName(paymentMethodName);
		ArrayList<PaymentMethodResponseDTO> list = paymentMethodDAO.selectByPaymentMethodName(req);
		model.addAttribute("paymentmethodlist", list);
		
		return "searchedPaymentMethodTable";
	}
	
	@RequestMapping(value="/searchByPaymentMethodPhone/{paymentMethodPhone}",method=RequestMethod.GET)
	public String searchByEmail(@PathVariable String paymentMethodPhone,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		PaymentMethodRequestDTO req = new PaymentMethodRequestDTO();
		req.setPaymentMethodPhone(paymentMethodPhone);
		ArrayList<PaymentMethodResponseDTO> list = paymentMethodDAO.selectByPaymentMethodPhone(req);
		model.addAttribute("paymentmethodlist", list);
		
		return "searchedPaymentMethodTable";
	}
	
	@RequestMapping(value="/searchByPaymentMethodAll/{paymentMethodID}/{paymentMethodName}/{paymentMethodPhone}",method=RequestMethod.GET)
	public String searchByAll(@PathVariable String paymentMethodID,@PathVariable String paymentMethodName,@PathVariable String paymentMethodPhone,ModelMap model,HttpSession session){
	    if(session.getAttribute("currentEmail")==null) {
	        return  "errorPage";
	       }
		PaymentMethodRequestDTO req = new PaymentMethodRequestDTO();
		req.setPaymentMethodID(Integer.parseInt(paymentMethodID));
		req.setPaymentMethodName(paymentMethodName);
		req.setPaymentMethodPhone(paymentMethodPhone);
		ArrayList<PaymentMethodResponseDTO> list = paymentMethodDAO.selectByPaymentMethodAll(req);
		model.addAttribute("paymentmethodlist", list);
		
		return "searchedPaymentMethodTable";
	}
}
