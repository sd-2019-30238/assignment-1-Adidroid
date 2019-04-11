package BusinessLogic;

public class RecommendationFactory implements factoryInterface {

    @Override
    public Recommendation getRecommendation(String type) {
        if(type.equals("Genre")){
            return new GenreRecommendation();
        }
        else
            return new AuthorRecommendation();

    }
}
