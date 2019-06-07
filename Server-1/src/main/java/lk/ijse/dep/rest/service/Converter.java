package lk.ijse.dep.rest.service;

import lk.ijse.dep.rest.dto.CustomerDTO;
import lk.ijse.dep.rest.dto.ItemDTO;
import lk.ijse.dep.rest.dto.SuperDTO;
import lk.ijse.dep.rest.entity.Customer;
import lk.ijse.dep.rest.entity.Item;
import lk.ijse.dep.rest.entity.SuperEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof Customer) {
            Customer c = (Customer) entity;
            return (T) new CustomerDTO(c.getId(), c.getName(), c.getAddress());
        } else if (entity instanceof Item) {
            Item i = (Item) entity;
            System.out.println(i.getCode());
            ItemDTO itemDTO = new ItemDTO(i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice());
            System.out.println(itemDTO);
            T t = (T) itemDTO;
            System.out.println("T is"+ t);
            return t;

        } else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof CustomerDTO) {
            CustomerDTO c = (CustomerDTO) dto;
            return (T) new Customer(c.getId(), c.getName(), c.getAddress());

        } else if (dto instanceof ItemDTO) {
            ItemDTO i = (ItemDTO) dto;
            return (T) new Item(i.getCode(), i.getDescription(), i.getUnitPrice(), i.getQtyOnHand());
        } else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

//    public static <T extends SuperDTO> List<T> getDTOList(List<CustomEntity> list, Class<T> dtoClass) {
//        return list.stream().map(c -> getDTO(c, dtoClass)).collect(Collectors.toList());
//    }

}
