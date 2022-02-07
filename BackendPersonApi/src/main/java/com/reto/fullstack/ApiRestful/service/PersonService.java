package com.reto.fullstack.ApiRestful.service;

import com.reto.fullstack.ApiRestful.exception.BadRequestException;
import com.reto.fullstack.ApiRestful.model.dtos.PersonDto;
import com.reto.fullstack.ApiRestful.model.entities.Person;
import com.reto.fullstack.ApiRestful.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person) throws BadRequestException {
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        if(person.getBirth().after(now)){
            throw new BadRequestException("La fecha de nacimiento no puede ser mayor que la fecha actual");
        }
        else{
            try{
                return personRepository.save(person);
            }catch (Exception e) {
                throw new BadRequestException("Este nombre ya existe");
            }
        }
    }

    public Person update(PersonDto personDto,Long id) throws BadRequestException {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            Person person1 = person.get();
            Date in = new Date();
            LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
            Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
            if(personDto.getBirth().after(now)){
                throw new BadRequestException("La fecha de nacimiento no puede ser mayor que la fecha actual");
            }
            else{
                try{
                    person1.update(personDto);
                    return personRepository.save(person1);
                }catch (Exception e) {
                    throw new BadRequestException("Este nombre ya existe");
                }
            }
        }else{
            throw new BadRequestException("No existe una persona con este Id");
        }
    }

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }
    public void delete(Person person){
        personRepository.delete(person);
    }
    public Optional<Person> findById(Long id) throws BadRequestException {
        try{
            return personRepository.findById(id);
        }catch(Exception e){
            throw new BadRequestException("No existe una persona con este id");
        }

    }

}
