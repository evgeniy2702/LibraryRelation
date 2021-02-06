package zhurenko.ua.hebirnate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zhurenko.ua.model.Owner;
import zhurenko.ua.model.OwnerBook;

import java.util.List;

@Component
public class HibernateBookOwnerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateBookOwnerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addRelation(Long bookId, Long ownerId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        OwnerBook ownerBook = new OwnerBook();
        ownerBook.setBook_id(bookId);
        ownerBook.setOwner_id(ownerId);
        session.save(ownerBook);
        transaction.commit();
        session.close();
    }

    public void deleteRelationk(Long bookId, Long ownerId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query delete = session.createNativeQuery("delete from owner_books where book_id = " + bookId  +
                " and owner_id = " + ownerId + ";");
        delete.executeUpdate();
        transaction.commit();
        session.close();
    }

    public List<Long> getRelationOwnerId(Long bookId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Long> idLists = session.createQuery("from Long where book_id =" + bookId + ";", Long.class).list();
        transaction.commit();
        session.close();
        return idLists;
    }
    
    public List<Owner> getRelationOwner(List<Long> idList){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Owner> owners = session.createQuery("from Owner;", Owner.class ).list();
        for (Owner o: owners ){
            if(!idList.contains(o.getId())){
                owners.remove(o);
            }
        }
        transaction.commit();
        session.close();
        return  owners;
    }
}
