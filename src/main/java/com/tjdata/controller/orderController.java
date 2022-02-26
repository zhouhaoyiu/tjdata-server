package com.tjdata.controller;


import com.tjdata.domain.AddOrder;
import com.tjdata.domain.EditOrder;
import com.tjdata.mapper.OrderMapper;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.tjdata.controller.vectorController.getObject;

@RestController
@RequestMapping("order")
public class orderController {
    @Resource
    private OrderMapper orderMapper;

    @PostMapping("addOrder")
    public Object addOrder(@RequestBody AddOrder orderInfo) {
        String userName = orderInfo.getUserName();
        String orderDate = orderInfo.getOrderDate();
        String orderName = orderInfo.getOrderName();
        String brand = orderInfo.getBrand();
        String specification = orderInfo.getSpecification();
        Integer amount = orderInfo.getAmount();
        String description = orderInfo.getDescription();

        int res = orderMapper.addOrder(userName, orderDate, orderName, brand, specification, amount, description);

        return getObject(res, "订购信息");
    }

    @GetMapping("getAllOrder")
    public Object getAllOrder() {
        List res = orderMapper.getAllOrder();
        JSONObject json = new JSONObject();
        json.put("code", "0");
        json.put("msg", "获得订购信息成功");
        json.put("data", res);
        return json;
    }

    @PostMapping("editOrder")
    public Object editOrder(@RequestBody EditOrder editOrder) {
        String price = editOrder.getPrice();
        String classification = editOrder.getClassification();
        String orderStatus = editOrder.getOrderStatus();
        Integer id = editOrder.getId();

        int res = orderMapper.editOrder(price, classification, orderStatus, id);
        return getObject(res, "修改订购信息");

    }
}
