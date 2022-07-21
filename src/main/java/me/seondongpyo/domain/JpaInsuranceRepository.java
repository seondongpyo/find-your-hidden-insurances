package me.seondongpyo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaInsuranceRepository extends InsuranceRepository, JpaRepository<Insurance, Long> {
}
