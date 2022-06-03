package hcmute.tranhoanglong.foody;

public class City
{
    private int id;
    private String city;

    public City(int id, String city)
    {
        this.id = id;
        this.city = city;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
}