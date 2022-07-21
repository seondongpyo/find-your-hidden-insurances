package me.seondongpyo.domain;

import java.util.List;

public interface UnclaimedClaimRepository {

    List<UnclaimedClaim> findAll();
}
