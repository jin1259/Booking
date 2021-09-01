package bookingexhibition;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MyPageRepository extends CrudRepository<MyPage, Long> {

    List<MyPage> findByBookingId(Long bookingId);


}