package com.farzoom.ehd.service;

import com.farzoom.common.persistence.es.model.Company;
import com.farzoom.common.persistence.es.model.Order;
import com.farzoom.common.persistence.es.model.Relation;
import com.farzoom.common.persistence.es.repositories.CompanyRepository;
import com.farzoom.common.persistence.es.repositories.OrderRepository;
import com.farzoom.ehd.mapper.OrderMapper;
import com.farzoom.ehd.repository.OrdersRepository;
import com.farzoom.jooq.model.tables.pojos.Orders;
import com.farzoom.jooq.model.tables.records.OrdersRecord;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository esOrderRepository;
    private final OrdersRepository ordersRepository;
  //  private CompanyRepository companyRepository;
    // private GenParams genparams;
    private OrderMapper orderMapper;

    public void findAllOrdersAndInsert() {
        List<Order> orders = esOrderRepository.searchAll("orderTypeRefId:rko","30s");
        //TODO инфо по компании
        //TODO инфо из генпарамсов
        ObjectMapper objectMapper = new ObjectMapper();
        List<Orders> pojoOrders = orders.stream().map( t -> orderMapper.mapToOrders(t)).collect(Collectors.toList());
        ordersRepository.insertAll(objectMapper.convertValue(pojoOrders, new TypeReference<List<OrdersRecord>>() {
        }));

    }
}
