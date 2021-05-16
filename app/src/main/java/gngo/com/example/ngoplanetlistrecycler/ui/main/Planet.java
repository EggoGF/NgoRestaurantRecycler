package gngo.com.example.ngoplanetlistrecycler.ui.main;

public class Planet {
    public int logo;
    public String name;
    public String type;

    public Planet(){
        super();
    }

    public Planet(int logo, String name, String type){
        super();
        this.logo = logo;
        this.name = name;
        this.type = type;
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

}
