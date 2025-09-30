public class Car {
    public Car(String nomer, String model, String color, Integer probeg, Integer cost){
        nomer_ = nomer;
        model_ = model;
        color_ = color;
        probeg_ = probeg;
        cost_ = cost;
    }

    public String toString(){
        return getNomer() + "-" + getModel_() + "-" + getColor() + "-" + getProbeg().toString() + "-" + getCost().toString();
    }

    public String getNomer(){
        return nomer_;
    }

    public String getModel_(){
        return model_;
    }

    public String getColor(){
        return color_;
    }

    public Integer getProbeg(){
        return probeg_;
    }

    public void setProbeg(Integer probeg){
        probeg_ = probeg;
    }

    public Integer getCost(){
        return cost_;
    }

    public void setCost(Integer cost){
        cost_ = cost;
    }

    private String nomer_;
    private String model_;
    private String color_;
    private Integer probeg_;
    private Integer cost_;
}
