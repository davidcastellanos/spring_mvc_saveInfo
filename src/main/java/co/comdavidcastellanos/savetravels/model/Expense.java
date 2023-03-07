package co.comdavidcastellanos.savetravels.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100, message = "el nombre debe tener entre 3 y 100 carácteres.")
    private String expenseName;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100, message = "el vendedor debe tener entre 3 y 100 carácteres.")
    private String vendor;

    @NotNull
    @NotEmpty
    private String amount;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 250, message = "el nombre debe tener entre 3 y 250 carácteres.")
    private String description;

    public Expense() {

    }

    public Expense(String expenseName, String vendor, String amount, String description) {
        this.expenseName = expenseName;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }

    public Expense(long id, String expenseName, String vendor, String amount, String description) {
        this.id = id;
        this.expenseName = expenseName;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
