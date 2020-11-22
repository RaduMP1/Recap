package advanced;

import java.util.*;

public class Library {

    private Map<Genre, Set<Book>> bookshelf;

    public Map<Genre, Set<Book>> getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Map<Genre, Set<Book>> bookshelf) {
        this.bookshelf = bookshelf;
    }

    public void initWithDefaultBooks() {
        bookshelf = new HashMap<Genre, Set<Book>>();
        Book drama1 = new Book("GG", "Great Gatsby", Genre.DRAMA, 2001);
        final Book horror1 = new Book("MS", "Frankenstein", Genre.HORROR, 1897);
        Book scifi1 = new Book("FH", "Dune", Genre.SCIFI, 1996);

        // 3 modalitati diferite de a initializa Map-ul (bookshelf)
        // prima
        Set<Book> dramaSection = new HashSet<Book>();
        dramaSection.add(drama1);
        bookshelf.put(Genre.DRAMA, dramaSection);

        // a 2a
        bookshelf.put(horror1.getGenre(), new HashSet<Book>() {{
            add(horror1);
        }});

        // a 3a
        bookshelf.put(scifi1.getGenre(), new HashSet<Book>(Arrays.asList(scifi1)));

    }

    public Library() {  // constructor in care apelam metoda de init "initWit...."
        initWithDefaultBooks();
    }
}
