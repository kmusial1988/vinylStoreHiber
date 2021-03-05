package vinylStoreHiber.DAO;

import vinylStoreHiber.model.Vinyl;

import java.util.List;

public interface IVinylDAO {
    List<Vinyl> getAllVinyl();

    List<Vinyl> getProductByCategory(Vinyl.Category category);

    Vinyl getVinylByISBN(String isbn);

    void addVinyl(Vinyl vinyl);
    void updateVinyl(Vinyl vinyl);
}
