package fun.jianjie.miniorder.service.impl;

import fun.jianjie.miniorder.dao.OrderProductDao;
import fun.jianjie.miniorder.domain.OrderProduct;
import fun.jianjie.miniorder.service.OrderProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;


@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Resource
    private OrderProductDao orderProductDao;


    @Override
    @Transactional(rollbackFor=Exception.class)
    public Boolean saveOrderProducts(OrderProduct orderProduct) {
        return orderProductDao.saveOrderProducts(orderProduct)>0?true:false;
    }

    @Override
    public Boolean saveOrderProductsList(ArrayList<OrderProduct> orderProducts) {
        return orderProductDao.saveOrderProductsList(orderProducts)>0?true:false;
    }
}
