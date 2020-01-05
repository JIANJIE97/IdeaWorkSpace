package fun.jianjie.miniorder.service;

import fun.jianjie.miniorder.domain.OrderProduct;

import java.util.ArrayList;


public interface OrderProductService {
    public Boolean saveOrderProducts(OrderProduct orderProduct);

    public Boolean saveOrderProductsList(ArrayList<OrderProduct> orderProducts);
}
