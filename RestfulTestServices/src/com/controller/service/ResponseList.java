package com.controller.service;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.dao.enitity.Employee;

@XmlRootElement(name = "responseList")
public class ResponseList {

    private List<Employee> list;

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

}