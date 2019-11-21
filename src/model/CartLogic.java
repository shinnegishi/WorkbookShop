package model;
import java.util.List;

public class CartLogic {

    public List<Cart> add2Cart(Cart cart,List<Cart> cartList){
        //cartList.add(0,cart);
        boolean isEqual=false;


            for(Cart aCart: cartList) {
                System.out.println(aCart.getP_id());
                System.out.println(cart.getP_id());
                System.out.println(aCart.getP_id());
                if(aCart.getP_id().equals(cart.getP_id())) {
                aCart.setCount(aCart.getCount()+cart.getCount());
                isEqual=true;
                }
            }

        if(!isEqual){
            cartList.add(cart);
        }
        return cartList;
    }


    public List<Cart> rem2Cart(Cart cart,List<Cart> cartList){
        //cartList.add(0,cart);

        if(cartList.isEmpty()) {
            return cartList;
        }

        Integer index=0;
        Integer indexFlg=null;

            for(Cart aCart: cartList) {
                System.out.println(aCart.getP_id());
                System.out.println(cart.getP_id());
                if(aCart.getP_id().equals(cart.getP_id())) {
                    indexFlg=index;
                }
                index++;
            }

            System.out.println(indexFlg);
            cartList.remove((int)indexFlg);

            return cartList;
    }



}
