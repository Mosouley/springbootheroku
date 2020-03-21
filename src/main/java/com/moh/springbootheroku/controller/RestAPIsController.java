package com.moh.springbootheroku.controller;

import java.util.Arrays;

import com.moh.springbootheroku.model.Customer;
import com.moh.springbootheroku.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIsController {

    @Autowired
    CustomerRepository repository;

  @RequestMapping("/save")
  public String process(){
    // save a list of Customers
    repository.saveAll(Arrays.asList(new Customer("Jack", "Smith")
                    , new Customer("Adam", "Johnson"), 
                    new Customer("Kim", "Smith"),
                    new Customer("David", "Williams"), 
                    new Customer("Peter", "Davis")));
    
    return "Done";
  }
  
  @RequestMapping("/findall")
  public String findAll(){
    String result = "";
    
    for(Customer cust : repository.findAll()){
      result += cust.toString() + "<br>";
    }
    
    return result;
  }
  
  @RequestMapping("/findbyid")
  public String findById(@RequestParam("id") long id){
    String result = "";
    result = repository.findById(id).toString();
    return result;
  }
  
  @RequestMapping("/findbylastname")
  public String fetchDataByLastName(@RequestParam("lastname") String lastName){
    String result = "";
    
    for(Customer cust: repository.findByLastName(lastName)){
      result += cust.toString() + "<br>"; 
    }
    
    return result;
  }
}