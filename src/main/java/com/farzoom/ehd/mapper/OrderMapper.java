package com.farzoom.ehd.mapper;

import com.farzoom.common.persistence.es.model.Order;
import com.farzoom.jooq.model.tables.pojos.Orders;

public class OrderMapper {

    public Orders mapToOrders(Order order) {
        Orders ordersDto = new Orders();
        ordersDto.setApplicationId(order.getId());
        ordersDto.setApplicationNum(order.getOrderNumber());
      //  ordersDto.setBeginDate(order.getCreatedDateTime());
      //  ordersDto.setEndDate(order.getExecutedDateTime());
      //  ordersDto.setChannelNameTxt();
      //  ordersDto.setClientNameTxt(); //company.shortName
        ordersDto.setCreationNameTxt(order.getInitiator().getFullName());
     //   ordersDto.setInnTxt(); //company.inn
     //   ordersDto.setRegistrationDepartmentTxt();
     //   ordersDto.setTech$changeDate();
    //    ordersDto.setTech$insAuditId();
     //   ordersDto.setTech$rowStatus();
        return ordersDto;
    }

}
