import java.util.*;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Car> car_list = new ArrayList<>();

        System.out.println("input cars:");

        Scanner src = new Scanner(System.in);

        while(src.hasNextLine()){
            String str = src.nextLine();

            String[] params = str.split("\\|");
            if(params.length != 5) break;

            String nomer = "";
            String model = "";
            String color = "";
            Integer probeg = 0;
            Integer cost = 0;

            int i = 0;
            for (String pr : params)
            {
                switch(i){
                    case 0:
                        nomer = pr;
                        break;
                    case 1:
                        model = pr;
                        break;
                    case 2:
                        color = pr;
                        break;
                    case 3:
                        probeg = Integer.parseInt(pr);
                        break;
                    case 4:
                        cost = Integer.parseInt(pr);
                        break;
                }
                i++;
            }
            if(!nomer.isEmpty() && !model.isEmpty() && !color.isEmpty()){
                car_list.add(new Car(nomer, model, color, probeg, cost));
            }
        }


        System.out.println("Total cars: " + car_list.size());
        System.out.println();

        String colorToFind = "black";
        Integer mileageToFind = 0;

        System.out.println("Номера всех автомобилей, имеющих заданный цвет - " + colorToFind + ": ");
        car_list.stream().filter(c -> c.getColor().equalsIgnoreCase(colorToFind) || c.getProbeg().equals(mileageToFind)).map(Car::getNomer).forEach(System.out::println);

        Integer n = 500000;
        Integer m = 1000000;
        System.out.println("Уникальные автомобили: " + car_list.stream().filter(c -> c.getCost() > n && c.getCost() < m).map(Car::getModel_).sorted().distinct().count() + " шт.");
        //.forEach(System.out::println);

        System.out.println("Цвет автомобиля с минимальной стоимостью: " + car_list.stream().min(Comparator.comparingInt(Car::getCost)).get().getColor());

        String car_model1 = "Toyota";
        System.out.println("Средняя стоимость модели " + car_model1 + ": " + car_list.stream().filter(c -> c.getModel_().equals(car_model1)).map(Car::getCost).flatMapToInt(IntStream::of).average().orElse(Double.NaN));

        String car_model2 = "Volvo";
        System.out.println("Средняя стоимость модели " + car_model2 + ": " + car_list.stream().filter(c -> c.getModel_().equals(car_model2)).map(Car::getCost).flatMapToInt(IntStream::of).average().orElse(0));
    }
}
/*
a123me|Mercedes|White|0|8300000
b873of|Volga|Black|0|673000
w487mn|Lexus|Grey|76000|900000
p987hj|Volga|Red|610|704340
c987ss|Toyota|White|254000|761000
o983op|Toyota|Black|698000|740000
p146op|BMW|White|271000|850000
u893ii|Toyota|Purple|210900|440000
l097df|Toyota|Black|108000|780000
y876wd|Toyota|Black|160000|1000000

 */