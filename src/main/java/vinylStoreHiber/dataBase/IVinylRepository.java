package vinylStoreHiber.dataBase;

import vinylStoreHiber.model.Vinyl;

import java.util.List;

public interface IVinylRepository {
    List<Vinyl> getAllVinyl();
    List<Vinyl> getAllVinyl90();
    List<Vinyl> getAllVinyl00();
    Vinyl getVinylByISBN (String isbn);
    void addVinyl(Vinyl vinyl);

    void updateVinyl(Vinyl vinyl);
}
