package lk.nsbm.project.rest.service.custom;

import lk.nsbm.project.rest.dto.CustomerDTO;
import lk.nsbm.project.rest.service.SuperService;

import java.util.List;

public interface ManageCustomersService extends SuperService {

    List<CustomerDTO> getCustomers();

    void createCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void deleteCustomer(String customerID);

    CustomerDTO findCustomer(String id);

    List<CustomerDTO> findCustomersByAddress(String address);


}
