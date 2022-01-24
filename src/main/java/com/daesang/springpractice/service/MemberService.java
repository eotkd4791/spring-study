package com.daesang.springpractice.service;

import com.daesang.springpractice.domain.Member;
import com.daesang.springpractice.domain.repository.MemberRepository;
import com.daesang.springpractice.domain.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = new MemoryMemberRepository();
  }

  public Long join(Member member) {
    validateDuplicateMember(member);

    memberRepository.save(member);
    return member.getId();
  }

  // 중복 회원 검증
  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
      .ifPresent(m -> {
        throw new IllegalStateException("이미 존재하는 회원입니다.");
      });
  }

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
