package org.wt.service.impl;

import org.springframework.stereotype.Service;
import org.wt.model.Order;

import java.util.ArrayList;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl {

    public List<Order> queryAllOrders() {
        return queryAllOrdersInternal();
    }

    private List<Order> queryAllOrdersInternal() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("o201908290001"));
        orders.add(new Order("o201908290002"));
        orders.add(new Order("o201908290003"));
        return orders;
    }
}
