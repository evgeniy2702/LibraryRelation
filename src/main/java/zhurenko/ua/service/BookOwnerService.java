package zhurenko.ua.service;

import org.springframework.stereotype.Service;
import zhurenko.ua.hebirnate.HibernateBookOwnerDAO;
import zhurenko.ua.model.Owner;

import java.util.List;

@Service
public class BookOwnerService {

    private HibernateBookOwnerDAO hibernateBookOwnerDAO;

    public BookOwnerService(HibernateBookOwnerDAO hibernateBookOwnerDAO) {
        this.hibernateBookOwnerDAO = hibernateBookOwnerDAO;
    }

    public void saveRelation(Long bookId, Long ownerId) {
        hibernateBookOwnerDAO.addRelation(bookId, ownerId);
    }

    public void deleteRelation(Long bookId, Long ownerId) {
        hibernateBookOwnerDAO.deleteRelationk(bookId, ownerId);
    }

    public List<Long> getRelationOwnerId(Long bookId) {
        return hibernateBookOwnerDAO.getRelationOwnerId(bookId);
    }

    public List<Owner> getRelationOwner(List<Long> idList) {
        return hibernateBookOwnerDAO.getRelationOwner(idList);
    }
}
