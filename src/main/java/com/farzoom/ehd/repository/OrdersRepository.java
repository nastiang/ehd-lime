package com.farzoom.ehd.repository;

import com.farzoom.jooq.model.tables.pojos.Orders;
import com.farzoom.jooq.model.tables.records.OrdersRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersRepository {
    DSLContext dsl = DSL.using(SQLDialect.POSTGRES);

    public void insertAll(List<OrdersRecord> orders){
        dsl.batchInsert(orders);
    }
}
