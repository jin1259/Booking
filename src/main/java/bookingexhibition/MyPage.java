package bookingexhibition;

import javax.persistence.*;

@Entity
@Table(name="MyPage_table")
public class MyPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String bookingStatus;
        private Long bookingAmt;
        private Long bookingId;
        
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        
        public String getBookingStatus() {
            return bookingStatus;
        }

        public void setBookingStatus(String bookingStatus) {
            this.bookingStatus = bookingStatus;
        }

        public Long getBookingAmt() {
            return bookingAmt;
        }

        public void setBookingAmt(Long bookingAmt) {
            this.bookingAmt = bookingAmt;
        }

        public Long getBookingId() {
            return bookingId;
        }

        public void setBookingId(Long bookingId) {
            this.bookingId = bookingId;
        }


}