package food;

import food.enums.ProductType;

public class Product {
    private String name;
    private Integer code;
    private String keepingCondition;
    private String address;
    private Integer price;
    private ProductType Types;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }



    public String getKeepingCondition() {
        return keepingCondition;
    }

    public void setKeepingCondition(String keepingCondition) {
        this.keepingCondition = keepingCondition;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ProductType getTypes() {
        return Types;
    }

    public void setTypes(ProductType Types) {
        this.Types = Types;
    }

    public void setTypes(Integer Types) {
        switch (Types) {
            case 1:
                this.Types = ProductType.can;
            case 2:
                this.Types = ProductType.health;
            case 3:
                this.Types = ProductType.dairy;
            case 4:
                this.Types = ProductType.snacks;
            case 5:
                this.Types = ProductType.protein;


        }
    }


}

