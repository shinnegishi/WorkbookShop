package model;

import java.util.List;

import dao.OrderMainDAO;

public class OrderMainLogic {


    public OrderMain insert(OrderMain orderMain) {

        OrderMainDAO dao=new OrderMainDAO();
        return dao.create(orderMain);


    }



    public List<OrderMain> findAllByUserId(Usr loginUsr){
        OrderMainDAO dao=new OrderMainDAO();
        List<OrderMain> orderMainList=dao.findAllByUserId(loginUsr);
        for(OrderMain orderMain:orderMainList) {
            if(orderMain.getDelivery_date()==null || orderMain.getDelivery_date()=="") {
                orderMain.setDelivery_date("未配達");
            }

        }
        return orderMainList;
    }


    public List<OrderMain> selectByPoId(Integer po_id){

        OrderMainDAO dao=new OrderMainDAO();
        List<OrderMain> orderMainList=dao.selectByPoId(po_id);
        for(OrderMain orderMain:orderMainList) {
            if(orderMain.getDelivery_date()==null || orderMain.getDelivery_date()=="") {
                orderMain.setDelivery_date("未配達");
            }

        }
        return orderMainList;

    }




}
