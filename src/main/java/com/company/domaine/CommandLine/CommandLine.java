package com.company.domaine.CommandLine;
import com.company.domaine.Product.Product;

public class CommandLine implements InterfaceCommandLine{
    private Product product;
    private String productReference;
    private QuantityOfProduct quantityOfProduct ;
    private CommandLinePrice commandLinePrice;

    public CommandLine(Product product, QuantityOfProduct quantityOfProduct) {
        this.product = product;
        this.productReference = product.getProductReference().getReference();
        this.quantityOfProduct = quantityOfProduct;
        this.commandLinePrice = new CommandLinePrice(product.getProductPrice().getPrice()*quantityOfProduct.getQuantity());
    }

    public CommandLine(Product product) { //CL One Product
        this.product = product;
        this.productReference = product.getProductReference().getReference();
        this.quantityOfProduct = new QuantityOfProduct(1);
        this.commandLinePrice = new CommandLinePrice(product.getProductPrice().getPrice()*quantityOfProduct.getQuantity());
    }

    @Override
    public Product getProduct(){
        return product;
    }

    @Override
    public QuantityOfProduct getQuantityOfProduct() {
        return quantityOfProduct;
    }

    @Override
    public CommandLinePrice getCommandLinePrice() {
        return commandLinePrice;
    }

    @Override
    public void PrintCommandLine(){

        System.out.println("Product : " + getProduct().getProductName().getName());
        System.out.println("Description : " + getProduct().getProductDescription().getDescription());
        System.out.println("Price : " + getProduct().getProductPrice().getPrice()+ " EUR");
        System.out.println("Quantity : " + getQuantityOfProduct().getQuantity());
        System.out.println("  \n");
    }

    @Override
    public void addOneProduct(){
        QuantityOfProduct newQuantityOfProduct = new QuantityOfProduct(quantityOfProduct.getQuantity() + 1);
        this.quantityOfProduct = newQuantityOfProduct;
        this.commandLinePrice = new CommandLinePrice(product.getProductPrice().getPrice()*quantityOfProduct.getQuantity());
    }

    @Override
    public void addProduct(int nbOfNewProduct ){
        QuantityOfProduct newQuantityOfProduct = new QuantityOfProduct(quantityOfProduct.getQuantity() + nbOfNewProduct);
        this.quantityOfProduct = newQuantityOfProduct;
        this.commandLinePrice = new CommandLinePrice(product.getProductPrice().getPrice()*quantityOfProduct.getQuantity());
    }

    @Override
    public void deleteOneProduct() {
        if (quantityOfProduct.getQuantity()-1 > 0) {
            QuantityOfProduct newQuantityOfProduct = new QuantityOfProduct(quantityOfProduct.getQuantity() - 1);
            this.quantityOfProduct = newQuantityOfProduct;
            this.commandLinePrice = new CommandLinePrice(product.getProductPrice().getPrice() * quantityOfProduct.getQuantity());
        }
        else  throw new RuntimeException("Error of number delete product");
    }

    @Override
    public void deleteProduct(int nbOfDeleteProduct) {
        if (nbOfDeleteProduct < quantityOfProduct.getQuantity()){
            QuantityOfProduct newQuantityOfProduct = new QuantityOfProduct(quantityOfProduct.getQuantity() - nbOfDeleteProduct);
            this.quantityOfProduct = newQuantityOfProduct;
            this.commandLinePrice = new CommandLinePrice(product.getProductPrice().getPrice()*quantityOfProduct.getQuantity());
        }
        else throw new RuntimeException("Error of number delete product");
    }

    @Override
    public void modifyQuantityOfProduct(QuantityOfProduct newQuantityOfProduct){
        this.quantityOfProduct = newQuantityOfProduct;
        this.commandLinePrice = new CommandLinePrice(product.getProductPrice().getPrice()*newQuantityOfProduct.getQuantity());

    }

    @Override
    public Product findIfProductIsPresent(Product source){
        if(source.getProductReference().getReference() == product.getProductReference().getReference()){
            System.out.println("je suis la");
            return source;
        }
        else return null;
    }
}
























