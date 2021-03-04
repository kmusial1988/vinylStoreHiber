package vinylStoreHiber.services;

import vinylStoreHiber.model.Vinyl;

import java.util.List;

public interface IVinylService {
    List<Vinyl> getAllVinyl();

    List<Vinyl> getAllVinyl90();

    List<Vinyl> getAllVinyl00();

    Vinyl getVinylByISBN(String isbn);

    void addVinyl(Vinyl vinyl);
}
