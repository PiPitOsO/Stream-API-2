import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Collection<People> peoples = Arrays.asList(
                new People("Аня", 16, Sex.WOMEN),
                new People("Коля", 17, Sex.MAN),
                new People("Толя", 18, Sex.MAN),
                new People("Валя", 19, Sex.MAN),
                new People("Таня", 20, Sex.WOMEN),
                new People("Саня", 15, Sex.MAN),
                new People("Вова", 14, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 57, Sex.MAN)
        );

        Stream<People> stream = peoples.stream();
        stream.filter(x -> x.getSex().equals(Sex.MAN)).
                filter(y -> y.getAge() > 17).
                forEach(System.out::println);

        double manAverageAge = peoples.stream()
                .filter(x -> x.getSex().equals(Sex.MAN))
                .mapToInt(People::getAge).average()
                .getAsDouble();
        System.out.println("\nСредний возраст среди мужчин: " + manAverageAge);

        long stream2 = peoples.stream()
                .filter(y -> y.getAge() > 15)
                .count();
        System.out.println("\nКол-во потенциально работоспособных людей: " + stream2);
    }
}