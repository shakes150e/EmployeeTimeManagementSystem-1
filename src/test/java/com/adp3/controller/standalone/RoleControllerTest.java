package com.adp3.controller.standalone;

import com.adp3.entity.standalone.Role;
import com.adp3.entity.standalone.Store;
import com.adp3.entity.standalone.Timekeeping;
import com.adp3.factory.standalone.RoleFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleControllerTest{

     Role role= RoleFactory.buildRoleService("12345");


    @Autowired
    private TestRestTemplate restTemplate;
    private String roleUrl = "http://localhost:8080/role/";
    private static String SECURITY_USERNAME ="Super";
    private static String SECURITY_PASSWORD ="Password.ADP3";


    @Test
    public void a_create() {

        String urlCreate = roleUrl + "create";
        ResponseEntity<Role> storeResponseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(urlCreate, role, Role.class);
        System.out.println("Created data: " +role);
        assertEquals(role.getRoleID(), storeResponseEntity.getBody().getRoleID());
        assertNotNull(storeResponseEntity);
        assertNotNull(storeResponseEntity.getBody());
        role = storeResponseEntity.getBody();

    }

//    @Test
//    public void b_getAll() {
//        String urlGet = roleUrl + "getAll" ;
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<T>(null, headers);
//        ResponseEntity<String> responseEntity = restTemplate
//                .withBasicAuth(SECURITY_USERNAME,SECURITY_USERNAME)
//                .exchange(urlGet, HttpMethod.GET, entity, String.class);
//        assertNotNull(responseEntity);
//    }

    @Test
    public void c_read() {
        String url = roleUrl + "read" + role.getRoleID();
        ResponseEntity<Role> leaveResponseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Role.class);
        assertNotNull(leaveResponseEntity);
        assertNotNull(leaveResponseEntity.getBody());
    }

    @Test
    public void d_update() {
        Role updated  = new Role.Builder().copy(role).setRoleID("12345").build();
        String url = roleUrl + " updated ";
        ResponseEntity<Role> ResponseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url,updated, Role.class);
        Assert.assertNotNull(ResponseEntity);
        Assert.assertNotNull(updated);
    }

    @Test
    public void e_delete() {
        String urlDel = roleUrl + " Delete " + role.getRoleID();
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(urlDel);
        System.out.println("Data deleted ");
    }

}

