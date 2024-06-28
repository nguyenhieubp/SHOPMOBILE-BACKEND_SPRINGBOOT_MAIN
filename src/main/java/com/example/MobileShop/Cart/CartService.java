package com.example.MobileShop.Cart;

import com.example.MobileShop.Cart.Response.ResponseCart;
import com.example.MobileShop.CommonDetailProduct.CommonDetailProductService;
import com.example.MobileShop.PhoneVariable.PhoneVariable;
import com.example.MobileShop.PhoneVariable.PhoneVariableService;
import com.example.MobileShop.PhoneVariable.response.ResponsePhoneVariable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PhoneVariableService phoneVariableService;


    @Autowired
    private CommonDetailProductService commonDetailProductService;

    public List<ResponseCart> getAllCart() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream().map(cart -> {
            ResponseCart responseCart = modelMapper.map(cart, ResponseCart.class);

            // Fetch and set the PhoneVariable details
            ResponsePhoneVariable responsePhoneVariable = phoneVariableService.getPhoneVariableById(cart.getProduct_item_id());
            responseCart.setProduct_item_id(responsePhoneVariable.getPhoneVariable());

            return responseCart;
        }).collect(Collectors.toList());
    }


    public ResponseCart getItemCart(UUID id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + id));

        ResponseCart responseCart = modelMapper.map(cart, ResponseCart.class);

        // Fetch and set the PhoneVariable details
        ResponsePhoneVariable responsePhoneVariable = phoneVariableService.getPhoneVariableById(cart.getProduct_item_id());
        responseCart.setProduct_item_id(responsePhoneVariable.getPhoneVariable());

        return responseCart;
    }

    public String createCart(CartDto cart){
        Cart newCart= cartRepository.save(modelMapper.map(cart,Cart.class));
        return "Create Sucsess";
    }


    public boolean changeQuantityCartIncrement(UUID id){
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + id));

        cart.setQuantity(cart.getQuantity() + 1);
        cartRepository.save(cart);
        return true;
    }

    public boolean changeQuantityCartDecrement(UUID id){
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + id));

        cart.setQuantity(cart.getQuantity() - 1);
        cartRepository.save(cart);
        return true;
    }

    public boolean deleteCart(UUID id){
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + id));

        cartRepository.delete(cart);
        return true;
    }



    public List<ResponseCart> getAllCartUser(UUID id) {
        List<Cart> carts = cartRepository.findCartByUseId(id);
        return carts.stream().map(cart -> {
            ResponseCart responseCart = modelMapper.map(cart, ResponseCart.class);

            // Fetch and set the PhoneVariable details
            ResponsePhoneVariable responsePhoneVariable = phoneVariableService.getPhoneVariableById(cart.getProduct_item_id());
            responseCart.setProduct_item_id(responsePhoneVariable.getPhoneVariable());

            return responseCart;
        }).collect(Collectors.toList());
    }

}
