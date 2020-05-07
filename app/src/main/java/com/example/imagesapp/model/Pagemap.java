
package com.example.imagesapp.model;

import java.util.List;

public class Pagemap
{
    private Cse_thumbnail[] cse_thumbnail;

    private Metatags[] metatags;

    private Cse_image[] cse_image;

    public Cse_thumbnail[] getCse_thumbnail ()
    {
        return cse_thumbnail;
    }

    public void setCse_thumbnail (Cse_thumbnail[] cse_thumbnail)
    {
        this.cse_thumbnail = cse_thumbnail;
    }

    public Metatags[] getMetatags ()
    {
        return metatags;
    }

    public void setMetatags (Metatags[] metatags)
    {
        this.metatags = metatags;
    }

    public Cse_image[] getCse_image ()
    {
        return cse_image;
    }

    public void setCse_image (Cse_image[] cse_image)
    {
        this.cse_image = cse_image;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cse_thumbnail = "+cse_thumbnail+", metatags = "+metatags+", cse_image = "+cse_image+"]";
    }
}
