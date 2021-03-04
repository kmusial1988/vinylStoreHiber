package vinylStoreHiber.model;

import javax.persistence.*;

@Entity(name = "tvinyl")
public class Vinyl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private int pieces;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private double price;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Vinyl(String title, String author, int pieces, String isbn, double price, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pieces = pieces;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public Vinyl() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public enum Category {
        lata90,
        lata00
    }

    @Override
    public String toString() {
        return "Vinyl{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pieces=" + pieces +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    @Override
    public Object clone()  {
        return new Vinyl(this.title, this.author, this.pieces, this.isbn, this.price, this.category);


    }
}
