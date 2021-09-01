package bookingexhibition.external;

public class Payment {

    private Long id;
    private Long bookingId;
    private String bookingStatus;
    private Long amt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getBookingId() {
        return bookingId;
    }
    
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    
    public String getBookingStatus() {
        return bookingStatus;
    }
    
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    
    public Long getAmt() {
        return amt;
    }
    
    public void setAmt(Long amt) {
        this.amt = amt;
    }

}
