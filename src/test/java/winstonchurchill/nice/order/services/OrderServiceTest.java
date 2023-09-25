package winstonchurchill.nice.order.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.repositores.IMemberRepository;
import winstonchurchill.nice.domain.member.repositores.MemoryMemberRepository;
import winstonchurchill.nice.domain.member.types.MemberGrade;
import winstonchurchill.nice.domain.order.entity.Order;
import winstonchurchill.nice.domain.order.repositories.IOrderRepository;
import winstonchurchill.nice.domain.order.repositories.MemoryOrderRepository;
import winstonchurchill.nice.domain.order.services.IOrderService;
import winstonchurchill.nice.domain.order.services.OrderService;

public class OrderServiceTest {
    private final IOrderService orderService = new OrderService();
    private final IMemberRepository memberRepository = new MemoryMemberRepository();
    private final IOrderRepository orderRepository = new MemoryOrderRepository();

    final int itemPrice = 11000;
    final String itemName = "mad-item";

    @Test
    void save() {
        final Member mad = new Member(1L, "mad", MemberGrade.VIP);
        this.memberRepository.save(mad);
        final Member member = this.memberRepository.findById(mad.getId());
        final Order order = this.orderService.createOrder(1L, member.getId(), itemName, itemPrice);
        this.orderRepository.save(order);
        final Order orderRecord = this.orderRepository.findById(order.getId());
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(orderRecord.getTotalPrice());
    }
}