package main.by.trk.service;


import main.by.trk.domain.Person;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("personService")
@Transactional
public class PersonService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Person> getAll() {
        logger.debug("Retrieving all persons");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Person");
        return query.list();
    }
    public Person get(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Person person = (Person)session.get(Person.class,id);
        return person;
    }
    public void add(Person person){
        logger.debug("add new person");
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }
    public void delete(Integer id){
        logger.debug("deleting existing person");
        Session session = sessionFactory.getCurrentSession();
        Person person = (Person)session.get(Person.class,id);
        session.delete(person);
    }
    public void edit(Person person){
        logger.debug("editing existing person");
        Session session = sessionFactory.getCurrentSession();
        Person existingPerson = (Person)session.get(Person.class,person.getPersonId());
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setMoney(person.getMoney());
        existingPerson.setCreditCards(person.getCreditCards());
        session.save(existingPerson);
    }
}
