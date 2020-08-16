package com.introduction.jpa.controller;

import com.introduction.jpa.entity.Contact;
import com.introduction.jpa.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Configuration
@RestController
@RequestMapping("/contacts")
@Validated
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    /** -------------------------------------
                PRIMEIRA TABELA
     --------------------------------------*/

    @DeleteMapping("/deleteByIdWithJPQLNamedParameter/")
    public ResponseEntity<String> deleteByIdWithJPQLNamedParameter(@RequestParam("id") Long id){
        contactRepository.deleteByIdWithJPQLNamedParameter(id);
        return ResponseEntity.ok().body("Deletado com sucesso deleteByIdWithJPQLNamedParameter");
    }

    @DeleteMapping("/deleteByIdWithJPQLPositionedParameter/")
    public ResponseEntity<String> deleteByIdWithJPQLPositionedParameter(@RequestParam("id") Long id){
        contactRepository.deleteByIdWithJPQLPositionedParameter(id);
        return ResponseEntity.ok().body("Deletado com sucesso deleteByIdWithJPQLPositionedParameter");
    }

    /** -------------------------------------
                SEGUNDA TABELA
     --------------------------------------*/

    @DeleteMapping("/deleteByIdWithNativeSQLNamedParameter/")
    public ResponseEntity<String> deleteByIdWithNativeSQLNamedParameter(@RequestParam("id") Long id) {
        contactRepository.deleteByIdWithNativeSQLNamedParameter(id);
        return ResponseEntity.ok().body("Deletado com sucesso deleteByIdWithNativeSQLNamedParameter");
    }

    @DeleteMapping("/deleteByIdWithNativeSQLPositionedParameter/")
    public ResponseEntity<String> deleteByIdWithNativeSQLPositionedParameter(@RequestParam("id") Long id){
        contactRepository.deleteByIdWithNativeSQLPositionedParameter(id);
        return ResponseEntity.ok().body("Deletado com sucesso deleteByIdWithNativeSQLPositionedParameter");
    }

    /** -------------------------------------
                TERCEIRA TABELA
     --------------------------------------*/

    @GetMapping("/findById/")
    public ResponseEntity<Contact> findById(@RequestParam("id") Long id) {
        Optional<Contact> response = contactRepository.findById(id);
        return ResponseEntity.ok().body(response.get());
    }

    @GetMapping("/findAll/")
    public ResponseEntity<List<Contact>> findAll(){
        List<Contact> response = contactRepository.findAll();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/save/")
    public ResponseEntity<Contact> save(@RequestBody() Contact contact) {
        Contact response = contactRepository.save(contact);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/deleteById/")
    public ResponseEntity<String> deleteById(@RequestParam("id") Long id){
        contactRepository.deleteById(id);
        return ResponseEntity.ok().body("Deletado com sucesso deleteById");
    }

    /** -------------------------------------
                QUARTA TABELA
     --------------------------------------*/


    @GetMapping("/findByEmail/")
    public ResponseEntity<Contact> findByEmail(@RequestParam("email") String email){
        Contact response = contactRepository.findByEmail(email);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findAllByEmail/")
    public ResponseEntity<List<Contact>> findAllByEmail(@RequestParam("email") String email){
        List<Contact> response = contactRepository.findAllByEmail(email);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByIdAndEmail/")
    public ResponseEntity<Contact> findByIdAndEmail(@RequestParam("email") String email, @RequestParam("id") Long id){
        Contact response = contactRepository.findByIdAndEmail(id, email);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByIdOrEmail/")
    public ResponseEntity<Contact> findByIdOrEmail(@RequestParam("email") String email, @RequestParam("id") Long id){
        Contact response = contactRepository.findByIdOrEmail(id, email);
        return ResponseEntity.ok().body(response);
    }

    /** -------------------------------------
                QUINTA TABELA
     --------------------------------------*/

    @GetMapping("/findByEmailNativeSQL/")
    public ResponseEntity<Contact> findByEmailNativeSQL(@RequestParam("email") String email){
        Contact response = contactRepository.findByEmailNativeSQL(email);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByEmailJPQLPositionedParameter/")
    public ResponseEntity<Contact> findByEmailJPQLPositionedParameter(@RequestParam("email") String email){
        Contact response = contactRepository.findByEmailJPQLPositionedParameter(email);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByEmailJPQLNamedParameter/")
    public ResponseEntity<Contact> findByEmailJPQLNamedParameter(@RequestParam("email") String email){
        Contact response = contactRepository.findByEmailJPQLNamedParameter(email);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByNameContaining/")
    public ResponseEntity<List<Contact>> findByNameContaining(@RequestParam("name") String name){
        List<Contact> response = contactRepository.findByNameContaining(name);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByNameContainingNativeQuery/")
    public ResponseEntity<List<Contact>> findByNameContainingNativeQuery(@RequestParam("name") String name){
        List<Contact> response = contactRepository.findByNameContainingNativeQuery(name);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByNameContainingJPQL/")
    public ResponseEntity<List<Contact>> findByNameContainingJPQL(@RequestParam("name") String name){
        List<Contact> response = contactRepository.findByNameContainingJPQL(name);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByNameNotContainingNativeQuery/")
    public ResponseEntity<List<Contact>> findByNameNotContainingNativeQuery(@RequestParam("name") String name){
        List<Contact> response = contactRepository.findByNameNotContainingNativeQuery(name);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByNameNotContainingJPQL/")
    public ResponseEntity<List<Contact>> findByNameNotContainingJPQL(@RequestParam("name") String name){
        List<Contact> response = contactRepository.findByNameNotContainingJPQL(name);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByNameNotContaining/")
    public ResponseEntity<List<Contact>> findByNameNotContaining(@RequestParam("name") String name){
        List<Contact> response = contactRepository.findByNameNotContaining(name);
        return ResponseEntity.ok().body(response);
    }

    /** -------------------------------------
                SEXTA TABELA
     --------------------------------------*/

    @GetMapping("/findByEmailIsNull/")
    public ResponseEntity<List<Contact>> findByEmailIsNull(){
        List<Contact> response = contactRepository.findByEmailIsNull();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByEMailIsNotNull/")
    public ResponseEntity<List<Contact>> findByEMailIsNotNull(){
        List<Contact> response = contactRepository.findByEMailIsNotNull();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByName/")
    public ResponseEntity<List<Contact>> findByName(@RequestParam("name") String name){
        List<Contact> response = contactRepository.findByName(name);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByNameIgnoreCase/")
    public ResponseEntity<List<Contact>> findByNameIgnoreCase(@RequestParam("name") String name){
        List<Contact> response = contactRepository.findByNameIgnoreCase(name);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByNameNotEqual/")
    public ResponseEntity<List<Contact>> findByNameNotEqual(@RequestParam("name") String name){
        List<Contact> response = contactRepository.findByNameNotEqual(name);
        return ResponseEntity.ok().body(response);
    }

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/findByDateBetween/")
    public ResponseEntity<List<Contact>> findByDateBetween(@RequestParam("from") String from, @RequestParam("to") String to ) throws ParseException {
        Date dateFormatter = df.parse(from);
        Date dateFormatter2 = df.parse(to);
        List<Contact> response = contactRepository.findByDateBetween(dateFormatter, dateFormatter2);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByDateBefore/")
    public ResponseEntity<List<Contact>> findByDateBefore(@RequestParam("date") String date) throws ParseException {
        Date dateFormatter = df.parse(date);
        List<Contact> response = contactRepository.findByDateBefore(dateFormatter);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByDateAfter/")
    public ResponseEntity<List<Contact>> findByDateAfter(@RequestParam("date") String date) throws ParseException {
        Date dateFormatter = df.parse(date);
        List<Contact> response = contactRepository.findByDateAfter(dateFormatter);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/updateNameById/")
    public ResponseEntity<String> updateNameById(@RequestParam("name") String name, @RequestParam("id") Long id){
        contactRepository.updateNameById(id, name);
        return ResponseEntity.ok().body("UPDATE com sucesso updateNameById");
    }

}
