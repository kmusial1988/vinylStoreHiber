package vinylStoreHiber.dataBase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vinylStoreHiber.dataBase.IVinylRepository;
import vinylStoreHiber.model.Vinyl;
import vinylStoreHiber.services.IVinylService;

import java.util.List;

@Component
public class HBVinylRepositoryImpl implements IVinylRepository {



    @Autowired
    IVinylService vinylService;

    @Override
    public List<Vinyl> getAllVinyl() {
        return this.vinylService.getAllVinyl();
    }

    @Override
    public List<Vinyl> getAllVinyl90() {
        return this.vinylService.getAllVinyl90();
    }

    @Override
    public List<Vinyl> getAllVinyl00() {
        return this.vinylService.getAllVinyl00();
    }

    @Override
    public Vinyl getVinylByISBN(String isbn) {
        return this.vinylService.getVinylByISBN(isbn);
    }

    @Override
    public void addVinyl(Vinyl vinyl) {
        this.vinylService.addVinyl(vinyl);
    }
}
