package bookingexhibition;

import bookingexhibition.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {

    @Autowired
    MyPageRepository myPageRepository;  //private

    //예약 완료시 myPage 데이터 생성
    @StreamListener(KafkaProcessor.INPUT)

    public void when_CREATE_Booked(@Payload CompletedPayment completedPayment)  {
        try {
            if (completedPayment.validate()){ 

                System.out.println("\n\n##### listener MyPage completedPayment : " + completedPayment.toJson() + "\n\n");
    
                    // view 객체 생성
                    MyPage myPage = new MyPage();
    
                    // view 객체에 이벤트의 Value 를 set 함
                    myPage.setId(completedPayment.getId());
                    myPage.setBookingId(completedPayment.getBookingId());
                    myPage.setBookingStatus(completedPayment.getBookingStatus());
                    myPage.setBookingAmt(completedPayment.getAmt());

    
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);

                }
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
}