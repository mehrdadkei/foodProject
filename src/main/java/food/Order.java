package food;
import food.enums.OrderStatus;
import food.enums.ProductType;

public class Order {
    private Product product;
    private Integer id;
    private Long count;
    private OrderStatus status;
    private ProductType type;
    private Integer releaseDay;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Integer getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(Integer releaseDay) {
        this.releaseDay = releaseDay;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product.getName() +
                '}';
    }
}
