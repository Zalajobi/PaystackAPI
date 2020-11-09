package paystack.api.model.transaction;

import java.util.HashMap;

//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Initialize {
    private double amount;
    private String email;
    private String currency;
//    private HashMap<String, String> metadata;
//    private String reference;
    private String callback_url;
//    private String plan;
//    private String invoiceLimit;

    public String getAmount() {
        return String.valueOf(amount * 100);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getcallback_url() {
        return callback_url;
    }

    public void setcallback_url(String callback_url) {
        this.callback_url = callback_url;
    }

    public HashMap<String, Object> asMap() {
        HashMap<String, Object> query = new HashMap<>();
        query.put("email", getEmail());
        query.put("amount", getAmount());
        query.put("currency", getCurrency());
        query.put("callback_url", getcallback_url());
//        System.out.println(getMetadata());
//        query.put("metadata", getMetadata());
//        query.put("reference", getReference());
//        query.put("plan", getPlan());
//        query.put("invoiceLimit", getInvoiceLimit());

        return query;
    }
}
