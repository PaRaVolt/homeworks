package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import model.Car;
import repository.CarsRepositoryImpl;

public class Main extends CarsRepositoryImpl {
    public static void main(String[] args) {

        List<Car> car_list = new ArrayList<>();

        try
        {
            BufferedReader in = new BufferedReader(new FileReader("data/cars.txt"));
            String str;
            while ((str = in.readLine()) != null)
            {
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
            in.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        System.out.println("Total cars: " + car_list.size());
        System.out.println();

        if(!car_list.isEmpty())
        {
            CarsRepositoryImpl repository = new CarsRepositoryImpl();

            try(FileWriter writer = new FileWriter("report.txt", false))
            {
                Object [] vyborka = repository.showCarsNOmerByColorOrMileage(car_list, "black", 0);
                writer.write("Номера всех автомобилей, имеющих заданный цвет - black: ");
                writer.append('\n');

                for(Object s : vyborka){
                    writer.write(String.valueOf(s));
                    writer.append('\n');
                }

                writer.write("Уникальные автомобили: " + repository.showUniqueCarsNumberByCost(car_list, 500000, 1000000) + " шт.");
                writer.append('\n');

                writer.write("Цвет автомобиля с минимальной стоимостью: " + repository.showColorOfCarWithMinCost(car_list));
                writer.append('\n');

                writer.write("Средняя стоимость модели Toyota: " + String.format("%.2f", repository.showAverageCostOfCarModel(car_list, "Toyota")));
                writer.append('\n');

                writer.write("Средняя стоимость модели Volvo: " + String.format("%.2f", repository.showAverageCostOfCarModel(car_list, "Volvo")));
                writer.append('\n');

                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }
}

