package zhurenko.ua.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private int year;

    @Column(name = "stile")
    private String stileOfBook;

    @Column(name = "num_pages")
    private int numPages;
    private String description;

    @ManyToOne(targetEntity = Buyer.class,
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id",
                referencedColumnName = "buyer_id")
    private Buyer buyer;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStileOfBook() {
        return stileOfBook;
    }

    public void setStileOfBook(String stileOfBook) {
        this.stileOfBook = stileOfBook;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", stileOfBook='" + stileOfBook + '\'' +
                ", numPages=" + numPages +
                ", description='" + description + '\'' +
                ", buyerId=" + buyer.getId() + '\'' +
                ", buyerName=" + buyer.getNameBuyer() +
                '}';
    }
}
