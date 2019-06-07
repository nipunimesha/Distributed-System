package lk.ijse.dep.rest.service.custom.impl;

import lk.ijse.dep.rest.dto.ItemDTO;
import lk.ijse.dep.rest.repository.CustomerRepository;
import lk.ijse.dep.rest.repository.ItemRepository;
import lk.ijse.dep.rest.service.Converter;
import lk.ijse.dep.rest.service.custom.ManageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManageItemServiceImpl implements ManageItemService {

    private ItemRepository itemDAO;
    @Autowired
    public ManageItemServiceImpl(ItemRepository itemDAO) {
        this.itemDAO = itemDAO;
    }


    @Transactional(readOnly = true)
    public List<ItemDTO> getItems() {

        return Converter.getDTOList(itemDAO.findAll());
    }


    public void createItems(ItemDTO dto) {
        itemDAO.save(Converter.getEntity(dto));

    }


    public void updateItems(ItemDTO dto) {

    }


    public void deleteItems(String customerID) {

    }


    public ItemDTO findItems(String id) {
        return null;
    }
}
