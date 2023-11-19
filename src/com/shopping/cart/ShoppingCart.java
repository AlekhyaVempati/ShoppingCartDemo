package com.shopping.cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.shopping.cart.model.Items;

public class ShoppingCart {

	public static void main(String[] args) {

		Map<String, Items> itemsPrice = new HashMap<>();

		itemsPrice = itemOfferDetails(itemsPrice);

		List<String> inputItems = addItemsToCart();

		Map<String, Long> consolidatedMap = inputItems.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Items in Shopping cart with its Quantity: " + consolidatedMap);

		calculatePrices(consolidatedMap, itemsPrice);

	}

	private static void calculatePrices(Map<String, Long> consolidatedMap, Map<String, Items> itemsPrice) {
		double totalPrice = 0;
		for (String item : consolidatedMap.keySet()) {
			int quantity = consolidatedMap.get(item).intValue();
			totalPrice += calculateTotalPrice(item, quantity, itemsPrice, totalPrice);
		}
		System.out.println("Total Price of all items in the cart: " + totalPrice);
	}

	private static double calculateTotalPrice(String item, int quantity, Map<String, Items> itemsPrice,
			double totalPrice) {
		for (String itemName : itemsPrice.keySet()) {
			if (item.equals(itemName)) {

				if (quantity > 1) {
					int qty = quantity / itemsPrice.get(itemName).getSplQuantity();
					int remainingQty = quantity % itemsPrice.get(itemName).getSplQuantity();
					System.out.println("itemName " + itemName + " remainingQty: " + remainingQty);
					System.out.println("itemName " + itemName + " qty: " + qty);
					totalPrice = (itemsPrice.get(itemName).getItemPrice() * remainingQty)
							+ (itemsPrice.get(itemName).getSplPrice() * qty);
				} else {
					totalPrice = itemsPrice.get(itemName).getItemPrice();
				}
				System.out.println("itemName: " + itemName + " total price:  " + totalPrice);
			}
		}
		return totalPrice;
	}

	private static List<String> addItemsToCart() {
		List<String> inputItems = Arrays.asList("Apple", "Banana", "Apple", "Melon", "Melon", "Lime", "Lime", "Banana",
				"Melon", "Lime");

		System.out.println("Initial Items in Shopping cart: " + inputItems);

		return inputItems;

	}

	private static Map<String, Items> itemOfferDetails(Map<String, Items> itemsPrice) {
		itemsPrice.put("Apple", new Items(35.0, 1, 35.0));
		itemsPrice.put("Banana", new Items(20.0, 1, 20.0));
		itemsPrice.put("Melon", new Items(50.0, 2, 50.0)); // 1+1
		itemsPrice.put("Lime", new Items(15.0, 3, 30.0)); // 3 for price of 2

		return itemsPrice;
	}

}
