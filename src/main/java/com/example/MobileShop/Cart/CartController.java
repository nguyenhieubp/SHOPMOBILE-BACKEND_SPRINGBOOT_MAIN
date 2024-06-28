package com.example.MobileShop.Cart;

import com.example.MobileShop.Cart.Response.ResponseCart;
import com.example.MobileShop.PhoneVariable.PhoneVariable;
import com.example.MobileShop.PhoneVariable.PhoneVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private PhoneVariableService phoneVariableService;

    @GetMapping("/getAll")
    public List<ResponseCart> getAllCart(){
        return cartService.getAllCart();

    }

    @GetMapping("/item/{id}")
    public ResponseCart getItemCart(@PathVariable UUID id){
        return cartService.getItemCart(id);
    }

    @PostMapping("/addToCart")
    public String createCart(@RequestBody CartDto cart){
        return cartService.createCart(cart);
    }

    @PatchMapping("/update/quantity/increment/{id}")
    public boolean changeQuantityCartIncrement(@PathVariable UUID id){
        return cartService.changeQuantityCartIncrement(id);
    }

    @PatchMapping("/update/quantity/decrement/{id}")
    public boolean changeQuantityCartDecrement(@PathVariable UUID id){
        return cartService.changeQuantityCartDecrement(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCart(@PathVariable UUID id){
        return cartService.deleteCart(id);
    }

    @GetMapping("/user/{id}")
    public List<ResponseCart> getAllCartUser(@PathVariable UUID id){
        return cartService.getAllCartUser(id);
    }
}
