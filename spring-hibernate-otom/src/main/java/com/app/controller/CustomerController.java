package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.dto.AddressDto;
import com.app.dto.CustomerDto;
import com.app.serive.api.CustomerService;

@Controller
@RequestMapping("/admin/")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = { "/" })
	public String viewRegistration(ModelMap model) {
		CustomerDto customerDto = new CustomerDto();
		List<AddressDto> addressDtoList = new ArrayList<AddressDto>();
		AddressDto addressDto1 = new AddressDto();
		AddressDto addressDto2 = new AddressDto();
		addressDtoList.add(addressDto1);
		addressDtoList.add(addressDto2);
		customerDto.setAddressesDto(addressDtoList);
		model.addAttribute("customerForm", customerDto);

		return "registration";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String saveCustomer(Model model, @ModelAttribute("customerForm") CustomerDto customerDto,
			BindingResult bindingResult) {
		customerService.saveCustomer(customerDto);
		return "redirect:/";
	}

	@ModelAttribute("list")
	public List<CustomerDto> getCustomers() {
		return customerService.getCustomers();
	}
	
	public void codeChangesTest(){
	}

}
