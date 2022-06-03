package hcmute.tranhoanglong.foody;

public class Country
{
    private int id;
    private String country;

    public Country(int id, String country)
    {
        this.id = id;
        this.country = country;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}