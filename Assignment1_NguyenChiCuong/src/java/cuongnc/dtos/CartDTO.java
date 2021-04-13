/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongnc.dtos;

import java.util.HashMap;

/**
 *
 * @author nguye
 */
public class CartDTO {

    private String userID;
    private HashMap<String, ProductDTO> shoppingCart = null;

    public CartDTO(String userID) {
        this.userID = userID;
        shoppingCart = new HashMap<>();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public HashMap<String, ProductDTO> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<String, ProductDTO> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }    
    
    public void addCart(ProductDTO dto) throws Exception{
        if (shoppingCart.containsKey(dto.getProID())) {
            int quantity_cart = shoppingCart.get(dto.getProID()).getProQuantity() + dto.getProQuantity();
            dto.setProQuantity(quantity_cart);
        }
        shoppingCart.put(dto.getProID(), dto);
    }

    public void deleteCart(String idProduct) throws Exception{
        if (shoppingCart.containsKey(idProduct)){
            shoppingCart.remove(idProduct);
        }
    }
    
}
