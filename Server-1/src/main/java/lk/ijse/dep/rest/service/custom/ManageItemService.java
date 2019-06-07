package lk.ijse.dep.rest.service.custom;

import lk.ijse.dep.rest.dto.ItemDTO;
import lk.ijse.dep.rest.service.SuperService;

import java.util.List;

public interface ManageItemService extends SuperService {

    List<ItemDTO> getItems();

    void createItems(ItemDTO dto);

    void updateItems(ItemDTO dto);

    void deleteItems(String customerID);

    ItemDTO findItems(String id);


}
