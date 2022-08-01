package me.seondongpyo.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@PropertySource("classpath:application-dev.properties")
@Service
public class MyDataHubApiService {

    @Value("${mydatahub.api.insure-money-inquiry-url}")
    private String insureMoneyInquiryURI;

    @Value("${mydatahub.api.captcha-sms-uri}")
    private String captchaSmsURI;

    @Value("${mydatahub.api.token}")
    private String token;
}
