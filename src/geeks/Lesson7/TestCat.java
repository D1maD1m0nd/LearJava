package geeks.Lesson7;

public class TestCat {
    public static void main(String[] args) {
        Cat[] cats = RuleCats.GenerateCats(60);
        Plate plate = new Plate(200);
        //в данном случае остались голодные коты
        RuleCats.eatCats(cats, plate);

        //в следующем случае все коты должны быть уже накормленные,но это не факт
        RuleCats.eatCats(cats, plate);
    }
}
