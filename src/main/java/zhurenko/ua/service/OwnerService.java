package zhurenko.ua.service;

import org.springframework.stereotype.Service;
import zhurenko.ua.hebirnate.HibernateOwnerDAO;
import zhurenko.ua.model.Owner;

import java.util.List;

@Service
public class OwnerService {
    private final HibernateOwnerDAO hibernateOwnerDAO;

    public OwnerService(HibernateOwnerDAO hibernateOwnerDAO) {
        this.hibernateOwnerDAO = hibernateOwnerDAO;
    }

    public void saveOwner(Owner owner){
        hibernateOwnerDAO.addOwner(owner);
    }

    public Owner getLastOwnerByName(String string){
        return hibernateOwnerDAO.getLastOwnerByName(string);
    }
    
    public List<Owner> getListOwners(){
        return hibernateOwnerDAO.getListOwners();
    }
}
