package restfrontend1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend1.dao.CartDao;
import backend1.dao.ItemDao;
import backend1.model.Cart;
import backend1.model.Item;

@RestController
public class CartRestController {

	@Autowired
	CartDao cartDao;
	
	@Autowired
	ItemDao itemDao;
	
	@RequestMapping(value = "/refresh/{cartId}")
	public Cart getCartById(@PathVariable("cartId") int cartId) {
		return cartDao.getById(cartId);
	}
	
	@RequestMapping(value = "/remove/{itemId}", method = RequestMethod.PUT)
	public void removeItem(@PathVariable("itemId") int itemId) {
		Item item = itemDao.getItemById(itemId);
		itemDao.remove(item);
	}
}
