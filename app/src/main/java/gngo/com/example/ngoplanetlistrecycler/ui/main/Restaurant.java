package gngo.com.example.ngoplanetlistrecycler.ui.main;

public class Restaurant {
    public int logo;
    public String name;
    public String type;
    public String location;
    public String cost;

    public Restaurant(){
        super();
    }

    public Restaurant(int logo, String name, String type, String cost, String location){
        super();
        this.logo = logo;
        this.name = name;
        this.type = type;
        this.location = location;
        this.cost = cost;
    }

    public int getLogo(){
        return logo;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public String getCost() {return cost; }

    public String getLocation() {return location; }
}

