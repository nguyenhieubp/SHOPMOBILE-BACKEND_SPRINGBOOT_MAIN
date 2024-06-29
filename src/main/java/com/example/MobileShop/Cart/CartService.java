package com.example.MobileShop.Cart;

import com.example.MobileShop.Cart.Response.ResponseCart;
import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.CommonDetailProduct.CommonDetailProductRepository;
import com.example.MobileShop.CommonDetailProduct.CommonDetailProductService;
import com.example.MobileShop.Exception.ResourceNotFoundException;
import com.example.MobileShop.PhoneVariable.PhoneVariable;
import com.example.MobileShop.PhoneVariable.PhoneVariableRepository;
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
    private PhoneVariableRepository phoneVariableRepository;


    @Autowired
    private CommonDetailProductRepository commonDetailProductRepository;

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

    public String createCart(CartDto cartDto) {
        // Fetch the PhoneVariable from CartDto
        PhoneVariable phoneVariable = phoneVariableRepository.findById(cartDto.getProduct_item_id())
                .orElseThrow(() -> new ResourceNotFoundException("PhoneVariable not found for this id :: " + cartDto.getProduct_item_id()));

        // Fetch the associated CommonDetailProduct
        CommonDetailProduct commonDetailProduct = commonDetailProductRepository.findById(phoneVariable.getCommonDetailProduct())
                .orElseThrow(() -> new ResourceNotFoundException("CommonDetailProduct not found for this id :: " + phoneVariable.getCommonDetailProduct()));

        // Decrement the quantity_of_goods
        if (commonDetailProduct.getQuantity_of_goods() - cartDto.getQuantity() < 0) {
            return "Không đủ sản phẩm";
        }
        commonDetailProduct.setQuantity_of_goods(commonDetailProduct.getQuantity_of_goods() - cartDto.getQuantity());

        // Save the updated CommonDetailProduct
        commonDetailProductRepository.save(commonDetailProduct);

        // Save the new cart
        Cart newCart = cartRepository.save(modelMapper.map(cartDto, Cart.class));
        System.out.println(newCart);

        return "Create Success";
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

    public boolean deleteCart(UUID id) {
        // Fetch the cart entity by its ID
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + id));

        // Fetch the PhoneVariable from the Cart
        PhoneVariable phoneVariable = phoneVariableRepository.findById(cart.getProduct_item_id())
                .orElseThrow(() -> new RuntimeException("PhoneVariable not found with id: " + cart.getProduct_item_id()));

        // Fetch the associated CommonDetailProduct
        CommonDetailProduct commonDetailProduct = commonDetailProductRepository.findById(phoneVariable.getCommonDetailProduct())
                .orElseThrow(() -> new RuntimeException("CommonDetailProduct not found with id: " + phoneVariable.getCommonDetailProduct()));

        // Increment the quantity_of_goods
        commonDetailProduct.setQuantity_of_goods(commonDetailProduct.getQuantity_of_goods() + cart.getQuantity());

        // Save the updated CommonDetailProduct
        commonDetailProductRepository.save(commonDetailProduct);

        // Delete the cart entity
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
