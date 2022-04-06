/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebAa.ApiRestFull2.repository;

import com.pruebAa.ApiRestFull2.modelo.Payment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JOSÈ LUGO GOMEZ
 */
public interface PaymentRepository extends JpaRepository<Payment, Short> {
    @Query(value = "select Cs.first_name, Pay.amount, Pay.payment_date, St.first_name \r\n"
    		 + "from customer Cs, payment Pay, staff St \r\n"
    		 + "where Pay.staff_id = St.staff_id and Pay.customer_id = Cs.customer_id and St.staff_id = ?;" 
                ,nativeQuery = true)    
            
    List<Object> listarClientesyPagosPorStaff(@Param("IdStaff")  Short IdStaff);
    
}
