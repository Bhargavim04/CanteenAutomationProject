package com.example.canteen;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.canteen.entity.Order;
import com.example.canteen.repository.OrderRepository;
import com.example.canteen.service.OrderService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CanteenApplicationTests {
	@Autowired
	  private OrderService service;
	  @MockBean
	  private OrderRepository repository;

	  @BeforeEach
	  void init() {
	    MockitoAnnotations.openMocks(this);
	  }
	  
	  @Test
	  public void listAllOrdersTest() {
	    when(repository.listAllOrders())
	    .thenReturn(Stream.of(new Order((long)345,"First Order","Food Items","California"),
	        new Order((long)346,"Second Order","Regular Items","California"),
	        new Order((long)347,"Third Order","Clothes","California")).collect(Collectors.toList()));
	    assertEquals(3,service.listAllOrders().size());
	  }
	  @Test
	  public void getOrderByIdTest() {
	    Order order =new Order((long)345,"First Order","Food Items","California");
	    when(repository.selectOrderById((long)345)).thenReturn(order);
	    assertEquals(order,service.selectOrderById((long)345));    
	  }

	  
	 

}
