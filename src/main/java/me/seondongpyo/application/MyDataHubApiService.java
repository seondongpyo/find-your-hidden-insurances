package me.seondongpyo.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyDataHubApiService {

    @Value("${mydatahub.api.insure-money-inquiry-uri}")
    private String insureMoneyInquiryURI;

    @Value("${mydatahub.api.captcha-sms-uri}")
    private String captchaSmsURI;

    @Value("${mydatahub.token}")
    private String token;
}
