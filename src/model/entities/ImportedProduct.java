package model.entities;

public final class ImportedProduct extends Product {
	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}
	
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	
	public double totalPrice() {
		return customsFee + price;
	}

	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" $ "+String.format("%.2f",totalPrice()));
		sb.append(" (Customs fee: $ "+String.format("%.2f",getCustomsFee())+")\n");
		
		return sb.toString();
		
		
	}

	
	
	
	

}
