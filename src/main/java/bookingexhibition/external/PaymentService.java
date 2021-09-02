package bookingexhibition.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name ="payment", url="${api.url.payment}") //, fallback = PaymentServiceImpl.class) //jym - application.yml
//@FeignClient(name="Payment", url="http://Payment:8080")
//@FeignClient(name="Payment", url="http://localhost:8084")
public interface PaymentService {

    //@RequestMapping(method= RequestMethod.GET, path="/payments")
    //public void payment(@RequestBody Payment payment);

    //  PMJ Start - jym
    @RequestMapping(method = RequestMethod.POST, value = "/payments", consumes = "application/json")
    public void startPayment(Payment payment); 
    //  PMJ End
    
}

