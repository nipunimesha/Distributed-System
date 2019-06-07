package lk.nsbm.server.controller;

import lk.nsbm.server.dto.CustomerDTO;
import lk.nsbm.server.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping(value = "/api/v1/items")
@CrossOrigin
@RestController
public class ItemControler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<ItemDTO> findAllItems() {
        try{
            return   restTemplate.exchange("http://localhost:8081/api/v1/items", HttpMethod.GET, null, new ParameterizedTypeReference<List<ItemDTO>>() {
            }).getBody();
        }catch (Exception e1){
            try{
                return   restTemplate.exchange("http://localhost:8082/api/v1/items", HttpMethod.GET, null, new ParameterizedTypeReference <List<ItemDTO>>() {
                }).getBody();
            }catch (Exception e2){
                return   restTemplate.exchange("http://localhost:8083/api/v1/items", HttpMethod.GET, null, new ParameterizedTypeReference <List<ItemDTO>>() {
                }).getBody();
            }

        }

    }
}
