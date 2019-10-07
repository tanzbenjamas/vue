package com.sut.sa.g13.Controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sut.sa.g13.Entity.*;
import com.sut.sa.g13.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private BankRepository bankRepository;

        @GetMapping("/employee")
        public Collection<Employee> employee(){
            return employeeRepository.findAll().stream().collect(Collectors.toList());
        }

        @GetMapping("/gender")
        public Collection<Gender> gender(){
            return genderRepository.findAll().stream().collect(Collectors.toList());
        }

        @GetMapping("/province")
        public Collection<Province> province(){
            return provinceRepository.findAll().stream().collect(Collectors.toList());
        }

        @GetMapping("/position")
        public Collection<Position> position(){
            return positionRepository.findAll().stream().collect(Collectors.toList());
        }

        @GetMapping("/bank")
        public Collection<Bank> bank(){
            return bankRepository.findAll().stream().collect(Collectors.toList());
        }

        @PostMapping("/employee/{nameInfo}/{genderid}/{idcard}/{address}/{provinceid}/{phone}/{positionid}/{bankid}/{banknum}/{user}/{pass}")
        public Employee newEmployee(Employee newEmployee,
                @PathVariable String nameInfo,
                @PathVariable Long genderid,
                @PathVariable String idcard,
                @PathVariable String address,
                @PathVariable Long provinceid,
                @PathVariable String phone,
                @PathVariable Long positionid,
                @PathVariable Long bankid,
                @PathVariable String banknum,
                @PathVariable String user,
                @PathVariable String pass
                ) {
                    
                    Gender gender = genderRepository.findByGenderid(genderid);
                    Province province = provinceRepository.findByProvinceid(provinceid);
                    Position position = positionRepository.findByPositionid(positionid);
                    Bank bank = bankRepository.findByBankid(bankid);

                    newEmployee.setEmployeename(nameInfo);
                    newEmployee.setGenderid(gender);
                    newEmployee.setIdcardnumber(idcard);
                    newEmployee.setAddress(address);
                    newEmployee.setProvinceid(province);
                    newEmployee.setTelephone(phone);
                    newEmployee.setPositionid(position);
                    newEmployee.setBankid(bank);
                    newEmployee.setBanknum(banknum);
                    newEmployee.setUsername(user);
                    newEmployee.setPassword(pass);
                    return employeeRepository.save(newEmployee);

            }

}

