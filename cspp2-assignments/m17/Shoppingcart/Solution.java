import java.util.Scanner;
class Item {
	//private catalogue[]
	private String name;
	private int quantity;
	private double price;
	public Item(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
		this.price = 0;
	}
	public Item(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return this.name;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public double getPrice() {
		return this.price;
	}
}
class ShoppingCart {
	public double disc;
	public Item[] catalog;
	public int catalogCount;
	public Item[] cart;
	public int cartCount;
	public ShoppingCart() {
		catalog = new Item[10];
		catalogCount = 0;
		cart = new Item[10];
		cartCount = 0;
		disc = 0;
	}
	public void addToCatalog(Item item) {
		catalog[catalogCount++] = item;

	}
	public void addToCart(Item item) {
		int flag = 0;
		for (int i = 0; i < cartCount ; i++) {
			if (cart[i].getName().equals(item.getName())) {
				cart[i].setQuantity(cart[i].getQuantity() + item.getQuantity());
				flag = 1;
			}
		}
		if (flag != 1) {

			cart[cartCount++] = item;
		}


	}
	public void removeFromCart(Item item) {
		int pos = 0;
		int flag = 0;
		for (int i = 0; i < cartCount; i++) {
			if (cart[i].getName().equals(item.getName())) {
				cart[i].setQuantity(cart[i].getQuantity() - item.getQuantity());
				if (cart[i].getQuantity() == 0) {
					flag = 1;
					pos = i;
					break;
				}
			}

		}
		if (flag == 1) {
			for (int i = pos; i < cartCount; i++) {
				cart[i] = cart[i + 1];
			}
			cart[cartCount - 1] = null;
			cartCount--;
		}
	}
	public void showCart() {
		for (int i = 0; i < cartCount; i++) {
			System.out.println(cart[i].getName() + " " + cart[i].getQuantity());

		}

	}
	public void showCatalog() {
		for ( int i = 0; i < catalogCount; i++) {
			System.out.println(catalog[i].getName() + " " + catalog[i].getQuantity() + " " + catalog[i].getPrice());
		}
	}
	public double getTotalAmount() {
		double total = 0;
		for (int i = 0; i < cartCount ; i++) {
			for ( int j = 0; j < catalogCount; j++) {
				if (cart[i].getName().equals(catalog[j].getName())) {
					total += catalog[j].getPrice() * cart[i].getQuantity();
				}
			}
		}
		return total;
	}
	public double getPayableAmount() {
		double amount = getTotalAmount();
		amount -= (amount / 100) * this.disc;
		//discount
		amount += (amount / 100) * 15;
		return amount;
	}
	public void applyCoupon(String coupon) {
		if (this.disc == 0.0) {
			if (coupon.equals("IND10") || coupon.equals("IND20") || coupon.equals("IND30") || coupon.equals("IND50")) {
				this.disc = Double.parseDouble(coupon.substring(3, coupon.length()));
			} else {
				System.out.println("Invalid coupon");
			}

		}

	}
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartCount; i++) {
			for (int j = 0; j < catalogCount; j++) {
				if (cart[i].getName().equals(catalog[j].getName())) {
					System.out.println(cart[i].getName() + " " + cart[i].getQuantity() + " " + catalog[j].getPrice());

				}
			}
		}
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + (getTotalAmount() / 100) * disc);
		System.out.println("Tax:" + (getTotalAmount() - getTotalAmount()) * 0.15);
		System.out.println("Payable amount: " + getPayableAmount());
	}
}
class Solution {
	public static void main(String[] args) {
		ShoppingCart sc = new ShoppingCart();
		//Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		// check if there is one more line to process
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String line = s.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "Item":
				String[] data = tokens[1].split(",");
				sc.addToCatalog(new Item(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2])));
				break;
			case "catalog":
				sc.showCatalog();
				break;
			case "add":
				data = tokens[1].split(",");
				sc.addToCart(new Item(data[0], Integer.parseInt(data[1])));
				//sc.addToCart(new Item())
				break;
			case "show":
				sc.showCart();
				break;
			case "totalAmount":
				System.out.println("totalAmount: " + sc.getTotalAmount());
				break;
			case "remove":
				data = tokens[1].split(",");
				sc.removeFromCart(new Item(data[0], Integer.parseInt(data[1])));
				break;
			case "payableAmount":
				System.out.println("Payable amount: " + sc.getPayableAmount());

				break;
			case "print":
				sc.printInvoice();
				break;
			case "coupon":
				sc.applyCoupon(tokens[1]);
				break;
			}
		}
	}
}