package Model;

public class Borrow {

    private int id;
    private String customerUsername;
    private String bookId;

    public Borrow(int id, String customerUsername, String bookId) {
        this.id = id;
        this.customerUsername = customerUsername;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
