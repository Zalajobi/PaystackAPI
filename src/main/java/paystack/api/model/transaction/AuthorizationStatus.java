package paystack.api.model.transaction;

import java.util.HashMap;

public class AuthorizationStatus {
    private String code;
    private String email;
    private double amount;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAmount() {
        return String.valueOf(amount * 100);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public HashMap<String, Object> asMap() {
        HashMap<String, Object> query = new HashMap<>();
        query.put("code", getCode());
        query.put("email", email);
        query.put("amount", getAmount());

        return query;
    }
}
