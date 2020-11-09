package paystack.api.model.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document(collection = "customer")
public class Customer {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private String code;
    private String risk_action;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRisk_action() {
        return risk_action;
    }

    public void setRisk_action(String risk_action) {
        this.risk_action = risk_action;
    }

    public HashMap<String, Object> asMap() {
        HashMap<String, Object> query = new HashMap<>();
        query.put("id", Long.valueOf(getId()));
        query.put("customer_code", getCode());
        query.put("first_name", getFirstname());
        query.put("last_name", getLastname());
        query.put("email", getEmail());
        query.put("phone", getPhone());
        query.put("risk_action", getRisk_action());

        return query;
    }
}
