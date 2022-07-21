package me.seondongpyo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDormantClaimRepository
    extends DormantClaimRepository, JpaRepository<DormantClaim, Long> {
}
