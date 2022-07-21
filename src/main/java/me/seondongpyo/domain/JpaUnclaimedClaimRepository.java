package me.seondongpyo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUnclaimedClaimRepository
    extends UnclaimedClaimRepository, JpaRepository<UnclaimedClaim, Long> {
}
