package uk.co.martmarma.library.domain;

public class Author {

    private final int id;
    private final String name;

    public Author(final int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
