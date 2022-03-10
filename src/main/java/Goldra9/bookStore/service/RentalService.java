package Goldra9.bookStore.service;

import Goldra9.bookStore.domain.Member;
import Goldra9.bookStore.domain.Rental;
import Goldra9.bookStore.domain.RentalItem;
import Goldra9.bookStore.domain.item.Item;
import Goldra9.bookStore.repository.ItemRepository;
import Goldra9.bookStore.repository.MemberRepository;
import Goldra9.bookStore.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RentalService
{
    private final RentalRepository rentalRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    //== 대여 == //
    @Transactional
    public Long Rental(Long memberId, Long itemId, int count)
    {
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //대여상품 생성
        RentalItem rentalItem = RentalItem.createRentalItem(item, item.getRentalPrice(), count);

        //대여 생성
        Rental rental = Rental.createRental(member, rentalItem);

        //대여 저장
        rentalRepository.save(rental);
        return rental.getId();
    }

    //대여 취소
    @Transactional
    public void CancelOrReturn(Long rentalId)
    {
        Rental rental = rentalRepository.findOne(rentalId);
        rental.cancelOrReturn();
    }




}
