package lk.nsbm.project.rest.repository;

//import lk.ijse.dep.rest.entity.Item;
import lk.nsbm.project.rest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {
}
