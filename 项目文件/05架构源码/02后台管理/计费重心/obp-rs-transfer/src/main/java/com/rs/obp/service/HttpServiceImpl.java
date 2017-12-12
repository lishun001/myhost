/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author wangxinming
 */
@Service(value = "httpService")
public class HttpServiceImpl implements HttpService {

    @Autowired
    private RestTemplate restTemplate;
}
