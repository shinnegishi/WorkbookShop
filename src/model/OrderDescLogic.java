package model;

import java.util.List;

import dao.OrderDescDAO;


public class OrderDescLogic {

    public List<OrderDesc> insert(List<OrderDesc> orderDescList) {

        for(OrderDesc orderDesc:orderDescList) {
            OrderDescDAO dao=new OrderDescDAO();
            dao.create(orderDesc);
        }
        return orderDescList;

    }


    public List<OrderDesc> selectByPo_id(Integer po_id) {
        OrderDescDAO dao=new OrderDescDAO();
        List<OrderDesc> orderDescList=dao.selectByPo_id(po_id);

        return orderDescList;

    }


}
