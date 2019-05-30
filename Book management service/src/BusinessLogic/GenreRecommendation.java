package BusinessLogic;

import BusinessLogic.Service.BookService;
import BusinessLogic.Model.Book;


import java.util.List;
import java.util.Random;

public class GenreRecommendation extends Recommendation {

    private List<Book> books;

    @Override
    public List<Book> getRecommendation(){
       String genre=getRandomGenre();
       return  books=BookService.getAllGenre(genre);

    }

    private String getRandomGenre(){
        List<Book> allBooks= BookService.getAll();
        Book randomBook=allBooks.get(new Random().nextInt(allBooks.size()));
        return randomBook.getGenre();

    }
}
