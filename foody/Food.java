package hcmute.tranhoanglong.foody;

import android.media.Image;

public class Food
{
    private int id;
    private String name;
    //private Image image;
    private String description;

    public Food(int id, String name, String description)
    {
        this.id = id;
        this.name = name;
        //this.image = image;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
/*
    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }
*/
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}