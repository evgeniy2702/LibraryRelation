package zhurenko.ua.hebirnate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zhurenko.ua.model.Owner;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HibernateOwnerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateOwnerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addOwner(Owner owner) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(owner);

        transaction.commit();
        session.close();
    }

    public Owner getLastOwnerByName(String string){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Owner> owners = session.createQuery("from Owner", Owner.class).list();
        owners = owners.stream().filter(o -> o.getNameOwner().equalsIgnoreCase(string)).collect(Collectors.toList());
        Owner owner = (Owner) owners.stream().sorted((o1,o2) -> o2.getId().compareTo(o1.getId())).toArray()[0];
        transaction.commit();
        session.close();
        return  owner;
    }

    public List<Owner> getListOwners() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Owner> owners = session.createQuery("from Owner", Owner.class).list();
        transaction.commit();
        session.close();
        return owners;
    }
}
