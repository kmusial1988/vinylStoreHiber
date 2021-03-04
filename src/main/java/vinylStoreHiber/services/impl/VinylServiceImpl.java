package vinylStoreHiber.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vinylStoreHiber.DAO.IVinylDAO;
import vinylStoreHiber.model.Vinyl;
import vinylStoreHiber.services.IVinylService;

import java.util.List;

@Service
public class VinylServiceImpl implements IVinylService {

    @Autowired
    IVinylDAO vinylDAO;

    @Override
    public List<Vinyl> getAllVinyl(){
        return this.vinylDAO.getAllVinyl();
    }
    @Override
    public List<Vinyl> getAllVinyl90() {
        return this.vinylDAO.getProductByCategory(Vinyl.Category.lata90);
    }

    @Override
    public List<Vinyl> getAllVinyl00() {
        return this.vinylDAO.getProductByCategory(Vinyl.Category.lata00);
    }
    @Override
    public Vinyl getVinylByISBN(String isbn) {
        return this.vinylDAO.getVinylByISBN(isbn);
    }

    @Override
    public void addVinyl(Vinyl vinyl) {
        this.vinylDAO.addVinyl(vinyl);
    }
}
