package lk.nsbm.server.controller;


import lk.nsbm.server.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RequestMapping(value = "/api/v1/customers")
@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(params = "q")
    public List<CustomerDTO> findAllCustomersByAddress(@RequestParam("q")
                                                                   String address){

        try{
            return   restTemplate.exchange("http://localhost:8081/api/v1/customers?q=" + address, HttpMethod.GET, null, new ParameterizedTypeReference <List<CustomerDTO>>() {
            }).getBody();
        }catch (Exception e){
            try{
                return   restTemplate.exchange("http://localhost:8082/api/v1/customers?q=" + address, HttpMethod.GET, null, new ParameterizedTypeReference <List<CustomerDTO>>() {
                }).getBody();
            }catch (Exception e1){
                return   restTemplate.exchange("http://localhost:8083/api/v1/customers?q=" + address, HttpMethod.GET, null, new ParameterizedTypeReference <List<CustomerDTO>>() {
                }).getBody();
            }

        }


    }

    @GetMapping
    public List<CustomerDTO> findAllCustomers() {
        try{
            return   restTemplate.exchange("http://localhost:8081/api/v1/customers", HttpMethod.GET, null, new ParameterizedTypeReference <List<CustomerDTO>>() {
            }).getBody();
        }catch (Exception e1){
            try{
                return   restTemplate.exchange("http://localhost:8082/api/v1/customers", HttpMethod.GET, null, new ParameterizedTypeReference <List<CustomerDTO>>() {
                }).getBody();
            }catch (Exception e2){
                return   restTemplate.exchange("http://localhost:8083/api/v1/customers", HttpMethod.GET, null, new ParameterizedTypeReference <List<CustomerDTO>>() {
                }).getBody();
            }

        }

    }

    @GetMapping("/{id:C\\d{3}}")
    public CustomerDTO findCustomer(@PathVariable("id") String customerId) {
       return restTemplate.getForEntity("http://localhost:8081/api/v1/customers/"+customerId,CustomerDTO.class).getBody();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody CustomerDTO customer) {
        try {
            return restTemplate.postForEntity("http://localhost:8081/api/v1/customers",customer,String.class).getBody();
        }catch (Exception q2){
            try {
                return restTemplate.postForEntity("http://localhost:8082/api/v1/customers",customer,String.class).getBody();

            }catch (Exception q3){
                return restTemplate.postForEntity("http://localhost:8083/api/v1/customers",customer,String.class).getBody();
            }
        }
    }
//
    @DeleteMapping("/{id:C\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") String customerId) {
        restTemplate.delete("http://localhost:8081/api/v1/customers/"+customerId);

    }
//
//    @PutMapping(value = "/{id:C\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity updateCustomer(@PathVariable("id") String customerId,
//                                         @RequestBody CustomerDTO customer) {
//        if (customerId.equals(customer.getId())) {
//            customersService.updateCustomer(customer);
//            return new ResponseEntity(HttpStatus.OK);
//        } else {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }

}
