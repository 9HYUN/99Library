package Goldra9.library.service;

import Goldra9.library.domain.Member;
import Goldra9.library.domain.Rental;
import Goldra9.library.domain.RentalItem;
import Goldra9.library.domain.item.Item;
import Goldra9.library.repository.ItemRepository;
import Goldra9.library.repository.MemberRepository;
import Goldra9.library.repository.RentalRepository;
import Goldra9.library.repository.RentalSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void cancel(Long rentalId)
    {
        Rental rental = rentalRepository.findOne(rentalId);
        rental.cancel();
    }

    //대여 조회
    public List<Rental> findAll()
    {
        return rentalRepository.findAll();
    }

    public List<Rental> findRental(RentalSearch rentalSearch)
    {
        return rentalRepository.findWithMember(rentalSearch);
    }




}
