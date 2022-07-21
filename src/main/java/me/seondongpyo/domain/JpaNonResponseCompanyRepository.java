package me.seondongpyo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNonResponseCompanyRepository
    extends NonResponseCompanyRepository, JpaRepository<NonResponseCompany, Long> {
}
