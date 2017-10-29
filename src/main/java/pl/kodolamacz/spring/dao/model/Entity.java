package pl.kodolamacz.spring.dao.model;

/**
 * Created by acacko on 29.10.17
 */
public abstract class Entity {

    private Long id;

    public Entity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
