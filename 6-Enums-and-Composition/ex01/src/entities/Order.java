package entities;

import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
    private Integer id;
    private LocalDateTime moment;
    private OrderStatus status;

    public Order() {}

    public Order(Integer id, LocalDateTime moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                ", status=" + status +
                '}';
    }
}
