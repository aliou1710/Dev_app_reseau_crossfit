/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isib.demo.crossfit.Repository;


import isib.demo.crossfit.Tables.Clients;
import isib.demo.crossfit.Tables.Test;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author aliou
 */
public interface TestRepository  extends CrudRepository<Test, String> {
    
    public Test GetClientSupNote(String date ,String epreuve ,String note);
     public Test GetClientEpreuve(String date , String epreuve);
     public Test GetDeletebyNomEpreuveDateJury();
     public Clients GetClientsByDate();
     
     @Query(value="select k.nom ,t.note, e.nEpreuve, c.nomcompetition FROM   Competition c  join  c.inscritCollection i  join i.clients k join k.testCollection t join t.epreuve e  where  e.nEpreuve=:nomEpreuve  and k.nom=:nomClient")
     public Optional<List<Test>> GetTestbyEpreuve(@Param("nomEpreuve")String nomEpreuves , @Param("nomClient") String Nomclients);
}
