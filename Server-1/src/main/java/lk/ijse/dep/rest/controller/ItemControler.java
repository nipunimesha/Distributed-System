package lk.ijse.dep.rest.controller;

import lk.ijse.dep.rest.dto.CustomerDTO;
import lk.ijse.dep.rest.dto.ItemDTO;
import lk.ijse.dep.rest.service.custom.ManageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/v1/items")
@CrossOrigin
@RestController
public class ItemControler {
    @Autowired
    private ManageItemService manageItemService;


    @GetMapping
    public ResponseEntity<List<ItemDTO>> findAllItems() {
        List <ItemDTO> items = manageItemService.getItems();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", items.size() + "");
        return new ResponseEntity<List<ItemDTO>>(items, httpHeaders, HttpStatus.OK);
    }


}
