package app.customer;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public CustomerEntity() {
    }

    public CustomerEntity(String name) {
        this.name = name;
    }

    //region Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    //endregion

}
