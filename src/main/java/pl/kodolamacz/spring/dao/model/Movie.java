package pl.kodolamacz.spring.dao.model;

/**
* Created by acacko on 29.10.17
 */
public class Movie extends Entity {

    private String title;
    private int price; // in grosze

    public Movie(Long id, String title, int price) {
        super(id);
        this.title = title;
        this.price = price;
    }

    public Movie(Long id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
