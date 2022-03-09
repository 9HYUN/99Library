package Goldra9.bookStore.service;


import Goldra9.bookStore.domain.Member;
import Goldra9.bookStore.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService
{
    private final MemberRepository memberRepository;

    //== 회원가입 ==//
    @Transactional
    public Long join(Member member)
    {
        //예외 처리
        List<Member> findMembers = memberRepository.findByPersonNumber(member.getPersonNumber());
        if(!findMembers.isEmpty())
        {
            throw new IllegalStateException("해당 주민등록번호로 가입되어있습니다.");
        } else memberRepository.save(member);
        return member.getId();
    }

    //== 회원 전체 조회 ==//
    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }

    //== 회원 선택 조회 ==//
    public Member findOne(Long memberId)
    {
        return memberRepository.findOne(memberId);
    }
        // 보류 set없이 어케 하지
//    @Transactional
//    public void update(Long id, String name)
//    {
//        Member member = memberRepository.findOne(id);
//
//    }


}
