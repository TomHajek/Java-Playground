package dev.playground.repository;

import dev.playground.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    // Native query to find address based on employeeId (employee is another table -> join tables)
    @Query(nativeQuery = true, value = "SELECT ea.id, ea.lane1, ea.lane2, ea.zip, ea.state FROM SeleniumExpress.address ea JOIN SeleniumExpress.employee e ON e.id = ea.employee_id WHERE ea.employee_id = 1")
    Address findAddressByEmployeeId(@Param("employeeId") int employeeId);

}
