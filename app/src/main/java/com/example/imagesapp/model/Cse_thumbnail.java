
package com.example.imagesapp.model;


public class Cse_thumbnail
{
    private String src;

    private String width;

    private String height;

    public String getSrc ()
    {
        return src;
    }

    public void setSrc (String src)
    {
        this.src = src;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [src = "+src+", width = "+width+", height = "+height+"]";
    }
}

