package bookingexhibition;

import javax.persistence.*;

//req/res
import bookingexhibition.external.Payment; 
import bookingexhibition.external.PaymentService;

import org.springframework.beans.BeanUtils;
//import java.util.List;
//import java.util.Date;

@Entity
@Table(name="Booking_table")
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;    
    private String date;    
    private String custName;    
    private String phoneNum;    
    private Long exhibitionId;  
    //private Long paymentId;
    private String bookingStatus;   
    private String time; 
    private Long amt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public Long getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(Long exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    //public Long getPaymentId() {
    //    return paymentId;
    //}

    //public void setPaymentId(Long paymentId) {
    //    this.paymentId = paymentId;
    //}
    
    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getAmt() {
        return amt;
    }

    public void setAmt(Long amt) {
        this.amt = amt;
    }

    //1. pub/sub START
    @PostPersist
    public void onPostPersist(){
        Booked booked = new Booked();
        BeanUtils.copyProperties(this, booked);
        booked.publishAfterCommit();
    }
    //1. pub/sub end

    //2. req/res start
    /*
    @PostPersist
    public void callPaymentStart(){
            Payment payment = new Payment();

            payment.setBookingId(this.getId());
            payment.setBookingStatus("Req/Res PAYMENT COMPLETED");        
            payment.setAmt(this.getAmt());
            
            // start payment
            PaymentService paymentService = BookingApplication.applicationContext.getBean(PaymentService.class);
            paymentService.startPayment(payment);
    }
    */
    //2. req/res end

    @PreRemove
    public void onPreRemove(){
        // 특정 대상에 대해 삭제 또는 갱신되도록 처리 필요
        CanceledBooking canceledBooking = new CanceledBooking();
        BeanUtils.copyProperties(this, canceledBooking);
        canceledBooking.publishAfterCommit();

    }

}