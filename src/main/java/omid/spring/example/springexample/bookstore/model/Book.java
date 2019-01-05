package omid.spring.example.springexample.bookstore.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String title;
    public Date publishDate;
    public double price;

    public Book() {
    }

    public Book(String title, Date publishDate, double price) {
        this.title = title;
        this.publishDate = publishDate;
        this.price = price;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Author_book" , joinColumns = @JoinColumn(name = "book_id") ,
            inverseJoinColumns = @JoinColumn(name="author_id"))
    public Set<Author> authors = new HashSet<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", authors=" + authors +
                '}';
    }
}
